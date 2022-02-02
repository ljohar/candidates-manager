package com.example.firstCommit.service;

import com.example.firstCommit.entities.Candidate;

import java.util.List;
import java.util.Optional;

/**
 * CRUD: Create, Retrieve / Read, Update, Delete
 */

public interface CandidateService {

    Optional<Candidate> findById(Long id);
    List<Candidate> findAll();

    Candidate save(Candidate candidate);

    boolean deleteById(Long id);

    boolean deleteAll();

}
