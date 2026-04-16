package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackingLocations = new ArrayList<>();
    static ParcelBox<StandartParcel> standartBox = new ParcelBox<>(14000);
    static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(13000);
    static ParcelBox<PerishableParcel> perishableParcelParcelBox = new ParcelBox<>(12400);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    getListOfBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println(("4 - Добавить новую локацию в трекинг"));
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        boolean running = true;

        System.out.println("Какой вес у посылки в граммах?");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Какой адрес доставки?");
        String adress = scanner.nextLine();
        System.out.println("Какой день отправки?");
        int sendDay = Integer.parseInt(scanner.nextLine());
        while (running) {
            System.out.println("Какой тип посылки вы хотите выбрать?");
            System.out.println("  Стандартная\n  Хрупкая\n  Скоропортящаяся\n");
            String description = scanner.nextLine();
            if (description.equalsIgnoreCase("Стандартная")) {
                StandartParcel standartParcel = new StandartParcel(description, weight, adress, sendDay);
                allParcels.add(standartParcel);
                standartBox.addParcel(standartParcel);
                break;
            } else if (description.equalsIgnoreCase("Хрупкая")) {
                FragileParcel fragileParcel = new FragileParcel(description, weight, adress, sendDay);
                allParcels.add(fragileParcel);
                trackingLocations.add(fragileParcel);
                fragileBox.addParcel(fragileParcel);
                break;
            } else if (description.equalsIgnoreCase("Скоропортящаяся")) {
                System.out.println("Сколько дней максимального хранения товара1?");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, adress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableParcelParcelBox.addParcel(perishableParcel);
                break;
            } else {
                System.out.println("Вы ввели неправильный вариант, введите снова");

            }

        }
    }


    // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels


    private static void sendParcels() {
        if (allParcels.isEmpty()) {
            System.out.println("Список посылок пуст, добавьте посылку");
        } else {
            for (int i = 0; i < allParcels.size(); i++) {
                Parcel parcel = allParcels.get(i);
                parcel.packageItem();
                parcel.deliver();
            }
            // Пройти по allParcels, вызвать packageItem() и deliver()
        }
    }

    private static void calculateCosts() {
        if (allParcels.isEmpty()) {
            System.out.println("Список посылок пуст, добавьте посылку");
        } else {
            int price = 0;
            for (int i = 0; i < allParcels.size(); i++) {
                price += allParcels.get(i).calculateDeliveryCost();

            }
            System.out.println("Итоговая стоимость составит: " + price);
            // Посчитать общую стоимость всех доставок и вывести на экран
        }
    }

    private static void reportStatus() {
        System.out.println("Введите новое местоположение для трекинга");
        String newLocation = scanner.nextLine();

        for (int i = 0; i < trackingLocations.size(); i++) {
            trackingLocations.get(i).reportStatus(newLocation);

        }

    }

    private static void getListOfBox() {
        System.out.println("  Список посылок в какой коробке нужно вывести?\n 1-Стандартная\n2-Хрупкая\n3-Скоропортящаяся ");
        int description = Integer.parseInt(scanner.nextLine());
        if (description == 1) {
            for (Parcel p : standartBox.getALLParcels()) {
                System.out.println(p);
            }
        } else if (description == 2) {
            System.out.println(fragileBox.getALLParcels());
            for (Parcel p : fragileBox.getALLParcels()) {
                System.out.println(p);
            }
        } else if (description == 3) {
            for (Parcel p : perishableParcelParcelBox.getALLParcels()) {
                System.out.println(p);
            }
        } else {
            System.out.println("Такой команды нет");
        }
    }

}
