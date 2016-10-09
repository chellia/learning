package com.learn.ds;

public class StackMin 
{
	int size = 10;
	
	int[] stack = new int[size];
	int[] minStack = new int[size];
	int top = -1;
	int minTop = -1;
	
	public void push(int data)
	{
		if(isStackFull())
		{
			System.out.println("Over Flow");
		}else{
			if(minTop < 0)
			{
				this.minStack[++minTop] = data;
			}else{
				int temp = minStack[minTop];
				if(data < temp)
				{
					this.minStack[minTop] = temp;
					this.minStack[++minTop] = data;
				}
			}
			this.stack[++top]=data;
		}
	}

	private boolean isStackFull() {
		if((this.size-1) == this.top)
			return true;
		return false;
	}
	
	public int getMinimum()
	{
		if(minTop > -1)
		{
			return this.minStack[minTop];
		}
		return -1;
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
			int temp = this.minStack[minTop];
			if(a == temp)
			{
				this.minTop--;
			}
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
		StackMin myStack = new StackMin();
		myStack.push(10);
		//myStack.display();
		myStack.push(11);
		//myStack.display();
		//myStack.pop();
		//myStack.pop();
		//myStack.display();
		
		//myStack.pop();
		for(int i =3;i<7;i++)
		{
			myStack.push(i);
		}
		myStack.display();
		System.out.println("minimum element="+ myStack.getMinimum());
		/*int[] arr = new int[]{4,5,2,25};
		
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
		}*/
	}

}
