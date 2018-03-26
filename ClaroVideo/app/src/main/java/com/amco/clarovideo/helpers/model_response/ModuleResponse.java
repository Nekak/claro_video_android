package com.amco.clarovideo.helpers.model_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 24/03/18.
 */
public class ModuleResponse {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("components")
    @Expose
    private ComponentsResponse componentsResponse;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets components response.
     *
     * @return the components response
     */
    public ComponentsResponse getComponentsResponse() {
        return componentsResponse;
    }

    /**
     * Sets components response.
     *
     * @param componentsResponse the components response
     */
    public void setComponentsResponse(ComponentsResponse componentsResponse) {
        this.componentsResponse = componentsResponse;
    }
}
