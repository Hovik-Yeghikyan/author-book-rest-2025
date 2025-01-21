package com.vector.authorbookrest2025.mapper;

import com.vector.authorbookrest2025.dto.BookDto;
import com.vector.authorbookrest2025.dto.SaveBookRequest;
import com.vector.authorbookrest2025.entity.Author;
import com.vector.authorbookrest2025.entity.Book;
import com.vector.authorbookrest2025.exception.AuthorNotFoundException;
import com.vector.authorbookrest2025.repository.AuthorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BookMapper {
    @Autowired
    private AuthorRepository authorRepository;

    public abstract BookDto toDto(Book book);

    public abstract List<BookDto> toDtoList(List<Book> books);

    @Mapping(target = "author", expression = "java(findAuthorById(bookRequest.getAuthorId()))")
    @Mapping(target = "createdAt",expression = "java(new java.util.Date())")
    public abstract Book toEntity(SaveBookRequest bookRequest);

    protected Author findAuthorById(int id) {
        return authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException("Author not found with " + id +" id"));

    }
}
