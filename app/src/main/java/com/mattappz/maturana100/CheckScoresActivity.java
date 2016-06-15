package com.mattappz.maturana100;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;

public class CheckScoresActivity extends AppCompatActivity {

    Toolbar toolbar;
    NestedScrollView mNestedScrollView;
    AppBarLayout mAppBarLayout;
    FloatingActionButton fab;

    private int verticalOffsett;


    public static void showFabWithAnimation(final FloatingActionButton fab, final int delay) {
        fab.setVisibility(View.INVISIBLE);
        fab.setScaleX(0.0F);
        fab.setScaleY(0.0F);
        fab.setAlpha(0.0F);
        fab.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                fab.getViewTreeObserver().removeOnPreDrawListener(this);
                fab.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fab.show();
                    }
                }, delay);
                return true;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_scores);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sprawdź wyniki");


        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        showFabWithAnimation(fab, 500);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Podziel się wynikami z przyjaciółmi!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBat, int verticalOffset) {

                verticalOffsett = verticalOffset;
            }
        });
    }


    public void onBackPressed() {


        if (verticalOffsett != 0) {
            mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    if (verticalOffset == 0) {
                        finishActivity();
                    }
                }
            });

            fab.hide();
            mAppBarLayout.setExpanded(true);

        } else {
            finishActivity();
        }
    }

    private void finishActivity() {

        fab.hide(new FloatingActionButton.OnVisibilityChangedListener() {
            @Override
            public void onHidden(FloatingActionButton fab) {
                super.onHidden(fab);
                supportFinishAfterTransition();
            }
        });
    }


}
