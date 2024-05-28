module kz.ori.javafxproj {
    requires javafx.controls;
    requires javafx.fxml;


    opens kz.ori.javafxproj to javafx.fxml;
    exports kz.ori.javafxproj;
}