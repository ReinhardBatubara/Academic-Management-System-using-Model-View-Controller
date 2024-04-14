# Academic Management System

Welcome to the Academic Management System! This repository hosts a powerful Java-based tool designed to revolutionize academic administration within educational institutions. Below, you'll find an engaging overview of the system's capabilities and structure.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Getting Started](#getting-started)
4. [Usage](#usage)
5. [Contributing](#contributing)
6. [License](#license)

## Introduction

Enter the realm of streamlined academic administration with our Academic Management System. Crafted in Java, this robust application is your all-in-one solution for efficiently managing courses, students, lecturers, and enrollments within your institution. Let's delve into the world of possibilities that this system offers.

## Features

- **Course Management**: Seamlessly add, open, and display detailed course information, including code, name, credits, and passing grade requirements.
- **Student Management**: Effortlessly enroll and track students, capturing vital details such as ID, name, academic year, and study program.
- **Lecturer Management**: Empower your faculty by efficiently assigning and managing lecturers with comprehensive details like ID, name, initial, email, and associated study programs.
- **Enrollment Management**: Simplify the enrollment process, update grades, and handle remedial actions swiftly and efficiently.
- **Course History**: Explore the comprehensive history of course implementations, including details of each period and the enrolled students' achievements.
- **Data Printing**: Generate comprehensive reports of lecturers, courses, students, and enrollments effortlessly for administrative purposes.

## Getting Started

Embark on your journey with the Academic Management System by following these simple steps:

1. Clone this repository to your local machine.
2. Ensure you have Java installed and configured on your system.
3. Open the project in your preferred Java development environment.
4. Compile and launch the `ApplicationController` class to initiate the application.

## Usage

Experience the power of the Academic Management System through its intuitive command-line interface. Explore a world of commands tailored to your administrative needs:

- `addCourse <code> <name> <credits> <passinggrade>`: Add a new course to the system.
- `addStudent <id> <name> <year> <studyProgram>`: Enroll a new student into the system.
- `showStudentDetails <id>`: Display detailed information about a specific student, including GPA and total credits.
- `addEnrollment <code> <id> <academicYear> <semester>`: Enroll a student into a specific course, academic year, and semester.
- `updateEnrollmentGrade <code> <id> <academicYear> <semester> <grade>`: Update a student's grade for a specific enrollment.
- `processRemedial <code> <id> <academicYear> <semester> <newGrade>`: Process remedial action for a student's grade in a specific course, academic year, and semester.
- `courseHistory <code>`: Display the comprehensive history of a specific course, including details of each period and enrolled students' achievements.
- `printData`: Generate comprehensive reports of lecturers, courses, students, and enrollments.

### Usage Examples:

**Input**:

```bash
addCourse#12S1101#Introduction to Information Systems#3#C
course-open#12S1101#2020/2021#odd#IUS
course-open#12S1101#2020/2021#even#IUS
course-open#12S1101#2021/2022#odd#IUS
addStudent#12S20001#John Doe#2020#Information Systems
addStudent#12S20002#Jane Smith#2020#Information Systems
enrollment-add#12S1101#12S20001#2020/2021#odd
enrollment-add#12S1101#12S20002#2020/2021#odd
enrollment-add#12S1101#12S20002#2021/2022#odd
enrollment-grade#12S1101#12S20001#2020/2021#odd#B
enrollment-grade#12S1101#12S20002#2020/2021#odd#A
course-history#12S1101
```

**Output**:

```bash
12S1101|Introduction to Information Systems|3|C|2020/2021|odd|IUS (iustisia.simbolon@del.ac.id)
12S1101|12S20001|2020/2021|odd|B
12S1101|12S20002|2020/2021|odd|A
12S1101|Introduction to Information Systems|3|C|2021/2022|odd|IUS (iustisia.simbolon@del.ac.id)
12S1101|12S20002|2021/2022|odd|-
```