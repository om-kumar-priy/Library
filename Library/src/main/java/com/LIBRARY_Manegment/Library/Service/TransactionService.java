package com.LIBRARY_Manegment.Library.Service;

import com.LIBRARY_Manegment.Library.DTO.RequestDto.IssueBookRequestDto;
import com.LIBRARY_Manegment.Library.DTO.ResponseDto.IssueBookResponseDto;

public interface TransactionService {
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}


