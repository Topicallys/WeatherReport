package pojo;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Rain{
    @JsonProperty("1h")
    private double _1h;

    public Rain(double _1h) {
        this._1h = _1h;
    }

    public double get_1h() {
        return _1h;
    }
}

