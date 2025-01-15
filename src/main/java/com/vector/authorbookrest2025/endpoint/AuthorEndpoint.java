package com.vector.authorbookrest2025.endpoint;

import com.vector.authorbookrest2025.entity.Author;
import com.vector.authorbookrest2025.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorEndpoint {

    private final AuthorService authorService;

    @GetMapping(value = "/authors")
    public List<Author> getAll() {
        return authorService.findAll();
    }
    @GetMapping("/authors/{id}")
    public Author getById(@PathVariable("id") int id) {
        return authorService.findById(id);
    }

    @PostMapping("/authors")
    public Author create(@RequestBody Author author) {
        return authorService.save(author);
    }

    @DeleteMapping("authors/{id}")
    public void delete(@PathVariable("id") int id) {
        authorService.deleteById(id);
    }
}
