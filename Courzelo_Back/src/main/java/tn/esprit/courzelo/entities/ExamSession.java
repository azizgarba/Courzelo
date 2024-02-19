package tn.esprit.courzelo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ExamSession")
public class ExamSession {
    @Id
    private  String id;
    @Indexed
    private String day;
    @Indexed
    private String startTime;
    @Indexed
    private String endTime;
    @DBRef
    private Class aClass;
}
