<%-- 
    Document   : DeleteRecords
    Created on : 31 Aug, 2023, 8:31:12 AM
    Author     : au
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///stud", "root", "");
                Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM INFO WHERE ID="+request.getParameter("id")+"");
                response.sendRedirect("DisplayRecords.jsp");
            } catch (Exception e) {
                out.print(e);
            }
        %>
    </body>
</html>
