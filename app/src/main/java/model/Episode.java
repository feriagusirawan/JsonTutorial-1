package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pcp on 13/01/2017.
 */

public class Episode {
    @SerializedName("season") private Double season;
    @SerializedName("name") private String name;
    @SerializedName("number") private Double number;

    public Double getSeason() {
        return season;
    }

    public String getName() {
        return name;
    }

    public Double getNumber() {
        return number;
    }
}
