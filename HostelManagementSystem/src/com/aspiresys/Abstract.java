package com.aspiresys;

interface HostelDetails{
int a=10;
void display();
}
class HostelerDetails implements HostelDetails{
public void display() {
 if(a>=10) {
 System.out.println("Displaying");
 }
 }
} 


public class Abstract {
	public static void main(String[] args) {
		HostelerDetails hostelerDetails=new HostelerDetails();
		hostelerDetails.display();
	}
}
