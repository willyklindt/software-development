import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class Model {
    Controller controller = new Controller();


}

class Controller {
    Connection conn = null;

    Controller() {
        if (conn == null) open();
    }

    public void open() {


        try {
            String url = "jdbc:sqlite:logistics.sqlite";
            conn = DriverManager.getConnection(url);
            System.out.println("Got it!");
        } catch (
                SQLException e) { //eventuelt brug throw exception
            System.out.println("Failed to open connection");
            if (conn != null) close();
        }

    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        conn = null;
    }

    public void Command (String sql) {
        if(conn == null) open();
        if(conn == null){
            System.out.println("No connection");
            return;
        }
        Statement statement = null;

        try {
            statement = conn.createStatement();
            String query = sql;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("Got name "+name);
            }
            if (statement != null) { statement.close(); }
            statement.executeUpdate(sql); }
                catch (SQLException e){
                    System.out.println("Error in statement " + sql);
                }
            }
        }








