package academic.controller;

import academic.model.*;
import java.util.ArrayList;
import java.util.Collections;

public class ApplicationController {

    public static void addCourse(String[] inputSegments, ArrayList<Course> courses) {
        String code = inputSegments[1];
        String name = inputSegments[2];
        int credits = Integer.parseInt(inputSegments[3]);
        String passinggrade = inputSegments[4];
        boolean mirip = false;
        
        for (Course course : courses) {
            if (course.getCode().equalsIgnoreCase(code)) {
                mirip = true;
                break;
            }
        }
        
        if (!mirip) {
            Course course = new Course(code, name, credits, passinggrade);
            courses.add(course);
        }
    }

    public static void openCourse(String[] inputSegments, ArrayList<Course> courses, ArrayList<Lecturer> lecturers, ArrayList<CourseOpening> courseOpenings) {
        if (inputSegments.length >= 5) {
            String code = inputSegments[1];
            String academicYear = inputSegments[2];
            String semester = inputSegments[3];
            String lecturerInitialList = inputSegments[4];
            String LecturerInitial = inputSegments[4];
            
            for (Course course : courses) {
                if (course.getCode().equalsIgnoreCase(code)) {
                    String name = course.getName();
                    Integer credit = course.getCredits();
                    String grade = course.getPassingGrade();
            
                    for (Lecturer lecturer : lecturers) {
                        if (lecturer.getInitial().equalsIgnoreCase(lecturerInitialList)) {
                            String email = lecturer.getEmail();
                
                            CourseOpening courseOpening = new CourseOpening(code, name, credit, grade, academicYear, semester, lecturerInitialList, lecturers.toArray(new Lecturer[lecturers.size()]), LecturerInitial, email);
                            courseOpenings.add(courseOpening);
                        }
                    }
                    break;
                }
            }
        }
    }

    public static void showCourseHistory(String[] inputSegments, ArrayList<CourseOpening> courseOpenings, ArrayList<Enrollment> enrollments) {
        String code = inputSegments[1];
        
        for (CourseOpening opening : courseOpenings) {
            if (opening.getCode().equals(code)) {
                Collections.sort(courseOpenings, (a1, a2) -> a2.getSemester().compareTo(a1.getSemester()));
                
                for (CourseOpening courseOpening : courseOpenings) {
                    if (courseOpening.getCode().equals(code)) {
                        System.out.println(courseOpening.getCode() + "|" + courseOpening.getName() + "|" + courseOpening.getCredit() + "|" + courseOpening.getGrade() + "|" + courseOpening.getAcademicYear() + "|" + courseOpening.getSemester() + "|" + courseOpening.getLecturerInitial() + " (" + courseOpening.getEmail() + ")");
                        
                        for (Enrollment enrollment : enrollments) {
                            if (enrollment.getCode().equals(courseOpening.getCode()) && enrollment.getAcademicYear().equals(courseOpening.getAcademicYear()) && enrollment.getSemester().equals(courseOpening.getSemester())) {
                                if ("Ya".equals(enrollment.getRemedi())) {
                                    System.out.println(enrollment.getCode() + "|" + enrollment.getId() + "|" + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|" + enrollment.getNewGrade() + "(" + enrollment.getGrade() + ")");
                                } else {
                                    System.out.println(enrollment.getCode() + "|" + enrollment.getId() + "|" + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|" + enrollment.getGrade());
                                }
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    public static void addStudent(String[] inputSegments, ArrayList<Student> students) {
        String id = inputSegments[1];
        String name = inputSegments[2];
        String year = inputSegments[3];
        String studyprogram = inputSegments[4];
        boolean mirip = false;
        
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id) && student.getYear().equalsIgnoreCase(year)) {
                mirip = true;
                break;
            }
        }
        
        if (!mirip) {
            Student student = new Student(id, name, year, studyprogram);
            students.add(student);
        }
    }

    public static void showStudentDetails(String[] inputSegments, ArrayList<Student> students, ArrayList<Course> courses, ArrayList<Enrollment> enrollments) {
        double sumGrade = 0, tempGrade = 0;
        int sumSks = 0;
        double result = 0;
        double mulGpa = 0;
        boolean empty = false;
        byte count = 0;
        String tempId = "";
        
        for (int i = 0; i < enrollments.size(); i++) {
            if (inputSegments[1].equals(enrollments.get(i).getId())) {
                if (enrollments.get(i).getGrade().equals("None")) {
                    if (count == 0) {
                        empty = true;
                    }
                    break;
                } else {
                    if (enrollments.get(i).getRemedi() == "Ya") {
                        sumGrade = enrollments.get(i).SumGps(enrollments.get(i).getNewGrade());
                    } else {
                        sumGrade = enrollments.get(i).SumGps(enrollments.get(i).getGrade());
                    }
                    for (int j = 0; j < courses.size(); j++) {
                        if (enrollments.get(i).getCode().equals(courses.get(j).getCode())) {
                            if (tempId.equals(courses.get(j).getCode())) {
                                sumSks = sumSks - courses.get(j).getCredits();
                                mulGpa = mulGpa - courses.get(j).getCredits() * tempGrade;
                            }
                            sumSks = sumSks + courses.get(j).getCredits();
                            mulGpa = mulGpa + courses.get(j).getCredits() * sumGrade;
                            tempId = courses.get(j).getCode();
                            tempGrade = sumGrade;
                            if (sumSks == 0) {
                                result = 0;
                            } else {
                                result = mulGpa / sumSks;
                            }
                            break;
                        }
                    }
                }
                count = 1;
            }
        }
        
        for (int k = 0; k < students.size(); k++) {
            if (inputSegments[1].equals(students.get(k).getId())) {
                if (!empty) {
                    students.get(k).getGpa(result);
                    students.get(k).getSks(sumSks);
                    students.get(k).toStringDetail(students.get(k));
                } else {
                    students.get(k).toStringDetail(students.get(k));
                }
            }
        }
    }

    public static void addEnrollment(String[] inputSegments, ArrayList<Enrollment> enrollments) {
        String code = inputSegments[1];
        String id = inputSegments[2];
        String academicyear = inputSegments[3];
        String semester = inputSegments[4];
        Enrollment enrollment = new Enrollment(code, id, academicyear, semester, "None", "No", 0, "");
        enrollments.add(enrollment);
    }

    public static void updateEnrollmentGrade(String[] inputSegments, ArrayList<Enrollment> enrollments) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCode().equalsIgnoreCase(inputSegments[1]) && enrollment.getId().equalsIgnoreCase(inputSegments[2]) && enrollment.getAcademicYear().equalsIgnoreCase(inputSegments[3]) && enrollment.getSemester().equalsIgnoreCase(inputSegments[4])) {
                enrollment.grade = inputSegments[5];
            }
        }
    }

    public static void processRemedial(String[] inputSegments, ArrayList<Enrollment> enrollments) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCode().equalsIgnoreCase(inputSegments[1]) && enrollment.getId().equalsIgnoreCase(inputSegments[2]) && enrollment.getAcademicYear().equalsIgnoreCase(inputSegments[3]) && enrollment.getSemester().equalsIgnoreCase(inputSegments[4]) && enrollment.sumRemedi < 1 && enrollment.getGrade() != "None") {
                enrollment.remedi = "Ya";
                enrollment.sumRemedi = enrollment.sumRemedi + 1;
                enrollment.newGrade = inputSegments[5];
            }
        }
    }

    public static void addLecturer(String[] inputSegments, ArrayList<Lecturer> lecturers) {
        String id = inputSegments[1];
        String name = inputSegments[2];
        String initial = inputSegments[3];
        String email = inputSegments[4];
        String studyprogram = inputSegments[5];
        boolean mirip = false;
        
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getId().equalsIgnoreCase(id)) {
                mirip = true;
                break;
            }
        }
        
        if (!mirip) {
            Lecturer lecturer = new Lecturer(id, name, initial, email, studyprogram);
            lecturers.add(lecturer);
        }
    }

    public static void printData(ArrayList<Lecturer> lecturers, ArrayList<Course> courses, ArrayList<Student> students, ArrayList<Enrollment> enrollments) {
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer.getId() + "|" + lecturer.getName() + "|" + lecturer.getInitial() + "|" + lecturer.getEmail() + "|" + lecturer.getStudyProgram());
        }
        
        for (Course course : courses) {
            System.out.println(course.getCode() + "|" + course.getName() + "|" + course.getCredits() + "|" + course.getPassingGrade());
        }
        
        for (Student student : students) {
            System.out.println(student.getId() + "|" + student.getName() + "|" + student.getYear() + "|" + student.getStudyProgram());
        }
        
        for (Enrollment enrollment : enrollments) {
            if (enrollment.remedi == "Ya") {
                System.out.println(enrollment.getCode() + "|" + enrollment.getId() + "|" + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|" + enrollment.getNewGrade() + "(" + enrollment.grade + ")");
            } else {
                System.out.println(enrollment.getCode() + "|" + enrollment.getId() + "|" + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|" + enrollment.getGrade());
            }
        }
    }
}
