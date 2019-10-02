package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student extends Teacher implements Serializable {

  private String name;
  private int age;
  private Address address; // Composite / Associated class

  private static final long serialVersionUID = 1L;

  public static void main(String[] args) {

    String filePath = "/Users/y0b007t/Desktop/std.txt";

    try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
         ObjectOutputStream objectOutputStream =
             new ObjectOutputStream(fileOutputStream)) {
      Address address = new Address();
      address.setCity("BLR");
      Student student = new Student("Y", 26, address);
      student.setTeachedName("Shivani");
      objectOutputStream.writeObject(student);
    } catch (IOException e) {
      e.printStackTrace();
    }

//    try (FileInputStream fileInputStream = new FileInputStream(filePath);
//         ObjectInputStream objectInputStream =
//             new ObjectInputStream(fileInputStream)) {
//      demo.Student student1 = (demo.Student) objectInputStream.readObject();
//      System.out.println(student1);
//      System.out.println(student1.getTeachedName());
//    } catch (IOException | ClassNotFoundException e) {
//      e.printStackTrace();
//    }

  }

  public Student(String name, int age, Address address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "demo.Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", address=" + address +
        '}';
  }
}

class Teacher implements Serializable {

  public Teacher() {
    this.teachedName = "Default";
  }

  String teachedName;

  public String getTeachedName() {
    return teachedName;
  }

  public void setTeachedName(String teachedName) {
    this.teachedName = teachedName;
  }

  @Override
  public String toString() {
    return "Teacher{" +
        "teachedName='" + teachedName + '\'' +
        '}';
  }
}

class Address implements Serializable {

  String city;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "Address{" +
        "city='" + city + '\'' +
        '}';
  }
}
