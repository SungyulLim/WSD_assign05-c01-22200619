package org.example.db.my_clubapi.controller;

import org.example.db.my_clubapi.dto.*;
import org.example.db.my_clubapi.service.ClubService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping
    public ResponseEntity<ClubResponse> create(@RequestBody ClubRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clubService.create(request));
    }

    @GetMapping
    public List<ClubResponse> findAll() {
        return clubService.findAll();
    }

    @GetMapping("/count")
    public int count() {
        return clubService.count();
    }

    @GetMapping("/{id}")
    public ClubResponse findById(@PathVariable Long id) {
        return clubService.findById(id);
    }

    @PutMapping("/{id}")
    public ClubResponse update(@PathVariable Long id, @RequestBody ClubRequest request) {
        return clubService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clubService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
