package com.fatihsyams.mymaps;

import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar toolBar;
    private Fragment1 fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        setSupportActionBar(toolBar);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frag_container, fragment1)
                .commit();

        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);

                bottomSheetDialog.setTitle("");
                bottomSheetDialog.show();
            }
        });
    }

    private void initView() {
        toolBar = findViewById(R.id.bottom_appbar);
        fragment1 = new Fragment1();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_normal:
                fragment1.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.action_terrain:
                fragment1.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.action_satellite:
                fragment1.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
        }

        return true;
    }
}
