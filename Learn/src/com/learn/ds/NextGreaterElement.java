package com.learn.ds;

public class NextGreaterElement 
{

	public static void main(String args[])
	{
		Stack myStack = new Stack();
		int[] arr = new int[]{4,5,2,25};
		
		for(int i = 0;i<arr.length;i++)
		{
			if(myStack.isEmpty())
			{
				myStack.push(arr[i]);
			}else{
				while(myStack.top >=0)
				{
					int temp = myStack.pop();
					if(arr[i] > temp)
					{
						System.out.println(temp+"-->"+arr[i]);
					}else{
						myStack.push(temp);
						break;
					}
				}
				myStack.push(arr[i]);
			   
			}
		}
		
		while(myStack.top >=0)
		{
			System.out.println(myStack.pop() + "-->"+ "-1");
		}
	}
}
