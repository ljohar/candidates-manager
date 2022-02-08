package com.example.firstCommit.controlller;

import com.example.firstCommit.entities.Candidate;
import com.example.firstCommit.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    /**
     * GET http://localhost:8080/api/candidates
     */

    @GetMapping("/candidates")
    public List<Candidate> findAll() {
        return candidateService.findAll();}

    @GetMapping("/candidates/{id}")
    public ResponseEntity<Candidate> findById(@PathVariable Long id){
        Optional<Candidate> candidateOpt = candidateService.findById(id);
        if(candidateOpt.isPresent())
            return ResponseEntity.ok(candidateOpt.get());
        return ResponseEntity.notFound().build(); // 404
    }


    @GetMapping("/candidates/search/country/{country}")
    public List<Candidate> findAllByCountry(@PathVariable String country){
       return candidateService.findAllByCountry(country);
    }

    @GetMapping("/candidates/search/country/{country}/{city}")
    public List<Candidate> findAllByCountryAndCity(@PathVariable String country, @PathVariable String city){
        return candidateService.findAllByCountry(country);
    }

    @GetMapping("/candidates/search/presencialidad/presencialidad=true")
    public List<Candidate> findAllByPresencialidadTrue(){
        return candidateService.findAllByPresencialidadTrue();
    }

    @GetMapping("/candidates/search/presencialidad/presencialidad=false")
    public List<Candidate> findAllByPresencialidadFalse(){
        return candidateService.findAllByPresencialidadFalse();
    }

    @GetMapping("/candidates/search/traslado/traslado=true")
    public List<Candidate> findAllByTrasladoTrue(){
        return candidateService.findAllByTrasladoTrue();
    }

    @GetMapping("/candidates/search/traslado/traslado=false")
    public List<Candidate> findAllByTrasladoFalse(){
        return candidateService.findAllByTrasladoFalse();
    }


    /**
     * Create a new candidate
     */
    @PostMapping("/candidates")
    public ResponseEntity<Candidate> create(@RequestBody Candidate candidate){
        if (candidate.getId() != null)
            return ResponseEntity.badRequest().build(); //400
        return ResponseEntity.ok(candidateService.save(candidate));
    }

    /**
     * Update candidate info
     * PUT http://localhost:8080/api/candidates
     */
    @PutMapping("/candidates")
    public ResponseEntity<Candidate> update(@RequestBody Candidate candidate){
        if (candidate.getId() == null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(candidateService.save(candidate));
    }

    @DeleteMapping("/candidates/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean result = candidateService.deleteById(id);
        if(result)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.internalServerError().build();
    }


}
