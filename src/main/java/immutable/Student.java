package immutable;

public class Student {

  private final int id;
  private final String name;
  private final Address address;

  public static void main(String[] args) throws CloneNotSupportedException {

    Address studentAddress = new Address();
    studentAddress.setCity("BLR");
    studentAddress.setState("KA");
    Student student = new Student(1, "Y", studentAddress);

    Address innerAddress = student.getAddress();
    innerAddress.setCity("Pune");
    System.out.println(student);

  }

  public Student(int id, String name, Address address) throws CloneNotSupportedException {
    this.id = id;
    this.name = name;
    this.address = address.clone();
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Address getAddress() throws CloneNotSupportedException {
    return address.clone();
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", address=" + address +
        '}';
  }
}

class Address implements Cloneable {

  private String city;
  private String state;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  protected Address clone() throws CloneNotSupportedException {
    return (Address) super.clone();
  }

  @Override
  public String toString() {
    return "Address{" +
        "city='" + city + '\'' +
        ", state='" + state + '\'' +
        '}';
  }
}

