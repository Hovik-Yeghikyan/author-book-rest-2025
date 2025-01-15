package com.vector.authorbookrest2025.service;


import com.vector.authorbookrest2025.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {

    Page<Author> findAll(Pageable pageable);

    List<Author> findAll();

    Author save(Author author);

    void deleteById(int id);

    Author findById(int id);

}
