package info.thecodinglive.feignclient.mapService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "kakao", url = "http://dapi.kakao.com")
/**
 * @See https://developers.kakao.com/docs/latest/ko/local/dev-guide
 * **/
public interface KakaoLocalSearchClient {
    @GetMapping("/v2/local/search/keyword.json")
    ResponseEntity<Void> findLocationNotIncludeHeader(String query); //fail not include header

    @GetMapping("/v2/local/search/keyword.json")
    ResponseEntity<String> findLocationWithHeader(@RequestHeader("Authorization") String authHeader,
                                                  @RequestParam("query") String query);

    @GetMapping("/v2/local/search/keyword.json")
    ResponseEntity<LocalSearchResponseWrapper> findLocation(@RequestHeader("Authorization") String authHeader,
                                                  @RequestParam("query") String query);

    @GetMapping("/v2/local/search/keyword.json")
    ResponseEntity<LocalSearchResponse> findResponse(@RequestHeader("Authorization") String authHeader,
                                                            @RequestParam("query") String query);
}
