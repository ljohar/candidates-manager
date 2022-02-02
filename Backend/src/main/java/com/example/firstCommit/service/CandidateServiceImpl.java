package com.example.firstCommit.service;

import com.example.firstCommit.entities.Candidate;
import com.example.firstCommit.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;


    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }


    @Override
    public Optional<Candidate> findById(Long id) {
        if(id==null || id<=0)
            return Optional.empty();

        return candidateRepository.findById(id);
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }


    @Override
    public Candidate save(Candidate candidate) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || !candidateRepository.existsById(id))
            return false;

        candidateRepository.deleteById(id);

        return true;
    }

    @Override
    public boolean deleteAll() {
        candidateRepository.deleteAll();
        return true;
    }
}
