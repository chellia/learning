package com.learn.ds;

public class Stack 
{
	int size = 10;
	
	int[] stack = new int[size];
	int top = -1;
	
	public void push(int data)
	{
		if(isStackFull())
		{
			System.out.println("Over Flow");
		}else{
			this.stack[++top]=data;
		}
	}

	private boolean isStackFull() {
		if((this.size-1) == this.top)
			return true;
		return false;
	}
	
	public int pop()
	{
		int a = -1;
		if(isEmpty())
		{
			System.out.println("Under Flow");
		}
		else{
			//stack[--top] = 0;
			a = this.stack[top];
			this.top--;
		}
		return a;
	}

	private boolean isEmpty() {
		if(top == -1)
			return true;
		return false;
	}
	
	public void display()
	{
		System.out.println("Display Method Start");
		int i = top;
		while(i>=0)
		{
			
			System.out.println(stack[i]);
			i--;
			
		}
		System.out.println("Display Method end");
	}
	
	public static void main(String args[])
	{
		Stack myStack = new Stack();
		/*myStack.push(1);
		//myStack.display();
		myStack.push(2);
		//myStack.display();
		myStack.pop();
		myStack.pop();
		myStack.display();
		myStack.pop();
		for(int i =0;i<=10;i++)
		{
			myStack.push(i);
		}
		myStack.display();*/
		
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
