package com.example.datapokemononline;

import android.preference.SwitchPreference;
import android.support.v4.widget.SwipeRefreshLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PokemonController {
    private MainActivity pokemonView;
    SwipeRefreshLayout swipePokemon;
    List<PokemonModel> pokemonModels;

    OkHttpClient client;
    //private ArrayList<PokemonModel> mypokemon = new ArrayList<>();

    public List<PokemonModel> getMypokemon() {
        return pokemonModels;
    }

    public PokemonController(MainActivity pokemonView){ this.pokemonView = pokemonView; }

    public void InitData(){
        pokemonModels = new ArrayList<PokemonModel>();
        pokemonModels.clear();

        //code bawaan dari Okhttp3
        Request request = new Request.Builder()
                .url("https://api.pokemontcg.io/v1/cards")
                .build();

        client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                pokemonView.onFailure();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                pokemonView.onResponse(response);
            }
        });

    //pokemonView.showRecylerList();
    }
}
