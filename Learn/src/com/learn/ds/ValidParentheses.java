package com.learn.ds;



public class ValidParentheses {

	public static void main(String[] args)
	{
	     char[] arr = new char[]{')','(',')','(',')',')','(','(','(','(',')',')',')',')',')'};
	     arr = new char[]{'(','(','(',')',')',')','(','(',')','(',')',')'};
	     arr = new char[]{'(',')','(','(',')','(',')','('};
	     
		 StackPolindrom stack = new StackPolindrom();
		 int count = 0;
		 int max = 0;
	      for(int i = 0; i<arr.length;i++)
	      {
	    	  if(arr[i] == '(')
	    	  {
	    		  stack.push(arr[i]);
	    	  }
	    	  else{
	    		   if(!stack.isEmpty())
	    		   {
	    			   char temp = stack.pop();
	    			   if(arr[i] == ')')
	    			   {
	    				   if(temp == '(')
	    				   count++;
	    				   
	    			   }
	    			   else{
	    				  if(max < count)
	    				  max = count; 
	    				  count = 0;
	    			   }
	    		   }else{
	    			   max = count;
	    			   count = 0;
	    		   }
	    	  }
	      }
	      if(max == 0)
	      {
	    	  max = count;
	      }
	      
	      System.out.println(2*max);
	      getMaxSubString();
		//isBalanced(lStr,lMap);
		

	}
	
	public static void getMaxSubString()
	{
		  char[] arr = new char[]{')','(',')','(',')',')','(','(','(','(',')',')',')',')',')'};
		   //  arr = new char[]{'(','(','(',')',')',')','(','(',')','(',')',')'};
		     arr = new char[]{'(',')','(','(',')','(',')','('};
		  //String  str="((()()";
		 // str="()(()))))";
		 // arr = str.toCharArray();
		 
			 Stack stack = new Stack();
			 stack.push(-1);
			 int result = 0;
			 
			 int max = 0;
			 
			 for(int i = 0; i< arr.length;i++)
			 {
				 if(arr[i] == '(')
				 {
					 stack.push(i);
				 }else{
					int temp = stack.pop();
					if(stack.isEmpty())
					{
						 stack.push(i);
					}
					else
					{
						result = Math.max(result,i - stack.peek());
					}
				 }
			 }
			 
			 System.out.println(result);
			 
	}

	

}
