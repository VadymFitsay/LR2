package com.fitsay.LR2;
import com.fitsay.LR2.patient.Patient;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Клас для демонстрації функціональності класу Patient.
 * Дані зчитуються з файлу data.txt і виводяться на екран інформація про пацієнтів.
 * Метод Diag виводить пацієнтів в яких навний введений з консолі діагноз
 * Метод Num_med виводить пацієнтів в яких номер медичної картки знаходиться в діпазоні який вводить користувач
 * Метод Num виводить пацієнтів в яких номер телефона починається з вказаної цифри яку вводить користувач
 * @author Vadym Fitsay
 */
public class Main {
    /**
     * Демонстрація методів.
     * @param args масив параметрів командного рядка
     */
    public static void main(String[] args) throws FileNotFoundException {
        Patient[] patient = setArr();
        Scanner scanner = new Scanner(System.in);
        String value;
        do {
            System.out.println("Пошук пацієнтів за");
            System.out.println("1. Діагнозом");
            System.out.println("2. Діапазоном номеру медкартки");
            System.out.println("3. Номером телефону");
            System.out.println("4.Вихід\n");
            value = scanner.nextLine();
            switch (value) {
                case "1" -> Diag(patient,scanner.nextLine());
                case "2" ->  {Num_med(patient,scanner.nextInt(),scanner.nextInt());
                scanner.nextLine();}
                case "3" -> {
                    System.out.println("Введіть 4 цифри з номера телефона:");
                    Print_P(Num(patient, scanner.nextLine()));
                }
                case "4" -> System.out.println("Завершення програми");
            }
        } while (!value.equals("4"));
        scanner.close();
    }
    /**
     * Метод для створення та заповнення масиву даними
     * @return повертає масив об'єктів з типом Patient
     */
    public static Patient[] setArr() throws FileNotFoundException {
        String separator = File.separator;
        String path = separator + "Users" + separator + "Admin" + separator + "IdeaProjects" + separator + "LR2" + separator + "src" + separator + "com"+ separator + "fitsay" + separator + "LR2"+separator + "data.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        Patient[] patient = new Patient[scanner.nextInt()];
        scanner.nextLine();
        for (int i = 0; i < patient.length; i++)
        {
            Patient x = new Patient();
            x.setid(i+1);
            x.setSurname(scanner.nextLine());
            x.setName(scanner.nextLine());
            x.setPatronymic(scanner.nextLine());
            x.setAddress(scanner.nextLine());
            x.setNumber(scanner.nextLine());
            x.setNumber_med_CARD(scanner.nextInt());
            scanner.nextLine();
            x.setDiagnosis(scanner.nextLine());
            System.out.print(x +"\n\n");
            patient[i] = x;
        }
        scanner.close();
        return patient;
    }

    /**
     * Метод для виведення масиву об'єктів типу Patient
     * в яких поле Diagnosis співпадає з параметром diagnosis
     * @param x масив об'єктів типу Patient
     * @param diagnosis шуканий діагноз
     */
    public static void Diag(Patient[] x, String diagnosis){
        for (Patient x2:x) {
            if (diagnosis.equals(x2.getDiagnosis())) {
                System.out.print(x2 +"\n\n");
            }
        }
    }

    /**
     * Метод для виведення масиву об'єктів типу Patient
     * в яких поле Number_med_CARD знаходиться в інтервалі [st;en]
     * @param x масив об'єктів типу Patient
     * @param st початок інтервалу
     * @param en кінець інтервалу
     */
    public static void Num_med(Patient[] x, int st,int en){
        for (Patient x2:x) {
            if (x2.getNumber_med_CARD()>=st && x2.getNumber_med_CARD()<=en ) {
                System.out.print(x2 +"\n\n");
            }
        }
    }
    /**
     * Метод для виведення масиву об'єктів типу Patient
     * в яких номер телефону починається на цифру num
     * @param x масив об'єктів типу Patient
     * @param num перша цифра номеру телефону
     */
    public static Patient[] Num(Patient[] x, String num){
        ArrayList<Patient> y = new ArrayList<Patient>();
        for (Patient x2:x) {
            for (int i = 9; i > 2; i--) {
                if (x2.getNumber().regionMatches(i, num, 0, 4)) {
                    y.add(x2);
                    break;
                }
            }
        }
        Patient[] Patient = y.toArray(new Patient[y.size()]);
        return Patient;
    }
    public static void Print_P(Patient[] x){
        System.out.println("Кількість: " + x.length);
        for (Patient x2:x) {
            System.out.print(x2 +"\n\n");

        }
    }
}