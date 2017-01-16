package com.example.pcp.jsontutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import network.ImdbEndpoint;
import adapters.EpisodesAdapter;
import model.ImdbResponse;
import model.InnerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class retrofitActivity extends AppCompatActivity implements Callback<ImdbResponse> {

    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    EpisodesAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        setupRecycler();
    }

    private void setupRecycler() {
        recyclerView = (RecyclerView) findViewById(R.id.episodes_recycler);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new EpisodesAdapter(this);
        recyclerView.setAdapter(mAdapter);
    }

    public void onGetEp(View view){
        Gson gson=new GsonBuilder()
                .setDateFormat("yyyy-MM-dd''HH:mm:ssZ")
                .create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ImdbEndpoint.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ImdbEndpoint imdbEndpoint=retrofit.create(ImdbEndpoint.class);

        Call<ImdbResponse>callSeries=imdbEndpoint.getSeriesByName(("how I met your mother"));
        callSeries.enqueue(this);

    }

    @Override
    public void onResponse(Call<ImdbResponse> call, Response<ImdbResponse> response) {
        int code = response.code();
        if (code == 200) {
            ImdbResponse seriesBodyResponse = response.body();
            InnerResponse series = seriesBodyResponse.getResponse();
            mAdapter.updateDataSet(series.getEpisodes());
        } else {
            Toast.makeText(this, "Did not work: " + String.valueOf(code), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<ImdbResponse> call, Throwable t) {
        Toast.makeText(this, "Nope", Toast.LENGTH_LONG).show();
    }
}
