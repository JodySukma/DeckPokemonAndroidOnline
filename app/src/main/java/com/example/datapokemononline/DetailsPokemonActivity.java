package com.example.datapokemononline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsPokemonActivity extends AppCompatActivity {
    TextView tvDetailsIdPokoemon;
    TextView tvDetailsNamaPokemon;
    ImageView imgDetailsPokemon;
    TextView tvDetailsNumberPokemon;
    TextView tvDetailsArtisPokemon;
    TextView tvDetailsRarityPokemon;
    TextView tvDetailsSetPokemon;
    TextView tvDetailsSetCodePokemon;

    PokemonModel pokemonModel;

    public static final String EXTRA_POKEMON = "extra_pokemon";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pokemon);

        tvDetailsIdPokoemon = findViewById(R.id.id_details_pokemon);
        tvDetailsNamaPokemon = findViewById(R.id.nama_details_pokemon);
        imgDetailsPokemon = findViewById(R.id.img_details_Pokemon);
        tvDetailsNumberPokemon = findViewById(R.id.number_details_pokemon);
        tvDetailsArtisPokemon = findViewById(R.id.artist_details_pokemon);
        tvDetailsRarityPokemon = findViewById(R.id.rarity_details_pokemon);
        tvDetailsSetPokemon = findViewById(R.id.deck_details_pokemon);
        tvDetailsSetCodePokemon = findViewById(R.id.deck_code_details_pokemon);

        pokemonModel =(PokemonModel) getIntent().getParcelableExtra(EXTRA_POKEMON);

        tvDetailsIdPokoemon.setText(pokemonModel.getId());
        tvDetailsNamaPokemon.setText(pokemonModel.getName());
        tvDetailsNumberPokemon.setText(pokemonModel.getNumber());
        tvDetailsArtisPokemon.setText(pokemonModel.getArtist());
        tvDetailsRarityPokemon.setText(pokemonModel.getRarity());
        tvDetailsSetPokemon.setText(pokemonModel.getSet());
        tvDetailsSetCodePokemon.setText(pokemonModel.getSetCode());
        Glide.with(this)
                .load(pokemonModel.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(imgDetailsPokemon);
    }
}
