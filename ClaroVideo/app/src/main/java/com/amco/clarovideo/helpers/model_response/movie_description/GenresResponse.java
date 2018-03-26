package com.amco.clarovideo.helpers.model_response.movie_description;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nekak on 24/03/18.
 */
public class GenresResponse {
    @SerializedName("genre")
    @Expose
    private ArrayList<GenreResponse> arrGenres;

    /**
     * Gets arr genres.
     *
     * @return the arr genres
     */
    public ArrayList<GenreResponse> getArrGenres() {
        return arrGenres;
    }

    /**
     * Sets arr genres.
     *
     * @param arrGenres the arr genres
     */
    public void setArrGenres(ArrayList<GenreResponse> arrGenres) {
        this.arrGenres = arrGenres;
    }
}
