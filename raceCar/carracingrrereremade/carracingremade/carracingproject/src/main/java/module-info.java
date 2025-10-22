
module carracingproject.fxcore {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens carracingproject.fxcore to javafx.fxml;
    exports carracingproject.fxcore;
}
