package com.amco.clarovideo.views;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amco.clarovideo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nekak on 25/03/18.
 */
public class ContentMovieView extends FrameLayout {
    /**
     * The Text view.
     */
    @BindView(R.id.tv_vhcm)
    TextView textView;

    /**
     * The Linear layout.
     */
    @BindView(R.id.ll_vhcm)
    LinearLayout linearLayout;

    /**
     * Instantiates a new Content movie view.
     *
     * @param context the context
     */
    public ContentMovieView(@NonNull Context context) {
        super(context);

        bindViews(context);
    }

    /**
     * Instantiates a new Content movie view.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public ContentMovieView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        bindViews(context);
    }

    private void bindViews(Context context) {
        View view = inflate(context, R.layout.view_content_movie, null);

        ButterKnife.bind(this, view);

        this.addView(view);
    }

    /**
     * Gets text view.
     *
     * @return the text view
     */
    public TextView getTextView() {
        return textView;
    }

    /**
     * Add text.
     *
     * @param context    the context
     * @param textString the text string
     */
    public void addText(Context context, String textString) {
        TextView tv = new TextView(context);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(14);

        tv.setText(textString);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        tv.setLayoutParams(params);

        linearLayout.addView(tv);
    }
}
