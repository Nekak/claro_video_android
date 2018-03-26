package com.amco.clarovideo.helpers.model_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 24/03/18.
 */
public class EntryResponse {
    @SerializedName("api_version")
    @Expose
    private String apiVersion;

    @SerializedName("authpn")
    @Expose
    private String authPn;

    @SerializedName("authpt")
    @Expose
    private String authPt;

    @SerializedName("format")
    @Expose
    private String format;

    @SerializedName("r_egion")
    @Expose
    private String region;

    @SerializedName("device_id")
    @Expose
    private String deviceId;

    @SerializedName("device_category")
    @Expose
    private String deviceCategory;

    @SerializedName("device_model")
    @Expose
    private String deviceModel;

    @SerializedName("device_type")
    @Expose
    private String deviceType;

    @SerializedName("device_manufacturer")
    @Expose
    private String deviceManufacturer;

    @SerializedName("HKS")
    @Expose
    private String hks;

    @SerializedName("node")
    @Expose
    private String node;

    /**
     * Gets api version.
     *
     * @return the api version
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * Sets api version.
     *
     * @param apiVersion the api version
     */
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Gets auth pn.
     *
     * @return the auth pn
     */
    public String getAuthPn() {
        return authPn;
    }

    /**
     * Sets auth pn.
     *
     * @param authPn the auth pn
     */
    public void setAuthPn(String authPn) {
        this.authPn = authPn;
    }

    /**
     * Gets auth pt.
     *
     * @return the auth pt
     */
    public String getAuthPt() {
        return authPt;
    }

    /**
     * Sets auth pt.
     *
     * @param authPt the auth pt
     */
    public void setAuthPt(String authPt) {
        this.authPt = authPt;
    }

    /**
     * Gets format.
     *
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets format.
     *
     * @param format the format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Gets region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets region.
     *
     * @param region the region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets device id.
     *
     * @return the device id
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets device id.
     *
     * @param deviceId the device id
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Gets device category.
     *
     * @return the device category
     */
    public String getDeviceCategory() {
        return deviceCategory;
    }

    /**
     * Sets device category.
     *
     * @param deviceCategory the device category
     */
    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    /**
     * Gets device model.
     *
     * @return the device model
     */
    public String getDeviceModel() {
        return deviceModel;
    }

    /**
     * Sets device model.
     *
     * @param deviceModel the device model
     */
    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    /**
     * Gets device type.
     *
     * @return the device type
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * Sets device type.
     *
     * @param deviceType the device type
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Gets device manufacturer.
     *
     * @return the device manufacturer
     */
    public String getDeviceManufacturer() {
        return deviceManufacturer;
    }

    /**
     * Sets device manufacturer.
     *
     * @param deviceManufacturer the device manufacturer
     */
    public void setDeviceManufacturer(String deviceManufacturer) {
        this.deviceManufacturer = deviceManufacturer;
    }

    /**
     * Gets hks.
     *
     * @return the hks
     */
    public String getHks() {
        return hks;
    }

    /**
     * Sets hks.
     *
     * @param hks the hks
     */
    public void setHks(String hks) {
        this.hks = hks;
    }

    /**
     * Gets node.
     *
     * @return the node
     */
    public String getNode() {
        return node;
    }

    /**
     * Sets node.
     *
     * @param node the node
     */
    public void setNode(String node) {
        this.node = node;
    }
}
