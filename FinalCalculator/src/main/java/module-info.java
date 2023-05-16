module com.example.finalcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalcalculator to javafx.fxml;
    exports com.example.finalcalculator;
}