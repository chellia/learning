package com.learn.ds;

public class StackPolindrom 
{

	int size = 10;
	char[] stack = new char[size];
	int top = -1;
	
	public void push(char data)
	{
		if(isStackFull())
		{
			System.out.println("Over Flow");
		}else{
			this.stack[++top]=data;
		}
	}

	public boolean isStackFull() {
		if((this.size-1) == this.top)
			return true;
		return false;
	}
	
	public char pop()
	{
		char a = '-';
		if(isEmpty())
		{
			System.out.println("Under Flow");
		}
		else{
			a = stack[top];
			this.top--;
		}
		return a;
	}

	public boolean isEmpty() {
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
			
			System.out.println(String.format("%c",stack[i]));
			i--;
			
		}
		System.out.println("Display Method end");
	}
	
	public static void main(String args[])
	{
		StackPolindrom myStack = new StackPolindrom();
		myStack.push('a');
		myStack.push('b');
		myStack.push('a');
		myStack.push('b');
		myStack.push('a');
		myStack.display();
		
		int size = myStack.top+1;
		int mid = 0;
		if(size % 2 != 0)
		{
			mid = size/2;
		}else{
			mid = size /2;
		}
		
		isPoli(myStack,mid);
		/*myStack.pop();
		myStack.pop();
		myStack.display();
		myStack.pop();
		for(int i =0;i<=10;i++)
		{
			myStack.push(i);
		}
		myStack.display();*/
	}

	private static char isPoli(StackPolindrom myStack, int mid) {
		if(myStack.top <= mid)
		{
			if(mid % 2 != 0)
			{
				myStack.pop();
				return myStack.pop();
			}else{
				myStack.pop();
				return myStack.pop();
			}
			
			
		}
		else{
			char temp = myStack.pop();
			char data = isPoli(myStack,mid);
			if(temp != data)
			{
				System.out.println(" it is not");
			}
		}
		return 'a';
	}

}
