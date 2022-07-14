package ql_sv.sevice;

import ql_sv.model.Student;
import ql_sv.utils.CSVUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StudentService implements IStudentService {
    public final static String PATH = "data/student.csv";
    private static StudentService instance;

    private StudentService() {
    }

    public static StudentService getInstance() {
        if (instance == null)
            instance = new StudentService();
        return instance;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        List<String> records = CSVUtils.readData(PATH);
        for (String record : records) {
            students.add(Student.parse(record));
        }
        return students;
    }

    @Override
    public Student findById(long id) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    @Override
    public void add(Student newStudent) {
        List<Student> students = findAll();
        newStudent.setId(System.currentTimeMillis() / 1000);
        students.add(newStudent);
        CSVUtils.writeData(PATH, students);
    }

    @Override
    public void update(Student newStudent) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getId() == newStudent.getId()) {
                String fullName = newStudent.getFullName();
                if (fullName != null && !fullName.isEmpty())
                    student.setFullName(newStudent.getFullName());

                Integer age = newStudent.getAge();
                if (age != null)
                    student.setAge(newStudent.getAge());

                String gender = newStudent.getGender();
                if (gender != null)
                    student.setGender(newStudent.getGender());

                String address = newStudent.getAddress();
                if (address != null)
                    student.setAddress(newStudent.getAddress());

                Double averageScore = newStudent.getAverageScore();
                if (averageScore != null)
                    student.setAverageScore(newStudent.getAverageScore());

                CSVUtils.writeData(PATH, students);
            }
        }

    }

    @Override
    public boolean exitsById(long id) {
        return findById(id) != null;
    }

    @Override
    public void removeById(long id) {
        List<Student> students = findAll();
        students.removeIf(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getId() == id;
            }
        });
        CSVUtils.writeData(PATH, students);
    }

    @Override
    public boolean checkDuplicateName(String fullName) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getFullName().equals(fullName))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicateId(long id) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getId() == id)
                return true;
        }
        return false;
    }

    @Override
    public List<Student> sortByScoreASC() {
        List<Student> students = new ArrayList<>(findAll());
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double result = o1.getAverageScore() - o2.getAverageScore();
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return students;
    }

    @Override
    public List<Student> sortByScoreDES() {
        List<Student> students = new ArrayList<>(findAll());
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double result = o2.getAverageScore() - o1.getAverageScore();
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return students;
    }

}
