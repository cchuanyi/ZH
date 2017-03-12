package com.cc.ccy.zh;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listview;
    private RollPagerView mRollViewPager;
    private ArrayList<HashMap<String,Object>> data;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initSilidingmenu();
        initleft();
    }

    private void initleft() {
        listview= (ListView) this.findViewById(R.id.lv_menu);
        data=new ArrayList<>();
        HashMap<String,Object> map1=new HashMap<>();map1.put("name","日常心理学");
        HashMap<String,Object> map2=new HashMap<>();map2.put("name","用户推荐日报");
        HashMap<String,Object> map3=new HashMap<>();map3.put("name","电影日报");
        HashMap<String,Object> map4=new HashMap<>();map4.put("name","不许无聊");
        HashMap<String,Object> map5=new HashMap<>();map5.put("name","设计日报");
        HashMap<String,Object> map6=new HashMap<>();map6.put("name","大公司日报");
        HashMap<String,Object> map7=new HashMap<>();map7.put("name","财经日报");
        HashMap<String,Object> map8=new HashMap<>();map8.put("name","互联网安全");
        HashMap<String,Object> map9=new HashMap<>();map9.put("name","开始游戏");
        HashMap<String,Object> map10=new HashMap<>();map10.put("name","音乐日报");
        HashMap<String,Object> map11=new HashMap<>();map11.put("name","动漫日报");
        HashMap<String,Object> map12=new HashMap<>();map12.put("name","体育日报");
        data.add(map1);
        data.add(map2);
        data.add(map3);
        data.add(map4);
        data.add(map5);
        data.add(map6);
        data.add(map7);
        data.add(map8);
        data.add(map9);
        data.add(map10);
        data.add(map12);
        data.add(map12);

        adapter=new SimpleAdapter(this,data,R.layout.item_menu,new String[]{"name"},new int[]{R.id.item_tv});
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private void initSilidingmenu() {
        SlidingMenu menu=new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
       // menu.setShadowDrawable(R.color.colorAccent);

        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.left_menu);


    }

    private void init() {
        toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.toolbar_menu);

        toolbar.setNavigationIcon(R.mipmap.ic_drawer_home);
        toolbar.setTitle("首页");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        mRollViewPager = (RollPagerView) findViewById(R.id.roll_view_pager);

        //设置播放时间间隔
        mRollViewPager.setPlayDelay(1000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }


    }

}

