package info.thecodinglive.feignclient.mapService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalSearchResponse {
    private Integer id;
    @JsonProperty("address_name")
    private String addressName;
    @JsonProperty("category_group_name")
    private String categoryGroupName;
    @JsonProperty("category_group_code")
    private String categoryGroupCode;
    @JsonProperty("category_name")
    private String categoryName;
    private String distance;
    private String phone;
    @JsonProperty("place_name")
    private String placeName;
    @JsonProperty("place_url")
    private String placeUrl;
    @JsonProperty("road_address_name")
    private String roadAddressName;
    private String x;
    private String y;

    public LocalSearchResponse() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public void setCategoryGroupName(String categoryGroupName) {
        this.categoryGroupName = categoryGroupName;
    }

    public void setCategoryGroupCode(String categoryGroupCode) {
        this.categoryGroupCode = categoryGroupCode;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPlaceUrl(String placeUrl) {
        this.placeUrl = placeUrl;
    }

    public void setRoadAddressName(String roadAddressName) {
        this.roadAddressName = roadAddressName;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Integer getId() {
        return id;
    }

    public String getAddressName() {
        return addressName;
    }

    public String getCategoryGroupName() {
        return categoryGroupName;
    }

    public String getCategoryGroupCode() {
        return categoryGroupCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDistance() {
        return distance;
    }

    public String getPhone() {
        return phone;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceUrl() {
        return placeUrl;
    }

    public String getRoadAddressName() {
        return roadAddressName;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    @Override
    public String toString() {
        return "LocalSearchResponse{" +
                "id=" + id +
                ", addressName='" + addressName + '\'' +
                ", categoryGroupName='" + categoryGroupName + '\'' +
                ", categoryGroupCode='" + categoryGroupCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", distance='" + distance + '\'' +
                ", phone='" + phone + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeUrl='" + placeUrl + '\'' +
                ", roadAddressName='" + roadAddressName + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}
