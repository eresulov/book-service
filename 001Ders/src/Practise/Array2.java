package Practise;

import java.util.Random;
//budaki 2 ci sualdir
public class Array2 {
	static void bubbleSort(int array[]) {
		System.out.println("Bu2 ci sualdir");
		int count = array.length;
		int temp = 0;
		for (int i = 0; i < count; i++) {
			for (int j = 1; j < (count - i); j++) {
				if (array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int array[] = new int[50];
		int max = 0;

		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(1, 101);
		}
		for (int cap : array) {
			System.out.println(cap);
		}

		for (int cap : array) {
			if (cap > max) {
				max = cap;

			}

		}
		System.out.println("max value : " + max);
		int min = max;
		for (int cap2 : array) {
			if (cap2 < min) {
				min = cap2;
			}
		}
		System.out.println("min value : " + min);
		System.out.println("azdan coxa verilme ");
		bubbleSort(array);
		for (int cap3 : array) {

			System.out.print(cap3 + " ");
		}

	}

}
