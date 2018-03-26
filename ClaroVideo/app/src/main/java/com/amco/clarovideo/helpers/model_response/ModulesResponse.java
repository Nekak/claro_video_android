package com.amco.clarovideo.helpers.model_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nekak on 24/03/18.
 */
public class ModulesResponse {
    @SerializedName("module")
    @Expose
    private ArrayList<ModuleResponse> arrModule;

    /**
     * Gets arr module.
     *
     * @return the arr module
     */
    public ArrayList<ModuleResponse> getArrModule() {
        return arrModule;
    }

    /**
     * Sets arr module.
     *
     * @param arrModule the arr module
     */
    public void setArrModule(ArrayList<ModuleResponse> arrModule) {
        this.arrModule = arrModule;
    }
}
