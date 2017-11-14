package jdbc.p1306.connection.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MakingAStatement {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from employees");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"   "+rs.getString(2));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
