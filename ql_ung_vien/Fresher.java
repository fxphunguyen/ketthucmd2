package ql_ung_vien;

public class Fresher extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(int certificatedId, String certificatedName, int certificatedRank, String certificatedDate, String graduationDate, String graduationRank, String education) {
        super ( certificatedId, certificatedName, certificatedRank, certificatedDate );
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "graduationDate='" + graduationDate + '\'' +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\'' +
                '}';
    }

    @Override
    public void showMe() {
        toString ();
    }
}
