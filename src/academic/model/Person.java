package academic.model;

/**
 * @author 12S22012 Reinhard Batubara
 */

public class Person {
    protected String id;
    protected String name;
    protected String studyprogram;

    public Person(String id, String name, String studyprogram) {
        this.id = id;
        this.name = name;
        this.studyprogram = studyprogram;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getStudyProgram() {
        return studyprogram;
    }

    public void setStudyProgram(String studyprogram) {
        this.studyprogram = studyprogram;
    }
}
