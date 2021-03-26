package info.thecodinglive.feignclient.mapService;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LocalSearchResponseWrapper {
    public LocalSearchResponseWrapper() {
    }

    public LocalSearchResponseWrapper(List<LocalSearchResponse> localSearchResponse, LocalSearchMeta localSearchMeta) {
        this.localSearchResponse = localSearchResponse;
        this.localSearchMeta = localSearchMeta;
    }

    @JsonProperty("documents")
    private List<LocalSearchResponse> localSearchResponse;
    @JsonProperty("meta")
    private LocalSearchMeta localSearchMeta;

    public List<LocalSearchResponse> getLocalSearchResponse() {
        return localSearchResponse;
    }

    public void setLocalSearchResponse(List<LocalSearchResponse> localSearchResponse) {
        this.localSearchResponse = localSearchResponse;
    }

    public LocalSearchMeta getLocalSearchMeta() {
        return localSearchMeta;
    }

    public void setLocalSearchMeta(LocalSearchMeta localSearchMeta) {
        this.localSearchMeta = localSearchMeta;
    }

    private static class LocalSearchMeta {}

}
