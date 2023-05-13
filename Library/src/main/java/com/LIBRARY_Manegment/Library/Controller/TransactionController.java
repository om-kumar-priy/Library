package com.LIBRARY_Manegment.Library.Controller;


import com.LIBRARY_Manegment.Library.DTO.RequestDto.IssueBookRequestDto;
import com.LIBRARY_Manegment.Library.DTO.ResponseDto.IssueBookResponseDto;
import com.LIBRARY_Manegment.Library.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        return transactionService.issueBook(issueBookRequestDto);
    }
}

