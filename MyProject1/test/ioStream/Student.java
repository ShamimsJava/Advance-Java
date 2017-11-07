package ioStream;

public class Student {
    private String name;
    private String address;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return getName()+" "+getAddress();
    }
    
    public static void main(String[] args) {
        Student students = new Student("Shamim", "Dhaka");
        System.out.println(students.toString());
    }
}
