package ru.skypro;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
//        printIsLeapYear(2020);

//        printRecommendApplicationVersion(0, 2015);

//        System.out.println("Количество дней доставки: " + calculateDeliveryDays(55));

//        findAndPrintDuplicatesIfAny("aabcdefghijk");

//        int[] arr = new int[]{3, 2, 1, 6, 5};
//        reverseArray(arr);
//        System.out.println("reversed array:" + Arrays.toString(arr));

        int[] array = generateRandomArray();
        double avgSum = calculateAverageValueFrom(array);
        System.out.println("Average sum :" + avgSum);


    }


    public static void printIsLeapYear(int year) {
        boolean yearIsLeap = isLeap(year);
        printIsLeapYearResult(year, yearIsLeap);
    }

    private static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static void printIsLeapYearResult(int year, boolean yearIsLeap) {
        if (yearIsLeap) {
            System.out.println(year + " - високосный год.");
        } else {
            System.out.println(year + " - не високосный год.");
        }
    }

    public static void printRecommendApplicationVersion(int clientOS, int deviceYear) {
        boolean deviceIsOld = isDeviceOld(deviceYear);
        System.out.print("Установите ");
        if (deviceIsOld) {
            System.out.print("Lite");
        }
        System.out.print(" версию для ");
        if (clientOS == 0) {
            System.out.println("iOS");
        } else {
            System.out.println("Android");
        }
    }

    private static boolean isDeviceOld(int deviceYear) {
        int currentYear = LocalDate.now().getYear();
        return deviceYear <= currentYear;
    }

    public static int calculateDeliveryDays(int deliveryDistance) {
        int result = 1;
        if (deliveryDistance > 20) {
            result ++;
        }
        if (deliveryDistance > 60) {
            result ++;
        }
        return result;
    }

    public static void findAndPrintDuplicatesIfAny(String text) {
        if (text.equals("")) {
            return;
        }
        char[] letters = text.toCharArray();
        char prevChar = Character.MAX_VALUE;
        boolean isDuplicateFound = false;
        for (char letter : letters) {
            if (letter == prevChar) {
                System.out.println("Найден дубль по символу " + letter);
                isDuplicateFound = true;
                break;
            }
            prevChar = letter;
        }
        if (isDuplicateFound) {
                System.out.println("Дублей не найдено");
        }
    }

    public static void reverseArray(int[] arr) {
        int head = 0;
        int tail = arr.length - 1;
        while (head < tail) {
            int temp = arr[head];
            arr[head++] = arr[tail];
            arr[tail--] = temp;
        }
    }

    public static double calculateAverageValueFrom(int[] arr) {
        int sum = calculateSumFrom(arr);
        return calculateAverageValue(sum, arr.length);
    }

    private static int calculateSumFrom(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    private static double calculateAverageValue(int sum, int elementAmount) {
        return sum / (double) elementAmount;
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }


}

