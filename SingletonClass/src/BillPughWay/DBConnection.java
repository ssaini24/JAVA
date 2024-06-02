package BillPughWay;

public class DBConnection {
    private String hostName;
    private Integer port;
    private String userName;
    private String password;

    private DBConnection(){
        System.out.println("making connection...");
    }
    static class DBConnectionHelper {
        private static final DBConnection DBObj = new DBConnection();
    }

    public static DBConnection getDBInstance(){
        return DBConnectionHelper.DBObj;
    }
}
