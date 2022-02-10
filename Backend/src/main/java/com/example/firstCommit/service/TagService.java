package com.example.firstCommit.service;

import com.example.firstCommit.entities.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Optional<Tag> findById(Long id);

    List<Tag> findAll();

    Tag save(Tag tag);

    List<Tag> saveAll(List<Tag> tag);

    boolean deleteById(Long id);
}
