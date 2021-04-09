package info.thecodinglive.feignClient.mapService;


import info.thecodinglive.feignclient.mapService.KakaoLocalSearchClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class KakoLocalSearchTest {
    @Autowired
    KakaoLocalSearchClient kakaoLocalSearchClient;


    @Test
    public void findLocation() {
        //given
        String query = "율동공원";
        String authHeaderValue = "KakaoAK 464b4c25cadd87ca45f1ea99a7822608";
        //when
        ResponseEntity<String> response = kakaoLocalSearchClient.findLocationWithHeader(authHeaderValue, query);
        //then
        System.out.println(response);
        /**
         * <200 OK OK,{"documents":[{"address_name":"경기 성남시 분당구 율동 399","category_group_code":"","category_group_name":"",
         * "category_name":"여행 \u003e 공원 \u003e 도시근린공원","distance":"","id":"12455726","phone":"031-702-8714(팩스)",
         * "place_name":"율동공원","place_url":"http://place.map.kakao.com/12455726","road_address_name":"","x":"127.152112503385",
         * "y":"37.3784081470585"},{"address_name":"경기 성남시 분당구 율동 311","category_group_code":"PK6","category_group_name":"주차장",
         * "category_name":"교통,수송 \u003e 교통시설 \u003e 주차장 \u003e 공영주차장","distance":"","id":"26358363","phone":"031-707-1743",
         * "place_name":"율동공원 A주차장","place_url":"http://place.map.kakao.com/26358363","road_address_name":"경기 성남시 분당구 문정로 145",
         * "x":"127.15000422803055","y":"37.38335565691922"},{"address_name":"경기 성남시 분당구 분당동 112","category_group_code":"PK6",
         * "category_group_name":"주차장","category_name":"교통,수송 \u003e 교통시설 \u003e 주차장","distance":"","id":"1466698767",
         * "phone":"","place_name":"율동공원 B주차장","place_url":"http://place.map.kakao.com/1466698767",
         * "road_address_name":"경기 성남시 분당구 서현로 459","x":"127.147451424796","y":"37.3736458297354"},
         * {"address_name":"경기 광주시 오포읍 신현리 712-36","category_group_code":"","category_group_name":"",
         * "category_name":"부동산 \u003e 주거시설 \u003e 빌라,연립주택","distance":"","id":"25086295","phone":"",
         * "place_name":"율동공원라폴리움","place_url":"http://place.map.kakao.com/25086295",
         * "road_address_name":"경기 광주시 오포읍 신현로 39-47","x":"127.15133329943473","y":"37.361473477689486"},{
         * "address_name":"경기 성남시 분당구 율동 452","category_group_code":"","category_group_name":"",
         * "category_name":"여행 \u003e 공원시설물","distance":"","id":"17560383","phone":"031-704-6266","place_name":"율동자연공원 번지점프장",
         * "place_url":"http://place.map.kakao.com/17560383","road_address_name":"","x":"127.148574220016","y":"37.3773710612919"},
         * {"address_name":"경기 성남시 분당구 분당동 112","category_group_code":"","category_group_name":"",
         * "category_name":"교통,수송 \u003e 자동차 \u003e 전기자동차 충전소 \u003e 환경부전기차 충전소","distance":"","id":"607918754","phone":"","place_name":"율동자연공원 B주차장 전기차충전소",
         * "place_url":"http://place.map.kakao.com/607918754","road_address_name":"","x":"127.147216080122","y":"37.3733830237074"},{"address_name":"경기 성남시 분당구 율동 415",
         * "category_group_code":"AT4","category_group_name":"관광명소","category_name":"여행 \u003e 관광,명소 \u003e 저수지","distance":"","id":"17807902","phone":"","place_name":"율동자연공원 분당저수지","place_url":"http://place.map.kakao.com/17807902","road_address_name":"","x":"127.150095452067","y":"37.3770051267286"},{"address_name":"경기 성남시 분당구 율동 399","category_group_code":"","category_group_name":"","category_name":"가정,생활 \u003e 반려동물 \u003e 반려견놀이터","distance":"","id":"27601527","phone":"031-729-4382","place_name":"율동공원 반려견놀이터","place_url":"http://place.map.kakao.com/27601527","road_address_name":"","x":"127.152067326273","y":"37.3784009969651"},{"address_name":"경기 성남시 분당구 율동 367-3","category_group_code":"","category_group_name":"","category_name":"여행 \u003e 공원시설물","distance":"","id":"17385289","phone":"","place_name":"율동자연공원 만남의광장","place_url":"http://place.map.kakao.com/17385289","road_address_name":"","x":"127.1519436268","y":"37.3797671079781"},{"address_name":"경기 성남시 분당구 율동 311","category_group_code":"","category_group_name":"","category_name":"가정,생활 \u003e 유아 \u003e 놀이시설 \u003e 놀이터","distance":"","id":"1800186462","phone":"","place_name":"율동공원 놀이터","place_url":"http://place.map.kakao.com/1800186462","road_address_name":"","x":"127.149798638766","y":"37.3821773791359"},{"address_name":"경기 성남시 분당구 율동 426-2","category_group_code":"","category_group_name":"","category_name":"가정,생활 \u003e 유아 \u003e 놀이시설 \u003e 놀이터","distance":"","id":"17557720","phone":"","place_name":"율동자연공원 어린이놀이터","place_url":"http://place.map.kakao.com/17557720","road_address_name":"","x":"127.147675956618","y":"37.3776064525817"},{"address_name":"경기 성남시 분당구 율동 318","category_group_code":"","category_group_name":"","category_name":"서비스,산업 \u003e 관리,운영 \u003e 공원관리운영","distance":"","id":"17563469","phone":"031-702-8713","place_name":"율동자연공원 관리사무소","place_url":"http://place.map.kakao.com/17563469","road_address_name":"경기 성남시 분당구 문정로 145","x":"127.150675838674","y":"37.3826772337009"},{"address_name":"경기 성남시 분당구 율동 300-2","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 한식 \u003e 육류,고기 \u003e 족발,보쌈","distance":"","id":"1528180883","phone":"031-717-4432","place_name":"한소반 율동공원점","place_url":"http://place.map.kakao.com/1528180883","road_address_name":"경기 성남시 분당구 새마을로175번길 6","x":"127.149779672805","y":"37.3839956679267"},{"address_name":"경기 성남시 분당구 율동 453-1","category_group_code":"","category_group_name":"","category_name":"여행 \u003e 공원시설물","distance":"","id":"17556477","phone":"","place_name":"율동자연공원 분수대","place_url":"http://place.map.kakao.com/17556477","road_address_name":"","x":"127.149348161236","y":"37.3759356560259"},{"address_name":"경기 성남시 분당구 율동 112-3","category_group_code":"CS2","category_group_name":"편의점","category_name":"가정,생활 \u003e 편의점 \u003e GS25","distance":"","id":"12314921","phone":"031-781-3515","place_name":"GS25 율동공원점","place_url":"http://place.map.kakao.com/12314921","road_address_name":"경기 성남시 분당구 문정로 156","x":"127.150822388201","y":"37.383686192821"}],"meta":{"is_end":false,"pageable_count":43,"same_name":{"keyword":"율동공원","region":[],"selected_region":""},"total_count":43}},
         * [access-control-allow-headers:"Authorization, KA, Origin, X-Requested-With, Content-Type, Accept", access-control-allow-methods:"GET, OPTIONS", access-control-allow-origin:"*", connection:"keep-alive", content-type:"application/json; charset=utf-8", date:"Fri, 26 Mar 2021 12:04:47 GMT", server:"nginx", transfer-encoding:"chunked", vary:"Accept-Encoding", x-request-id:"75b22840-8e2b-11eb-9b12-2f9d4c585aef"]>
         **/
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}
