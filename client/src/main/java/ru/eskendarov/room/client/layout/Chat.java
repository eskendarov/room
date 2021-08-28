package ru.eskendarov.room.client.layout;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import ru.eskendarov.room.client.Room;

import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Double.MAX_VALUE;
import static javafx.geometry.Pos.CENTER;

/**
 * @author Enver Eskendarov
 * @version 1.0 27.08.2021
 */
public class Chat {

    private final GridPane root; // .setGridLinesVisible(true) - отобразить сетку

    public Chat() {
        root = new GridPane();
    }

    public Parent load() {
        final ResourceBundle res = ResourceBundle.getBundle("locale/lang");
        final Button exit = new Button(res.getString("exit"));
        final Button send = new Button(res.getString("send"));
        final TextField message = new TextField();
        final TextArea chatText = new TextArea();
        final Label usersLabel = new Label(res.getString("online"));
        final Label chatLabel = new Label(res.getString("chat"));
        final ListView<String> usersList = new ListView<>(
                FXCollections.observableArrayList(
                        List.of("Oleg", "Roma", "Enver", "Musya")
                ));
        final HBox msgSend = new HBox(message, send);
        final VBox users = new VBox(usersLabel, usersList);
        final VBox chat = new VBox(chatLabel, chatText);
        final Border border = new Border(new BorderStroke(
                Paint.valueOf("#B5B5B5"),
                BorderStrokeStyle.SOLID,
                new CornerRadii(5, 5, 0, 0, false),
                new BorderWidths(1, 1, 0, 1)));
        VBox.setVgrow(chatText, Priority.ALWAYS);
        HBox.setHgrow(message, Priority.ALWAYS);
        exit.setMaxWidth(MAX_VALUE);
        usersLabel.setMaxWidth(MAX_VALUE);
        chatLabel.setMaxWidth(MAX_VALUE);
        usersLabel.setPadding(new Insets(3));
        chatLabel.setPadding(new Insets(3));
        usersLabel.setAlignment(CENTER);
        chatLabel.setAlignment(CENTER);
        usersLabel.setBorder(border);
        chatLabel.setBorder(border);
        msgSend.setSpacing(5);
        root.add(users, 0, 0);
        root.add(exit, 0, 1);
        root.add(chat, 1, 0);
        root.add(msgSend, 1, 1);
        root.setPadding(new Insets(10));
        root.setHgap(5);
        root.setVgap(5);
        GridPane.setMargin(root, new Insets(10));
        chatText.setEditable(false);
        chatText.setWrapText(true);
        usersList.setFocusTraversable(false);
        exit.setOnAction(event -> {
            Room.setScene(new Login().load());
        });
        return root;
    }
}
