package com.example.firstCommit.controlller;

import com.example.firstCommit.entities.Candidate;
import com.example.firstCommit.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
        return candidateService.findAllByRemoteTrue();
    }

    @GetMapping("/candidates/search/presencialidad/presencialidad=false")
    public List<Candidate> findAllByPresencialidadFalse(){
        return candidateService.findAllByRemoteFalse();
    }

    @GetMapping("/candidates/search/traslado/traslado=true")
    public List<Candidate> findAllByTrasladoTrue(){
        return candidateService.findAllByRelocateTrue();
    }

    @GetMapping("/candidates/search/traslado/traslado=false")
    public List<Candidate> findAllByTrasladoFalse(){
        return candidateService.findAllByRelocateFalse();
    }

    @GetMapping("/candidates/search/tags/{tagname}")
    public List<Candidate> findAllByTagTagname(@PathVariable String tagname){
        return candidateService.findAllByTags_Tagname(tagname);
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
//            log.warn("Trying to update a non existent candidate")
            return ResponseEntity.badRequest().build(); // 400
//        TODO Retrieve the object and change the desire fields through setters
//        TODO Verify if the object exists by id
//        if(!candidateService.existbyId(candidate.getId())){
//          log.warn("")
//           return ResponseEntity.notFound().build(); // 404
        return ResponseEntity.ok(candidateService.save(candidate));
    }
// Integridad referencial borrar una tabla que esta relacionada con otras
// puede arrojar excepciones
    @DeleteMapping("/candidates/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean result = candidateService.deleteById(id);
// TODO verify first if the object exists
//        if(!candidateService.existbyId(candidate.getId())){
//          log.warn("Trying to delete a non existent candidate")
//           return ResponseEntity.notFound().build(); // 404
        if(result)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.internalServerError().build();
    }
//    TODO implement method deleteALl
//    @ApiIgnore
//    @DeleteMapping("/candidates")
//    public ResponseEntity<Void> deleteAll(){
//        log.info("REST Request for delete all candidates");
//        candidateService.deleteAll();
//        return RsponseEntity.noContent().build();
//
//    }


}
