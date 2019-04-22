package com.example.datapokemononline;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PokemonModel implements Parcelable {

    private String id;
    private String name;
    private String number;
    private String imageUrl;
    private String artist;
    private String rarity;
    private String set;
    private String setCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSetCode() {
        return setCode;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public class PokemonResultModel{
        private List <PokemonModel> cards;

        public List<PokemonModel> getCards(){
            return cards;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.number);
        dest.writeString(this.imageUrl);
        dest.writeString(this.artist);
        dest.writeString(this.rarity);
        dest.writeString(this.set);
        dest.writeString(this.setCode);
    }

    public PokemonModel() {
    }

    protected PokemonModel(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.number = in.readString();
        this.imageUrl = in.readString();
        this.artist = in.readString();
        this.rarity = in.readString();
        this.set = in.readString();
        this.setCode = in.readString();
    }

    public static final Creator<PokemonModel> CREATOR = new Creator<PokemonModel>() {
        @Override
        public PokemonModel createFromParcel(Parcel source) {
            return new PokemonModel(source);
        }

        @Override
        public PokemonModel[] newArray(int size) {
            return new PokemonModel[size];
        }
    };
}
