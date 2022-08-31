
package odev8;


import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

public class Odev7   {

    static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    static void buildHeap(int arr[], int n) {
        int startIdx = (n / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    static void printHeap(int arr[], int n) {
        System.out.println("\nHeaped:");
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("\nEnter the number of the array's ");
        int number_of_arrays = s.nextInt();
        Scanner lengths_of_array = new Scanner(System.in);
        System.out.print("\nEnter the length of the whole arrays length: ");
        int wholeArraysLength = lengths_of_array.nextInt();
        int count = 0;
        int unitedArray[] = new int[wholeArraysLength];
        int heapsLength = (wholeArraysLength) / (number_of_arrays);//heapteki eleman sayisi
        for (int i = 0; i < number_of_arrays; i++) {

            Scanner length_of_array = new Scanner(System.in);
            System.out.print("\nEnter the length of the " + (i + 1) + ".array:");
            int length = length_of_array.nextInt();

            int[] myArray = new int[length];
            System.out.println("\nEnter the elements of the " + (i + 1) + ".array: ");
            for (int j = 0; j < length; j++) {
                myArray[j] = length_of_array.nextInt();
                unitedArray[count] = myArray[j];
                count++;
            }

        }

        buildHeap(unitedArray, unitedArray.length);

        printHeap(unitedArray, unitedArray.length);
        

        int x = 0;

        int arrHeaped[][] = new int[number_of_arrays][heapsLength];
        for (int i = 0; i < number_of_arrays; i++) {
            for (int j = 0; j < heapsLength; j++) {
                arrHeaped[i][j] = unitedArray[x];
                ++x;
            }

        }
        for (int i = 0; i < number_of_arrays; i++) {
            for (int j = 0; j < heapsLength; j++) {

                System.out.print(arrHeaped[i][j] + " ");
            }
        }

    }

}