package com.example.firstCommit.controlller;

import com.example.firstCommit.entities.Tag;
import com.example.firstCommit.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    /**
     * GET http://localhost:8080/api/tags
     */

    @GetMapping("/tags")
    public List<Tag> findAll() {
        return tagService.findAll();}

    @GetMapping("/tags/{id}")
    public ResponseEntity<Tag> findById(@PathVariable Long id){
        Optional<Tag> tagOpt = tagService.findById(id);
        if(tagOpt.isPresent())
            return ResponseEntity.ok(tagOpt.get());
        return ResponseEntity.notFound().build(); // 404
    }

    /**
     * Create a new tag
     */
    @PostMapping("/tags")
    public ResponseEntity<Tag> create(@RequestBody Tag tag){
        if (tag.getId() != null)
            return ResponseEntity.badRequest().build(); //400
        return ResponseEntity.ok(tagService.save(tag));
    }

    @DeleteMapping("/tags/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean result = tagService.deleteById(id);
        if(result)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.internalServerError().build();
    }
}
