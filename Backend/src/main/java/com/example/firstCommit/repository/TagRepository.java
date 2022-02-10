package com.example.firstCommit.repository;

import com.example.firstCommit.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    //Optional<Tag> findByTagName(String name);

    //Boolean existsByTagTag(String tag);

}