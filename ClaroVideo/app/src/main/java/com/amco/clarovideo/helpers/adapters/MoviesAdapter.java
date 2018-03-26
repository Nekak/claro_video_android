package com.amco.clarovideo.helpers.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amco.clarovideo.R;
import com.amco.clarovideo.helpers.OnMovieSelectedListener;
import com.amco.clarovideo.helpers.model_response.GroupResponse;
import com.amco.clarovideo.views.MovieViewHolder;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by nekak on 24/03/18.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> implements View.OnClickListener {
    private Activity activity;
    private ArrayList<GroupResponse> items;
    private OnMovieSelectedListener listener;

    /**
     * Instantiates a new Movies adapter.
     *
     * @param activity the activity
     */
    public MoviesAdapter(@NonNull Activity activity) {
        this.items = new ArrayList<>();
        this.activity = activity;
    }

    /**
     * Update list.
     *
     * @param items the items
     */
    public void updateList(ArrayList<GroupResponse> items) {
        this.items.clear();
        this.items.addAll(items);

        notifyDataSetChanged();
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public ArrayList<GroupResponse> getItems() {
        return items;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_movie, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.getView().setOnClickListener(this);
        holder.getView().setTag(position);

        GroupResponse response = items.get(position);

        Glide.with(activity).load(getPreviewForScreenSize(response)).into(holder.getImageView());
    }

    private String getPreviewForScreenSize(GroupResponse response) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;

        return width > 290 ? response.getImageLarge() : response.getImageSmall();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.movieSelectedWithIndex((Integer) v.getTag());
        }
    }

    /**
     * Sets listener.
     *
     * @param listener the listener
     */
    public void setListener(OnMovieSelectedListener listener) {
        this.listener = listener;
    }
}
