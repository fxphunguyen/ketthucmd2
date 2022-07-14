package ql_ung_vien;

public class Experience extends Candidate{
    private int expInYear;
    private String proSkills;

    public Experience() {

    }

    public Experience(int certificatedId, String certificatedName, int certificatedRank, String certificatedDate, int expInYear, String proSkills) {
        super ( certificatedId, certificatedName, certificatedRank, certificatedDate );
        this.expInYear = expInYear;
        this.proSkills = proSkills;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkills() {
        return proSkills;
    }

    public void setProSkills(String proSkills) {
        this.proSkills = proSkills;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "expInYear=" + expInYear +
                ", proSkills='" + proSkills + '\'' +
                '}';
    }

    @Override
    public void showMe() {
        toString ();
    }
}
