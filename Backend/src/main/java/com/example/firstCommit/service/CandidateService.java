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

    List<Candidate> findAllByCountry(String candidateCountry);

    List<Candidate> findAllByRemoteTrue();

    List<Candidate> findAllByRemoteFalse();

    List<Candidate> findAllByRelocateTrue();

    List<Candidate> findAllByRelocateFalse();

    List<Candidate> findAllByCountryAndCity(String country, String city);

    Candidate save(Candidate candidate);

    List<Candidate> saveAll(List<Candidate> candidate);

    boolean deleteById(Long id);

   // List<Candidate> findAllByTagTagin(List <Tag> tags);

    List<Candidate> findAllByTags_Tagname(String tag);

    boolean deleteAll();

}
