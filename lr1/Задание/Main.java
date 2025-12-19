import java.util.Scanner;

class Patient {
    private final int id;
    private final String lastName;   // Фамилия
    private final String firstName;  // Имя
    private final String middleName; // Отчество
    private final String address;    // Адрес
    private final String phone;      // Телефон
    private final int medicalCardNumber; // Номер медицинской карты
    private final String diagnosis;  // Диагноз

    public Patient(int id, String lastName, String firstName, String middleName,
                   String address, String phone, int medicalCardNumber, String diagnosis) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() { return diagnosis; }
    public int getMedicalCardNumber() { return medicalCardNumber; }

    @Override
    public String toString() {
        return String.format(
            "ID: %d, ФИО: %s %s %s, Адрес: %s, Телефон: %s, Номер карты: %d, Диагноз: %s",
            id, lastName, firstName, middleName, address, phone, medicalCardNumber, diagnosis
        );
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Кодировка JVM: " + System.getProperty("file.encoding"));

        try (Scanner scanner = new Scanner(System.in))  
        {

            Patient[] patients = new Patient[5];
            patients[0] = new Patient(1, "Иванов", "Иван", "Иванович",
                    "Москва, ул. Ленина, 10", "+79123456789", 1001, "Gripp");
            patients[1] = new Patient(2, "Петров", "Петр", "Петрович",
                    "Санкт-Петербург, ул. Невского, 20", "+79234567890", 1002, "Asthma");
            patients[2] = new Patient(3, "Сидоров", "Сидор", "Сидорович",
                    "Екатеринбург, ул. Центральная, 30", "+79345678901", 1003, "Hypertension");
            patients[3] = new Patient(4, "Кузнецова", "Анна", "Васильевна",
                    "Новосибирск, ул. Красная, 40", "+79456789012", 1004, "Gripp");
            patients[4] = new Patient(5, "Васильев", "Михаил", "Николаевич",
                    "Казань, ул. Советская, 50", "+79567890123", 1005, "Allergy");

            System.out.println("\n=== Все пациенты ===");
            for (Patient p : patients) {
                System.out.println(p);
            }

            System.out.print("\nВведите диагноз для поиска: ");
            String searchDiagnosis = scanner.nextLine(); 

            System.out.println("\n=== Пациенты с диагнозом \"" + searchDiagnosis + "\" ===");
            boolean found = false;
            for (Patient p : patients) {
                if (p.getDiagnosis().equalsIgnoreCase(searchDiagnosis)) {
                    System.out.println(p);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Пациенты с таким диагнозом не найдены.");
            }

            System.out.print("\nВведите начало интервала номера карты: ");
            int start = scanner.nextInt();
            System.out.print("Введите конец интервала номера карты: ");
            int end = scanner.nextInt();

            scanner.nextLine(); // очищает буфер от оставшегося "\n"

            System.out.println("\n=== Пациенты с номером карты от " + start + " до " + end + " ===");
            found = false;
            for (Patient p : patients) {
                if (p.getMedicalCardNumber() >= start && p.getMedicalCardNumber() <= end) {
                    System.out.println(p);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Пациенты в указанном диапазоне не найдены.");
            }
        }
    }
}