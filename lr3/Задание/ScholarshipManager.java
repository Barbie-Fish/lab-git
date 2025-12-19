import java.util.ArrayList;
import java.util.List;

public class ScholarshipManager {
    private List<Student> students;
    
    public ScholarshipManager() {
        this.students = new ArrayList<>();
    }
    
    /**
     * Добавить студента
     * @param student студент
     */
    public void addStudent(Student student) {
        students.add(student);
    }
    
    /**
     * Студентов со стипендией 25%
     * @return список студентов
     */
    public List<Student> getStudentsWithScholarship25() {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.calculateScholarship() == Student.scholarship25) {
                result.add(student);
            }
        }
        return result;
    }
    
    /**
     * Студенты на платке
     * @return список студентов
     */
    public List<Student> getPaidStudents() {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getStudyType() == 'P') {
                result.add(student);
            }
        }
        return result;
    }
    
    /**
     * Средний балл
     * @return средний балл
     */
    public double calculateAverageGrade() {
        if (students.isEmpty()) {
            return 0;
        }
        
        double sum = 0;
        for (Student student : students) {
            sum += student.getAverageGrade();
        }
        
        return sum / students.size();
    }
    
    /**
     * Вывести студентов с стипендией 25%
     */
    public void printStudentsWithScholarship25() {
        System.out.println("=== Студенты со стипендией 25% (187.5) ===");
        List<Student> students25 = getStudentsWithScholarship25();
        if (students25.isEmpty()) {
            System.out.println("Таких студентов нет");
        } else {
            for (Student student : students25) {
                System.out.println(student);
            }
        }
        System.out.println();
    }
    
    /**
     * Вывести студентов на платной основе
     */
    public void printPaidStudents() {
        System.out.println("=== Студенты на платной основе ===");
        List<Student> paidStudents = getPaidStudents();
        if (paidStudents.isEmpty()) {
            System.out.println("Таких студентов нет");
        } else {
            for (Student student : paidStudents) {
                System.out.println(student);
            }
        }
        System.out.println();
    }
    
    /**
     * Вывести средний балл
     */
    public void printAverageGrade() {
        System.out.println("=== Средний балл по всем студентам ===");
        System.out.printf("Средний балл: %.2f%n", calculateAverageGrade());
        System.out.println();
    }
}
