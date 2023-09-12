package unit1;

import java.sql.*;

public class Def4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///stud", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM INFO");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.print("Column names are ");
            System.out.print(rsmd.getColumnLabel(1)+", ");
            System.out.print(rsmd.getColumnLabel(2)+", ");
            System.out.println(rsmd.getColumnLabel(3)+".");
            System.out.println(rsmd.getPrecision(2)); // size
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
