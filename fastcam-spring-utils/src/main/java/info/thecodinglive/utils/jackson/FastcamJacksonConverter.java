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

    private FastcamJacksonConverter() {}

    public static ObjectMapper getInstance() {
        return mapper;
    }

    public static String toJson(Object value) {
        String jsonString = "";

        try {
            if (value != null) {
                jsonString = mapper.writeValueAsString(value);
            }
        } catch (Exception e) {
            throw new RuntimeException("convert error");
        }

        return jsonString;
    }

    @SuppressWarnings("unchecked")
    public static <T> T toObject(String content, Class<T> valueType) {
        Object value = null;

        try {
            if (content != null) {
                value = mapper.readValue(content, valueType);
            }
        } catch (Exception e) {
            throw new RuntimeException("convert error");
        }

        return (T) value;
    }

    public static <T> T toObject(String content, TypeReference<T> type) {
        T value = null;

        try {
            if (content != null) {
                value = mapper.readValue(content, type);

            }

        } catch (Exception e) {
            throw new RuntimeException("convert error");
        }

        return value;
    }

    public static <T> T convert(Object obj, Class<T> type) {
        T value = null;

        try {
            value = mapper.convertValue(obj, type);
        } catch (Exception e) {
           throw new RuntimeException("convert error");
        }
        return value;
    }
}
