public class Mark {
    int subjectScore;

    Subject subject;

    Mark(int subjectScore,Subject subject){
        this.subjectScore = subjectScore;
        this.subject = subject;
    }

    public int getSubjectScore() {
        return subjectScore;
    }

    public Subject getSubject(){
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setSubjectScore(int subjectScore) {
        this.subjectScore = subjectScore;
    }
}
