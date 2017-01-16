package network;

import model.ImdbResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Pcp on 17/01/2017.
 */

public interface ImdbEndpoint {

    public static final String ENDPOINT = "http://imdbapi.poromenos.org/";
    @GET("/js/")
    Call<ImdbResponse> getSeriesByName(@Query("name") String name);
}
