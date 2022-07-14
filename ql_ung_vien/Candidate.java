package ql_ung_vien;

public abstract class Candidate {
    private int candidateId;
    private String fullName;
    private String birthDate;
    private int phoneNumber;
    private String email;
    private String candidateType;
    private int certificatedId;
    private String certificatedName;
    private int certificatedRank;
    private String certificatedDate;

    public Candidate() {
    }

    public Candidate(int candidateId, String fullName, String birthDate, int phoneNumber, String email, String candidateType, int certificatedId, String certificatedName, int certificatedRank, String certificatedDate) {
        this.candidateId = candidateId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.candidateType = candidateType;
        this.certificatedId = certificatedId;
        this.certificatedName = certificatedName;
        this.certificatedRank = certificatedRank;
        this.certificatedDate = certificatedDate;
    }

    public Candidate(int certificatedId, String certificatedName, int certificatedRank, String certificatedDate) {
        this.certificatedId = certificatedId;
        this.certificatedName = certificatedName;
        this.certificatedRank = certificatedRank;
        this.certificatedDate = certificatedDate;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCandidateType() {
        return candidateType.equals ( "0" )?"EXPERIENCE": candidateType.equals ( "1" )?"FRESHER":candidateType.equals ( "2" )?"INTERN":"INVALID!";
    }

    public void setCandidateType(String candidateType) {
        this.candidateType = candidateType;
    }

    public int getCertificatedId() {
        return certificatedId;
    }

    public void setCertificatedId(int certificatedId) {
        this.certificatedId = certificatedId;
    }

    public String getCertificatedName() {
        return certificatedName;
    }

    public void setCertificatedName(String certificatedName) {
        this.certificatedName = certificatedName;
    }

    public int getCertificatedRank() {
        return certificatedRank;
    }

    public void setCertificatedRank(int certificatedRank) {
        this.certificatedRank = certificatedRank;
    }

    public String getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId=" + candidateId +
                ", fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", candidateType='" + candidateType + '\'' +
                ", certificatedId=" + certificatedId +
                ", certificatedName='" + certificatedName + '\'' +
                ", certificatedRank=" + certificatedRank +
                ", certificatedDate='" + certificatedDate + '\'' +
                '}';
    }

    public abstract void showMe();
    public void showInfo(){
        toString ();
    }
}
