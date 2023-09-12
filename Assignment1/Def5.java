package unit1;

import java.sql.*;

public class Def5 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///stud", "root", "");
            Statement st = con.createStatement();
            st.execute("CREATE TABLE INFO (ID INT(3), NAME VARCHAR(10), CITY VARCHAR(10))");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
