import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String filename = "students.dat";
        
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            DataOutputStream dos = new DataOutputStream(fos);
            
            dos.writeInt(1001);
            dos.writeUTF("Alice");
            dos.writeDouble(3.85);
            
            dos.writeInt(1002);
            dos.writeUTF("Bob");
            dos.writeDouble(3.92);
            
            dos.writeInt(1003);
            dos.writeUTF("Charlie");
            dos.writeDouble(3.78);
            
            dos.close();
            fos.close();
            
            System.out.println("Student data written to file.");
            
            FileInputStream fis = new FileInputStream(filename);
            DataInputStream dis = new DataInputStream(fis);
            
            System.out.println("\nRetrieved Student Details:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                
                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + name);
                System.out.println("GPA: " + gpa);
                System.out.println();
            }
            
            dis.close();
            fis.close();
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
