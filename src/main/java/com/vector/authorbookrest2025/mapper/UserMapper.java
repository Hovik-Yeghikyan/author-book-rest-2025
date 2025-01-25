package com.vector.authorbookrest2025.mapper;

import com.vector.authorbookrest2025.dto.SaveUserRequest;
import com.vector.authorbookrest2025.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SaveUserRequest saveUserRequest);

}
