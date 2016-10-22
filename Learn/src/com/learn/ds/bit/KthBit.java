package com.learn.ds.bit;

public class KthBit {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		kthBitSetOrNot();
		settingKthBit();
		clearingKthBit();
		togglingkthbit();
		togglingrightmost();
		powerOftwo(7);
		multiplyBytwo();
		divideByTwo();
		noOfOnes();
		multiplyByseven();
		isOnlyOneintheGivenBinary(8);
	}
	
	private static void isOnlyOneintheGivenBinary(int i) {
		// TODO Auto-generated method stub
		if(powerOftwo(i))
		{
			
		}else{
			System.out.println("Not valid");
		}
	}

	private static void multiplyByseven() {
		
		int x = 2;
		x = (x<<3) - x;
		System.out.println("Mutiply by ="+x);
	}

	private static void noOfOnes() {
		int n = 10;
		int count = 0;
		 while(n!=0)
		  {
		    count += n & 1;
		    n >>= 1;
		  }
		 System.out.println("number of 1's="+count);
		 count=0;
		 while(n!=0){
		   n = n&(n-1);
		   count++;
		 }
		 System.out.println("number of 1's="+count);
	}

	private static void divideByTwo() {
		// TODO Auto-generated method stub
		int a = 2;
		int r= a<<1;
		System.out.println(a);
	}

	private static void multiplyBytwo() {
		// TODO Auto-generated method stub
		int a = 4;
		int r = a>>1;
		System.out.println(a);
	}

	private static boolean powerOftwo(int a) {
		// TODO Auto-generated method stub
		
		if((a&(a-1))==0)
		{
			System.out.println("it is pow of 2");
			return true;
		}else{
			System.out.println("it is not pow of 2");
			return false;
		}
	}

	private static void togglingrightmost() {
		
		int n = 20;
		System.out.println(Integer.toBinaryString(n));
		int k = 3;
		n = n & (n-1);
		System.out.println("rightmost:"+n);
		System.out.println(Integer.toBinaryString(n));
	}

	private static void togglingkthbit() {
		
		int n = 10;
		System.out.println(Integer.toBinaryString(n));
		int k = 1;
		n = n ^ (1 << (k-1));
		System.out.println("toggle:"+n);
		System.out.println(Integer.toBinaryString(n));
		
	}

	private static void clearingKthBit() {
		// TODO Auto-generated method stub
		int a = 10;
		int k =3;
		int d = a& ~(1<<k);
		System.out.println(d);
	}

	private static void settingKthBit() {
		// TODO Auto-generated method stub
		int a = 10;
		int k = 0;
		int result = a | 1<<k;
		System.out.println(result);
	}

	public static void kthBitSetOrNot()
	{
		int a = 10;
		int k = 1;
		int shift = a & 1<<k;
		if(shift != 0)
		{
			System.out.println("it is set");
		}else{
			System.out.println("it is not set");
		}
	}

}
