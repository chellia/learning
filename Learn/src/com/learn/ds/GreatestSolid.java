package com.learn.ds;

public class GreatestSolid 
{

	public static void main(String args[])
	{
		int[] arr = new int[]{1,3,2,5};
		arr = new int[]{8,6,3,1,9};
		Stack building= new Stack();
		building.push(1);
		building.push(3);
		building.push(2);
		building.push(5);
		
		int[][] values= new int[arr.length][arr.length];
		int max = 0;
		for(int i = 0 ; i<arr.length;i++)
		{
			int a = findNextSmallestElementPosForWard(i,arr[i],arr);
			int b = findNextSmallestElementPosBackWard(i,arr[i],arr);
			
			int temp =arr[i]*(a+b+1);
			if(temp > max)
			{
				max = temp;
			}
			
		}
		System.out.println(max);
		//int max = findMaximum(values);
	}

	private static  int findMaximum(int[][] values) {
		
		return 0;
		
	}

	private static int findNextSmallestElementPosForWard(int startPos, int height,int[] arr) {
		int init = 0;
		int nextSmallestPos = 0;
		for(int i=startPos+1;i<arr.length;i++)
		{
			if(arr[i]  >= height)
			{
				nextSmallestPos += 1;
			}else{
				break;
			}
		}
	//	if(nextSmallestPos  >startPos )
			return nextSmallestPos;		
	//	return arr.length;
	}
	
	private static int findNextSmallestElementPosBackWard(int startPos, int height,int[] arr) {
		int init = 0;
		int nextSmallestPos = 0;
		for(int i=startPos-1;i>0;i--)
		{
			if(arr[i]  >= height)
			{
				init +=1;
				nextSmallestPos += 1;
			}
			else{
				break;
			}
		}
		
			return nextSmallestPos;		
		//return 0;
	}
}
