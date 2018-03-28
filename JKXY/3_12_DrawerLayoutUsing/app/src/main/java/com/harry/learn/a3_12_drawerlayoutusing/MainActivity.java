package com.harry.learn.a3_12_drawerlayoutusing;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<String> menuList;
    private ArrayAdapter<String> adapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String title;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = getTitle().toString();

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);
        toolbar = findViewById(R.id.toolbar);

        menuList = new ArrayList<String>();
        menuList.add("开发");
        menuList.add("军事");
        menuList.add("人才");
        menuList.add("外交");
        menuList.add("内政");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuList);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(this);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                toolbar.setTitle("请选择");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                toolbar.setTitle(title);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //动态插入一个Fragment到FrameLayout当中
        Fragment contentFragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString("text", menuList.get(position));
        contentFragment.setArguments(args);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, contentFragment).commit();

        mDrawerLayout.closeDrawer(mDrawerList);
    }
}
