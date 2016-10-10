package com.learn.ds.queue;

public class QueueLL 
{
	Node front;
	Node rear;

	class Node
	{
		int data;
		Node next;
	}
	
	public void enQ(int data)
	{
		insertAtEnd(data);
	}
	
	public int deQ()
	{
		return deleteAtBigining();
	}
	
	public void insertAtEnd(int data)
	{
		if(rear == null && front == null)
		{
			front = new Node();
			front.data = data;
			front.next = null;
			rear = front;
		}else{
			Node current = new Node();
			current.data = data;
			rear.next = current;
			rear = current;
			if(front == null)
			{
				front = rear;
			}
		}
	}
	
	public int deleteAtBigining()
	{
		if(front == null && rear == null)
		{
			System.out.println("Under Flow");
			return -1;
		}
		else{
			int data = front.data;
			front = front.next;
			return data;
		}
	}
	
	public boolean isEmpty()
	{
		if(front == null)
		{
			return true;
		}
		return false;
	}
	
	public void display()
	{
		Node current = front;
		if(current != null)
		{
			System.out.println(current.data);
		
		while(current.next != null)
		{
			current = current.next;
			System.out.println(current.data);
			
			
		}
		}
	}
	
	public static void main(String args[])
	{
		QueueLL lQueueLL = new QueueLL();
		lQueueLL.deQ();
		lQueueLL.enQ(2);
		lQueueLL.enQ(3);
		lQueueLL.display();
		findMaximuminsubarray();
	}
	
	
	public static void findMaximuminsubarray()
	{
		int[] arr = new int[]{1,2,3,1,4,5,2,3,6};
		QueueLL lQueueLL = new QueueLL();
		int k = 3;
		int count = 0;
		
		for(int i = 0; i< arr.length;)
		{
			if(!((arr.length-1) -i >= k-1) )
			{
				break;
			}
			if(count == 0 )
			{
				lQueueLL.enQ(arr[i]);
				lQueueLL.enQ(arr[i]);
				count++;
			}else{
				if(count < k)
				{
					int current = lQueueLL.deQ();
					int max = lQueueLL.deQ();
					if(arr[count+i] > max)
					{
						lQueueLL.enQ(current);
						lQueueLL.enQ(arr[count+i]);
					}else{
						lQueueLL.enQ(current);
						lQueueLL.enQ(max);
					}
					//lQueueLL.enQ(Math.max(lQueueLL.deQ(), arr[count]));
					count++;
					if(count == k)
					{
						count = 0;
						i++;
						lQueueLL.deQ();
						System.out.print(lQueueLL.deQ());
						System.out.print(" ");
					}
				}
			}
		}
		
	}
	
}
