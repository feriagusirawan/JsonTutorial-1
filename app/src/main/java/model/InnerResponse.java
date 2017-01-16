package model;

import com.google.gson.annotations.SerializedName;
import java.util.List;


/**
 * Created by Pcp on 13/01/2017.
 */

public class InnerResponse {
    @SerializedName("episodes") private List<Episode> episodes;
    @SerializedName("year") private Double year;


    public List<Episode> getEpisodes(){
        return episodes;
    }
    public Double getYear(){
        return  year;
    }
}
