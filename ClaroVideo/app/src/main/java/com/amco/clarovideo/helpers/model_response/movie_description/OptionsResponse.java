package com.amco.clarovideo.helpers.model_response.movie_description;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nekak on 25/03/18.
 */
public class OptionsResponse {
    @SerializedName("option")
    @Expose
    private ArrayList<OptionResponse> arrOptions;

    @SerializedName("count")
    @Expose
    private Integer count;

    /**
     * Gets arr options.
     *
     * @return the arr options
     */
    public ArrayList<OptionResponse> getArrOptions() {
        return arrOptions;
    }

    /**
     * Sets arr options.
     *
     * @param arrOptions the arr options
     */
    public void setArrOptions(ArrayList<OptionResponse> arrOptions) {
        this.arrOptions = arrOptions;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}
