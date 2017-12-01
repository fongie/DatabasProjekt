package integration;


public class DatabaseManager {

    private void Connect () {
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
