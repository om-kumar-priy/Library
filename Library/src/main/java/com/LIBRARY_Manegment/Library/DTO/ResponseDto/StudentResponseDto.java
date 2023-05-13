package com.LIBRARY_Manegment.Library.DTO.ResponseDto;

import com.LIBRARY_Manegment.Library.Enum.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponseDto {

    private int id;

    private String name;

    private int age;

    private Department department;

    private String mobNo;

    CardResponseDto cardResponseDto;
}