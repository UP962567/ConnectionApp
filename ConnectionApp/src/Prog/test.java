package Prog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test extends HttpServlet
{
    public void doGet(HttpServletResponse res) throws IOException, ServletException
    {
        PrintWriter out = res.getWriter();
        try
        {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","m1a2l3i4Q5i6");
            // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from contact_main");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>EmpId</th><th>EmpName</th><th>Salary</th><tr>");
            while (rs.next())
            {
                String n = rs.getString("empid");
                String nm = rs.getString("empname");
                int s = rs.getInt("sal");
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}