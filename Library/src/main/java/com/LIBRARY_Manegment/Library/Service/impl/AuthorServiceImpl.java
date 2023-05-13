package com.LIBRARY_Manegment.Library.Service.impl;

import com.LIBRARY_Manegment.Library.DTO.ResponseDto.GetAuthorResponseDto;
import com.LIBRARY_Manegment.Library.Modal.Author;
import com.LIBRARY_Manegment.Library.Repository.AuthorRepository;
import com.LIBRARY_Manegment.Library.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author) {
      authorRepository.save(author);
        return "Author added";
    }

    @Override
    public GetAuthorResponseDto getByMail(String email) {
        Author author=authorRepository.findByEmail(email);

        GetAuthorResponseDto authorResponseDto=new GetAuthorResponseDto();
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setName(author.getName());

        return authorResponseDto;
    }
}
