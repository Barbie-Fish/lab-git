public abstract class Student {
    // Константы для стипендий
    public static final double scholarship25 = 187.5;
    public static final double scholarship50 = 375.0;
    public static final double scholarship75 = 562.5;
    public static final double scholarship100 = 750.0;
    
    private String name;
    private double averageGrade;
    private char studyType; // 'B' - бюджет, 'P' - платное
    private char sessionPassed; // '+' - сдал, '-' - не сдал
    
    /**
     * Конструктор студента
     * @param name имя студента
     * @param averageGrade средний балл
     * @param studyType тип обучения ('B' - бюджет, 'P' - платное)
     * @param sessionPassed сессия (+ сдал, - не сдал)
     */
    public Student(String name, double averageGrade, char studyType, char sessionPassed) {
        this.name = name;
        this.averageGrade = averageGrade;
        this.studyType = studyType;
        this.sessionPassed = sessionPassed;
    }
    
    /**
     * Рассчитать стипендию
     * @return размер стипендии
     */
    public double calculateScholarship() {
        // Платники не получают стипендию
        if (studyType == 'P') {
            return 0;
        }
        
        // Если сессия не сдана - стипендия 0
        if (sessionPassed == '-') {
            return 0;
        }
        
        // Расчет стипендии по среднему баллу
        if (averageGrade >= 9.0) {
            return scholarship100;
        } else if (averageGrade >= 8.0) {
            return scholarship75;
        } else if (averageGrade >= 7.0) {
            return scholarship50;
        } else if (averageGrade >= 6.0) {
            return scholarship25;
        } else {
            return 0;
        }
    }
    
    // Геттеры
    public String getName() {
        return name;
    }
    
    public double getAverageGrade() {
        return averageGrade;
    }
    
    public char getStudyType() {
        return studyType;
    }
    
    public char getSessionPassed() {
        return sessionPassed;
    }
    
    @Override
    public String toString() {
        String studyTypeStr = (studyType == 'B') ? "Бюджет" : "Платное";
        String sessionStr = (sessionPassed == '+') ? "Сдал" : "Не сдал";
        double scholarship = calculateScholarship();
        
        return String.format("%s | %s | Средний балл: %.1f | %s | Стипендия: %.1f", 
                           name, studyTypeStr, averageGrade, sessionStr, scholarship);
    }
}