package com.learn.ds.heap;

public class MaxHeap
{

	public static void main(String arg[])
	{
		//100,90,11,10,8,7,5
		int[] arr = new int[]{10,8,11,5,7,90,100};
		buildHeap(arr);
		System.out.println(arr[0]);
		for(int i = 0 ; i<7;i++)
		{
		findKthsmallest(arr,i);
		System.out.println(arr[0]);
		}
	}

	private static void findKthsmallest(int[] arr, int i) {
		// TODO Auto-generated method stub
		int len = arr.length-1;
		while(i>0)
		{
			int largest = arr[0];
			int temp = arr[len];
			arr[len]=largest;
			arr[0]=temp;
			maxHeapify(arr,0,--len);
			--i;
		}
	}

	private static int[] buildHeap(int[] arr)
	{
		
		int n = arr.length;
		
		for(int i = n/2;i>=0;i--)
		{
			maxHeapify(arr,i,n);
		}
		
		return null;
	}

	private static void maxHeapify(int[] arr, int ele,int len) {
		
		if(ele>len)
		{
			return;
		}
		
		int left = 2*ele+1;
		int right = 2*ele+2;
		
		int max = ele;
		
		if(left < len   && arr[max] < arr[left] )
		{
			max = left;
		}
		if(right < len   && arr[max] < arr[right])
		{
			max = right;
		}
		
		if(max != ele)
		{
			exchange(arr,max,ele);
			maxHeapify(arr,max,len);
		}
	}

	private static void exchange(int[] arr, int max, int ele) {
		// TODO Auto-generated method stub
		int temp = arr[max];
		arr[max] = arr[ele];
		arr[ele] = temp;
	}
}
