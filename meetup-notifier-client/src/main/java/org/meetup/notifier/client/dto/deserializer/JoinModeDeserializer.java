package org.meetup.notifier.client.dto.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.meetup.notifier.client.dto.JoinMode;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author Batuhan Apaydın
 */
public class JoinModeDeserializer extends StdDeserializer<JoinMode> {
    private static final JoinMode DEFAULT_JOIN_MODE = JoinMode.OPEN;

    public JoinModeDeserializer() {
        this(null);
    }


    public JoinModeDeserializer(Class<?> vc) {
        super(vc);
    }

    public JoinMode deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String joinMode = jsonParser.getText();
        if (StringUtils.hasText(joinMode)) {
            return JoinMode.valueOf(joinMode.toUpperCase());
        }
        return DEFAULT_JOIN_MODE;
    }
}
