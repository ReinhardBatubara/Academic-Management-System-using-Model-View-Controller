package academic.model;

/**
 * @author 12S22012 Reinhard Batubara
 */
public class Course {

    private String code;
    private String name;
    private int credits;
    private String passinggrade;

    public Course(String code, String name, int credits, String passinggrade){
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.passinggrade = passinggrade;
    }

    public String getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public int getCredits(){
        return credits;
    }

    public String getPassingGrade(){
        return passinggrade;
    }
}


