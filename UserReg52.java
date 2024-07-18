

import java.util.*;


import java.sql.*;

public class UserReg52 
{
    public static void main(String[] args) 
    {
        try (Scanner s = new Scanner(System.in)) 
        {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "Qazmlp01");

            PreparedStatement Ps1 = con.prepareStatement("insert into UserReg52 values (?,?,?,?,?,?,?)");
            PreparedStatement Ps2 = con.prepareStatement("select * from UserReg52 where Uname=? and Pword=?");

            while (true) {
                System.out.println("...Choose...");
                System.out.println("\t1.Register\n\t2.Login\n\t3.Exit");

                System.out.println("Enter the Choice");
                int choice = Integer.parseInt(s.nextLine());

                switch (choice) {

                    case 1: // Register
                        System.out.println("Enter your User Id");
                        String Ui = s.nextLine();

                        System.out.println("Enter your Password");
                        String Pw = s.nextLine();

                        System.out.println("Enter your First Name");
                        String Fn = s.nextLine();
                        
                        System.out.println("Enter your Last Name ");
                        String Ln = s.nextLine();

                        System.out.println("Enter your Addr");
                        String Ad = s.nextLine();

                        System.out.println("Enter your Email");
                        String Ea = s.nextLine();

                        System.out.println("Enter your Phno");
                        int Pn = Integer.parseInt(s.nextLine());

                        
                        
                        

                        Ps1.setString(1, Ui);
                        Ps1.setString(2, Pw);
                        Ps1.setString(3, Fn);
                        Ps1.setString(4, Ln);
                        Ps1.setString(5, Ad);
                        Ps1.setString(6, Ea);
                        Ps1.setInt(7, Pn);
                        

                        int K = Ps1.executeUpdate(); // Execution
                        if (K > 0) {
                            System.out.println("Registration Successful");
                        }
                        break;

                    case 2:
                        System.out.println("Login");
                        System.out.println("Enter your Username");
                        String Uname = s.nextLine();

                        System.out.println("Enter your Password");
                        String Pword = s.nextLine();

                        Ps2.setString(1, Uname);
                        Ps2.setString(2, Pword);

                        ResultSet rs = Ps2.executeQuery();
                        
                  //     while (true) {
                    //        System.out.println("...Choose...");
                      //      System.out.println("\t1.View Profile\n\t2.Edit\n\t3.Exit");

                        //    System.out.println("Enter the no");
                          //  int no = Integer.parseInt(s.nextLine());

                      //switch(no)
                      //{
                      //case 1: 
                        //  System.out.println("View Profile");
                          //String Vp = s.nextLine();

                          //ResultSet rs = Ps2.executeQuery();
                          
                        
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
                        
                        if (rs.next()) 
                        {
                            System.out.println(rs.getString(1) + "\t" + rs.getString(2)+"\t"+rs.getString(3) + "\t" + rs.getString(4)+"\t"+rs.getString(5) + "\t" + rs.getString(6)+ "\t" + rs.getString(7));
                        } 
                            else 
                        {
                            System.out.println("Incorrect Username or Password");
                        }
                      
                      //}
                        
                        break;
                        
                        //}  
                        
                    case 3:
                        System.exit(0);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}









