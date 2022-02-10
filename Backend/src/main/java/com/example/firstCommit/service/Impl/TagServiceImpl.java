package com.example.firstCommit.service.Impl;

import com.example.firstCommit.entities.Tag;
import com.example.firstCommit.repository.TagRepository;
import com.example.firstCommit.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Optional<Tag> findById(Long id) {
        if(id==null || id<=0)
            return Optional.empty();
        return tagRepository.findById(id);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> saveAll(List<Tag> tag) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || !tagRepository.existsById(id))
            return false;
        tagRepository.deleteById(id);
        return true;
    }
}
