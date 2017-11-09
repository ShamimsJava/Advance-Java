package shamim.test;

public class Student {
    String name, age, email, gender, hobby, round, note;

    public Student(String name, String age, String email, String gender, String hobby, String round, String note) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.hobby = hobby;
        this.round = round;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getHobby() {
        return hobby;
    }

    public String getRound() {
        return round;
    }

    public String getNote() {
        return note;
    }
    
}
