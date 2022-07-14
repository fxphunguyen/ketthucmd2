package ql_ung_vien;

public class Candidate {
    private Long candidateId;
    private String fullName;
    private int birthDay;
    private int phone;
    private String email;
    private Candidate_Type candidate_type;

    public Candidate() {
    }

    public Candidate(Long candidateId, String fullName, int birthDay, int phone, String email, Candidate_Type candidate_type) {
        this.candidateId = candidateId;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.candidate_type = candidate_type;
    }

    public static Candidate parse(String record) {
        String[] fields = record.split(",");
        Long id = Long.parseLong(fields[0]);
        String fullName = fields[1];
        int birthDay = Integer.parseInt(fields[2]);
        int phone = Integer.parseInt(fields[3]);
        String email = fields[4];
        Candidate_Type candidate_type = Candidate_Type.valueOf(fields[5]);
        return new Candidate(id, fullName, birthDay, phone, email, candidate_type);
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Candidate_Type getCandidate_type() {
        return candidate_type;
    }

    public void setCandidate_type(Candidate_Type candidate_type) {
        this.candidate_type = candidate_type;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",
                candidateId,
                fullName,
                birthDay,
                phone,
                email,
                candidate_type);
    }
}
