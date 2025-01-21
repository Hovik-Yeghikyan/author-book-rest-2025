package com.vector.authorbookrest2025.endpoint;

import com.vector.authorbookrest2025.dto.BookDto;
import com.vector.authorbookrest2025.dto.SaveBookRequest;
import com.vector.authorbookrest2025.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookEndpoint {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SaveBookRequest saveBookRequest) {

        return ResponseEntity.ok(bookService.save(saveBookRequest));
    }
}
