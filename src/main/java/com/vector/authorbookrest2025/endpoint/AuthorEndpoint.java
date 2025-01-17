package com.vector.authorbookrest2025.endpoint;

import com.vector.authorbookrest2025.dto.AuthorDto;
import com.vector.authorbookrest2025.dto.SaveAuthorRequest;
import com.vector.authorbookrest2025.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorEndpoint {

    private final AuthorService authorService;

    @GetMapping(value = "/authors")
    public ResponseEntity<List<AuthorDto>> getAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @PostMapping("/authors")
    public ResponseEntity<?> create(@RequestBody SaveAuthorRequest authorRequest) {
        if (authorService.findByPhone(authorRequest.getPhone()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        AuthorDto authorFromDb = authorService.save(authorRequest);
        return ResponseEntity.ok(authorFromDb);
    }

    @DeleteMapping("authors/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (authorService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
