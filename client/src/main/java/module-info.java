module client {
    requires javafx.controls;
    requires javafx.fxml;
    opens ru.eskendarov.room.client to javafx.fxml, javafx.controls;
    exports ru.eskendarov.room.client;
}
