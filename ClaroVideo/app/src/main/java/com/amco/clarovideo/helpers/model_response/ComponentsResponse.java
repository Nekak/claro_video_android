package com.amco.clarovideo.helpers.model_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nekak on 24/03/18.
 */
public class ComponentsResponse {
    @SerializedName("component")
    @Expose
    private ArrayList<ComponentResponse> arrComponent;

    /**
     * Gets arr component.
     *
     * @return the arr component
     */
    public ArrayList<ComponentResponse> getArrComponent() {
        return arrComponent;
    }

    /**
     * Sets arr component.
     *
     * @param arrComponent the arr component
     */
    public void setArrComponent(ArrayList<ComponentResponse> arrComponent) {
        this.arrComponent = arrComponent;
    }
}
