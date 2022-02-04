package com.example.firstCommit.repository;

import com.example.firstCommit.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    //List<Candidate> findAllByCountry (String country)
}
