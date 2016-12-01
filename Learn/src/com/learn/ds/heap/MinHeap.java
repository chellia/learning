package com.learn.ds.heap;

public class MinHeap 
{ 

	public static void main(String[] args)
	{
		int[] arr = getJoinedPipes(1,new int[]{4,2,3,5});
		for (int i =0;i<arr.length;i++) {
			
			System.out.println(arr[i]);
		}
		
	}
    public static int[] getJoinedPipes(int input1,int[] input2)
    {
        //Write code here
        int result[] = minCost(input2);
        return result;
    }
    
    private static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i]= a[j];
        a[j]=temp;
    }
    
    private static void minHeapify(int[] a,int k, int n)
    {
        if(k>n)
        {
            return;
        }
        
        int left = 2*k+1;
        int right = 2*k+2;
        int min = k;
        if(left < n && a[left] < a[min])
        {
            min = left;
        }
        
        if(right < n && a[right] < a[min])
        {
            min = right;
        }
        
        if(k != min )
        {
            swap(a,k,min);
            minHeapify(a,min,k);
        }
    }
    
    private static int[] minCost(int[] a)
    {
        
        int len = a.length;
        int[] result = new int[len];
        if(len == 0)
        {
            return result;
        }
        if(len == 1)
        {
            return result;
        }
        
        minHeap(a);
        int i=0;
        while(len >= 2)
        {
            int first = a[0];
            a[0] = a[len-1];
            minHeapify(a,0,len-1);
            a[0] = a[0]+first;
            result[i++]=a[0];
            minHeapify(a,0,len-1);
            len = len - 1;
        }
        
        int[] output = constructArr(i,result);
        
        return output;
    }
    
    private static int[] constructArr(int len, int[] result) {
		int arr[] = new int[len];
		for(int i=0;i<len;i++)
		{
			arr[i] = result[i];
			
		}
		return arr;
	}
	private static void print(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] !=0)
            {
                if(i>0)
                {
                    System.out.print(",");
                }
                System.out.print(arr[i]);
            }
        }
    }
    
   
    private static void minHeap(int[] a)
    {
        int len = a.length-1;
        for(int i = len/2;i>=0;i--)
        {
            minHeapify(a,i,len);
        }
    }
}