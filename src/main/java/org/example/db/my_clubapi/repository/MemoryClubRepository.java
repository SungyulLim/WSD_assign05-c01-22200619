package org.example.db.my_clubapi.repository;

import org.example.db.my_clubapi.domain.Club;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MemoryClubRepository implements ClubRepository {
    private final Map<Long, Club> store = new LinkedHashMap<>();
    private long sequence = 0L;
    @Override public Club save(Club club) { club.setId(++sequence); store.put(club.getId(), club); return club; }
    @Override public List<Club> findAll() { return new ArrayList<>(store.values()); }
    @Override public Optional<Club> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    @Override public Club update(Club club) { store.put(club.getId(), club); return club; }
    @Override public void deleteById(Long id) { store.remove(id); }
}
