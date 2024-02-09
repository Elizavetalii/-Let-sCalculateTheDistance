package org.example;
import java.util.Scanner;

public class DistanceCalculator {
    public static final double EARTH_RADIUS = 6371; // Радиус Земли в километрах

    public static void main(String[] args) { //вход в программу
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите географические координаты первой точки");
        System.out.println("Широта:");
        double latitude1 = scanner.nextDouble(); //Считывание широты первой точки
        System.out.println("Долгота:");
        double longitude1 = scanner.nextDouble(); //Считывание долготы первой точки

        System.out.println("Введите географические координаты второй точки");
        System.out.println("Широта:");
        double latitude2 = scanner.nextDouble();//Считывание широты второй точки
        System.out.println("Долгота:");
        double longitude2 = scanner.nextDouble();//Считывание долготы второй точки

        double distance = calculateDistance(latitude1, longitude1, latitude2, longitude2);
        System.out.printf("Расстояние между точками: %.2f км", distance);
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2){
        //Принимает четыре параметра - координаты двух точек
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Вычисляем разницу широты и долготы
        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        // Используем формулу Хаверсинуса для расчета расстояния на сфере
        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Возвращаем радиус Земли умноженый на значение получившееся в формуле
        return EARTH_RADIUS * c;
    }
}