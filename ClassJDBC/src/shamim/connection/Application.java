package shamim.connection;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Employees> list = DataRetrieveService.getEmployees();
        System.out.println("Employee Id       Employee Name");
        System.out.println("---------------------------------");
        for (Employees e : list) {

            System.out.println(e.getEmployeeID() + "              " + e.getLastName());
        }
    }
}
