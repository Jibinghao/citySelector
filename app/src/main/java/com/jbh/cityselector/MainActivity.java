package com.jbh.cityselector;

import android.os.Handler;
import android.support.v4.view.ViewPager;
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

    }
}
