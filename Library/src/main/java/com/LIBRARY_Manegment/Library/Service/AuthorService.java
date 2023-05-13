package com.LIBRARY_Manegment.Library.Service;

import com.LIBRARY_Manegment.Library.DTO.ResponseDto.GetAuthorResponseDto;
import com.LIBRARY_Manegment.Library.Modal.Author;

public interface AuthorService {
    public String addAuthor(Author author);
    public GetAuthorResponseDto getByMail(String email);
}
