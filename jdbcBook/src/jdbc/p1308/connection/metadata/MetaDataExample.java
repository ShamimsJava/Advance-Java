package jdbc.p1308.connection.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;

public class MetaDataExample {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from employees");
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            System.out.println("Number of column : " + columns);
            System.out.println("------------Column Name------------------");
            for (int i = 1; i <= columns; i++) {
                    System.out.println(md.getColumnName(i));
            }
            System.out.println("------------Column Level------------------");
            for (int i = 1; i <= columns; i++) {
                System.out.println(md.getColumnLabel(i));
            }
            
            int row = 0;
            while(rs.next()){
                System.out.println("Row : "+(++row));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
