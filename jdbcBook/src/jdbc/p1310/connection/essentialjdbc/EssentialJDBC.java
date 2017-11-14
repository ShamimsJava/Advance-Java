package jdbc.p1310.connection.essentialjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class EssentialJDBC {
    
    Connection conn;
    Statement st;
    String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String sql = "select * from employees";

    public EssentialJDBC() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, "hr", "hr");
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getResultByColumnName(){
        try {
            ResultSet rs = st.executeQuery(sql);
            int row = 0;
            while(rs.next()){
                System.out.println("Row " + (++row) + " : Employee Id : " + rs.getInt("employee_id")
                        + " First Name : " + rs.getString("first_name"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        EssentialJDBC ej = new EssentialJDBC();
        ej.getResultByColumnName();    
    }
}
