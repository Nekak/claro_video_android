package com.amco.clarovideo.helpers.model_response.movie_description;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 24/03/18.
 */
public class MovieCommonResponse {
    @SerializedName("position")
    @Expose
    private Integer position;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("large_description")
    @Expose
    private String largeDescription;

    @SerializedName("image_large")
    @Expose
    private String imageLarge;

    @SerializedName("duration")
    @Expose
    private String duration;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("extendedcommon")
    @Expose
    private ExtendedCommonResponse extendedCommonResponse;

    @SerializedName("ranking")
    @Expose
    private RankingResponse rankingResponse;

    /**
     * Gets extended common response.
     *
     * @return the extended common response
     */
    public ExtendedCommonResponse getExtendedCommonResponse() {
        return extendedCommonResponse;
    }

    /**
     * Sets extended common response.
     *
     * @param extendedCommonResponse the extended common response
     */
    public void setExtendedCommonResponse(ExtendedCommonResponse extendedCommonResponse) {
        this.extendedCommonResponse = extendedCommonResponse;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Gets image large.
     *
     * @return the image large
     */
    public String getImageLarge() {
        return imageLarge;
    }

    /**
     * Sets image large.
     *
     * @param imageLarge the image large
     */
    public void setImageLarge(String imageLarge) {
        this.imageLarge = imageLarge;
    }

    /**
     * Gets large description.
     *
     * @return the large description
     */
    public String getLargeDescription() {
        return largeDescription;
    }

    /**
     * Sets large description.
     *
     * @param largeDescription the large description
     */
    public void setLargeDescription(String largeDescription) {
        this.largeDescription = largeDescription;
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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * Gets position.
     *
     * @return the position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * Gets ranking response.
     *
     * @return the ranking response
     */
    public RankingResponse getRankingResponse() {
        return rankingResponse;
    }

    /**
     * Sets ranking response.
     *
     * @param rankingResponse the ranking response
     */
    public void setRankingResponse(RankingResponse rankingResponse) {
        this.rankingResponse = rankingResponse;
    }
}
