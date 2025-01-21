package com.vector.authorbookrest2025.mapper;

import com.vector.authorbookrest2025.dto.AuthorDto;
import com.vector.authorbookrest2025.dto.SaveAuthorRequest;
import com.vector.authorbookrest2025.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {


    //  @Mapping(source = "name", target = "name")
    AuthorDto toDto(Author author);

    List<AuthorDto> toDtoList(List<Author> authors);

    Author toEntity(SaveAuthorRequest saveAuthorRequest);
}
