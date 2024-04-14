package MVC.src.academic.drive;
import academic.controller.*;
import academic.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {

    // ANSI color codes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BOLD = "\033[0;1m";
    public static final String ANIMATION = "|/-|/-\\";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        ArrayList<CourseOpening> courseOpenings = new ArrayList<>();

        System.out.println(ANSI_CYAN + "Welcome to Academic Management System" + ANSI_RESET);
        System.out.println("=====================================");

        while (true) {
            System.out.println("\n" + ANSI_BOLD + "Enter your command (or type '---' to exit): " + ANSI_RESET);
            String input = scanner.nextLine().trim();

            if (input.equals("---")) {
                break;
            }

            System.out.print(ANSI_YELLOW + "Processing" + ANSI_RESET);
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100); // Delay for animation effect
                    System.out.print("\b" + ANIMATION.charAt(i % ANIMATION.length()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String[] inputSegments = input.split("#");
            String command = inputSegments[0];

            switch (command) {
                case "course-add":
                    System.out.println("\n" + ANSI_YELLOW + "Adding a new course..." + ANSI_RESET);
                    ApplicationController.addCourse(inputSegments, courses);
                    System.out.println(ANSI_GREEN + "Course added successfully!" + ANSI_RESET);
                    break;
                case "course-open":
                    System.out.println("\n" + ANSI_YELLOW + "Opening a course..." + ANSI_RESET);
                    ApplicationController.openCourse(inputSegments, courses, lecturers, courseOpenings);
                    System.out.println(ANSI_GREEN + "Course opened successfully!" + ANSI_RESET);
                    break;
                case "course-history":
                    System.out.println("\n" + ANSI_YELLOW + "Displaying course history..." + ANSI_RESET);
                    ApplicationController.showCourseHistory(inputSegments, courseOpenings, enrollments);
                    break;
                case "student-add":
                    System.out.println("\n" + ANSI_YELLOW + "Adding a new student..." + ANSI_RESET);
                    ApplicationController.addStudent(inputSegments, students);
                    System.out.println(ANSI_GREEN + "Student added successfully!" + ANSI_RESET);
                    break;
                case "student-details":
                    System.out.println("\n" + ANSI_YELLOW + "Fetching student details..." + ANSI_RESET);
                    ApplicationController.showStudentDetails(inputSegments, students, courses, enrollments);
                    break;
                case "enrollment-add":
                    System.out.println("\n" + ANSI_YELLOW + "Adding a new enrollment..." + ANSI_RESET);
                    ApplicationController.addEnrollment(inputSegments, enrollments);
                    System.out.println(ANSI_GREEN + "Enrollment added successfully!" + ANSI_RESET);
                    break;
                case "enrollment-grade":
                    System.out.println("\n" + ANSI_YELLOW + "Updating enrollment grade..." + ANSI_RESET);
                    ApplicationController.updateEnrollmentGrade(inputSegments, enrollments);
                    System.out.println(ANSI_GREEN + "Grade updated successfully!" + ANSI_RESET);
                    break;
                case "enrollment-remedial":
                    System.out.println("\n" + ANSI_YELLOW + "Processing remedial enrollment..." + ANSI_RESET);
                    ApplicationController.processRemedial(inputSegments, enrollments);
                    System.out.println(ANSI_GREEN + "Remedial processed successfully!" + ANSI_RESET);
                    break;
                case "lecturer-add":
                    System.out.println("\n" + ANSI_YELLOW + "Adding a new lecturer..." + ANSI_RESET);
                    ApplicationController.addLecturer(inputSegments, lecturers);
                    System.out.println(ANSI_GREEN + "Lecturer added successfully!" + ANSI_RESET);
                    break;
                default:
                    System.out.println("\n" + ANSI_YELLOW + "Unknown command" + ANSI_RESET);
            }
        }

        System.out.println("\n" + ANSI_CYAN + "Printing system data..." + ANSI_RESET);
        ApplicationController.printData(lecturers, courses, students, enrollments);
        System.out.println("\n" + ANSI_CYAN + "Thank you for using Academic Management System!" + ANSI_RESET);
        scanner.close();
    }
}
