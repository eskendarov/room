package ru.eskendarov.room.client.layout;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import ru.eskendarov.room.client.Room;

import java.util.ResourceBundle;

/**
 * @author Enver Eskendarov
 * @version 1.0 09/04/2021
 */
public class CheckMail {

    private final GridPane root;

    public CheckMail() {
        root = new GridPane();
    }

    public Parent load() {
        final ResourceBundle res = ResourceBundle.getBundle("locale/lang");
        final Label lblMail = new Label(res.getString("code"));
        final TextField checkCode = new TextField();
        final Button exit = new Button(res.getString("exit"));
        final Button enter = new Button(res.getString("enter"));
        root.add(lblMail, 0, 0);
        root.add(checkCode, 1, 0);
        root.add(exit, 0, 1);
        root.add(enter, 1, 1);
        root.setPadding(new Insets(10));
        root.setHgap(5);
        root.setVgap(5);
        GridPane.setMargin(root, new Insets(10));
        exit.setMaxWidth(Double.MAX_VALUE);
        enter.setMaxWidth(Double.MAX_VALUE);
        exit.setOnAction(event -> {
            Room.setScene(new Login().load());
        });
        enter.setOnAction(event -> {
            //todo
        });
        return root;
    }
}
