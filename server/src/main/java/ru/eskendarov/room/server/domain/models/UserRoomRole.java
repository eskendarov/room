package ru.eskendarov.room.server.domain.models;

import lombok.Data;

/**
 * Date: 09.09.2021
 * Project: room
 * Class: UserRoomRole
 *
 * @author Enver Eskendarov (envereskendarov@gmail.com)
 * @version 1.0
 */
@Data
public class UserRoomRole {

    private int id;
    private int userId;
    private int roomId;
    private int roleId;
}
