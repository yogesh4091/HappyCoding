public class Student implements Comparable {

  private int id;
  private String name;

  public Student(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Object o) {
    return this.name.compareTo(((Student) o).name);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Student)) {
      return false;
    }
    Student student = (Student) o;
    return id == student.id;
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
  }

  public static void main(String[] args) {

//    HashMap<Student, Boolean> treeMap = new HashMap<>();
//
//    Student s1 = new Student(1, "D");
//    Student s2 = new Student(4, "A");
//    Student s3 = new Student(2, "B");
//    Student s4 = new Student(3, "C");
//    Student s5 = new Student(3, "C");
//    Student s6 = new Student(3, "C");
//    Student s7 = new Student(3, "C");
//    Student s8 = new Student(3, "C");
//    Student s9 = new Student(3, "C");
//    Student s10 = new Student(3, "C");
//
//    treeMap.put(s1, true);
//    treeMap.put(s2, true);
//    treeMap.put(s3, true);
//    treeMap.put(s4, true);
//    treeMap.put(s5, true);
//    treeMap.put(s6, true);
//    treeMap.put(s7, true);
//    treeMap.put(s8, true);
//    treeMap.put(s9, true);
//    treeMap.put(s10, true);
//
//    treeMap.forEach((k, v) -> System.out.println(k + ":" + v));

    System.out.println("04FF30E810574854847CC79DBF38353C".replaceFirst(
        "([0-9a-fA-F]{8})([0-9a-fA-F]{4})([0-9a-fA-F]{4})([0-9a-fA-F]{4})([0-9a-fA-F]+)",
        "$1-$2-$3-$4-$5"));

//    System.out.println("Basic " + Base64.getEncoder().encodeToString("iyw3a4rbE684k_LRSPhh".getBytes()));
  }
}
