package com.example.firstCommit.controlller;

import com.example.firstCommit.entities.Candidate;
import com.example.firstCommit.service.CandidateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
