module seu.bd.edu.dress {
    requires javafx.controls;
    requires javafx.fxml;


    opens seu.bd.edu.dress to javafx.fxml;
    exports seu.bd.edu.dress;
}