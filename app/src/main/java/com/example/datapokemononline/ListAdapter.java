package com.example.datapokemononline;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PokemonModel> mypokemon;

    public ListAdapter(Context context, ArrayList<PokemonModel> mypokemon){
        this.context = context;
        this.mypokemon = mypokemon;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pokemon, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder viewHolder,final int index) {
        viewHolder.tvIdPokemon.setText(mypokemon.get(index).getId());
        viewHolder.tvNamaPokemon.setText(mypokemon.get(index).getName());
        viewHolder.tvNumberPokemon.setText(mypokemon.get(index).getNumber());
        viewHolder.tvArtist.setText(mypokemon.get(index).getArtist());
        viewHolder.tvRarity.setText(mypokemon.get(index).getRarity());
        viewHolder.tvSet.setText(mypokemon.get(index).getSet());
        viewHolder.tvSetCode.setText(mypokemon.get(index).getSetCode());
        Glide.with(context)
                .load(mypokemon.get(index).getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(viewHolder.imgPokemon);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsPokemonActivity.class);
                intent.putExtra(DetailsPokemonActivity.EXTRA_POKEMON, mypokemon.get(index));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return mypokemon.size(); }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdPokemon;
        TextView tvNamaPokemon;
        ImageView imgPokemon;
        TextView tvNumberPokemon;
        TextView tvArtist;
        TextView tvRarity;
        TextView tvSet;
        TextView tvSetCode;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvIdPokemon = itemView.findViewById(R.id.id_pokemon);
            tvNamaPokemon = itemView.findViewById(R.id.nama_pokemon);
            imgPokemon = itemView.findViewById(R.id.img_Pokemon);
            tvNumberPokemon = itemView.findViewById(R.id.number_pokemon);
            tvArtist = itemView.findViewById(R.id.artist_pokemon);
            tvRarity = itemView.findViewById(R.id.rarity_pokemon);
            tvSet = itemView.findViewById(R.id.deck_pokemon);
            tvSetCode = itemView.findViewById(R.id.deck_code_pokemon);

        }
    }
}
