package com.amco.clarovideo.helpers.model_response.movie_description;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nekak on 25/03/18.
 */
public class RankingResponse {
    @SerializedName("views_count")
    @Expose
    private Integer viewsCount;

    @SerializedName("votes_count")
    @Expose
    private Integer votesCount;

    @SerializedName("average_votes")
    @Expose
    private Integer averageVotes;

    /**
     * Gets views count.
     *
     * @return the views count
     */
    public Integer getViewsCount() {
        return viewsCount;
    }

    /**
     * Sets views count.
     *
     * @param viewsCount the views count
     */
    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    /**
     * Gets votes count.
     *
     * @return the votes count
     */
    public Integer getVotesCount() {
        return votesCount;
    }

    /**
     * Sets votes count.
     *
     * @param votesCount the votes count
     */
    public void setVotesCount(Integer votesCount) {
        this.votesCount = votesCount;
    }

    /**
     * Gets average votes.
     *
     * @return the average votes
     */
    public Integer getAverageVotes() {
        return averageVotes;
    }

    /**
     * Sets average votes.
     *
     * @param averageVotes the average votes
     */
    public void setAverageVotes(Integer averageVotes) {
        this.averageVotes = averageVotes;
    }
}
