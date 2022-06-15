module com.example.laba_ {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.laba_92.model;
    opens com.example.laba_92.table;
    opens com.example.laba_92 to javafx.fxml;
    exports com.example.laba_92;
}