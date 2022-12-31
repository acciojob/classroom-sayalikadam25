package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class StudentRepository {
    private HashMap<String,Student> studentDb;
    private HashMap<String, Teacher> teacherDb;
    private HashMap<String, List<String>> pair;
    private List<Student> list;
    public StudentRepository() {
        studentDb = new HashMap<>();
        teacherDb = new HashMap<>();
        pair = new HashMap<>();
        list = new ArrayList<>();
    }

    public void addStudent(Student student){
        String key = student.getName();
        studentDb.put(key,student);
    }
    public void addTeacher(Teacher teacher){
        String key = teacher.getName();
        teacherDb.put(key,teacher);
    }
    public Student getStudent(String searchName){
        return studentDb.get(searchName);
    }
    public Teacher getTeacher(String searchName){
        return teacherDb.get(searchName);
    }
    public void addPair(String teacherName, String studentName){
        List<String> l = pair.get(teacherName);
        if(l==null)
            l=new ArrayList<>();
        l.add(studentName);
        pair.put(teacherName,l);
    }
    public List<String> getStudentsByTeacher(String teacherName){
        return pair.get(teacherName);
    }
    public List<String> getAllStudents(){
        List<String> l= new ArrayList<>();
        for(Student s:studentDb.values()){
            l.add(s.getName());
        }
        return l;
    }
    public void deleteTeacherAndStudents(String teacherName){
        List<String> lis= pair.get(teacherName);
        for(String name:lis){
            studentDb.remove(name);
        }
        pair.remove(teacherName);
        teacherDb.remove(teacherName);
    }
    public void deleteAllTeachers(){
        pair = new HashMap<>();
        teacherDb = new HashMap<>();
    }

}
