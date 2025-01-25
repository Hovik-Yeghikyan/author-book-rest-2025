package com.vector.authorbookrest2025.service.impl;


import com.vector.authorbookrest2025.dto.AuthorDto;
import com.vector.authorbookrest2025.dto.SaveAuthorRequest;
import com.vector.authorbookrest2025.entity.Author;
import com.vector.authorbookrest2025.exception.AuthorNotFoundException;
import com.vector.authorbookrest2025.mapper.AuthorMapper;
import com.vector.authorbookrest2025.repository.AuthorRepository;
import com.vector.authorbookrest2025.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;


    @Override
    public Page<Author> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    @Override
    public List<AuthorDto> findAll() {
        List<Author> authors = authorRepository.findAll();
        return authorMapper.toDtoList(authors);
    }

    @Override
    public AuthorDto save(SaveAuthorRequest saveAuthorRequest) {
        Author author = authorRepository.save(authorMapper.toEntity(saveAuthorRequest));
        return authorMapper.toDto(author);
    }

    @Override
    public void deleteById(int id) {
        if (!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException("Author not found with id " + id);
        }
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto findById(int id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            return null;
        }
        return authorMapper.toDto(author);

    }

    @Override
    public Optional<Author> findByPhone(String phone) {
        return authorRepository.findByPhone(phone);
    }


}
