package com.amco.clarovideo.activities;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.RatingBar;

import com.amco.clarovideo.R;
import com.amco.clarovideo.delegate.AppDelegate;
import com.amco.clarovideo.helpers.RestApi;
import com.amco.clarovideo.helpers.model_response.GroupResponse;
import com.amco.clarovideo.helpers.model_response.ServerResponse;
import com.amco.clarovideo.helpers.model_response.movie_description.GroupMovieResponse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertNotNull;

/**
 * Created by nekak on 25/03/18.
 */
@RunWith(AndroidJUnit4.class)
public class MovieDescriptionActivityTest {
    /**
     * The Activity test rule.
     */
    @Rule
    public ActivityTestRule<MovieDescriptionActivity> activityTestRule = new ActivityTestRule<>(MovieDescriptionActivity.class, false, false);

    /**
     * Download movies is right.
     */
    @Test
    public void downloadMovies_IsRight() {
        Intent intent = new Intent();
        intent.putExtra("movie", new GroupResponse());

        activityTestRule.launchActivity(intent);

        String idMovie = "530089";
        final RestApi restApi = ((AppDelegate) activityTestRule.getActivity().getApplication()).getRestApi();

        Call<ServerResponse> callMovieDescription = restApi.getMovies("services/content/data?" + RestApi.URL_KEYS + "&group_id=" + idMovie);

        assertNotNull("The call is null", callMovieDescription);

        callMovieDescription.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                assertNotNull("The response has not message", response.body().getMessage());

                if (response.isSuccessful() && response.body().getMessage().equals(RestApi.OK)) {
                    assertNotNull("The response has not data", response.body().getDataResponse());
                    GroupMovieResponse movieResponse = response.body().getDataResponse().getMovieResponse();

                    assertNotNull("The movie information is null", movieResponse);

                    if (movieResponse != null) {
                        RatingBar ratingBar = activityTestRule.getActivity().findViewById(R.id.rb_amd);
                        assertNotNull("Rating bar is null", ratingBar);
                        //ratingBar.setVisibility(View.VISIBLE);
                        //ratingBar.setRating(movieResponse.getCommonResponse().getRankingResponse().getAverageVotes());

                        //updateData(movieResponse);
                    } else {
                        //showSnackBarError(R.string.error_no_content);
                    }
                } else {
                    //showSnackBarError(R.string.error_download_content);
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                if (!call.isCanceled()) {
                    //showSnackBarError(R.string.error_download_content);
                    //stopRefreshLayout();
                }
            }
        });
    }
}
