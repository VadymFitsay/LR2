package com.fitsay.LR2.patient;
/**
 * Клас для зберігання даних про пацієнта
 * @author Vadym Fitsay
 */
public class Patient {
    private int id;
    private String Surname;
    private String Name;
    private String Patronymic;
    private String Address;
    private String Number;
    private int Number_med_CARD;
    private String Diagnosis;
    /**
     * Конструктор cтворення нового об'єкту
     */
    public Patient(){}
    /**
     * Конструктор cтворення нового об'єкту з заданими параметрами
     * @param id id пацієнта
     * @param Surname прізвище
     * @param Name ім'я
     * @param Patronymic по-батькові
     * @param Address адреса пацієнта
     * @param Number номер телефону
     * @param Number_med_CARD номер медичної картки
     * @param Diagnosis діагноз
     */
    public Patient(int id , String Surname,String Name,String Patronymic,String Address,String Number,int Number_med_CARD,String Diagnosis) {
        this.id = id;
        this.Surname = Surname;
        this.Name = Name;
        this.Patronymic = Patronymic;
        this.Address = Address;
        this.Number = Number;
        this.Number_med_CARD = Number_med_CARD;
        this.Diagnosis = Diagnosis;
    }
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getSurname() {
        return Surname;
    }
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getPatronymic() {
        return Patronymic;
    }
    public void setPatronymic(String Patronymic) {
        this.Patronymic = Patronymic;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }
    public String getNumber() {
        return Number;
    }
    public void setNumber(String Number) {
        this.Number = Number;
    }
    public int getNumber_med_CARD() {
        return Number_med_CARD;
    }
    public void setNumber_med_CARD(int Number_med_CARD) {
        this.Number_med_CARD = Number_med_CARD;
    }
    public String getDiagnosis() {
        return Diagnosis;
    }
    public void setDiagnosis(String Diagnosis) {
        this.Diagnosis = Diagnosis;
    }
    /**
     * Перевантажений метод toString
     * @return представлення об'єкта у String форматі
     */
    @Override
    public String toString() {
        return "Patient "
                + "№" + id+ "\n"
                + "fullName = '" + Surname+" "+Name +" " + Patronymic  + '\'' +"\n"
                + "(Address = " + Address
                + ", Number = " + Number
                + ", Number_med_CART = " + Number_med_CARD
                + ", Diagnosis = " + Diagnosis
                + ')';
    }
}
