package com.example.tab04;

import java.util.List;

import com.viewpagerindicator.TabPageIndicator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
/**
 * 
 * 使用第三方设置代码设置指示器
 *
 */

public class MainActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private TabPageIndicator indicator;
	private TabAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }
	private void initView() {
		mViewPager = (ViewPager)findViewById(R.id.viewpager);
		indicator = (TabPageIndicator)findViewById(R.id.id_indicator);
		mAdapter = new TabAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mAdapter);
		
		indicator.setViewPager(mViewPager,0);
	}
}
