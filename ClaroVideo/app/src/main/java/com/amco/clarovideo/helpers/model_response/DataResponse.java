package com.amco.clarovideo.helpers.model_response;

import com.amco.clarovideo.helpers.model_response.movie_description.GroupMovieResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nekak on 24/03/18.
 */
public class DataResponse {
    @SerializedName("modules")
    @Expose
    private ModulesResponse modulesResponse;

    @SerializedName("groups")
    @Expose
    private ArrayList<GroupResponse> arrGroup;

    @SerializedName("group")
    @Expose
    private GroupMovieResponse movieResponse;

    /**
     * Gets modules response.
     *
     * @return the modules response
     */
    public ModulesResponse getModulesResponse() {
        return modulesResponse;
    }

    /**
     * Sets modules response.
     *
     * @param modulesResponse the modules response
     */
    public void setModulesResponse(ModulesResponse modulesResponse) {
        this.modulesResponse = modulesResponse;
    }

    /**
     * Gets arr group.
     *
     * @return the arr group
     */
    public ArrayList<GroupResponse> getArrGroup() {
        return arrGroup;
    }

    /**
     * Sets arr group.
     *
     * @param arrGroup the arr group
     */
    public void setArrGroup(ArrayList<GroupResponse> arrGroup) {
        this.arrGroup = arrGroup;
    }

    /**
     * Gets movie response.
     *
     * @return the movie response
     */
    public GroupMovieResponse getMovieResponse() {
        return movieResponse;
    }

    /**
     * Sets movie response.
     *
     * @param movieResponse the movie response
     */
    public void setMovieResponse(GroupMovieResponse movieResponse) {
        this.movieResponse = movieResponse;
    }
}
