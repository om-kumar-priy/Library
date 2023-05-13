package com.LIBRARY_Manegment.Library.Controller;

import com.LIBRARY_Manegment.Library.DTO.ResponseDto.GetAuthorResponseDto;
import com.LIBRARY_Manegment.Library.Modal.Author;
import com.LIBRARY_Manegment.Library.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author)
    {
     return   authorService.addAuthor(author);
    }


    // get author by mail

    @GetMapping("/get_email")
    public GetAuthorResponseDto getByMail(@RequestParam("email") String email){
      return  authorService.getByMail(email);
    }
// delete a Author by id

    // update the Author by id

    // find a Author by id

    // find all the Author
}
