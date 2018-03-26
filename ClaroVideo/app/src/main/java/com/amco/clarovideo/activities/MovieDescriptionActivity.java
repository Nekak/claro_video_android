package com.amco.clarovideo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.amco.clarovideo.R;
import com.amco.clarovideo.delegate.AppDelegate;
import com.amco.clarovideo.helpers.RestApi;
import com.amco.clarovideo.helpers.model_response.GroupResponse;
import com.amco.clarovideo.helpers.model_response.ServerResponse;
import com.amco.clarovideo.helpers.model_response.movie_description.ExtendedCommonResponse;
import com.amco.clarovideo.helpers.model_response.movie_description.GenreResponse;
import com.amco.clarovideo.helpers.model_response.movie_description.GenresResponse;
import com.amco.clarovideo.helpers.model_response.movie_description.GroupMovieResponse;
import com.amco.clarovideo.helpers.model_response.movie_description.MediaResponse;
import com.amco.clarovideo.helpers.model_response.movie_description.OptionResponse;
import com.amco.clarovideo.helpers.model_response.movie_description.OriginalLanguageResponse;
import com.amco.clarovideo.helpers.model_response.movie_description.RoleResponse;
import com.amco.clarovideo.helpers.model_response.movie_description.RolesResponse;
import com.amco.clarovideo.helpers.model_response.movie_description.TalentResponse;
import com.amco.clarovideo.views.ContentMovieView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The type Movie description activity.
 */
public class MovieDescriptionActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, ViewTreeObserver.OnGlobalLayoutListener {
    private Call<ServerResponse> callMovieDescription;
    private GroupResponse movie;

    /**
     * The Image view.
     */
    @BindView(R.id.iv_amd)
    ImageView imageView;

    /**
     * The Text view.
     */
    @BindView(R.id.tv_amd)
    TextView textView;

    /**
     * The Linear layout.
     */
    @BindView(R.id.ll_amd)
    LinearLayout linearLayout;

    /**
     * The Swipe refresh layout.
     */
    @BindView(R.id.srl_amd)
    SwipeRefreshLayout swipeRefreshLayout;

    /**
     * The Rating bar.
     */
    @BindView(R.id.rb_amd)
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_description);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            savedInstanceState.getParcelable("movie");
        } else {
            Intent intent = getIntent();

            movie = intent.getParcelableExtra("movie");
        }

        this.swipeRefreshLayout.setOnRefreshListener(this);

        this.swipeRefreshLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable("movie", movie);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        movie = savedInstanceState.getParcelable("movie");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (callMovieDescription != null && !callMovieDescription.isCanceled()) {
            callMovieDescription.cancel();
        }
    }

    private void downloadMovies(String idMovie) {
        final RestApi restApi = ((AppDelegate) getApplication()).getRestApi();

        callMovieDescription = restApi.getMovies("services/content/data?" + RestApi.URL_KEYS + "&group_id=" + idMovie);

        callMovieDescription.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                stopRefreshLayout();

                if (response.isSuccessful() && response.body().getMessage().equals(RestApi.OK)) {
                    GroupMovieResponse movieResponse = response.body().getDataResponse().getMovieResponse();

                    if (movieResponse != null) {
                        ratingBar.setVisibility(View.VISIBLE);
                        ratingBar.setRating(movieResponse.getCommonResponse().getRankingResponse().getAverageVotes());

                        updateData(movieResponse);
                    } else {
                        showSnackBarError(R.string.error_no_content);
                    }
                } else {
                    showSnackBarError(R.string.error_download_content);
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                if (!call.isCanceled()) {
                    showSnackBarError(R.string.error_download_content);
                    stopRefreshLayout();
                }
            }
        });
    }

    private void updateData(GroupMovieResponse movieResponse) {
        linearLayout.removeAllViews();

        ExtendedCommonResponse extendedCommonResponse = movieResponse.getCommonResponse().getExtendedCommonResponse();

        if (extendedCommonResponse.getMediaResponse() != null) {
            putMediaData(extendedCommonResponse.getMediaResponse());
        }

        if (extendedCommonResponse.getRolesResponse() != null) {
            putRolesResponse(extendedCommonResponse.getRolesResponse());
        }

        if (extendedCommonResponse.getGenresResponse() != null) {
            putGenresData(extendedCommonResponse.getGenresResponse());
        }
    }

    private void putMediaData(MediaResponse mediaResponse) {
        ContentMovieView contentMovieView = new ContentMovieView(this);
        contentMovieView.getTextView().setText("Información");

        contentMovieView.addText(this, mediaResponse.getOriginalTitle() + " (" + mediaResponse.getPublishYear() + ")");

        if (mediaResponse.getCountryOriginResponse() != null) {
            contentMovieView.addText(this, mediaResponse.getCountryOriginResponse().getDescription());
        }

        contentMovieView.addText(this, "Duración: " + mediaResponse.getDuration());

        if (mediaResponse.getRatingResponse() != null) {
            contentMovieView.addText(this, mediaResponse.getRatingResponse().getDescription());
        }

        linearLayout.addView(contentMovieView);

        putDescription(mediaResponse.getDescriptionExtended());

        if (mediaResponse.getLanguageResponse().getOriginalLanguageResponse() != null) {
            putOriginalLanguage(mediaResponse.getLanguageResponse().getOriginalLanguageResponse());
        }

        ArrayList<String> dubbedArr = new ArrayList<>();
        ArrayList<String> subbedArr = new ArrayList<>();

        if (mediaResponse.getLanguageResponse().getOptionsResponse() != null) {
            for (OptionResponse or : mediaResponse.getLanguageResponse().getOptionsResponse().getArrOptions()) {
                if (or.getOptionName().equals("dubbed")) {
                    dubbedArr.add(or.getDescription());
                } else if (or.getOptionName().equals("subbed")) {
                    subbedArr.add(or.getDescription());
                }
            }
        }

        if (!dubbedArr.isEmpty()) {
            putDubbedLanguage(dubbedArr);
        }

        if (!subbedArr.isEmpty()) {
            putSubbedLanguage(subbedArr);
        }
    }

    private void putDescription(String description) {
        ContentMovieView contentMovieView = new ContentMovieView(this);
        contentMovieView.getTextView().setText("\nSinópsis");

        contentMovieView.addText(this, description);

        linearLayout.addView(contentMovieView);
    }

    private void putOriginalLanguage(OriginalLanguageResponse originalLanguageResponse) {
        ContentMovieView contentMovieView = new ContentMovieView(this);
        contentMovieView.getTextView().setText("\nIdioma original");

        contentMovieView.addText(this, originalLanguageResponse.getDescription());

        linearLayout.addView(contentMovieView);
    }

    private void putDubbedLanguage(ArrayList<String> dubbedLanguage) {
        ContentMovieView contentMovieView = new ContentMovieView(this);
        contentMovieView.getTextView().setText("\nDoblaje");

        for (String strL : dubbedLanguage) {
            contentMovieView.addText(this, strL);
        }

        linearLayout.addView(contentMovieView);
    }

    private void putSubbedLanguage(ArrayList<String> subbedLanguage) {
        ContentMovieView contentMovieView = new ContentMovieView(this);
        contentMovieView.getTextView().setText("\nSubtítulos");

        for (String strL : subbedLanguage) {
            contentMovieView.addText(this, strL);
        }

        linearLayout.addView(contentMovieView);
    }

    private void putRolesResponse(RolesResponse rolesResponse) {
        for (RoleResponse rr : rolesResponse.getArrRole()) {
            putRoleResponse(rr);
        }
    }

    private void putRoleResponse(RoleResponse roleResponse) {
        ContentMovieView contentMovieView = new ContentMovieView(this);
        contentMovieView.getTextView().setText("\n" + roleResponse.getDescription());

        for (TalentResponse tr : roleResponse.getTalentsResponse().getArrTalents()) {
            contentMovieView.addText(this, tr.getFullname());
        }

        linearLayout.addView(contentMovieView);
    }

    private void putGenresData(GenresResponse genresResponse) {
        ContentMovieView contentMovieView = new ContentMovieView(this);
        contentMovieView.getTextView().setText("\nGénero");

        for (GenreResponse gr : genresResponse.getArrGenres()) {
            contentMovieView.addText(this, gr.getDescription());
        }

        linearLayout.addView(contentMovieView);
    }

    private void showSnackBarError(int strId) {
        Snackbar.make(this.swipeRefreshLayout, strId, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onRefresh() {
        downloadMovies(movie.getId());
    }

    @Override
    public void onGlobalLayout() {
        this.swipeRefreshLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);

        Glide.with(MovieDescriptionActivity.this).load(movie.getImageLarge()).into(imageView);
        textView.setText(movie.getTitle());

        startRefreshLayout();
        downloadMovies(movie.getId());
    }

    /**
     * hide process indicator into refresh layout.
     */
    protected void stopRefreshLayout() {
        this.swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    /**
     * show process indicator into refresh layout.
     */
    protected void startRefreshLayout() {
        this.swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }
}
