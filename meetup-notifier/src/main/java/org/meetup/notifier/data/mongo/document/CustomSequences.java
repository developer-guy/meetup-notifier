package org.meetup.notifier.data.mongo.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author Batuhan Apaydın
 */
@Document(collection = "customSequences")
@Data
public class CustomSequences {
    @Id
    private String id;
    private int seq;

// getters and setters
}