package ql_ung_vien;

public class Intern extends Candidate {
    private String majors;
    private int semester;
    private String universityName;

    public Intern() {
    }

    public Intern(int certificatedId, String certificatedName, int certificatedRank, String certificatedDate, String majors, int semester, String universityName) {
        super ( certificatedId, certificatedName, certificatedRank, certificatedDate );
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "majors='" + majors + '\'' +
                ", semester=" + semester +
                ", universityName='" + universityName + '\'' +
                '}';
    }

    @Override
    public void showMe() {
        toString ();
    }
}
