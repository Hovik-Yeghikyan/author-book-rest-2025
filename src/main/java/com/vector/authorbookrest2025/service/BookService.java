package com.vector.authorbookrest2025.service;


import com.vector.authorbookrest2025.dto.BookDto;
import com.vector.authorbookrest2025.dto.SaveBookRequest;

import java.util.List;

public interface BookService {


    List<BookDto> findAll();

    BookDto save(SaveBookRequest bookRequest);

    void deleteById(int id);

    BookDto findById(int id);


}
