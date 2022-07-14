package ql_sv.sevice;

import ql_sv.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById (long id);

    void add(Student newStudent);

    void update(Student newStudent);

    boolean exitsById(long id);

    void removeById(long id);

    public boolean checkDuplicateName(String fullName);

    public boolean checkDuplicateId(long id);


    List <Student> sortByScoreASC();

    List <Student> sortByScoreDES();

}
