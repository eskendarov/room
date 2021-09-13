package ru.eskendarov.room.client;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.eskendarov.room.client.layout.Chat;

/**
 * Date: 27.08.2021
 * Project: room
 * Class: Room
 *
 * @author Enver Eskendarov (envereskendarov@gmail.com)
 * @version 1.0
 */
public class Room extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        setScene(new Chat().load());
    }

    public static void setScene(Parent root) {
        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
