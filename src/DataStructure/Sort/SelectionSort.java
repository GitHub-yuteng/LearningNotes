package DataStructure.Sort;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {

		int[] arr = {15, 3, 2, 45, 65, 33, 12};
		System.out.println("交换之前：" + Arrays.toString(arr));

//	0--1
//	0--2
//	0--3
//	0--4
//	1--2
//	1--3
//	1--4
//	2--3
//	2--4
//	3--4

		for(int j = 1;j<=arr.length-1;j++){
			for(int i = j;i<=arr.length-1;i++){
				int temp;
				if(arr[j-1]>arr[i]){
					temp = arr[j-1];
					arr[j-1] = arr[i];
					arr[i] = temp;
				}
			}
		}

		System.out.println("交换之后：" + Arrays.toString(arr));
	}
}