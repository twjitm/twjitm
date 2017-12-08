package com.twjitm.test;

/**
 * Created by 文江 on 2017/12/8.
 */
public class TestSort {

    public static void main(String[] args) {
        int[] array = {3, 1, 5, 7, 2, 4, 9, 6};

    }

    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
               int position=i-1;
               int value=array[i];
               array[i-1]=array[i];
               while(value<array[position]){
                 array[position+1]=array[position];
                 position--;
               }
            }
        }
    }

}
