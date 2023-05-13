package com.LIBRARY_Manegment.Library.Service.impl;

import com.LIBRARY_Manegment.Library.DTO.RequestDto.StudentRequestDto;
import com.LIBRARY_Manegment.Library.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.LIBRARY_Manegment.Library.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.LIBRARY_Manegment.Library.Enum.CardStatus;
import com.LIBRARY_Manegment.Library.Modal.Card;
import com.LIBRARY_Manegment.Library.Modal.Student;
import com.LIBRARY_Manegment.Library.Repository.StudentRepository;
import com.LIBRARY_Manegment.Library.Service.StudentService;
import com.LIBRARY_Manegment.Library.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

//      it for student parameter not Dto


// we need to set crd otherwise it take null
//        Card card=new Card();
//        card.setCardStatus(CardStatus.ACTIVATED);
//        card.setValidTill("2025-01-21");
//        card.setStudent(student);
//
//        student.setCard(card);
//        studentRepository.save(student);
//        return "Student added successfully";


        Student student=new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2025-01-25");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);
        return "Student added successfully";


    }

    @Override
    public Student find(int id) {

        return studentRepository.findById(id).get();
    }

    @Override
    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        try{
         Student   student=studentRepository.findById(updateStudentMobRequestDto.getId()).get();
        student.setMobNo(updateStudentMobRequestDto.getMobNo());
        Student updatedStudent=studentRepository.save(student);

       // now for dto
            UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto=new UpdateStudentMobNoResponseDto();
            updateStudentMobNoResponseDto.setName(updatedStudent.getName());
            updateStudentMobNoResponseDto.setMobNo(updatedStudent.getMobNo());
            return updateStudentMobNoResponseDto;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Invalid Student id");

        }

    }
}
