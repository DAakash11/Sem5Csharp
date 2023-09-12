package unit1;

import java.sql.*;
import java.util.*;

public class Def1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        Def1 obj = new Def1();
        obj.selectQuery();
        do{
            System.out.println("0. Exit.");
            System.out.println("1. Update.");
            System.out.println("2. Delete.");
            System.out.println("3. Select.");
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();
            switch(ch)
            {
                case 0:
                System.out.print("Thanks you visit again.");
                break;
                case 1:
                obj.updateQuery();
                obj.selectQuery();
                break;
                case 2:
                obj.deleteQuery();
                obj.selectQuery();
                break;
                case 3:
                obj.selectQuery();
                break;
                default:
                System.out.print("Error. Invalid choice.");
            }
        }while(ch!=0);
    }
    Scanner take = new Scanner(System.in);
    public void updateQuery() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///student", "root", "");
            PreparedStatement st = con.prepareStatement("UPDATE INFO SET NAME=?, CITY=? WHERE ID=?");
            System.out.print("Enter your id : ");
            int x = take.nextInt();
            System.out.print("Enter updated name : ");
            String nm = take.next();
            System.out.print("Enter updated city : ");
            String ct = take.next();
            st.setString(1, nm);
            st.setString(2, ct);
            st.setInt(3, x);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteQuery() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///student", "root", "");
            PreparedStatement st = con.prepareStatement("DELETE FROM INFO WHERE ID=?");
            System.out.print("Enter id to delete : ");
            int x = take.nextInt();
            st.setInt(1, x);
            st.executeUpdate();
            System.out.println("Record Deleted...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void selectQuery() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///student", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM INFO");
            while (rs.next()){
                System.out.print(rs.getInt(1)+" ");
                System.out.print(rs.getString(2)+" ");
                System.out.println(rs.getString(3)+" ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}