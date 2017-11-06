package jdbc;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from employees");
            while(rs.next()){
                System.out.println(rs.getInt("employee_id")+"    "+rs.getString("first_name")
                +"      "+rs.getString("last_name"));
            }
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
