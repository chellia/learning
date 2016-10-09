package com.learn.ds.queue;

public class Queue 
{

	int size = 0;
	int[] queue = new int[10];
	int front = -1;
	int rear = -1;
	
	public void enQueue(int data)
	{
		if(isFull())
		{
			System.out.println("Over flow");
		}
		else{
			size++;
			rear =  (rear +1 ) % queue.length;
			queue[rear]=data;
			
			if(front == -1)
			{
				front = rear;
			}
		}
	}
	
	public int size()
	{
		return this.size;
	}

	public boolean isFull() {
		if(queue.length == size)
		{
			return true;
		}
		return false;
	}
	
	public int deQueue()
	{
		if(isEmpty())
		{
			System.out.println("Under Flow");
			return -1;
		}else{
			int data = queue[front];
			size--;
			front = (front +1) % queue.length;
			if(size == 0)
			{
				front = -1;
				rear = -1;
			}
			return data;
		}
	}

	public boolean isEmpty() 
	{
		if(size==0)
			return true;
		return false;
	}
	
	public void display()
	{
		
		for(int i = front,j=0;j<size;j++)
		{
			System.out.println(queue[i]);
			i = i +1 % queue.length;
		}/*
		if(front <= rear)
		{
		for(int i = front;i<=rear;i++)
		{
			System.out.println(queue[i]);
		}
		}else{
			
			for(int i = front;i<size;i++)
			{
				System.out.println(queue[i]);
			}
			for(int i=0;i<=rear;i++)
			{
				System.out.println(queue[i]);
			}
		}*/
	}
	
	
	
	public static void main(String a[])
	{ 
		Queue lQueue = new  Queue();
		lQueue.deQueue();
		lQueue.enQueue(1);
		lQueue.deQueue();
		//lQueue.enQueue(2);
		//lQueue.display();
		
		for(int i=0;i<10;i++)
		{
			lQueue.enQueue(i);
		}
		lQueue.display();
		for(int i=0;i<5;i++)
		{
			lQueue.deQueue();
		}
		System.out.println("-------");
		lQueue.display();
		//lQueue.deQueue();
		
		
	}
}
