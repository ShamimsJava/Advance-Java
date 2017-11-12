package jdbc.connection.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Query {
     public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shamim", "shamim");
            String query = "select * from students";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            System.out.println("Id      Name        District");
            System.out.println("------------------------------");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"     "+rs.getString(3));
            }
            System.out.println("------------------------------");
        } catch (Exception e) {
            System.err.println("Data is not displayed....");
        }
    }
}
