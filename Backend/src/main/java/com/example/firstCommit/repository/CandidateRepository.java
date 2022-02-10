package com.example.firstCommit.repository;

import com.example.firstCommit.entities.Candidate;
import com.example.firstCommit.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {


    List<Candidate> findAllByCountry (String country);

    List<Candidate> findAllByCountryAndCity (String country, String city);

    List<Candidate> findAllByPresencialidadTrue();

    List<Candidate> findAllByPresencialidadFalse();

    List<Candidate> findAllByTrasladoTrue();

    List<Candidate> findAllByTrasladoFalse();

    //List<Candidate> findAllByTagTagin(Collection<Tag> tags);

    //List<Candidate> findAllByTagTagname(String tag);



}
