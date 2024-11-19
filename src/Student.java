import java.util.Comparator;

public class Student {
    private String name;
    private  int age;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    
    public  static Comparator<Student>compareByAge = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return student1.age-student2.age;
        }
    };


    public static Comparator<Student>sortByName = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return student1.name.compareTo(student2.name);
        }
    };



    @Override
    public String toString() {
        return "\nStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
