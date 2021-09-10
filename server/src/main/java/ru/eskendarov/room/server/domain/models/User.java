package ru.eskendarov.room.server.domain.models;

import lombok.Data;

/**
 * Date: 09.09.2021
 * Project: room
 * Class: User
 *
 * @author Enver Eskendarov (envereskendarov@gmail.com)
 * @version 1.0
 */
@Data
public class User {

    private int id;
    private String name;
    private String email;
    private String password;
}
