package com.anudip.Gym_Tracker;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.*;

import Entities.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllOprations {
	public static void main(String[] args) {
		try {
			
		System.out.println("Welcome to our Gym Tracker Enter any Number to continue");
		
		
		Scanner first = new Scanner(System.in);
		int exit = first.nextInt() ;
		
		while(exit!=0) {
			System.out.println(" Enter 1 to add a new Person \n"
					         + " Enter 2 to Update Person Detail \n"
					         + " Enter 3 to Delete  Person Detail \n"
					         + " Enter 4 to Get All Person Detail \n"
					         + " Enter 5 to Update Membership \n"
					         + " Enter 6 to Get All Membership Detail \n"
					         + " Enter 7 to Update Fees Detail \n"
					         + " Enter 8 to Get All Fees Detail \n"
					         + " Enter 9 to Add Equipment Detail \n"
					         + " Enter 10 to Update Equipment Detail \n"
					         + " Enter 11 to Delete Equipment Detail \n"
					         + " Enter 12 to Get all Equipment Detail \n"
					         + " Enter 13 to Add Medicine Detail \n"
					         + " Enter 14 to Update Medicine Detail\n"
					         + " Enter 15 to Delete Medicine Detail\n"
					         + " Enter 16 to Get All Medicine Detail\n");
			int x = first.nextInt() ;
			
			switch(x) {
			case 1:
			try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter PersonId : ");
			String PersonId = sc.nextLine();
			System.out.println("Enter Personname : ");
			String PersonName = sc.nextLine();
			System.out.println("Enter Gender ");
			String Gender = sc.nextLine();
			System.out.println("Enter Email ");
			String Email= sc.nextLine();
			System.out.println("Enter Phone no. ");
			String Phone = sc.nextLine();
			System.out.println("Enter Address ");
			String Address = sc.nextLine();
			System.out.println("Is he wants  Membership ? (Yes/No) ");
			String Membership_Status = sc.nextLine();
			System.out.println("Enter Membership Duration ");
			String Membership_Duration = sc.nextLine();
			System.out.println("Enter paid Fees ");
			String Total_Fees = sc.nextLine();
			System.out.println("Enter Remaining Fees ");
			String Remaining_Fees = sc.nextLine();		
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
	        Person_Detail Person1= new Person_Detail(PersonId,PersonName,Gender,Email,Phone,Address); 
			session.save(Person1);
			
			 
			
			
			//Membership Portion
			
			Membership membership1 = new Membership(PersonId, Person1, Membership_Status, Membership_Duration);
			
			List<Membership> memberships = new ArrayList<Membership>(); 
			memberships.add(membership1);
			Person1.setMembership(memberships);
			
			session.save(membership1);
			System.out.println(membership1); 
			
			//Fees Detail portion
	         Fees_Detail Fees1 = new Fees_Detail(PersonId,
			  Person1,Total_Fees,
			  Remaining_Fees);
			
			List<Fees_Detail> fees = new ArrayList<Fees_Detail>(); 
			fees.add(Fees1);
			Person1.setfees(fees);
			
			session.save(Fees1);
			System.out.println(fees); 
			
			transaction.commit();
			System.out.println("you Person Detail is saved  ======================================================================>\n   ");
			
			break;
			
		
			
			}
		catch(Exception e) {
			
			System.out.println(" Id is already taken ======================================================================>\n  ");
			break;
		}
			case 9 :
				try {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter EquipmentId : ");
					String EquipmentId = sc.nextLine();
					Scanner pc = new Scanner(System.in);
					System.out.println("Enter your Equipmentname : ");
					String Equipmentname = pc.nextLine();
					System.out.println("Enter your EquipmentType : ");
					String Equipmenttype = pc.nextLine();
					
					System.out.println("Enter your EquipmentUse : ");
					String EquipmentUse = pc.nextLine();
					
					
					
					SessionFactory factory = HibernateUtil.getSessionFactory(); 
					Session session = factory.openSession();
					Transaction transaction = session.beginTransaction();
					
			 Equipment Equip1= new Equipment(EquipmentId,Equipmenttype,Equipmentname,EquipmentUse);
			 
					session.save(Equip1); 
					transaction.commit();
					//Equipment Equipments = session.get(Equipment.class, EquipmentId);
					//System.out.println(Equipments); 
					System.out.println("your Equipment Detail is Added sucessfully  ======================================================================>\n  ");
					
					break;
					}
				   catch(Exception e) {
				 	
					System.out.println("Id is already taken  ======================================================================>\n  ");
					break;
				}
			
			
		case 13:
			
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter MedicineId : ");
				String MedicineId = sc.nextLine();
				Scanner pc = new Scanner(System.in);
				System.out.println("Enter your Medicine name : ");
				String MedicineName = pc.nextLine();

				System.out.println("Enter your Medicine Use : ");
				String MedicineUse = pc.nextLine();

				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Medicinedetail Med1 = new Medicinedetail(MedicineId, MedicineName, MedicineUse); 
				session.save(Med1);

				transaction.commit();
				//Medicinedetail Medicines = session.load(Medicinedetail.class, MedicineId);

				//System.out.println(Medicines); 
				System.out.println("your Medicine Detail is Added sucessfully  ======================================================================>\n  ");

				break;
			} catch (Exception e) {

				System.out.println("Id is already taken ======================================================================>\\n  ");
				break;
			}
		case 2:
			
			        // JDBC URL, username, and password of MySQL server
			        String jdbcUrl = "jdbc:mysql://localhost:3306/gym_tracker";
			        String username = "root";
			        String password = "dee123";

			        // JDBC variables for opening, closing, and managing connection
			        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
			            // Take user input for update values
			        	 Scanner scanner = new Scanner(System.in);
			        	System.out.println("Enter PersonId : ");
						String PersonId = scanner.nextLine();
			           
			            System.out.println("Enter new  name : ");
						String PersonName = scanner.nextLine();
						System.out.println("Enter Gender ");
						String Gender = scanner.nextLine();
						System.out.println("Enter new Email ");
						String Email= scanner.nextLine();
						System.out.println("Enter new Phone no. ");
						String Phone = scanner.nextLine();
						System.out.println("Enter new Address ");
						String Address = scanner.nextLine();
						
			            // Add more input prompts for other columns as needed

			            // SQL update statement with placeholders
			            String updateQuery = "UPDATE person_detail SET PersonName=?, Gender=? , Email=?, Phone=? ,Address=? WHERE PersonId=?";

			            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			                // Set values for the placeholders
			                preparedStatement.setString(1, PersonName);
			                preparedStatement.setString(2, Gender);
			                preparedStatement.setString(3, Email);
			                preparedStatement.setString(4, Phone);
			                preparedStatement.setString(5, Address);
			                // Set the condition value for the WHERE clause
			                preparedStatement.setString(6, PersonId);

			                // Execute the update statement
			                int rowsAffected = preparedStatement.executeUpdate();

			                System.out.println("Updated Sucessfully  ======================================================================> \n ");
			                break;
			            }
			        } catch (Exception e) {
			            System.out.println("Invalid Id ======================================================================>\\n  ");
			            break;
			        }
			    
			

		case 3:
			

		        // JDBC variables for opening, closing, and managing connection
		        try (Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/gym_tracker", "root","dee123")) {
		            // Take user input for the condition value
		            Scanner val = new Scanner(System.in);
		            System.out.print("Enter Person Id ");
		            
		            String conditionValue = val.nextLine();

		            // SQL delete statement with a placeholder for the condition
		            String membership = "DELETE FROM membership WHERE PersonId = ?";
		            String feesdetail = "DELETE FROM fees_detail WHERE PersonId = ?";
		            String Persondetail = "DELETE FROM Person_detail WHERE PersonId = ?";
		            

		            try (PreparedStatement preparedStatement = connection.prepareStatement(membership);
		            		PreparedStatement Statement = connection.prepareStatement(feesdetail);
		            		PreparedStatement PStatement = connection.prepareStatement(Persondetail);
		            		)
		            		
		            		
		            		 {
		                // Set the value for the condition placeholder
		                preparedStatement.setString(1, conditionValue);
		                Statement.setString(1, conditionValue);
		                PStatement.setString(1, conditionValue);
		                

		                // Execute the delete statement
		                 preparedStatement.executeUpdate();
		                 Statement.executeUpdate();
		                  PStatement.executeUpdate();
		        

		                System.out.println("Deleted successfully  ======================================================================>\n   " );
		                break;
		            }
		        } catch (Exception e) {
		            System.out.println("Invalid Id ======================================================================>\n  ");
		            break;
		        }
		case 10:
			
	        // JDBC variables for opening, closing, and managing connection
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_tracker","root","dee123")) {
	            // Take user input for update values
	        	 Scanner scan = new Scanner(System.in);
	        	System.out.println("Enter EquipmentId : ");
				String EquipmentId = scan.nextLine();
	           
	            System.out.println("Enter new  Equipmentname : ");
				String EquipmentName = scan.nextLine();
				System.out.println("Enter  new EquipmentType ");
				String EquipmentType = scan.nextLine();
				System.out.println("Enter Equipment Use ");
				String EquipmentUse= scan.nextLine();
				

	            // SQL update statement with placeholders
	            String updateQuery = "UPDATE equipment SET EquipmentName=?, EquipmentType=? , EquipmentUse=? WHERE EquipmentId=?";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	                // Set values for the placeholders
	                preparedStatement.setString(1, EquipmentName);
	                preparedStatement.setString(2, EquipmentType);
	                preparedStatement.setString(3, EquipmentUse);
	                
	                // Set the condition value for the WHERE clause
	                preparedStatement.setString(4, EquipmentId);

	                // Execute the update statement
	                preparedStatement.executeUpdate();

	                System.out.println("Updated Sucessfully  ======================================================================>\n  ");
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Id ======================================================================>\\n  ");
	            break;
	        }
		case 11:
			  // JDBC variables for opening, closing, and managing connection
	        try (Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/gym_tracker", "root","dee123")) {
	            // Take user input for the condition value
	            Scanner val = new Scanner(System.in);
	            System.out.print("Enter Equipment Id ");
	            String conditionValue = val.nextLine();

	            // SQL delete statement with a placeholder for the condition
	            String equipment = "DELETE FROM equipment WHERE EquipmentId = ?";
	           

	            try (PreparedStatement preparedStatement = connection.prepareStatement(equipment);
	            		
	            		)
	            		
	            		
	            		 {
	                // Set the value for the condition placeholder
	                preparedStatement.setString(1, conditionValue);
	                

	                // Execute the delete statement
	                int rowsAffected = preparedStatement.executeUpdate();
	                

	                System.out.println("Deleted successfully ======================================================================>\n  ");
	                break;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		case 14:
			 // JDBC variables for opening, closing, and managing connection
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_tracker","root","dee123")) {
	            // Take user input for update values
	        	 Scanner sca = new Scanner(System.in);
	        	System.out.println("Enter MedicineId : ");
				String MedicineId = sca.nextLine();
	           
	            System.out.println("Enter new  Medicinename : ");
				String MedicineName = sca.nextLine();
				System.out.println("Enter Medicine Use ");
				String MedicineUse= sca.nextLine();
				

	            // SQL update statement with placeholders
	            String updateQuery = "UPDATE medicinedetail SET MedicineName=?, MedicineUse=? WHERE MedicineId=?";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	                // Set values for the placeholders
	                preparedStatement.setString(1, MedicineName);
	                preparedStatement.setString(2, MedicineUse);
	          
	                
	                // Set the condition value for the WHERE clause
	                preparedStatement.setString(3, MedicineId);

	                // Execute the update statement
	                preparedStatement.executeUpdate();

	                System.out.println("Updated Sucessfully  ======================================================================>\n ");
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Id ======================================================================>\\n   ");
	            break;
	        }
		case 15:
			  // JDBC variables for opening, closing, and managing connection
	        try (Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/gym_tracker", "root","dee123")) {
	            // Take user input for the condition value
	            Scanner val = new Scanner(System.in);
	            System.out.print("Enter Medicine Id ");
	            String conditionValue = val.nextLine();

	            // SQL delete statement with a placeholder for the condition
	            String equipment = "DELETE FROM medicinedetail WHERE MedicineId = ?";
	           

	            try (PreparedStatement preparedStatement = connection.prepareStatement(equipment);
	            		
	            		)
	            		
	            		
	            		 {
	                // Set the value for the condition placeholder
	                preparedStatement.setString(1, conditionValue);
	                

	                // Execute the delete statement
	                int rowsAffected = preparedStatement.executeUpdate();
	                

	                System.out.println("Deleted successfully ======================================================================>\n  " );
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("invalid id ======================================================================>\\n  ");	            break;
	        }
		
		case 5:
	       
	        // JDBC variables for opening, closing, and managing connection
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_tracker","root",  "dee123")) {
	            // Take user input for update values
	        	 Scanner scanner = new Scanner(System.in);
	        	System.out.println("Enter PersonId : ");
				String PersonId = scanner.nextLine();
	           
	            System.out.println("Enter new Membership : ");
				String membership = scanner.nextLine();
				System.out.println("Enter new Membership Duration");
				String membership_duration = scanner.nextLine();
				
	            // SQL update statement with placeholders
	            String updateQuery = "UPDATE membership SET Membership=?, Membership_Duration=? WHERE PersonId=?";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	                // Set values for the placeholders
	                preparedStatement.setString(1, membership);
	                preparedStatement.setString(2, membership_duration);
	          
	               
	                // Set the condition value for the WHERE clause
	                preparedStatement.setString(3, PersonId);

	                // Execute the update statement
	                 preparedStatement.executeUpdate();

	                System.out.println("Updated Sucessfully  ======================================================================> \n ");
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Id ======================================================================>\\n  ");
	            break;
	        }
	        case 7:
	        	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_tracker","root",  "dee123")) {
		            // Take user input for update values
		        	 Scanner scanner = new Scanner(System.in);
		        	System.out.println("Enter PersonId : ");
					String PersonId = scanner.nextLine();
		           
		            System.out.println("Enter new  Total Amount : ");
					String Fees_Total = scanner.nextLine();
					System.out.println("Enter new Remaining fees Amount ");
					String Remaining_Fees = scanner.nextLine();
					
					
		            // SQL update statement with placeholders
		            String updateQuery = "UPDATE Fees_detail SET Total_Fees=?, Remaining_Fees=? WHERE PersonId=?";

		            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
		                // Set values for the placeholders
		                preparedStatement.setString(1, Fees_Total);
		                preparedStatement.setString(2, Remaining_Fees);
		               
		                // Set the condition value for the WHERE clause
		                preparedStatement.setString(3, PersonId);

		                // Execute the update statement
		                int rowsAffected = preparedStatement.executeUpdate();

		                System.out.println("Updated Sucessfully  ======================================================================> \n ");
		                break;
		            }
		        } catch (Exception e) {
		            System.out.println("Invalid Id ======================================================================>\\n  ");
		            break;
		        }
	        case 16:
	        	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_tracker","root",  "dee123")) {
	 	            // Take user input for update values
	 	        	Statement statement = connection.createStatement();
	 	        	ResultSet resultSet = statement.executeQuery("Select * from Medicinedetail");
	 	        	while(resultSet.next()) {
	 	        		String id = resultSet.getString("MedicineId");
	 	        		String name = resultSet.getString("MedicineName");
	 	        		String Use = resultSet.getString("MedicineUse");
	 	        		System.out.println("==============================\n"+"Medicine id :     "+ id + "\nMedicine Name :   " + name +"\nMedicine Use :    "+ Use +"\n==============================\n" );
	 	        	}
	 	        	resultSet.close();
	 	        	statement.close();
	 	        	connection.close();
	 	        	break;
	 	        	
	 	        	
	 	               
	 	            }catch(Exception e){
	 	            	System.out.println(" invalid id");
	 	            	break;
	 	            	
	 	            }
	        case 4:
	        	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_tracker","root",  "dee123")) {
	 	            // Take user input for update values
	 	        	Statement statement = connection.createStatement();
	 	        	ResultSet resultSet = statement.executeQuery("Select * from person_detail");
	 	        	while(resultSet.next()) {
	 	        		String id = resultSet.getString("PersonId");
	 	        		String name = resultSet.getString("PersonName");
	 	        		String Gender = resultSet.getString("Gender");
	 	        		String Phone = resultSet.getString("Phone");
	 	        		String Email = resultSet.getString("Email");
	 	        		String Address = resultSet.getString("Address");
	 	        		
	 	        		System.out.println("========================================\n"+"Person id :     "+ id + "\nPerson Name :   " + name +"\nGender :        "+ Gender +"\nPhone no. :     "+ Phone+"\nGmail :         " + Email+"\nAddress :       "+Address +"\n========================================\n" );
	 	        	}
	 	        	resultSet.close();
	 	        	statement.close();
	 	        	connection.close();
	 	        	break;
	 	        	
	 	        	
	 	               
	 	            }catch(Exception e){
	 	            	System.out.println(" invalid id");
	 	            	break;
	 	            	
	 	            }
	        case 6:
	        	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_tracker","root",  "dee123")) {
	 	            // Take user input for update values
	 	        	Statement statement = connection.createStatement();
	 	        	ResultSet resultSet = statement.executeQuery(" Select p.PersonName,m.MembershipId,m.Membership,m.Membership_Duration from person_detail p INNER JOIN membership m on p.PersonId =m.MembershipId;");
	 	        	while(resultSet.next()) {
	 	        		
	 	        		String id = resultSet.getString("m.MembershipId");
	 	        		String name = resultSet.getString("p.PersonName");
	 	        		String membership = resultSet.getString("m.Membership");
	 	        		String Duration = resultSet.getString("m.Membership_Duration");
	 	        		
	 	        		
	 	        		System.out.println("========================================\n"+"Membership id :      "+ id +"\nPerson Name :        "+ name + "\nMembership Status :  " + membership +"\nMembership Duration :"+ Duration +"\n========================================\n" );
	 	        	}
	 	        	resultSet.close();
	 	        	statement.close();
	 	        	connection.close();
	 	        	break;
	 	        	
	 	        	
	 	               
	 	            }catch(Exception e){
	 	            	System.out.println(" invalid id");
	 	            	break;
	 	            	
	 	            }
	        case 8:
	        	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_tracker","root",  "dee123")) {
	 	            // Take user input for update values
	 	        	Statement statement = connection.createStatement();
	 	        	ResultSet resultSet = statement.executeQuery(" Select p.PersonName,f.FeesId,f.Total_Fees,f.Remaining_Fees from person_detail p INNER JOIN fees_detail f on p.PersonId =f.FeesId;");
	 	        	while(resultSet.next()) {
	 	        		
	 	        		String id = resultSet.getString("F.FeesId");
	 	        		String name = resultSet.getString("p.PersonName");
	 	        		String Fees = resultSet.getString("f.Total_Fees");
	 	        		String Remaining = resultSet.getString("f.Remaining_Fees");
	 	        		
	 	        		
	 	        		System.out.println("========================================\n"+"Fees id :          "+ id +"\nPerson Name :      "+ name + "\nTotal Fees Paid :  " + Fees +"\nRemaining Fees :   "+ Remaining +"\n========================================\n" );
	 	        	}
	 	        	resultSet.close();
	 	        	statement.close();
	 	        	connection.close();
	 	        	break;
	 	        	
	 	        	
	 	               
	 	            }catch(Exception e){
	 	            	System.out.println(" invalid id");
	 	            	break;
	 	            	
	 	            }
	        case 12:
	        	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_tracker","root",  "dee123")) {
	 	            // Take user input for update values
	 	        	Statement statement = connection.createStatement();
	 	        	ResultSet resultSet = statement.executeQuery("Select * from equipment");
	 	        	while(resultSet.next()) {
	 	        		String id = resultSet.getString("EquipmentId");
	 	        		String name = resultSet.getString("EquipmentName");
	 	        		String Type = resultSet.getString("EquipmentType");
	 	        		String Use = resultSet.getString("EquipmentUse");
	 	        		
	 	        		System.out.println("===================================================\n"+"Equipment id :     "+ id + "\nEquipment Name :   " + name +"\nEquipment Type :   "+ Type + "\nEquipment Use :    " + Use +"\n===================================================\n" );
	 	        	}
	 	        	resultSet.close();
	 	        	statement.close();
	 	        	connection.close();
	 	        	break;
	 	        	
	 	        	
	 	               
	 	            }catch(Exception e){
	 	            	System.out.println(" invalid id");
	 	            	break;
	 	            	
	 	            }			
		    }
		
			
	}

	
	}catch (Exception e) {
		System.out.println("Please Enter a valid Number");
		
		}
	}
	 
		
		
	
}
