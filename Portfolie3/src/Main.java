import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main{
    public static void main(String[] args) {

        Model model = new Model();
        model.controller.Command("select name from habour;");
    }
}