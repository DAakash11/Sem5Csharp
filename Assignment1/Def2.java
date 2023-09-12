package unit1;

import java.sql.*;
import java.util.*;

public class Def2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your ID : ");
        int id = sc.nextInt();
        System.out.print("Enter your Name : ");
        String nm = sc.next();
        System.out.print("Enter your City : ");
        String ct = sc.next();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///stud", "root", "");
            PreparedStatement st = con.prepareStatement("INSERT INTO INFO VALUES (?,?,?)");
            st.setInt(1, id);
            st.setString(2, nm);
            st.setString(3, ct);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
