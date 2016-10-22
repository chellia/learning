package com.learn.ds.bit;

public class SwapWithOutTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1;
		int y = 2;
		System.out.println(x);
		System.out.println(y);
		
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		
		System.out.println(x);
		System.out.println(y);


	}

}
