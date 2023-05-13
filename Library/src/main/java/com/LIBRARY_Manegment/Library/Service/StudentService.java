package com.LIBRARY_Manegment.Library.Service;

import com.LIBRARY_Manegment.Library.DTO.RequestDto.StudentRequestDto;
import com.LIBRARY_Manegment.Library.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.LIBRARY_Manegment.Library.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.LIBRARY_Manegment.Library.Modal.Student;
import com.LIBRARY_Manegment.Library.exception.StudentNotFoundException;

public interface StudentService {
    public  String addStudent(StudentRequestDto studentRequestDto);
    public Student find(int id);
    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException;
}
