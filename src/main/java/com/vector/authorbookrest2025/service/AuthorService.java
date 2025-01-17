package com.vector.authorbookrest2025.service;


import com.vector.authorbookrest2025.dto.AuthorDto;
import com.vector.authorbookrest2025.dto.SaveAuthorRequest;
import com.vector.authorbookrest2025.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Page<Author> findAll(Pageable pageable);

    List<AuthorDto> findAll();

    AuthorDto save(SaveAuthorRequest saveAuthorRequest);

    void deleteById(int id);

    AuthorDto findById(int id);

    Optional<Author> findByPhone(String phone);

}
