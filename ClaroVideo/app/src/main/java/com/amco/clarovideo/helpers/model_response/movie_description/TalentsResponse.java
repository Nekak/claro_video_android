package com.amco.clarovideo.helpers.model_response.movie_description;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nekak on 24/03/18.
 */
public class TalentsResponse {
    @SerializedName("talent")
    @Expose
    private ArrayList<TalentResponse> arrTalents;

    /**
     * Gets arr talents.
     *
     * @return the arr talents
     */
    public ArrayList<TalentResponse> getArrTalents() {
        return arrTalents;
    }

    /**
     * Sets arr talents.
     *
     * @param arrTalents the arr talents
     */
    public void setArrTalents(ArrayList<TalentResponse> arrTalents) {
        this.arrTalents = arrTalents;
    }
}
