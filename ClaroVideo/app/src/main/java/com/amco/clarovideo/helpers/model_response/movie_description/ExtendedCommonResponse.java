package com.amco.clarovideo.helpers.model_response.movie_description;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 24/03/18.
 */
public class ExtendedCommonResponse {
    @SerializedName("genres")
    @Expose
    private GenresResponse genresResponse;

    @SerializedName("roles")
    @Expose
    private RolesResponse rolesResponse;

    @SerializedName("media")
    @Expose
    private MediaResponse mediaResponse;

    /**
     * Gets genres response.
     *
     * @return the genres response
     */
    public GenresResponse getGenresResponse() {
        return genresResponse;
    }

    /**
     * Sets genres response.
     *
     * @param genresResponse the genres response
     */
    public void setGenresResponse(GenresResponse genresResponse) {
        this.genresResponse = genresResponse;
    }

    /**
     * Gets roles response.
     *
     * @return the roles response
     */
    public RolesResponse getRolesResponse() {
        return rolesResponse;
    }

    /**
     * Sets roles response.
     *
     * @param rolesResponse the roles response
     */
    public void setRolesResponse(RolesResponse rolesResponse) {
        this.rolesResponse = rolesResponse;
    }

    /**
     * Gets media response.
     *
     * @return the media response
     */
    public MediaResponse getMediaResponse() {
        return mediaResponse;
    }

    /**
     * Sets media response.
     *
     * @param mediaResponse the media response
     */
    public void setMediaResponse(MediaResponse mediaResponse) {
        this.mediaResponse = mediaResponse;
    }
}
