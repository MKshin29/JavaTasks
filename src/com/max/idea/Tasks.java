package com.max.idea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tasks {
    public static void main(String[] args) {

//  разкомментируй для проверки задания :)
//        task1();
//        task2();
//        task3();
//        task4();

    }

    public static void task1(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("Введите число: ");
            //вводим с клавиатуры число
            int number = Integer.parseInt(reader.readLine());
            //если число четное, добавляем ему 1, что бы получить следующее нечетное за ним, иначе добавляем 2
            if(number % 2 == 0)     number += 1;
            else number += 2;

            //создаем массив из 10 элементов
            int[] numbersArray = new int[10];
            int index = 0;

            //заполняем массив нечетными числами начиная с number
            for (int i = number; i < number + 20; i += 2) {
                numbersArray[index] = i;
                index++;
            }

            //выводим на экран массив
            for (int i = 0; i < 10; i++) {
                System.out.print(numbersArray[i]);
                if(i != 9){
                    System.out.print("; ");
                }
            }
        }
        catch (IOException e){
            System.out.println("Должно быть введено целочисленное значение");
        }
    }

    public static void task2(){
        //создаем список для заполнения с клавиатуры
        List<Integer> numbersArray = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try{
            //заполняем массив, пока не введем пустую строку
            String entered;

            System.out.println("Введите с клавиатуры массив целых чисел. Для завершения ввода введите пустую строку: ");

            while(true){
                entered = reader.readLine();

                if (entered.isEmpty()){
                    break;
                }

                numbersArray.add(Integer.parseInt(entered));
            }

            //запоминаем минимальный и максимальный элемент списка
            int min = Collections.min(numbersArray);
            int max = Collections.max(numbersArray);

            //запоминаем индекс максимального и минимального элемента массива
            int minIndex = numbersArray.indexOf(min);
            int maxIndex = numbersArray.indexOf(max);

            //выводим все на экран
            System.out.println("Минимальное значение в массиве - " + min + ". Его индекс в массиве - " + minIndex + ".");
            System.out.println("Максимальное значение в массиве - " + max + ". Его индекс в массиве - " + maxIndex + ".");

        }
        catch (IOException e){
            System.out.println("Вы ввели не целочисленное значение");
        }

    }

    public static void task3(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try{
            //вводим с клавиатуры размер будущего массива
            System.out.print("Введите размер массива: ");
            int arraySize = Integer.parseInt(reader.readLine());
            //создаем массив заданного размера
            int[] numbersArray = new int[arraySize];

            //заполняем массив
            System.out.println("Заполните массив: ");

            for (int i = 0; i < numbersArray.length; i++) {
                numbersArray[i] = Integer.parseInt(reader.readLine());
            }

            //выводим на консоль массив до изменений
            System.out.println("Массив до изменения: ");
            for(Integer num: numbersArray){
                System.out.print(num + " ");
            }

            //запоминаем индекс максимального и минимального элементов массива
            //запоминаем максимальный и минимальный элементы массива
            int maxIndex = task3_IndexOfMaxValueOfArray(numbersArray);
            int maxValue = numbersArray[maxIndex];
            int minIndex = task3_IndexOfMinValueOfArray(numbersArray);
            int minValue = numbersArray[minIndex];

            //меняем местами ранее сохраненые элементы массива
            numbersArray[maxIndex] = minValue;
            numbersArray[minIndex] = maxValue;

            //выводим на консоль массив после изменений
            System.out.print("\nМассив после изменения: ");
            for(Integer num: numbersArray){
                System.out.print(num + " ");
            }
        }
        catch (IOException e){System.out.println("Вы ввели не целочисленное значение");}
    }

    public static void task4(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("Введите число строк двумерного массива: ");
            int arrayRows = Integer.parseInt(reader.readLine());

            System.out.println("Введите число столбцов двумерного массива: ");
            int arrayCols = Integer.parseInt(reader.readLine());
            //создаем матрицу заданного размера
            int[][] matrix = new int[arrayRows][arrayCols];
            //заполняем матрицу

            for (int i = 0; i < arrayRows; i++) {
                System.out.println("Введите строку номер " + i);
                for (int j = 0; j < arrayCols; j++) {
                    matrix[i][j] = Integer.parseInt(reader.readLine());
                }
            }

            //выводим матрицу в консоль
            System.out.println("Матрица: ");
            for (int i = 0; i < arrayRows; i++) {
                for (int j = 0; j < arrayCols ; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            //рассчитываем среднее арифметическое для каждой строки и сразу выводим это значение
            System.out.println("Среднее арифметическое для каждой строки");
            for (int i = 0; i < arrayRows; i++) {
                int rowSumm = 0;
                for (int j = 0; j < arrayCols; j++) {
                    rowSumm += matrix[i][j];
                }
                double mean = rowSumm * 1.0 / arrayCols;

                System.out.println("Среднее арифметическое строки номер " + i + ": " + mean);
            }
        }
        catch (IOException e){
            System.out.println("Должно быть введено целочисленное значение");
        }
    }

    public static int task3_IndexOfMaxValueOfArray(int[] array){
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
                index = i;
            }
        }

        return index;
    }

    public static int task3_IndexOfMinValueOfArray(int[] array){
        int max = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < max){
                max = array[i];
                index = i;
            }
        }

        return index;
    }

}
