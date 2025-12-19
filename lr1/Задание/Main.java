import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс-репозиторий для хранения и управления коллекцией пациентов.
 * Добавлен в рамках рефакторинга лабораторной работы №1.
 */
class PatientRepository {
    private final List<Patient> patients = new ArrayList<>();

    /** Добавление пациента */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    /** Удаление пациента по ID */
    public boolean removePatient(int id) {
        return patients.removeIf(p -> p.getId() == id);
    }

    /** Изменение пациента по ID */
    public boolean updatePatient(int id, Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                patients.set(i, updatedPatient);
                return true;
            }
        }
        return false;
    }

    /** Получение всех пациентов (копия списка для инкапсуляции) */
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

    /** Поиск по диагнозу (без учёта регистра) */
    public List<Patient> findByDiagnosis(String diagnosis) {
        List<Patient> result = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                result.add(p);
            }
        }
        return result;
    }

    /** Поиск по диапазону номеров медицинской карты */
    public List<Patient> findByCardNumberRange(int start, int end) {
        List<Patient> result = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getMedicalCardNumber() >= start && p.getMedicalCardNumber() <= end) {
                result.add(p);
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Кодировка JVM: " + System.getProperty("file.encoding"));

        PatientRepository repository = new PatientRepository();

        // Заполнение репозитория тестовыми данными
        repository.addPatient(new Patient(1, "Иванов", "Иван", "Иванович",
                "Москва, ул. Ленина, 10", "+79123456789", 1001, "Gripp"));
        repository.addPatient(new Patient(2, "Петров", "Петр", "Петрович",
                "Санкт-Петербург, ул. Невского, 20", "+79234567890", 1002, "Asthma"));
        repository.addPatient(new Patient(3, "Сидоров", "Сидор", "Сидорович",
                "Екатеринбург, ул. Центральная, 30", "+79345678901", 1003, "Hypertension"));
        repository.addPatient(new Patient(4, "Кузнецова", "Анна", "Васильевна",
                "Новосибирск, ул. Красная, 40", "+79456789012", 1004, "Gripp"));
        repository.addPatient(new Patient(5, "Васильев", "Михаил", "Николаевич",
                "Казань, ул. Советская, 50", "+79567890123", 1005, "Allergy"));

        try (Scanner scanner = new Scanner(System.in, "UTF-8")) {  // Явно указываем кодировку

            System.out.println("\n=== Все пациенты ===");
            repository.getAllPatients().forEach(System.out::println);

            System.out.print("\nВведите диагноз для поиска: ");
            String searchDiagnosis = scanner.nextLine().trim();

            System.out.println("\n=== Пациенты с диагнозом \"" + searchDiagnosis + "\" ===");
            List<Patient> byDiagnosis = repository.findByDiagnosis(searchDiagnosis);
            if (byDiagnosis.isEmpty()) {
                System.out.println("Пациенты с таким диагнозом не найдены.");
            } else {
                byDiagnosis.forEach(System.out::println);
            }

            System.out.print("\nВведите начало интервала номера карты: ");
            int start = scanner.nextInt();
            System.out.print("Введите конец интервала номера карты: ");
            int end = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            System.out.println("\n=== Пациенты с номером карты от " + start + " до " + end + " ===");
            List<Patient> byCardRange = repository.findByCardNumberRange(start, end);
            if (byCardRange.isEmpty()) {
                System.out.println("Пациенты в указанном диапазоне не найдены.");
            } else {
                byCardRange.forEach(System.out::println);
            }

            // Демонстрация удаления
            System.out.println("\n=== Демонстрация удаления ===");
            boolean removed = repository.removePatient(3);
            System.out.println("Пациент с ID=3 удалён: " + removed);
            System.out.println("Список после удаления:");
            repository.getAllPatients().forEach(System.out::println);
        }
    }
}