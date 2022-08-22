package com.example.firstCommit.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represnts the tags table in database
 */
@Entity
@Table(name = "tags")
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tags" )
    private String tagname;

    // Bidirectional
    @ManyToMany(mappedBy = "tags")
    private List<Candidate> candidates = new ArrayList<>();

    public Tag() {
    }

    public Tag(Long id, String tagName) {
        this.id = id;
        this.tagname = tagName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tag='" + tagname + '\'' +
                '}';
    }
}
