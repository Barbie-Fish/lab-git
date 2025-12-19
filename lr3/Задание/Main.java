public class Main {
    public static void main(String[] args) {
        ScholarshipManager manager = new ScholarshipManager();
        
        //Студенты
        manager.addStudent(new BudgetStudent("Иванов Иван", 9.2, '+'));
        manager.addStudent(new BudgetStudent("Петрова Мария", 7.5, '+'));
        manager.addStudent(new BudgetStudent("Сидоров Петр", 4.8, '-'));
        manager.addStudent(new BudgetStudent("Козлова Анна", 8.5, '+'));
        manager.addStudent(new BudgetStudent("Смирнов Алексей", 6.2, '-'));
        manager.addStudent(new BudgetStudent("Васильева Елена", 8.0, '+'));
        manager.addStudent(new BudgetStudent("Федоров Сергей", 6.5, '+'));
        manager.addStudent(new BudgetStudent("Павлова Наталья", 8.8, '+'));

        manager.addStudent(new PaidStudent("Николаев Дмитрий", 7.0, '+'));
        manager.addStudent(new PaidStudent("Морозова Ольга", 8.2, '+'));
        manager.addStudent(new PaidStudent("Азёма Максим", 5.7, '-'));
        
        // Вывод результатов
        manager.printStudentsWithScholarship25();
        manager.printPaidStudents();
        manager.printAverageGrade();
    }
}
