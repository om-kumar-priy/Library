package com.LIBRARY_Manegment.Library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {


}