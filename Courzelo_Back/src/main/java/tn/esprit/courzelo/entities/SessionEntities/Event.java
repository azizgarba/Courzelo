package tn.esprit.courzelo.entities.SessionEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Events")
public class Event {
    @Id
    private String id;

    @Indexed
    private String name;
    @Indexed
    private String location;
    @Indexed
    private Date date;
    @Indexed
    private String description ;
    @Indexed
    private double price;

    @Indexed
    private String category;

    private float estimation;

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", estimation=" + estimation +
                '}';
    }
}
