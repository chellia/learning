package com.learn.ds;

public class Minimumelement {

	public static void main(String[] args) {
		
		int[] arr = new int[]{5,1,8,0,7,9};
		int min = arr[0];
		int size = arr.length;
		int i = 1;
		System.out.println(minimum(min,arr,i,size));
		

	}

	private static int minimum(int min, int[] arr, int i,int size) {
		// TODO Auto-generated method stub
		if(i == size)
		{
			return min;
		}
		else{
			if(arr[i] < min)
			{
				min = arr[i];
			}
			return minimum(min,arr,++i,size);
		}
	}

}
