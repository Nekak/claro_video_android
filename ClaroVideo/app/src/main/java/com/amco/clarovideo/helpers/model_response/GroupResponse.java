package com.amco.clarovideo.helpers.model_response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 24/03/18.
 */
public class GroupResponse implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("title_uri")
    @Expose
    private String titleUri;

    @SerializedName("title_original")
    @Expose
    private String titleOriginal;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("description_large")
    @Expose
    private String descriptionLarge;

    @SerializedName("image_large")
    @Expose
    private String imageLarge;

    @SerializedName("image_medium")
    @Expose
    private String imageMedium;

    @SerializedName("image_small")
    @Expose
    private String imageSmall;

    /**
     * Instantiates a new Group response.
     */
    public GroupResponse(){
        id = "";
        title = "";
        titleUri = "";
        titleOriginal = "";
        description = "";
        descriptionLarge = "";
        imageLarge = "";
        imageMedium = "";
        imageSmall = "";
    }

    /**
     * Instantiates a new Group response.
     *
     * @param in the in
     */
    protected GroupResponse(Parcel in) {
        id = in.readString();
        title = in.readString();
        titleUri = in.readString();
        titleOriginal = in.readString();
        description = in.readString();
        descriptionLarge = in.readString();
        imageLarge = in.readString();
        imageMedium = in.readString();
        imageSmall = in.readString();
    }

    /**
     * The constant CREATOR.
     */
    public static final Creator<GroupResponse> CREATOR = new Creator<GroupResponse>() {
        @Override
        public GroupResponse createFromParcel(Parcel in) {
            return new GroupResponse(in);
        }

        @Override
        public GroupResponse[] newArray(int size) {
            return new GroupResponse[size];
        }
    };

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
     * Gets title uri.
     *
     * @return the title uri
     */
    public String getTitleUri() {
        return titleUri;
    }

    /**
     * Sets title uri.
     *
     * @param titleUri the title uri
     */
    public void setTitleUri(String titleUri) {
        this.titleUri = titleUri;
    }

    /**
     * Gets title original.
     *
     * @return the title original
     */
    public String getTitleOriginal() {
        return titleOriginal;
    }

    /**
     * Sets title original.
     *
     * @param titleOriginal the title original
     */
    public void setTitleOriginal(String titleOriginal) {
        this.titleOriginal = titleOriginal;
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
     * Gets description large.
     *
     * @return the description large
     */
    public String getDescriptionLarge() {
        return descriptionLarge;
    }

    /**
     * Sets description large.
     *
     * @param descriptionLarge the description large
     */
    public void setDescriptionLarge(String descriptionLarge) {
        this.descriptionLarge = descriptionLarge;
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
     * Gets image medium.
     *
     * @return the image medium
     */
    public String getImageMedium() {
        return imageMedium;
    }

    /**
     * Sets image medium.
     *
     * @param imageMedium the image medium
     */
    public void setImageMedium(String imageMedium) {
        this.imageMedium = imageMedium;
    }

    /**
     * Gets image small.
     *
     * @return the image small
     */
    public String getImageSmall() {
        return imageSmall;
    }

    /**
     * Sets image small.
     *
     * @param imageSmall the image small
     */
    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(titleUri);
        dest.writeString(titleOriginal);
        dest.writeString(description);
        dest.writeString(descriptionLarge);
        dest.writeString(imageLarge);
        dest.writeString(imageMedium);
        dest.writeString(imageSmall);
    }
}
