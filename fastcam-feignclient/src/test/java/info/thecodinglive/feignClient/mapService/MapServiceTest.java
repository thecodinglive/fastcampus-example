package info.thecodinglive.feignClient.mapService;

import info.thecodinglive.feignclient.mapService.LocalSearchResponse;
import info.thecodinglive.feignclient.mapService.LocalSearchResponseWrapper;
import info.thecodinglive.feignclient.mapService.LocalSearchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MapServiceTest {
    @Autowired
    LocalSearchService localSearchService;
    Integer locationId = 26358363;

    @Test
    public void localSearch() {

        //given
        //12455726
        LocalSearchResponse searchRespose = new LocalSearchResponse();

        LocalSearchResponseWrapper localSearchResponseWrapper = localSearchService
                .findLocationRetrunMap("율동공원").getBody();

        System.out.println( localSearchResponseWrapper.getLocalSearchResponse());
//
//        //when
        List<LocalSearchResponse> localSearchResultList = localSearchResponseWrapper.getLocalSearchResponse().stream()
                .filter( p -> p.getId().equals(locationId))
                .collect(Collectors.toList());
//
        Assertions.assertEquals(1, localSearchResultList.size(), "사이즈는 1이어야 합니다.");

        localSearchResultList.forEach( p -> {
            searchRespose.setPlaceUrl(p.getPlaceUrl());
            searchRespose.setPhone(p.getPhone());
        });

        String searchLocationResult = String.format("전화번호: %s, 지도url: %s", searchRespose.getPhone(),
                searchRespose.getPlaceUrl());

        System.out.println(searchLocationResult);

    }
}
