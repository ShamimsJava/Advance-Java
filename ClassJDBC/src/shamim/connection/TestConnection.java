package shamim.connection;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection conn = DbConnection.getConnection("xe", "hr", "hr");
    }
}
