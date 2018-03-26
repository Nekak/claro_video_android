package com.amco.clarovideo.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.amco.clarovideo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nekak on 24/03/18.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {
    /**
     * The Image view.
     */
    @BindView(R.id.iv_vhm)
    ImageView imageView;

    /**
     * The View.
     */
    @BindView(R.id.cl_vhm)
    View view;

    /**
     * Instantiates a new Movie view holder.
     *
     * @param itemView the item view
     */
    public MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    /**
     * Gets image view.
     *
     * @return the image view
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * Gets view.
     *
     * @return the view
     */
    public View getView() {
        return view;
    }
}
