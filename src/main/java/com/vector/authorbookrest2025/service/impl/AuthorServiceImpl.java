package com.vector.authorbookrest2025.service.impl;


import com.vector.authorbookrest2025.entity.Author;
import com.vector.authorbookrest2025.repository.AuthorRepository;
import com.vector.authorbookrest2025.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    @Override
    public Page<Author> findAll(Pageable pageable) {
        Page<Author> authors = authorRepository.findAll(pageable);
        return authors;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author findById(int id) {
        return authorRepository.findById(id).orElse(null);
    }


}
