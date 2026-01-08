/*Problem Statement: Create a program to manage student records using a singly linked list. Each node will store information about a student, including their Roll Number, Name, Age, and Grade. Implement the following operations:
Add a new student record at the beginning, end, or at a specific position.
Delete a student record by Roll Number.
Search for a student record by Roll Number.
Display all student records.
Update a student's grade based on their Roll Number.
Hint:
Use a singly linked list where each node contains student information and a pointer to the next node.
The head of the list will represent the first student, and the last node’s next pointer will be null.
Update the next pointers when inserting or deleting nodes.
*/
class StudentRecord {
    int rollNumber;
    String studentName;
    int studentAge;
    char studentGrade;
    StudentRecord nextStudent; 
}
public class StudentRecordSLL {
    private StudentRecord head;

    // Add a new student record at the end
    public void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        StudentRecord newStudent = new StudentRecord();
        newStudent.rollNumber = rollNumber;
        newStudent.studentName = name;
        newStudent.studentAge = age;
        newStudent.studentGrade = grade;
        newStudent.nextStudent = null;

        if (head == null) {
            head = newStudent;
        } else {
            StudentRecord current = head;
            while (current.nextStudent != null) {
                current = current.nextStudent;
            }
            current.nextStudent = newStudent;
        }
    }
    
    // Add New record at beginning
    public void addStudentAtBeginning(int rollNumber, String name, int age, char grade) {
        StudentRecord newStudent = new StudentRecord();
        newStudent.rollNumber = rollNumber;
        newStudent.studentName = name;
        newStudent.studentAge = age;
        newStudent.studentGrade = grade;
        newStudent.nextStudent = head;
        head = newStudent;
    }
    // Add At specific position
    public void addStudentAtPosition(int rollNumber, String name, int age, char grade, int position) {
        if (position == 0) {
            addStudentAtBeginning(rollNumber, name, age, grade);
            return;
        }

        StudentRecord newStudent = new StudentRecord();
        newStudent.rollNumber = rollNumber;
        newStudent.studentName = name;
        newStudent.studentAge = age;
        newStudent.studentGrade = grade;

        StudentRecord current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.nextStudent;
        }

        if (current != null) {
            newStudent.nextStudent = current.nextStudent;
            current.nextStudent = newStudent;
        }
    }

    // Delete student record by roll number 
    public void deleteStudentbyRollNumber(int rollNumber) {
        if (head == null) return;

        if (head.rollNumber == rollNumber) {
            head = head.nextStudent;
            return;
        }

        StudentRecord current = head;
        while (current.nextStudent != null && current.nextStudent.rollNumber != rollNumber) {
            current = current.nextStudent;
        }

        if (current.nextStudent != null) {
            current.nextStudent = current.nextStudent.nextStudent;
        }
    }

    // Search for student record by rollNumber
    public StudentRecord SearchStudentByRollNumber(int rollNumber) {
        StudentRecord current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.nextStudent;
        }
        return null;
    }

    // Display all student records
    public void displayAllStudents() {
        StudentRecord current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.studentName + ", Age: " + current.studentAge + ", Grade: " + current.studentGrade);
            current = current.nextStudent;
        }
    }

    // update student grade based on their roll number 
    public void updateStudentGrade(int rollNumber, char newGrade) {
        StudentRecord student = SearchStudentByRollNumber(rollNumber);
        if (student != null) {
            student.studentGrade = newGrade;
        }
    }
}
