package info.thecodinglive.utils.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class FastcamJacksonConverter {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false)
                .registerModule(new JavaTimeModule());
    }

    private FastcamJacksonConverter() {
        throw new RuntimeException("construct not support");
    }

    public static ObjectMapper getInstance() {
        return mapper;
    }

    public static String toJson(Object value) {
        try{
            return mapper.writeValueAsString(value);
        } catch (Exception e) {
            throw new RuntimeException("convert error");
        }
    }

    public static <T> T toObject(String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (Exception e) {
            throw new RuntimeException("convert error");
        }
    }

    public static <T> T toObject(String content, TypeReference<T> type) {
        try {
            return mapper.readValue(content, type);
        } catch (Exception e) {
            throw new RuntimeException("convert error");
        }
    }

    public static <T> T convert(Object obj, Class<T> type) {
        try {
            return mapper.convertValue(obj, type);
        } catch (Exception e) {
           throw new RuntimeException("convert error");
        }
    }
}
