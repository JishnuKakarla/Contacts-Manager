package com.techlab.contact.test;

import java.sql.SQLException;
import java.util.Scanner;
import com.techlab.contact.Contact;

public class Contacttest 
{
	public static void main(String[] args) throws SQLException 
	{
		Scanner sc = new Scanner(System.in);
		Contact c = new Contact();
		while (true) 
		{
			System.out.println("\n1.display\n2.add\n3.delete\n4.Exit\n");
			System.out.println("enter choice\n");
			int ch = sc.nextInt();
			switch (ch) 
			{
				case 1:
					c.display();
					break;
					
				case 2:
					c.add();
					break;
				case 3:
					c.delete();
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println("enter valid input");
			}
			sc.close();
		}
	}
}
