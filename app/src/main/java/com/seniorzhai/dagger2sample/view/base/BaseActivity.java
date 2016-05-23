package com.seniorzhai.dagger2sample.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.seniorzhai.dagger2sample.App;
import com.seniorzhai.dagger2sample.reject.components.AppComponent;


/**
 * Created by zhai on 16/5/23.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(App.get(this).getAppComponent());
    }

    protected void setTitleBar(boolean enabled, String title){
        getSupportActionBar().setHomeButtonEnabled(enabled);
        getSupportActionBar().setDisplayHomeAsUpEnabled(enabled);
        getSupportActionBar().setTitle(title);
    }

    protected abstract  void setupActivityComponent(AppComponent appComponent);

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
