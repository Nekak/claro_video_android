package com.amco.clarovideo.helpers.model_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 24/03/18.
 */
public class ComponentResponse {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("properties")
    @Expose
    private ComponentPropertiesResponse propertiesResponse;

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
     * Gets properties response.
     *
     * @return the properties response
     */
    public ComponentPropertiesResponse getPropertiesResponse() {
        return propertiesResponse;
    }

    /**
     * Sets properties response.
     *
     * @param propertiesResponse the properties response
     */
    public void setPropertiesResponse(ComponentPropertiesResponse propertiesResponse) {
        this.propertiesResponse = propertiesResponse;
    }
}
