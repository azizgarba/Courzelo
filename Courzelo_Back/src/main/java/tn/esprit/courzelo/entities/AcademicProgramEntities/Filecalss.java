package tn.esprit.courzelo.entities.AcademicProgramEntities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(collection = "Filecalss")
public class Filecalss {
    @Id
    private String id;
    @Indexed
    private String fileName;
    @Indexed
    private String fileType;

    @Field(targetType = FieldType.BINARY)
    private byte[] data;
    @DBRef
    private Course course;

    public Filecalss(String fileName, String fileType, byte[] data) {

        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

}
