package com.LIBRARY_Manegment.Library.Modal;

import com.LIBRARY_Manegment.Library.Enum.TransactionStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="transaction")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String transactionNumber;

    @CreationTimestamp
    private Date transactionDate;

    private boolean isIssueOperation;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @ManyToOne
    @JoinColumn
    Card card;

    @ManyToOne
    @JoinColumn
    Book book;

}
