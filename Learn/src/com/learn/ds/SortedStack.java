package com.learn.ds;

public class SortedStack {

	public static void main(String[] args) 
	{
		Stack S = new Stack();
		S.push(5);
		S.push(3);
		S.push(7);
		S.push(2);
		S.push(6);
		S.display();
		getEachElement(S);
		S.display();

	}
	
	public static void getEachElement(Stack S)
	{
		if(!S.isEmpty())
		{
			int data = S.pop();
			getEachElement(S);
			sortStack(S,data);
		}
	}

	private static void sortStack(Stack s, int data) {
		// TODO Auto-generated method stub
		if(s.isEmpty())
		{
			s.push(data);
			//return data;
		}else{
			int temp = s.pop();
			if(temp > data)
			{
				s.push(temp);
				s.push(data);
				
			//	return data;
			}else{
				sortStack(s,data); 
				s.push(temp);
			}
		}
	//	return -1;
	}

}
