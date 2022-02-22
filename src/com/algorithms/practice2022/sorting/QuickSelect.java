package com.algorithms.practice2022.sorting;

public class QuickSelect {


    public static int quickselect(int[] array, int k) {
        return quickSelect(array, 0, array.length -1, k -1);
    }

    private static int quickSelect(int[] arr, int start, int end, int position) {


        while(true) {


            int pivotIndex = start;
            int left = start + 1;
            int right = end;
            System.out.println("Pivot "+ pivotIndex + " left " + left + " right " + right);
            while (left <= right) {

                if (arr[left] <= arr[pivotIndex])
                    left++;
                if (arr[right] >= arr[pivotIndex])
                    right--;

                if (arr[left] > arr[pivotIndex] &&
                        arr[right] < arr[pivotIndex]) {
                    swap(arr, left, right);
                }

            }

            swap(arr, pivotIndex, right);

            if (right == position) {
                return arr[right];
            }

            if (right > position) {
                end = right - 1;
            } else {
                start = right+1;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {8, 5, 2, 9, 7, 6, 3};
        quickselect(arr, 3);
    }
}
