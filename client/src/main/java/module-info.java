module client {
    requires javafx.controls;
    requires javafx.fxml;
    opens ru.eskendarov.room.client to javafx.fxml;
    exports ru.eskendarov.room.client;
    exports ru.eskendarov.room.client.layout;
    opens ru.eskendarov.room.client.layout to javafx.fxml;
}