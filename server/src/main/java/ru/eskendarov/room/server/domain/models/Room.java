package ru.eskendarov.room.server.domain.models;

import lombok.Data;

/**
 * Date: 09.09.2021
 * Project: room
 * Class: Room
 *
 * @author Enver Eskendarov (envereskendarov@gmail.com)
 * @version 1.0
 */
@Data
public class Room {

    private int id;
    private String name;
    private User creatorId;
}
