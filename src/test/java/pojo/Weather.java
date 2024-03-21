package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather{
    private String description;


    public Weather(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

}