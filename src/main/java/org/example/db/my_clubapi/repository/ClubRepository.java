package org.example.db.my_clubapi.repository;

import org.example.db.my_clubapi.domain.Club;
import java.util.List;
import java.util.Optional;

public interface ClubRepository {
    Club save(Club club);
    List<Club> findAll();
    Optional<Club> findById(Long id);
    Club update(Club club);
    void deleteById(Long id);
}
