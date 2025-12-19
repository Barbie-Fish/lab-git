/**
 * Класс, описывающий пациента медицинского учреждения.
 * Добавлен геттер getId() в рамках рефакторинга для работы с репозиторием.
 */
public class Patient {
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

    // Геттеры, необходимые для репозитория
    public int getId() {
        return id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public int getMedicalCardNumber() {
        return medicalCardNumber;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d, ФИО: %s %s %s, Адрес: %s, Телефон: %s, Номер карты: %d, Диагноз: %s",
            id, lastName, firstName, middleName, address, phone, medicalCardNumber, diagnosis
        );
    }
}