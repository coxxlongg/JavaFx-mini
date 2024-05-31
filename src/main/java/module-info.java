module kz.ori.networkchat {
    requires javafx.controls;
    requires javafx.fxml;


    opens kz.ori.networkchat to javafx.fxml;
    exports kz.ori.networkchat;
}