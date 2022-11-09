module com.portfolie3.portfolie3v2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.portfolie3.portfolie3v2 to javafx.fxml;
    exports com.portfolie3.portfolie3v2;
}