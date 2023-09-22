package com.ControlStatements;

//Java Program to demonstrate the use of Enum  
//in switch statement  
public class enumSwitch {
	public enum Day {
		Sun, Mon, Tue, sunil,Wed, Thu, Fri, Sat 
	}

	public static void main(String args[]) {
		Day[] enumArr = Day.values();
		int[] intarr = {8,9,3};
		for (Day IndividualDay : enumArr) {
			switch (IndividualDay) {
			case Sun:
				System.out.println("Sunday");
				break;
			case Mon:
				System.out.println("Monday");
				break;
			case Tue:
				System.out.println("Tuesday");
				break;
			case Wed:
				System.out.println("Wednesday");
				break;
			case Thu:
				System.out.println("Thursday");
				break;
			/*
			 * case Fri: System.out.println("Friday"); break; case Sat:
			 * System.out.println("Saturday"); break;
			 */
			default :
				System.out.println("default block is executed");
				break;
			}
		}
		//for(int IndividualNumber:intarr) {
			//switch(IndividualNumber) {
			switch(intarr[2]) {
			case 3:
				System.out.println("inside case 3");
				break;
			case 4:
				System.out.println("inside case 4");
				break;
			case 5:
				System.out.println("inside case 5");
				break;
			case 6:
				System.out.println("inside case 6");
				break;	
			default:
				System.out.println("inside default block");
				break;
			}
		//}
	}
}