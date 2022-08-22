package com.example.firstCommit.service.Impl;


import com.example.firstCommit.entities.Candidate;
import com.example.firstCommit.entities.Tag;
import com.example.firstCommit.repository.CandidateRepository;
import com.example.firstCommit.service.CandidateService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

// TODO Add log messages
// private final Logger log = LoggerFactory.getLogger(BookController.class);

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;


    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }


    /**
     * Search a candidate by id
     * @param id
     * @return a Candidate object if exists, otherwise return an empty optional instance
     */
    @Override
    public Optional<Candidate> findById(Long id) {
        if(id==null || id<=0)
            return Optional.empty();
        return candidateRepository.findById(id);
    }

    /**
     * Search by all candidates
     * @return a list of candidates
     */
    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public List<Candidate> findAllByCountry(String candidateCountry){
        if (candidateCountry == null)
            return new ArrayList<>();
        return candidateRepository.findAllByCountry(candidateCountry);
    }

    @Override
    public List<Candidate> findAllByPresencialidadTrue() {
        return candidateRepository.findAllByPresencialidadTrue();
    }

    @Override
    public List<Candidate> findAllByPresencialidadFalse() {
        return candidateRepository.findAllByPresencialidadFalse();
    }

    @Override
    public List<Candidate> findAllByTrasladoTrue() {
        return candidateRepository.findAllByTrasladoTrue();
    }

    @Override
    public List<Candidate> findAllByTrasladoFalse() {
        return candidateRepository.findAllByTrasladoFalse();
    }

    @Override
    public List<Candidate> findAllByCountryAndCity(String country, String city) {
        return candidateRepository.findAllByCountryAndCity(country, city);
    }

    @Override
    public List<Candidate> findAllByTags_Tagname(String tag) {
        if (!StringUtils.hasLength(tag))
            throw new IllegalArgumentException("Etiqueta incorrecta");

        return candidateRepository.findAllByTags_Tagname(tag);
    }



    @Override
    public Candidate save(Candidate candidate) throws IllegalArgumentException {
        if(!isValidEmail(candidate.getEmail()))
            throw new IllegalArgumentException("Email incorrecto");
        return candidateRepository.save(candidate);
    }

    @Override
    // TODO resolve return null
    public List<Candidate> saveAll(List<Candidate> candidate) {
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


    private static boolean isValidEmail(String emailAddress) {
        String regexPattern = "^(\\S+)@(\\S+)\\.(\\S+)$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
