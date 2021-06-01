package java_gson;

public class Student implements Cloneable {
   private int ID;
   private String fullName;
   private String favourite;
    private int age;

    public Student(int ID, String fullName, String favourite, int age) {
        this.ID = ID;
        this.fullName = fullName;
        this.favourite = favourite;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", favourite='" + favourite + '\'' +
                ", age=" + age +
                '}';
    }
}
