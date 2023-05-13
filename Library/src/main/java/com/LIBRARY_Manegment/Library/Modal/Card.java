package com.LIBRARY_Manegment.Library.Modal;

import com.LIBRARY_Manegment.Library.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Card")
public class Card {

    @Id  // for P.Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//self generated value
    private int id;

    @CreationTimestamp
    private Date issueDate;

    @UpdateTimestamp
    private  Date updatedOn;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    private String validTill;

    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> booksIssued = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();
}
