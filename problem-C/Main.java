public class Main {
    public static void main(String[] args){
        Student s1 = new Student("Tan Ah Teck", "1 Happy Ave");
        s1.addCourseGrade("IM101", 97);
        s1.addCourseGrade("IM102", 68);
        s1.printGrades();
        
        System.out.println("Average is " + s1.getAverageGrade());
        //Average is 82.5

        /* Test Teacher class */
        Teacher t1 = new Teacher("Paul Tan", "8 sunset way");
        System.out.println(t1);
        //Teacher: Paul Tan(8 sunset way)
        String[] courses = {"IM101", "IM102", "IM101"};
        for (String course: courses) {
            if (t1.addCourse(course)) {
                System.out.println(course + " added");
            } else {
                System.out.println(course + " cannot be added");
            }
        }
       
        for (String course: courses) {
            if (t1.removeCourse(course)) {
                System.out.println(course + " removed");
            } else {
                System.out.println(course + " cannot be removed");
            }
        }
       
    }
}
class Person {
    // private instance variables
    private String name, address;

   /* Constructs a Person instance with the given name and address */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
   /* Returns the name */
    public String getName() {
        return name;
    }
   /* Returns the address */
    public String getAddress() {
        return address;
    }
   /* Sets the address */
    public void setAddress(String address) {
        this.address = address;
    }

    /** Returns a self-descriptive string */
    @Override
    public String toString() {
        return name + "(" + address + ")";
    }
}
class Student extends Person {
    // private instance variables
    private int numCourses;   // number of courses taken so far
    private String[] courses; // course codes
    private int[] grades;     // grade for the corresponding course codes
    private static final int MAX_COURSES = 30; // maximum number of courses

   
    public Student(String name, String address) {
        super(name, address);
        numCourses = 0;
        courses = new String[MAX_COURSES];
        grades = new int[MAX_COURSES];
    }

  
    @Override
    public String toString() {
        return "Student: " + super.toString();
    }

  
    public void addCourseGrade(String course, int grade) {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        ++numCourses;
    }

  
    public void printGrades() {
        System.out.print(this);
        for (int i = 0; i < numCourses; ++i) {
            System.out.print(" " + courses[i] + ":" + grades[i]);
        }
        System.out.println();
    }

    /** Computes the average grade */
    public double getAverageGrade() {
        int sum = 0;
        for (int i = 0; i < numCourses; i++ ) {
            sum += grades[i];
        }
        return (double)sum/numCourses;
    }
}
class Teacher extends Person {
   
    private int numCourses;   
    private String[] courses; // course codes
    private static final int MAX_COURSES = 5; // 

   
    public Teacher(String name, String address) {
        super(name, address);
        numCourses = 0;
        courses = new String[MAX_COURSES];
    }

   
    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }

  
    public boolean addCourse(String course) {
        // Check if the course already in the course list
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) return false;
        }
        courses[numCourses] = course;
        numCourses++;
        return true;
    }

   
    public boolean removeCourse(String course) {
        boolean found = false;
       
        int courseIndex = -1;  
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                courseIndex = i;
                found = true;
                break;
            }
        }
        if (found) {
            
            for (int i = courseIndex; i < numCourses-1; i++) {
                courses[i] = courses[i+1];
            }
            numCourses--;
            return true;
        } else {
            return false;
        }
    }
}
