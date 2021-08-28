package ru.eskendarov.room.client.layout;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import ru.eskendarov.room.client.Room;

import java.util.ResourceBundle;

import static java.lang.Double.MAX_VALUE;

/**
 * @author Enver Eskendarov
 * @version 1.0 06/04/2021
 */
public class Login {

    private final GridPane root;

    public Login() {
        root = new GridPane();
    }

    public Parent load() {
        final ResourceBundle res = ResourceBundle.getBundle("locale/lang");
        final Label loginLabel = new Label(res.getString("login"));
        final Label passLabel = new Label(res.getString("pass"));
        final TextField loginField = new TextField();
        final PasswordField passField = new PasswordField();
        final Button login = new Button(res.getString("enter"));
        final Button guest = new Button(res.getString("guest"));
        final Button signUp = new Button(res.getString("signup"));
        root.add(loginLabel, 0, 0);
        root.add(loginField, 1, 0);
        root.add(passLabel, 0, 1);
        root.add(passField, 1, 1);
        root.add(login, 2, 0, 1, 2);
        root.add(guest, 0, 2, 2, 1);
        root.add(signUp, 2, 2);
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(10));
        GridPane.setMargin(root, new Insets(10));
        GridPane.setHalignment(signUp, HPos.RIGHT);
        GridPane.setHalignment(guest, HPos.LEFT);
        guest.setMaxWidth(MAX_VALUE);
        login.setMaxSize(MAX_VALUE, MAX_VALUE);
        login.setOnAction(event -> {
            // todo
        });
        signUp.setOnAction(event -> {
            Room.setScene(new SignUp().load()); // todo
        });
        guest.setOnAction(event -> {
            Room.setScene(new Chat().load());
        });
        return root;
    }
}
