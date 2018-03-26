package com.amco.clarovideo.helpers.model_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 24/03/18.
 */
public class ServerResponse {
    @SerializedName("entry")
    @Expose
    private EntryResponse entry;

    @SerializedName("response")
    @Expose
    private DataResponse dataResponse;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("msg")
    @Expose
    private String message;

    /**
     * Gets entry.
     *
     * @return the entry
     */
    public EntryResponse getEntry() {
        return entry;
    }

    /**
     * Sets entry.
     *
     * @param entry the entry
     */
    public void setEntry(EntryResponse entry) {
        this.entry = entry;
    }

    /**
     * Gets data response.
     *
     * @return the data response
     */
    public DataResponse getDataResponse() {
        return dataResponse;
    }

    /**
     * Sets data response.
     *
     * @param dataResponse the data response
     */
    public void setDataResponse(DataResponse dataResponse) {
        this.dataResponse = dataResponse;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
