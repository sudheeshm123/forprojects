package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UsersManager {
	

/*###################################################################################################################*/
	
/*--------------------------------------------------Display Database----------------------------------------------*/	 
	 public static void display() {
			// TODO Auto-generated method stub
				String jdbcURL = "jdbc:mysql://localhost:3306/sampldb";
		        String dbUsername="root";
		        String dbPassword="password";
		        
		        
		        
		        System.out.println("Database Connected Successfully");
			 
			   
			/* System.out.println("Which operation you want to execute \n 1.Insert into table.\n 2.Update table \n 3.Delete data from table \n 4.Show the data");
		        */
		        Scanner in2=new Scanner(System.in);
		       
		        	 
		            
		            try {
		                 Connection connection = DriverManager.getConnection(jdbcURL,dbUsername,dbPassword);
	                     
		                 String sql ="SELECT * FROM users";
		                 Statement statement=connection.createStatement();
		                 ResultSet result=statement.executeQuery(sql);
		                 
		                 while(result.next()) {
		                	 int userId=result.getInt("user_id");
		                	 String username=result.getString("username");
		                	 String fullname=result.getString("fullname");
		                	 String email=result.getString("email");
		                	 String password=result.getString("password");
		                	 System.out.println(userId+" : " +username +" , "+ fullname +" , "+ email +" , "+ password );
		                	 
		                 }
		                
		            	 
		            	
		            	 
		            	  
		            	
		            	  
		            	 
		            	  connection.close();
		            	 
		            }
		            catch(SQLException ex) {
		            	ex.printStackTrace();
		            }
		         

		}
	 
/*-------------------------------------------------successfully displayed the database-----------------------------------*/	 

/*##########################################################################################################################################*/
	 
/*------------------------------------------------------------insert into the database----------------------------------------------*/
	 public static void insert() {
			// TODO Auto-generated method stub
				String jdbcURL = "jdbc:mysql://localhost:3306/sampldb";
		        String dbUsername="root";
		        String dbPassword="password";
		       
		        System.out.println("Database Connected Successfully");
				 
				   
		        
		        Scanner in3=new Scanner(System.in);
		        
		        System.out.println("Enter Username");
		        String username=in3.nextLine();
		        System.out.println("Enter fullname");
		        String fullname=in3.nextLine();
		        System.out.println("Enter email");
		        String email=in3.nextLine();
		        System.out.println("password");
		        String password=in3.nextLine();
		        
		       
			/* System.out.println("Which operation you want to execute \n 1.Insert into table.\n 2.Update table \n 3.Delete data from table \n 4.Show the data");
		        */
		 
		       
		        	 
		            
		            try {
		                 Connection connection = DriverManager.getConnection(jdbcURL,dbUsername,dbPassword);
	                     
		                if(connection!=null) {
		                	System.out.println("\nconnected to the database.....................");
		                	
		                }
		                
		                String sql="INSERT INTO users(username,fullname,email,password)"+"VALUES(?,?,?,?)";
		                
		            	PreparedStatement statement = connection.prepareStatement(sql);
		            	statement.setString(1,username);
		            	statement.setString(2,fullname);
		            	statement.setString(3,email); 
		            	statement.setString(4,password); 
		            	
		            	int rows=statement.executeUpdate();
		            	
		            	if (rows >0) {
		            		System.out.println("A new user has been inserted successfully.....!!!!!!!!");
		            	}
		            	  connection.close();
		            	 
		            }
		            catch(SQLException ex) {
		            	ex.printStackTrace();
		            }
		         

		}
/*----------------------------------------------------A new user is inserted successfully--------------------------------------------*/
	 
/*##########################################################################################################################################*/
	 
/*---------------------------------------------------------Update the DataBase---------------------------------*/	
	 public static void update() {
		// TODO Auto-generated method stub
			String jdbcURL = "jdbc:mysql://localhost:3306/sampldb";
	        String dbUsername="root";
	        String dbPassword="password";
	        
	        
	        
	        System.out.println("Database Connected Successfully");
		 
		   
		/* System.out.println("Which operation you want to execute \n 1.Insert into table.\n 2.Update table \n 3.Delete data from table \n 4.Show the data");
	        */
	        Scanner in=new Scanner(System.in);
	        
	        System.out.println("Enter New password");
	        String password=in.nextLine();
	        System.out.println("Enter fullname");
	        String fullname=in.nextLine();
	        System.out.println("Enter email");
	        String email=in.nextLine();
	        System.out.println("user name");
	        String username=in.nextLine();
	       
	        {
	        	 
	            
	            try {
	                 Connection connection = DriverManager.getConnection(jdbcURL,dbUsername,dbPassword);
	           
	                 String sql="UPDATE users SET password=?,fullname=?,email=?  WHERE username=?";
	            	 PreparedStatement statement=connection.prepareStatement(sql);
	            	 
	            	 statement.setString(1, password);
	            	 statement.setString(2, fullname);
	            	 statement.setString(3, email);
	            	 statement.setString(4, username);
	            	 
	            	 
	            	 int rows=statement.executeUpdate();
	            	  
	            	 if(rows>0) {
	            		 System.out.println("Updated succssfully");
	            	 }
	            	  
	            	 
	            	  connection.close();
	            	 
	        }
	         
	        catch(SQLException ex) {
	        	ex.printStackTrace();
	        }
			
		}

	}

/*-------------------------------------------------Updation successfully completed-------------------------------*/
	 
/*########################################################################################################################*/
	 
/*--------------------------------------------------------------------Delete item from table----------------------------------------*/
	 public static void remove() {
			// TODO Auto-generated method stub
				String jdbcURL = "jdbc:mysql://localhost:3306/sampldb";
		        String dbUsername="root";
		        String dbPassword="password";
		       
		        System.out.println("Database Connected Successfully");
				 
				   
		        
		        Scanner in4=new Scanner(System.in);
		        
		        System.out.println("Enter Username");
		        String username=in4.nextLine();
		    
		        
		       
			/* System.out.println("Which operation you want to execute \n 1.Insert into table.\n 2.Update table \n 3.Delete data from table \n 4.Show the data");
		        */
		 
		       
		        	 
		            
		            try {
		                 Connection connection = DriverManager.getConnection(jdbcURL,dbUsername,dbPassword);
	                     
		                if(connection!=null) {
		                	System.out.println("\nconnected to the database.....................");
		                	
		                }
		                
		                String sql="DELETE FROM users WHERE username=?";
		                
		            	PreparedStatement statement = connection.prepareStatement(sql);
		            	statement.setString(1,username);
		            	
		            	int rows=statement.executeUpdate();
		            	
		            	if (rows >0) {
		            		System.out.println("A user has been removed successfully.....!!!!!!!!");
		            	}
		            	  connection.close();
		            	 
		            }
		            catch(SQLException ex) {
		            	ex.printStackTrace();
		            }
		         

		}
/*-------------------------------------------------------Remove data from database-------------------------*/
	 
/*##########################################################################################################################################*/	 
	 
/*------------------------------------------------Main java code--------------------------------------------*/	
	public static void main(String[] args) {
		
		 System.out.println("Which operation you want to execute \n 1.Display Data base.\n 2.Insert into table \n 3.Update the values \n 4.Delete values");
   		 Scanner in1=new Scanner(System.in);
   		 int a = in1.nextInt(); 
         System.out.println("You entered integer "+a);
         switch (a) {
        	 case 1:
        		 display();
        		 break;
             case 2:
            	 insert();
            	 break;
             case 3:
            	 update();
            	 break;
             case 4:
            	 remove();
            	 break;
             default:
            	 System.out.println("you entered wrong keyword...........");
        	 }
  
	}
}
		

