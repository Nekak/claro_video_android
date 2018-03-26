package com.amco.clarovideo.helpers.model_response.movie_description;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nekak on 24/03/18.
 */
public class RolesResponse {
    @SerializedName("role")
    @Expose
    private ArrayList<RoleResponse> arrRole;

    /**
     * Gets arr role.
     *
     * @return the arr role
     */
    public ArrayList<RoleResponse> getArrRole() {
        return arrRole;
    }

    /**
     * Sets arr role.
     *
     * @param arrRole the arr role
     */
    public void setArrRole(ArrayList<RoleResponse> arrRole) {
        this.arrRole = arrRole;
    }
}
