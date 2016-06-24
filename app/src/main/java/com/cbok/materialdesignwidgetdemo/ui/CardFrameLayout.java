package com.cbok.materialdesignwidgetdemo.ui;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;

import com.cbok.materialdesignwidgetdemo.R;

/**
 * Created by hopes on 6/23/2016.
 */
public class CardFrameLayout extends FrameLayout {
    public CardFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CardFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(final int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        final float radius = getResources().getDimension(R.dimen.card_corner_radius);
        final int vw = w;
        final int vh = h;

        ViewOutlineProvider vop = new ViewOutlineProvider() {

            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0,0,vw,vh,radius);
            }
        };

        setOutlineProvider(vop);
        setClipToOutline(true);
    }
}
