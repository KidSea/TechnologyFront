package com.example.yuxuehai.technologyfront;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.example.yuxuehai.technologyfront.bean.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private FrameLayout mArticlesContainer;
    private RecyclerView mMenuRecyclerView;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initActionBar();
        initMenu();
    }

    private void initMenu() {
        mMenuRecyclerView.setLayoutManager(new LinearLayoutManager
                (getApplicationContext()));
        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem(getString(R.string.article), R.drawable.home));
        menuItems.add(new MenuItem(getString(R.string.about_menu), R.drawable.about));
        menuItems.add(new MenuItem(getString(R.string.exit), R.drawable.exit));

    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mArticlesContainer = (FrameLayout) findViewById(R.id.articles_container);
        mMenuRecyclerView = (RecyclerView) findViewById(R.id.menu_recyclerview);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }


    private void initActionBar() {
        mToolbar.setTitle(R.string.app_name);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
