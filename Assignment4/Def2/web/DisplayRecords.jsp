<%-- 
    Document   : DisplayRecords
    Created on : 31 Aug, 2023, 8:05:34 AM
    Author     : au
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Records</title>
    </head>
    <body>
        <% 
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///stud", "root", "");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM INFO");
        %>            
        <table border=1 align="center" style="margin-top: 100px; font-size: 30px;">
            <tr align="center">
                <td> ID </td>
                <td> Name </td>
                <td> City </td>
                <td> Action </td>
            </tr>
                    
        <%            
                while(rs.next()) {
        %>
            <tr align="center" style="position: relative;">
                <td> <%= rs.getString(1) %> </td>
                <td> <%= rs.getString(2) %> </td>
                <td> <%= rs.getString(3) %> </td>
                <td style="position: relative;"> <a href="DeleteRecords.jsp?id=<%= rs.getString(1) %>"> <button type="submit" style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">Delete</button></a> </td>
            </tr>
        <%
                }
        %>
        </table>
        <%
            } catch (Exception e) {
                out.print(e);
            }
        %>
    </body>
</html>
