package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, String> dict = new HashMap<>();
        dict.put(1, "A");

        for (Map.Entry<Integer, String> entry : dict.entrySet()){
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }

        final int N = 10;
        int[] array = new int[N];
        int[] arraySearch = new int[10];
        input(array);
        input(arraySearch, 10);
//        output(array);
        output(arraySearch);

//        bubbleSort(array);
//        sortBySelect(array);
//        insertionSort(array);
//        fastSort(array);
        fastSort(arraySearch);

        System.out.println();

        output(arraySearch);

        System.out.println();

        System.out.println(binarySearch(arraySearch, 3));


//        output(array);
        // write your code here
    }

    //Алгоритм бинарного поиска. Сложность алгоритма O(log n)
    private static int binarySearch(int[] sortedArray, int key) {
        int low = 0;
        int high = sortedArray.length -1;
        int index = -1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (sortedArray[mid] < key)
                low = mid + 1;
            if (sortedArray[mid] > key)
                high = mid - 1;
            if (sortedArray[mid] == key){
                index = mid;
                break;
            }
        }
        return index;
    }

    //Быстрая сортировка. Сложность алгоритма O(N*logN)
    private static void fastSort(int[] array) {
        recursionFastSort(array, 0, array.length - 1);
    }

    private static void recursionFastSort(int[] arr, int min, int max) {
        if (arr.length == 0) // условие выхода из рекурсии,  если длина массива равна 0
            return;
        if (min >= max) //выходим, так как нечего уже делить
            return;

        int middle = min + (max - min) / 2; // выбираем середину
        int middleElement = arr[middle];

        int i = min, j = max;
        while (i <= j) { // относительно элемента middle определяем меньшие элементы слева, большие справа
            while (arr[i] < middleElement) {
                i++;
            }
            while (arr[j] > middleElement) {
                j--;
            }

            if (i <= j) { //меняем местами
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

            if (min < j) // запускаем рекурсию с элементами меньшими чем middle
                recursionFastSort(arr, min, j);
            if (max > i) // запускаем рекурсию с элементами большими чем middle
                recursionFastSort(arr, i, max);
        }
    }

    //Сортировка методом вставки. Сложность алгоритма O(n^2)
    private static void insertionSort(int[] array) { // i - разделяющий маркер
        for (int i = 1; i < array.length; i++) { // делаем копию помеченного элемента
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) { // пока не будет найден меньший элемент
                array[j] = array[j - 1]; // сдвигаем элементы вправо
                --j;
            }
            array[j] = temp; // вставляем отмеченный элемент, в положеное ему место
        }
    }

    //Сортировка методом выбора. Сложность O(n^2)
    private static void sortBySelect(int[] array) {
        for (int i = 0; i < array.length - 1; i++) { // внешний обычный  цикл
            int min = i;

            for (int j = i + 1; j < array.length; j++) { // обычный цикл, но с отчетом сортированных чисел
                if (array[j] < array[min]) {
                    min = j;
                }

                int temp = array[i]; // вставка отссортированного числа, в положенную ему ячейку
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    //Пузырьковая сортировка. Сложность алгоритма O(n^2)
    private static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    private static void output(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void input(int[] inputArr) {
        Random random = new Random();
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = random.nextInt(1000);
        }
    }

    private static void input(int[] inputArr, int n) {
        Random random = new Random();
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = random.nextInt(n);
        }
    }
}
