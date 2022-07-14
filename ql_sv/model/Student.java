package ql_sv.model;

public class Student {
    private long id;
    private String fullName;
    private int age;
    private String gender;
    private String address;
    private double averageScore;

    public Student(String fullName, int age, String gender, String address, double averageScore) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averageScore = averageScore;
    }


    public static Student parse (String raw){
        String[]fields = raw.split(",");
        long id = Long.parseLong(fields[0]);
        String fullName = fields[1];
        int age = Integer.parseInt(fields[2]);
        String gender = fields[3];
        String address = fields[4];
        double averageScore = Double.parseDouble(fields[5]);
        return new Student(id,fullName,age,gender,address,averageScore);
    }

    public Student(long id, String fullName, int age, String gender, String address, double averageScore) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averageScore = averageScore;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",
                id,
                fullName,
                age,
                gender,
                address,
                averageScore);

    }
}
