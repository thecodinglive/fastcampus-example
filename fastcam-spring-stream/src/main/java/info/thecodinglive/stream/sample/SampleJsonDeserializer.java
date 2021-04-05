package info.thecodinglive.stream.sample;

import info.thecodinglive.utils.jackson.FastcamJacksonConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class SampleJsonDeserializer<T> extends JsonDeserializer<T> {
    public SampleJsonDeserializer() {
        super(FastcamJacksonConverter.getInstance());
        addTrustedPackages("*");
    }
}
