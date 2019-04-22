package com.example.datapokemononline;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvPokemon;
    SwipeRefreshLayout swipePokemon;
    Gson gson;

    ArrayList<PokemonModel> pokemonModels;
    ListAdapter listAdapter;

    PokemonController pokemonController = new PokemonController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPokemon =findViewById(R.id.rv_pokemon);
        rvPokemon.setLayoutManager(new LinearLayoutManager(this));

        pokemonModels = new ArrayList<>();
        listAdapter = new ListAdapter(this, pokemonModels);
        rvPokemon.setAdapter(listAdapter);
        pokemonController.InitData();

        SwipeRefresh();
    }

    public void onFailure() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                swipePokemon.setRefreshing(false);
                Toast.makeText(MainActivity.this, "Request anda gagal", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onResponse(Response response) throws IOException {
        if (response.isSuccessful()){
            gson = new Gson();
            final PokemonModel.PokemonResultModel resultModel = gson.fromJson(response.body().string(),
                    PokemonModel.PokemonResultModel.class);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    swipePokemon.setRefreshing(false);
                    pokemonModels.addAll(resultModel.getCards());

                    listAdapter.notifyDataSetChanged();
                }
            });
        }else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    swipePokemon.setRefreshing(false);
                    Toast.makeText(MainActivity.this, "Request anda error 404", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void SwipeRefresh(){
        swipePokemon = findViewById(R.id.swipe_refresh_pokemon);
        swipePokemon.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pokemonController.InitData();
            }
        });
        swipePokemon.setRefreshing(true);
        pokemonController.InitData();
    }

//    public void showRecylerList() {
//        rvPokemon.setLayoutManager(new LinearLayoutManager(this));
//        ListAdapter listAdapter = new ListAdapter(this, pokemonController.getMypokemon());
//        rvPokemon.setAdapter(listAdapter);
//    }
}
