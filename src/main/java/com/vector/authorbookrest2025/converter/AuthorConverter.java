package com.vector.authorbookrest2025.converter;

import com.vector.authorbookrest2025.dto.AuthorDto;
import com.vector.authorbookrest2025.dto.SaveAuthorRequest;
import com.vector.authorbookrest2025.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {

    public AuthorDto fromEntityToDto(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .phone(author.getPhone())
                .gender(author.getGender())
                .build();
    }

    public Author fromDtoToEntity(SaveAuthorRequest saveAuthorRequest) {
        return Author.builder()
                .name(saveAuthorRequest.getName())
                .surname(saveAuthorRequest.getSurname())
                .phone(saveAuthorRequest.getPhone())
                .dateOfBirthday(saveAuthorRequest.getDateOfBirthday())
                .gender(saveAuthorRequest.getGender())
                .build();
    }
}
