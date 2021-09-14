package ru.eskendarov.room.server.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Date: 09.09.2021
 * Project: room
 * Class: RoomUserRole
 *
 * @author Enver Eskendarov (envereskendarov@gmail.com)
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "room_user_role")
@Table(name = "room_user_role")
public class RoomUserRole implements Serializable {

    private static final long serialVersionUID = 1102368085498665957L;

    @Id
    @ManyToOne()
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj || this.getClass() != obj.getClass()) {
            return false;
        }
        final RoomUserRole other = (RoomUserRole) obj;
        return Objects.equals(this.room, other.room)
                && Objects.equals(this.user, other.user)
                && Objects.equals(this.role, other.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, user, role);
    }
}
