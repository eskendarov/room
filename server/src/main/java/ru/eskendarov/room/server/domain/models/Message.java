package ru.eskendarov.room.server.domain.models;

import lombok.Data;

/**
 * Date: 09.09.2021
 * Project: room
 * Class: Message
 *
 * @author Enver Eskendarov (envereskendarov@gmail.com)
 * @version 1.0
 */
@Data
public class Message {

    private int id;
    private int senderId;
    private int roomId;
    private int sendTime;
    private int receivedTime;
    private String text;
    private Content type;
}
