package com.LIBRARY_Manegment.Library.Service.impl;

import com.LIBRARY_Manegment.Library.DTO.RequestDto.IssueBookRequestDto;
import com.LIBRARY_Manegment.Library.DTO.ResponseDto.IssueBookResponseDto;
import com.LIBRARY_Manegment.Library.Enum.CardStatus;
import com.LIBRARY_Manegment.Library.Enum.TransactionStatus;
import com.LIBRARY_Manegment.Library.Modal.Book;
import com.LIBRARY_Manegment.Library.Modal.Card;
import com.LIBRARY_Manegment.Library.Modal.Transaction;
import com.LIBRARY_Manegment.Library.Repository.BookRepository;
import com.LIBRARY_Manegment.Library.Repository.CardRepository;
import com.LIBRARY_Manegment.Library.Repository.TransactionRepository;
import com.LIBRARY_Manegment.Library.Service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
    CardRepository cardRepository;
  @Autowired
    BookRepository bookRepository;

  @Autowired
  TransactionRepository transactionRepository;

    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

//        Transaction transaction=new Transaction();
//        transaction.setTransactionNumber(String.valueOf((UUID.randomUUID())));
//        transaction.setIssueOperation(true);
//
//        Card card;
//        try {
//            card=cardRepository.findById(issueBookRequestDto.getBookId()).get();
//
//        }
//       catch (Exception e) {
//           transaction.setTransactionStatus(TransactionStatus.FAILED);
//
//           transactionRepository.save(transaction);
//
//           throw new Exception("Invalid card Id !!");
//       }
//
//        transaction.setCard(card );
//        Book  book;
//        try {
//            book=bookRepository.findById(issueBookRequestDto.getBookId()).get();
//        }
//        catch (Exception e){
//            transaction.setTransactionStatus(TransactionStatus.FAILED);
//            transactionRepository.save(transaction);
//            throw new Exception("Invalid book id !!");
//        }
//        transaction.setBook(book);
//
//
//        if (card.getCardStatus()!= CardStatus.ACTIVATED)
//        {
//            transaction.setTransactionStatus(TransactionStatus.FAILED);
//            transactionRepository.save(transaction);
//            throw new Exception("Card is not Active !!");
//        }
//
//        if(book.isIssued()==true)
//        {
//            transaction.setTransactionStatus(TransactionStatus.FAILED);
//            transactionRepository.save(transaction);
//            throw new Exception("Book not Available !!");
//        }
//
//
//        //prepare response dto
//
//        IssueBookResponseDto issueBookResponseDto=new IssueBookResponseDto();
//        issueBookResponseDto.setBookName(book.getTitle());
//        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
//        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());
//
//
//        return issueBookResponseDto;


        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        Card card;
        try{
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id!!!");
        }

        transaction.setCard(card);

        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book id!!!!");
        }

        transaction.setBook(book);

        if(card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not Active!!!");
        }

        if(book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available!!!");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getBooksIssued().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card); // save card, book and transaction.

        // prepare response dtp;

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());

        return issueBookResponseDto;
    }
}