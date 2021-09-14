package ru.eskendarov.room.client.layout;

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
 * Date: 27.08.2021
 * Project: room
 * Class: SignUp
 *
 * @author Enver Eskendarov (envereskendarov@gmail.com)
 * @version 1.0
 */
public class SignUp {

    private final GridPane root;

    public SignUp() {
        root = new GridPane();
    }

    public Parent load() {
        final ResourceBundle res = ResourceBundle.getBundle("locale/lang");
        final Label mailLable = new Label(res.getString("mail"));
        final Label password = new Label(res.getString("pass"));
        final Label nameLable = new Label(res.getString("name"));
        final TextField mailField = new TextField();
        final TextField nameField = new TextField();
        final PasswordField passField = new PasswordField();
        final Button back = new Button(res.getString("back"));
        final Button send = new Button(res.getString("send"));
        root.add(mailLable, 0, 0);
        root.add(mailField, 1, 0);
        root.add(password, 0, 1);
        root.add(passField, 1, 1);
        root.add(nameLable, 0, 2);
        root.add(nameField, 1, 2);
        root.add(back, 0, 3);
        root.add(send, 1, 3);
        root.setVgap(5);
        root.setHgap(5);
        root.setPadding(new Insets(10));
        GridPane.setMargin(root, new Insets(10));
        back.setMaxWidth(MAX_VALUE);
        send.setMaxWidth(MAX_VALUE);
        back.setOnAction(event -> {
            Room.setScene(new Login().load());
        });
        send.setOnAction(event -> {
            Room.setScene(new CheckMail().load()); // todo
        });
        return root;
    }
}
