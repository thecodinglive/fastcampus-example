package info.thecodinglive.feignclient.mapService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LocalSearchService {
    private static final String authKey = "KakaoAK 464b4c25cadd87ca45f1ea99a7822608";
    private KakaoLocalSearchClient kakaoLocalSearchClient;

    public LocalSearchService(KakaoLocalSearchClient kakaoLocalSearchClient) {
        this.kakaoLocalSearchClient = kakaoLocalSearchClient;
    }

    public ResponseEntity<LocalSearchResponseWrapper> findLocationRetrunMap(String keyword) {
        return kakaoLocalSearchClient.findLocation(authKey, keyword);
    }

    public ResponseEntity<LocalSearchResponse> findResponse(String keyword) {
        return kakaoLocalSearchClient.findResponse(authKey, keyword);
    }



    public ResponseEntity<String> findLocaion(String keyword) {
        return kakaoLocalSearchClient.findLocationWithHeader(authKey, keyword);
    }



}
