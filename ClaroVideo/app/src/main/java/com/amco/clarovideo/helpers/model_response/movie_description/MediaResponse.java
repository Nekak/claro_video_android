package com.amco.clarovideo.helpers.model_response.movie_description;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 25/03/18.
 */
public class MediaResponse {
    @SerializedName("originaltitle")
    @Expose
    private String originalTitle;

    @SerializedName("description_extended")
    @Expose
    private String descriptionExtended;

    @SerializedName("publishyear")
    @Expose
    private String publishYear;

    @SerializedName("rating")
    @Expose
    private RatingResponse ratingResponse;

    @SerializedName("duration")
    @Expose
    private String duration;

    @SerializedName("countryoforigin")
    @Expose
    private CountryOriginResponse countryOriginResponse;

    @SerializedName("language")
    @Expose
    private LanguageResponse languageResponse;

    /**
     * Gets original title.
     *
     * @return the original title
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * Sets original title.
     *
     * @param originalTitle the original title
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    /**
     * Gets description extended.
     *
     * @return the description extended
     */
    public String getDescriptionExtended() {
        return descriptionExtended;
    }

    /**
     * Sets description extended.
     *
     * @param descriptionExtended the description extended
     */
    public void setDescriptionExtended(String descriptionExtended) {
        this.descriptionExtended = descriptionExtended;
    }

    /**
     * Gets publish year.
     *
     * @return the publish year
     */
    public String getPublishYear() {
        return publishYear;
    }

    /**
     * Sets publish year.
     *
     * @param publishYear the publish year
     */
    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    /**
     * Gets rating response.
     *
     * @return the rating response
     */
    public RatingResponse getRatingResponse() {
        return ratingResponse;
    }

    /**
     * Sets rating response.
     *
     * @param ratingResponse the rating response
     */
    public void setRatingResponse(RatingResponse ratingResponse) {
        this.ratingResponse = ratingResponse;
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
     * Gets country origin response.
     *
     * @return the country origin response
     */
    public CountryOriginResponse getCountryOriginResponse() {
        return countryOriginResponse;
    }

    /**
     * Sets country origin response.
     *
     * @param countryOriginResponse the country origin response
     */
    public void setCountryOriginResponse(CountryOriginResponse countryOriginResponse) {
        this.countryOriginResponse = countryOriginResponse;
    }

    /**
     * Gets language response.
     *
     * @return the language response
     */
    public LanguageResponse getLanguageResponse() {
        return languageResponse;
    }

    /**
     * Sets language response.
     *
     * @param languageResponse the language response
     */
    public void setLanguageResponse(LanguageResponse languageResponse) {
        this.languageResponse = languageResponse;
    }
}
