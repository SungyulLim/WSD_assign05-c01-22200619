package org.example.db.my_clubapi.service;

import org.example.db.my_clubapi.domain.Club;
import org.example.db.my_clubapi.dto.*;
import org.example.db.my_clubapi.repository.ClubRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class ClubService {
    private final ClubRepository repository;

    public ClubService(ClubRepository repository) {
        this.repository = repository;
    }
    public ClubResponse create(ClubRequest r) {
        validate(r);
        return toResponse(repository.save(new Club(null,r.name(),r.role(),r.gender())));
    }
    public List<ClubResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }
    public int count() {
        return repository.findAll().size();
    }
    public ClubResponse findById(Long id) {
        return toResponse(findClub(id));
    }
    public ClubResponse update(Long id, ClubRequest r) {
        validate(r);
        Club b=findClub(id); b.setName(r.name()); b.setRole(r.role()); b.setGender(r.gender());
        return toResponse(repository.update(b));
    }
    public void delete(Long id) { findClub(id); repository.deleteById(id); }
    private void validate(ClubRequest r) {
        if (r.name() == null || r.name().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Name is required");
        }
        if (r.role() == null || r.role().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Role is required");
        }
        if (r.gender() == null || r.gender().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Gender is required");
        }
    }
    private Club findClub(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Club not found: "+id)); }
    private ClubResponse toResponse(Club b) { return new ClubResponse(b.getId(),b.getName(),b.getRole(),b.getGender()); }
}
