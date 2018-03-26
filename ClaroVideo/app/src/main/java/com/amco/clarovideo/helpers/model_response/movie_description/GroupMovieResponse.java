package com.amco.clarovideo.helpers.model_response.movie_description;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 24/03/18.
 */
public class GroupMovieResponse {
    @SerializedName("common")
    @Expose
    private MovieCommonResponse commonResponse;

    /**
     * Gets common response.
     *
     * @return the common response
     */
    public MovieCommonResponse getCommonResponse() {
        return commonResponse;
    }

    /**
     * Sets common response.
     *
     * @param commonResponse the common response
     */
    public void setCommonResponse(MovieCommonResponse commonResponse) {
        this.commonResponse = commonResponse;
    }
}
