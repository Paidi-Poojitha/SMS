package com.sms;

import java.util.List;
import java.util.Scanner;

import com.dao.StudentDao;
import com.sms.entity.Student;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDao dao = new StudentDao();

        boolean isExit = false;

        while (!isExit) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Insert Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Search Student By ID");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                Student s1 = new Student();

                sc.nextLine();

                System.out.print("Enter Name: ");
                s1.setName(sc.nextLine());

                System.out.print("Enter Department: ");
                s1.setDepartment(sc.nextLine());

                System.out.print("Enter CGPA: ");
                s1.setCgpa(sc.nextDouble());

                System.out.print("Enter Phone Number: ");
                s1.setPhno(sc.nextLong());

                int saveResult = dao.saveStudent(s1);

                if (saveResult > 0) {
                    System.out.println("Student inserted successfully.");
                } else {
                    System.out.println("Insertion failed.");
                }

                break;

            case 2:

                System.out.print("Enter Student ID to update: ");
                int updateId = sc.nextInt();

                System.out.println("1. Update Name");
                System.out.println("2. Update Department");
                System.out.println("3. Update CGPA");
                System.out.println("4. Update Phone Number");

                System.out.print("Enter your choice: ");

                int updateChoice = sc.nextInt();

                sc.nextLine();

                int updateResult = 0;

                switch (updateChoice) {

                case 1:

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    updateResult = dao.updateStudent(updateId, updateChoice, newName);

                    break;

                case 2:

                    System.out.print("Enter new department: ");
                    String newDepartment = sc.nextLine();

                    updateResult = dao.updateStudent(updateId, updateChoice, newDepartment);

                    break;

                case 3:

                    System.out.print("Enter new CGPA: ");
                    double newCgpa = sc.nextDouble();

                    updateResult = dao.updateStudent(updateId, updateChoice, newCgpa);

                    break;

                case 4:

                    System.out.print("Enter new phone number: ");
                    long newPhone = sc.nextLong();

                    updateResult = dao.updateStudent(updateId, updateChoice, newPhone);

                    break;

                default:
                    System.out.println("Invalid update choice.");
                }

                if (updateResult > 0) {
                    System.out.println("Student updated successfully.");
                } else {
                    System.out.println("Update failed.");
                }

                break;

            case 3:

                System.out.print("Enter Student ID to delete: ");

                int deleteId = sc.nextInt();

                int deleteResult = dao.deleteStudent(deleteId);

                if (deleteResult > 0) {
                    System.out.println("Student deleted successfully.");
                } else {
                    System.out.println("Student not found.");
                }

                break;

            case 4:

                List<Student> students = dao.getStudents();

                if (students.size() > 0) {

                    for (Student student : students) {
                        System.out.println(student);
                    }

                } else {
                    System.out.println("No records found.");
                }

                break;

            case 5:

                System.out.print("Enter Student ID: ");

                int searchId = sc.nextInt();

                Student student = dao.getStudentById(searchId);

                if (student != null) {
                    System.out.println(student);
                } else {
                    System.out.println("Student not found.");
                }

                break;

            case 6:

                isExit = true;

                System.out.println("Application Closed.");

                break;

            default:

                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
