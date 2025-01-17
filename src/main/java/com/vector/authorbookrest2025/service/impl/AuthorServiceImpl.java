package com.vector.authorbookrest2025.service.impl;


import com.vector.authorbookrest2025.converter.AuthorConverter;
import com.vector.authorbookrest2025.dto.AuthorDto;
import com.vector.authorbookrest2025.dto.SaveAuthorRequest;
import com.vector.authorbookrest2025.entity.Author;
import com.vector.authorbookrest2025.repository.AuthorRepository;
import com.vector.authorbookrest2025.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;


    @Override
    public Page<Author> findAll(Pageable pageable) {
        Page<Author> authors = authorRepository.findAll(pageable);
        return authors;
    }

    @Override
    public List<AuthorDto> findAll() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> result = new ArrayList<>();
        for (Author author : authors) {
            result.add(authorConverter.fromEntityToDto(author));
        }
        return result;
    }

    @Override
    public AuthorDto save(SaveAuthorRequest saveAuthorRequest) {
        Author author = authorRepository.save(authorConverter.fromDtoToEntity(saveAuthorRequest));
        return authorConverter.fromEntityToDto(author);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto findById(int id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            return null;
        }
        return authorConverter.fromEntityToDto(author);

    }

    @Override
    public Optional<Author> findByPhone(String phone) {
        return authorRepository.findByPhone(phone);
    }


}
