package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }
    public void addPair(String studentName, String teacherName){
        studentRepository.addPair(teacherName,studentName);
    }
    public Student getStudent(String searchName){
        return studentRepository.getStudent(searchName);
    }
    public Teacher getTeacher(String teacherName){
        return studentRepository.getTeacher(teacherName);
    }
    public List<String> getStudentByTeacher(String teacherName){
        return studentRepository.getStudentsByTeacher(teacherName);
    }
    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public void deleteTeacherAndStudents(String teacherName){
        studentRepository.deleteTeacherAndStudents(teacherName);
    }
    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }

}
