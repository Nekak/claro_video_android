package com.amco.clarovideo.helpers.model_response.movie_description;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 25/03/18.
 */
public class LanguageResponse {
    @SerializedName("original")
    @Expose
    private OriginalLanguageResponse originalLanguageResponse;

    @SerializedName("dubbed")
    @Expose
    private String dubbed;

    @SerializedName("subbed")
    @Expose
    private String subbed;

    @SerializedName("options")
    @Expose
    private OptionsResponse optionsResponse;

    /**
     * Gets original language response.
     *
     * @return the original language response
     */
    public OriginalLanguageResponse getOriginalLanguageResponse() {
        return originalLanguageResponse;
    }

    /**
     * Sets original language response.
     *
     * @param originalLanguageResponse the original language response
     */
    public void setOriginalLanguageResponse(OriginalLanguageResponse originalLanguageResponse) {
        this.originalLanguageResponse = originalLanguageResponse;
    }

    /**
     * Gets dubbed.
     *
     * @return the dubbed
     */
    public String getDubbed() {
        return dubbed;
    }

    /**
     * Sets dubbed.
     *
     * @param dubbed the dubbed
     */
    public void setDubbed(String dubbed) {
        this.dubbed = dubbed;
    }

    /**
     * Gets subbed.
     *
     * @return the subbed
     */
    public String getSubbed() {
        return subbed;
    }

    /**
     * Sets subbed.
     *
     * @param subbed the subbed
     */
    public void setSubbed(String subbed) {
        this.subbed = subbed;
    }

    /**
     * Gets options response.
     *
     * @return the options response
     */
    public OptionsResponse getOptionsResponse() {
        return optionsResponse;
    }

    /**
     * Sets options response.
     *
     * @param optionsResponse the options response
     */
    public void setOptionsResponse(OptionsResponse optionsResponse) {
        this.optionsResponse = optionsResponse;
    }
}
