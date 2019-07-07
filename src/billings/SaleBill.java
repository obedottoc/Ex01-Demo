/*****
 * Package for representing billing information
 * 
 * Developed by C.ObedOtto
 * Associate Professor,Saveetha Engineering College.
 * 
 * obedotto@saveetha.ac.in
 */
package billings;

import java.util.Scanner;

/****
 * Class to represent SaleBill of LED Lamp
 * 
 * @author obedotto
 *
 */
public class SaleBill {
	private long customernumber;
	private String customername;
	private double powerrating;
	private String customertype;
	private int quantity;
	
	/***
	 * To create sale bill with initial values
	 */
	public SaleBill()
	{
		this.customernumber=1000;
		this.customername="unknown";
		this.powerrating=10;
		this.customertype="user";
		this.quantity=0;
	}
	
	/***
	 * 
	 * @param number  Customer number like 1001 etc
	 * @param name Customer name
	 * @param rating LED lamp power rating in watts
	 * @param type type of the customer user or vendor
	 * @param qty number LED lamps to be purchased
	 */
	public SaleBill(long number,String name,double rating,String type,int qty)
	{
		this.customernumber=number;
		this.customername=name;
		powerrating=rating;
		customertype=type;
		quantity=qty;
	}
	
	/***
	 * To get billing information from the user
	 */
	public void getData()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.printf("\n%40s","BILLING INFORMATION");
		System.out.print("\nEnter the customer number:");
		this.customernumber=sc.nextLong();
		System.out.print("Enter the customer name:");
		customername= sc.next();
		System.out.print("Enter the power rating in watts:");
		powerrating=sc.nextDouble();
		System.out.print("Enter the customer type (user or vendor):");
		customertype=sc.next();
		System.out.println("How many LED lamps:");
		quantity=sc.nextInt();
		
	}
	
	/*****
	 * To print the bill details
	 */
	public void printData()
	{
		System.out.printf("%-40s%40s\n", "Customer Number:"+customernumber,"CustomerName:"+customername);
		System.out.printf("%s%8.2f %-16s %40s\n", "Power rating:",powerrating,"Watts","CustomerType:"+customertype);
		System.out.printf("%-40s", "Number LED lamps:"+quantity);
	}
	
	/***
	 * To calculate the bill amount
	 */
	public void computeBillAmount()
	{
		double totalAmount=-1;
		String divider="---------------------------------------------------------------------------------";
		
		if(customertype.equals("user"))
		{
			if((quantity>=0)&& (quantity<=5))
			{
				totalAmount=quantity*250.0;
			}else if((quantity>=6)&&(quantity<=10))
			{
				totalAmount=quantity*230.0;
			}else if((quantity>=11)&&(quantity<=15))
			{
				totalAmount=quantity*215.0;
			}else
			{
				totalAmount=quantity*200.0;
			}
		}else if(customertype.equals("vendor"))
		{
			if((quantity>=0)&& (quantity<=5))
			{
				totalAmount=quantity*230.0;
			}else if((quantity>=6)&&(quantity<=10))
			{
				totalAmount=quantity*210.0;
			}else if((quantity>=11)&&(quantity<=15))
			{
				totalAmount=quantity*195.0;
			}else
			{
				totalAmount=quantity*180.0;
			}			
		}	
		System.out.print("\n"+divider+"\n");
		System.out.printf("%40s", "SALE BILL");
		System.out.print("\n"+divider+"\n");
		this.printData();
		System.out.printf("%29s%8.2f Rs", "Total Amount:",totalAmount);
		System.out.print("\n"+divider+"\n");
	}
}
