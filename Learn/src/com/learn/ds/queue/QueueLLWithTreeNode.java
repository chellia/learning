package com.learn.ds.queue;
import com.learn.ds.tree.Node;
public class QueueLLWithTreeNode 
{
	Node front;
	Node rear;

	class Node
	{
		com.learn.ds.tree.Node data;
		Node next;
	}
	
	public void enQ(com.learn.ds.tree.Node data)
	{
		insertAtEnd(data);
	}
	
	public com.learn.ds.tree.Node deQ()
	{
		return deleteAtBigining();
	}
	
	public void insertAtEnd(com.learn.ds.tree.Node data)
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
	
	public com.learn.ds.tree.Node deleteAtBigining()
	{
		if(front == null && rear == null)
		{
			System.out.println("Under Flow");
			return null;
		}
		else{
			com.learn.ds.tree.Node data = front.data;
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
			System.out.println(current.data.getData());
		
		while(current.next != null)
		{
			current = current.next;
			System.out.println(current.data.getData());
			
			
		}
		}
	}
	
	
	
	public static void main(String args[])
	{
		QueueLLWithTreeNode lQueueLL = new QueueLLWithTreeNode();
		lQueueLL.deQ();
		lQueueLL.enQ(new com.learn.ds.tree.Node(1));
		lQueueLL.enQ(new com.learn.ds.tree.Node(2));
		lQueueLL.display();
		
	}
	
	
	
		
	
	
}
