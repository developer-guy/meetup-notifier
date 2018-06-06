package org.meetup.notifier.client.dto.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.meetup.notifier.client.dto.Visibility;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author Batuhan Apaydın
 */
public class VisibilityDeserializer extends StdDeserializer<Visibility> {
    private static final Visibility DEFAULT_VISIBILITY = Visibility.PUBLIC;

    public VisibilityDeserializer() {
        this(null);
    }

    public VisibilityDeserializer(Class<?> vc) {
        super(vc);
    }

    public Visibility deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String visibility = jsonParser.getText();
        if (StringUtils.hasText(visibility)) {
            return Visibility.valueOf(visibility.toUpperCase());
        }
        return DEFAULT_VISIBILITY;
    }
}
