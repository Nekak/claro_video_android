package com.amco.clarovideo.helpers.model_response.movie_description;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 25/03/18.
 */
public class OptionResponse {
    @SerializedName("group_id")
    @Expose
    private String groupId;

    @SerializedName("content_id")
    @Expose
    private String contentId;

    @SerializedName("current_content")
    @Expose
    private String currentContent;

    @SerializedName("option_id")
    @Expose
    private String optionId;

    @SerializedName("audio")
    @Expose
    private String audio;

    @SerializedName("subtitle")
    @Expose
    private String subtitle;

    @SerializedName("option_name")
    @Expose
    private String optionName;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("desc")
    @Expose
    private String description;

    @SerializedName("label_short")
    @Expose
    private String labelShort;

    @SerializedName("label_large")
    @Expose
    private String labelLarge;

    /**
     * Gets group id.
     *
     * @return the group id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Sets group id.
     *
     * @param groupId the group id
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * Gets content id.
     *
     * @return the content id
     */
    public String getContentId() {
        return contentId;
    }

    /**
     * Sets content id.
     *
     * @param contentId the content id
     */
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    /**
     * Gets current content.
     *
     * @return the current content
     */
    public String getCurrentContent() {
        return currentContent;
    }

    /**
     * Sets current content.
     *
     * @param currentContent the current content
     */
    public void setCurrentContent(String currentContent) {
        this.currentContent = currentContent;
    }

    /**
     * Gets option id.
     *
     * @return the option id
     */
    public String getOptionId() {
        return optionId;
    }

    /**
     * Sets option id.
     *
     * @param optionId the option id
     */
    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    /**
     * Gets audio.
     *
     * @return the audio
     */
    public String getAudio() {
        return audio;
    }

    /**
     * Sets audio.
     *
     * @param audio the audio
     */
    public void setAudio(String audio) {
        this.audio = audio;
    }

    /**
     * Gets subtitle.
     *
     * @return the subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * Sets subtitle.
     *
     * @param subtitle the subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * Gets option name.
     *
     * @return the option name
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * Sets option name.
     *
     * @param optionName the option name
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets label short.
     *
     * @return the label short
     */
    public String getLabelShort() {
        return labelShort;
    }

    /**
     * Sets label short.
     *
     * @param labelShort the label short
     */
    public void setLabelShort(String labelShort) {
        this.labelShort = labelShort;
    }

    /**
     * Gets label large.
     *
     * @return the label large
     */
    public String getLabelLarge() {
        return labelLarge;
    }

    /**
     * Sets label large.
     *
     * @param labelLarge the label large
     */
    public void setLabelLarge(String labelLarge) {
        this.labelLarge = labelLarge;
    }
}
