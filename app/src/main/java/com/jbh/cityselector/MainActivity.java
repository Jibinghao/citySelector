package com.jbh.cityselector;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jbh.lib.CityPicker;
import com.jbh.lib.adapter.OnPickListener;
import com.jbh.lib.model.City;
import com.jbh.lib.model.HotCity;
import com.jbh.lib.model.LatelyCity;
import com.jbh.lib.model.LocateState;
import com.jbh.lib.model.LocatedCity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<HotCity> hotCities = new ArrayList<>();
                hotCities.add(new HotCity("北京", "北京", "101010100"));
                hotCities.add(new HotCity("上海", "上海", "101020100"));
                hotCities.add(new HotCity("广州", "广东", "101280101"));
                hotCities.add(new HotCity("深圳", "广东", "101280601"));
                hotCities.add(new HotCity("杭州", "浙江", "101210101"));
                List<LatelyCity> latelyCities = new ArrayList<>();
                latelyCities.add(new LatelyCity("广州", "广东", "101280101"));
                latelyCities.add(new LatelyCity("深圳", "广东", "101280601"));
                latelyCities.add(new LatelyCity("杭州", "浙江", "101210101"));
                latelyCities.add(new LatelyCity("北京", "北2京", "101010100"));
                latelyCities.add(new LatelyCity("上海", "上2海", "101020100"));

                CityPicker.getInstance()
                        .setFragmentManager(getSupportFragmentManager())    //此方法必须调用
                        .enableAnimation(true)    //启用动画效果
                        .setLocatedCity(new LocatedCity("杭州", "浙江", "101210101")) //APP自身已定位的城市，默认为null（定位失败）
                        .setHotCities(hotCities)    //指定热门城市
                        .setLatelyCities(latelyCities)
                        .setOnPickListener(new OnPickListener() {
                            @Override
                            public void onPick(int position, City data) {
                                Toast.makeText(getApplicationContext(), data.getName(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLocate() {
                                //开始定位，这里模拟一下定位
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //定位完成之后更新数据
                                        CityPicker.getInstance()
                                                .locateComplete(new LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS);
                                    }
                                }, 2000);
                            }
                        })
                        .show();
            }
        });

    }
}
