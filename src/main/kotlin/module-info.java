module pl.gawor.vapecatalogue {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens pl.gawor.vapecatalogue to javafx.fxml;
    opens pl.gawor.vapecatalogue.controller to javafx.fxml;
    exports pl.gawor.vapecatalogue;
}