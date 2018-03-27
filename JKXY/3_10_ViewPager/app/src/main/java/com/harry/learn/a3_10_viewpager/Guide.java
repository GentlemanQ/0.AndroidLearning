package com.harry.learn.a3_10_viewpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Guide extends Activity implements ViewPager.OnPageChangeListener{

    private ViewPager vp;
    private ViewPagerAdapter vpAdapter;
    private List<View> views;
    private ImageView[] dots;
    private int[] ids = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4};
    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initViews();
        initDots();
    }

    private void initViews(){
        LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.one, null));
        views.add(inflater.inflate(R.layout.two, null));
        views.add(inflater.inflate(R.layout.three, null));
        views.add(inflater.inflate(R.layout.four, null));

        vpAdapter = new ViewPagerAdapter(views, this);

        btn_start = views.get(views.size()-1).findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Guide.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        vp = findViewById(R.id.viewpager);
        vp.setAdapter(vpAdapter);
        vp.setOnPageChangeListener(this);
    }

    private void initDots(){
        dots = new ImageView[views.size()];

        for (int i = 0; i < views.size(); i++){
            dots[i] = findViewById(ids[i]);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        System.out.println("position="+position);
        for(int i = 0; i < ids.length; i++){
            if(position == i){
                dots[i].setImageResource(R.drawable.point_selected);
            }else{
                dots[i].setImageResource(R.drawable.point);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
