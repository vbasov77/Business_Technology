package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 2, 4, 6, 1, 3, 2, 6})));
        System.out.println(Arrays.toString(directSort(new int[]{5, 2, 4, 6, 1, 3, 2, 6})));
        System.out.println(Arrays.toString(insertSort(new int[]{5, 2, 4, 6, 1, 3, 2, 6})));
        System.out.println(Arrays.toString(heapSort(new int[]{5, 2, 4, 6, 1, 3, 2, 6})));
    }

    // Пузырьковая сортировка
    public static int[] bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        } while (!finish);
        return array;
    }

    // Сортировка выбором
    public static int[] directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
        return array;
    }

    // Сортировка вставками
    public static int[] insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    // Сортировка кучей
    public static int[] heapSort(int[] array) {

        //Построение кучи(перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heap(array, array.length, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heap(array, i, 0);
        }
        return array;
    }

    public static void heap(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; //Инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // Левый равно 2 * rootIndex + 1
        int rightChild = 2 * rootIndex + 2;// Правый равно 2 * rootIndex + 2

        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // Если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heap(array, heapSize, largest);
        }

    }
}