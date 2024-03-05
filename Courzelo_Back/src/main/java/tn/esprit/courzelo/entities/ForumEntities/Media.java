package tn.esprit.courzelo.entities.ForumEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "media")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    @Id
    private String id;
    @Indexed
    private Integer chatId;
    @Indexed
    private String userId;
    @Indexed
    private String title;
    @Indexed
    private Binary picture;
    @Indexed
    private String fileType ;
    @Indexed
    private MediaType mediaType;
}