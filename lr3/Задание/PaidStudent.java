public class PaidStudent extends Student {
    
    /**
     * @param name имя студента
     * @param averageGrade средний балл
     * @param sessionPassed сессия (+ сдал, - не сдал)
     */
    public PaidStudent(String name, double averageGrade, char sessionPassed) {
        super(name, averageGrade, 'P', sessionPassed);
    }
}
