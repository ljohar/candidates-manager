package com.example.firstCommit.controlller;

import com.example.firstCommit.entities.Candidate;
import com.example.firstCommit.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    /**
     * GET http://localhost:8081/api/candidates
     */

    @GetMapping("/candidates")
    public List<Candidate> findAll() {
        return candidateService.findAll();}

    /**
     * Create a new candidate
     */
    @PostMapping("/candidates")
    public ResponseEntity<Candidate> create(@RequestBody Candidate candidate){
        if (candidate.getId() != null)
            return ResponseEntity.badRequest().build(); //400
        return ResponseEntity.ok(candidateService.save(candidate));

    }
}
