package org.meetup.notifier.data.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * @author Batuhan Apaydın
 */

@Document(collection = "keyword")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Keyword {

    @Id
    private long id;

    private String token;

    private String keyword;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyword keyword1 = (Keyword) o;
        return getId() == (keyword1.getId()) &&
                Objects.equals(getToken(), keyword1.getToken()) &&
                Objects.equals(getKeyword(), keyword1.getKeyword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getToken(), getKeyword());
    }
}
