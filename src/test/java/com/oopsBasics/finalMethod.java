package com.oopsBasics;

class abc{
	//we cannot override a final method
	final int Caculation(int a, int b) {
		return a+b;
	}
}

public class finalMethod extends abc {
	//overriding in java : come under run time polymorphism

//	int Caculation(int a, int b) {
//		return a * b;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		abc objabc = new abc();
		System.out.println(objabc.Caculation(6, 4));
		finalMethod objChild = new finalMethod();
		System.out.println(objChild.Caculation(7, 16));
		
	}

}
