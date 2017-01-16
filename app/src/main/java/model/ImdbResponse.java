package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pcp on 13/01/2017.
 */

public class ImdbResponse {
    @SerializedName("How I Met Your Mother") private InnerResponse response;

    public InnerResponse getResponse() { return  response;}
}
