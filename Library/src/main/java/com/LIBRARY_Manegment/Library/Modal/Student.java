package com.LIBRARY_Manegment.Library.Modal;

import com.LIBRARY_Manegment.Library.Enum.Department;
import lombok.*;


import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student")
public class Student {


    @Id  // for P.Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//self generated value
    private int id;

     private  String name;

     private int age;

    @Enumerated(EnumType.STRING)// say to sql it is enum
     private Department department;

     private String mobNo;

     @OneToOne(mappedBy = "student",cascade =CascadeType.ALL)
     //cas..........all use if save parent then save child automatically
    Card card;
}
