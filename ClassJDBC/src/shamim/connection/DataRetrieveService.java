package shamim.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataRetrieveService {
    static Connection conn = DbConnection.getConnection("xe", "hr", "hr");
    public static List<Employees> getEmployees(){
        List<Employees> list = new ArrayList<>();
        
        try {
            Employees employee;
            PreparedStatement stmt = conn.prepareStatement("select * from employees");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                employee = new Employees();
                employee.setEmployeeID(rs.getInt(1));
                employee.setLastName(rs.getString(2));
                
                list.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
