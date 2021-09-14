package ru.eskendarov.room.server.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import ru.eskendarov.room.server.domain.enumerations.ContentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Date: 09.09.2021
 * Project: room
 * Class: Message
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
@Entity(name = "message")
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;
    @Column(name = "send_time")
    private LocalDateTime sendTime;
    @Column(name = "received_time")
    private LocalDateTime receivedTime;
    @Column(name = "text")
    private String text;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @Type(type = "ru.eskendarov.room.server.domain.enumerations.ContentType")
    private ContentType type;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.sender, other.sender)
                && Objects.equals(this.room, other.room)
                && Objects.equals(this.text, other.text)
                && Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, text, type);
    }
}
