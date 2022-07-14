package ql_ung_vien;

public class Main {
    public static void main(String[] args) {
        Candidate[] candidates = new Candidate[3];
        candidates[0] = new Experience ();
        candidates[1] = new Fresher ();
        candidates[2] = new Intern ();
        for (Candidate candidate : candidates){
            if (candidate instanceof Experience){
                candidate.showMe ();
            }
            if(candidate instanceof Fresher){
                candidate.showMe ();
            }
            if(candidate instanceof Intern){
                candidate.showMe ();
            }
            System.out.println(candidate);
        }
    }
}
