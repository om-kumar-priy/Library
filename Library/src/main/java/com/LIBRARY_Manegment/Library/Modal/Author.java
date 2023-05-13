package com.LIBRARY_Manegment.Library.Modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Author")
public class Author {


    @Id  // for P.Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//self generated value
    private int id;

    private  String name;

    private  int age;

   @Column(unique=true)
    private String email;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();

}
