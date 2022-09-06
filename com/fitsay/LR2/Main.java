package com.fitsay.LR2;
import com.fitsay.LR2.patient.Patient;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
        System.out.print("Пошук пацієнтів за діагнозом: ");
        Diag(patient,scanner.nextLine());
        System.out.println("Пошук пацієнтів за номером медичної картки в інтервалі:");
        Num_med(patient,scanner.nextInt(),scanner.nextInt());
        System.out.println("Пошук пацієнтів за першою цифрою номеру телефону: ");
        Num(patient, scanner.next().charAt(0));
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
            System.out.println("Пацієнт №" + x.getid());
            x.setSurname(scanner.nextLine());
            System.out.println("Прізвище: " + x.getSurname());
            x.setName(scanner.nextLine());
            System.out.println("Ім'я: "+ x.getName());
            x.setPatronymic(scanner.nextLine());
            System.out.println("По-батькові: "+ x.getPatronymic());
            x.setAddress(scanner.nextLine());
            System.out.println("Адреса: " + x.getAddress());
            x.setNumber(scanner.nextLine());
            System.out.println("Номер телефону: " + x.getNumber());
            x.setNumber_med_CARD(scanner.nextInt());
            System.out.println("Номер медичної картки: " + x.getNumber_med_CARD());
            scanner.nextLine();
            x.setDiagnosis(scanner.nextLine());
            System.out.println("Діагноз: "+ x.getDiagnosis());
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
    public static void Num(Patient[] x, char num){
        for (Patient x2:x) {
            if (num == (x2.getNumber().charAt(4))) {
                System.out.print(x2 +"\n\n");
            }
        }
    }
}