package com.mattappz.maturana100;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ResolveTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolve_test);
    }

    @Override
    public void onBackPressed(){
        supportFinishAfterTransition();
    }
}
