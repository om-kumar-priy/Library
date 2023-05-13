package com.LIBRARY_Manegment.Library.Controller;

import com.LIBRARY_Manegment.Library.DTO.RequestDto.StudentRequestDto;
import com.LIBRARY_Manegment.Library.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.LIBRARY_Manegment.Library.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.LIBRARY_Manegment.Library.Modal.Student;
import com.LIBRARY_Manegment.Library.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        return studentService. addStudent(studentRequestDto);

    }

    @PutMapping("/update_mobile")//use for update
    public UpdateStudentMobNoResponseDto updateMobMo( @RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws Exception{
        return studentService.updateMobNo(updateStudentMobRequestDto);

    }
    // delete a student by id

    // update the student by id

    // find a student by id

    @GetMapping("/get_student")
    public Student find(@RequestParam("Id") int id)
    {
     return studentService.find(id);
    }

    // find all the students
}
