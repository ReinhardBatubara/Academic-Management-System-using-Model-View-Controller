package academic.model;

/**
 * @author 12S22012 Reinhard Batubara
 */
public class Enrollment {

    public String academicyear;
    public String semester;
    public String grade;
    public String code;
    public String id;
    public String remedi;
    public Integer sumRemedi;
    public String newGrade;

    public Enrollment(String code, String id, String academicyear, String semester, String grade, String remedi, Integer sumRemedi, String newGrade) {
        this.code = code;
        this.id = id;
        this.academicyear = academicyear;
        this.semester = semester;
        this.grade = grade;
        this.remedi = remedi;
        this.sumRemedi = sumRemedi;
        this.newGrade = newGrade; 
    }

    public String getRemedi() {
        return remedi;
    }
    public Integer getSumRemedi(){
        return sumRemedi;
    }
    public String getNewGrade(){
        return newGrade;
    }

    public String getCode() {
        return code;
    }

    public String getId() {
        return id;
    }

    public String getAcademicYear() {
        return academicyear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    // A, AB, B, BC, C, D, dan E.
    public double SumGps(String grade){
        if(grade.equals("A")){
            return 4;
        }else if(grade.equals("AB")){
            return 3.5;
        }
        else if(grade.equals("B")){
            return 3;
        }
        else if(grade.equals("BC")){
            return 2.5;
        }
        else if(grade.equals("C")){
            return 2;
        }
        else if(grade.equals("D")){
            return 1.5;
        }else if(grade.equals("E")){
            return 1;
        }else{
            return 0;
        }
    }

    public void setGrade(String grade2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setGrade'");
    }
}