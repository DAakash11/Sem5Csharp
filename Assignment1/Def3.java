package unit1;

import java.sql.*;
import java.util.*;

public class Def3 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your id to delete : ");
        int x = sc.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///student", "root", "");
            CallableStatement st = con.prepareCall("call deleteQuery(?)");
            st.setInt(1, x);
            st.executeUpdate();
            System.out.print("Record deleted : ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
