package rest_api_23_marija_janeckaite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Folder {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
//    @JsonProperty("lists")
//    private Array lists;
}
