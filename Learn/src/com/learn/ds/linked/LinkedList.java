package com.learn.ds.linked;

public class LinkedList 
{
	
	class Node{
		int value;
		Node next;
	}
	
	Node head;
	
	public void display()
	{
		Node current = head;
		while(current != null)
		{
			System.out.print(current.value);
			System.out.print("->");
			current = current.next;
		}
		System.out.print("NULL");
	}
	
	public void display(Node node)
	{
		Node current = node;
		while(current != null)
		{
			System.out.print(current.value);
			System.out.print("->");
			current = current.next;
		}
		System.out.print("NULL");
	}
	
	public void insertAtBegining(int val)
	{
		Node current = head;
		if(current != null)
		{
			Node newnode = new Node();
			newnode.value = val;
			newnode.next = current;
			head = newnode;
		}else{
			head = new Node();
			head.value = val;
			head.next = null;
		}
	}
	
	public void insertAtEnd(int val)
	{
		Node current = head;
		while(current.next != null)
		{
			current = current.next;
		}
		Node newnode = new Node();
		newnode.value = val;
		newnode.next = null;
		current.next = newnode;
	}
	
	public void insertMiddle(int val)
	{
		Node slow = head;
		Node fast = head;
		if(slow != null && fast.next != null)
		{
			fast = fast.next;
			while(fast != null)
			{
				slow = slow.next;
				if(fast.next != null)
				fast = fast.next.next;
			}
			
		}
		Node newnode = new Node();
		newnode.value = val;
		newnode.next = slow.next;
		slow.next = newnode;
		
	}
	
	public void insertAtPosition(Node head,int value, int pos)
	{
		Node node = new Node();
		node.value = value;
		if(pos == 0)
		{
			
			node.next = head;
			head = node;
		}
		else{
			int i = 1;
			Node current = head;
			while(i>pos)
			{
				i++;
				current = current.next;
			}
			if(current == null)
			{
				current = node;
			}else{
				node.next = current.next;
				current.next = node;
			}
			
		}
	}
	
	public void deleteAtBegining(int val)
	{
		Node current = head;
		
		if(null != current)
		{
			head = current.next;
		}
	}
	
	public void deleteAtEnd(int val)
	{
		Node current = head;
		while(current.next.next != null)
		{
			current = current.next;
		}
		current.next = null;
	}
	
	public Node findNthNodefromBack(Node head,int pos)
	{
		Node current = head;
		Node begin = head;
		Node ahead = head;
		if(current == null)
		{
			System.out.println("No node");
			return head;
		}
		else{
			
			for(int i=1;i<pos;i++)
			{
				if(ahead.next != null)
				{
					ahead = ahead.next;
				}else{
					System.out.println("there is no "+ pos + "elements");
				}
			}
			while(ahead.next != null)
			{
				ahead = ahead.next;
				begin = begin.next;
			}
		}
		return begin;
	}
	
	public boolean isPolindrom(Node head,Node tail)
	{
		if(tail.next == null)
		{
			boolean f = (tail.value == head.value);
			head = head.next;
			return f;
		}
		else{
			 if(tail.next != null)
			 if(isPolindrom(head,tail.next)){
				 return true;
			 }else{
				 return false;
			 }
			
		}
		
		return false;
		
	}
	
	public void displayBack(Node head)
	{
		if(head.next != null)
		{
			displayBack(head.next);
		}
		System.out.print(head.value);
		System.out.print("->");
	}
	
	public void arrange(Node head)
	{
		Node zero = null;
		Node one = null;
		Node two = null;
		Node current = head;
		while(current != null)
		{
			if(current.value == 0)
			{
				zero = insertAtEnd(zero,current);
			}else if(current.value == 1)
			{
				one = insertAtEnd(one,current);
			}else{
				two = insertAtEnd(two,current);
			}

			current = current.next;
		}
		zero = merge(zero,one);
		zero = merge(zero,two);
		display(zero);
	}
	
	private Node merge(Node zero, Node one) {
		Node current = zero;
		if(current == null)
		{
			return one;
		    
		}
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = one;
		return zero;
	}

	private Node insertAtEnd(Node zero, Node current)
	{
		if(zero == null)
		{
			zero = new Node();
			zero.value = current.value;
		}else{
			Node temp = zero;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = new Node();
			temp.next.value = current.value;
			
		}
		return zero;
	}

	public static void main(String args[])
	{
		LinkedList lLinkedList = new LinkedList();
		lLinkedList.display();
		System.out.println();
		lLinkedList.insertAtBegining(2);
		lLinkedList.display();
		System.out.println();
		lLinkedList.insertAtBegining(1);
		lLinkedList.display();
		System.out.println();
		lLinkedList.insertAtBegining(0);
		lLinkedList.display();
		System.out.println();
		lLinkedList.insertAtBegining(2);
		lLinkedList.display();
		System.out.println();
		lLinkedList.insertAtBegining(1);
		lLinkedList.display();
		System.out.println();
		lLinkedList.insertAtBegining(0);
		lLinkedList.display();
		System.out.println();
		lLinkedList.arrange(lLinkedList.head);
		/*System.out.println(lLinkedList.isPolindrom(lLinkedList.head, lLinkedList.head));
		lLinkedList.displayBack(lLinkedList.head);*/
		/*lLinkedList.insertAtEnd(7);
		lLinkedList.display();		
		System.out.println();
		lLinkedList.insertMiddle(6);
		lLinkedList.display();
		System.out.println();
		Node node1 = lLinkedList.findNthNodefromBack(lLinkedList.head,1);
		System.out.println(node1.value);
		lLinkedList.deleteAtBegining(6);
		lLinkedList.display();
		System.out.println();
		lLinkedList.deleteAtEnd(6);
		lLinkedList.display();
		System.out.println();
		Node node = lLinkedList.findNthNodefromBack(lLinkedList.head,1);
		System.out.println(node.value);*/
		
	}

}
