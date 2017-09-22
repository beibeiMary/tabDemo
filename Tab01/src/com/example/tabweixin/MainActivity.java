package com.example.tabweixin;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
/**
 * ViewPager实现主界面制作,使用View
 */

public class MainActivity extends Activity implements OnClickListener{

	private ViewPager viewPager;
	private PagerAdapter adapter;
	private List<View> mViews = new ArrayList<View>();
	
	private LinearLayout mTabWeixin;
	private LinearLayout mTabFriends;
	private LinearLayout mTabAddress;
	private LinearLayout mTabSettings;
	
	private ImageButton mWeixinImg;
	private ImageButton mFriendsImg;
	private ImageButton mAddressImg;
	private ImageButton mSettingsImg;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        initView();
        initEvent();
    }

	private void initEvent() {
		// 设置事件
		mTabAddress.setOnClickListener(this);
		mTabFriends.setOnClickListener(this);
		mTabSettings.setOnClickListener(this);
		mTabWeixin.setOnClickListener(this);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			//ViewPager 改变时改变图标的颜色
			@Override
			public void onPageSelected(int arg0) {
				int currentItem = viewPager.getCurrentItem();
				resetImg();
				switch (currentItem) {
				case 0:
					mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
					break;
				case 1:
					mFriendsImg.setImageResource(R.drawable.tab_find_frd_pressed);
					break;
				case 2:
					mAddressImg.setImageResource(R.drawable.tab_address_pressed);
					break;
				case 3:
					mSettingsImg.setImageResource(R.drawable.tab_settings_pressed);
					break;

				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
	}

	private void initView() {
		viewPager = (ViewPager)findViewById(R.id.viewpager);
		
		mTabWeixin = (LinearLayout)findViewById(R.id.id_tab_chat);
		mTabAddress = (LinearLayout)findViewById(R.id.id_tab_address);
		mTabFriends = (LinearLayout)findViewById(R.id.id_tab_friend);
		mTabSettings = (LinearLayout)findViewById(R.id.id_tab_settings);
		
		mWeixinImg = (ImageButton)findViewById(R.id.id_tab_chat_btn);
		mFriendsImg = (ImageButton)findViewById(R.id.id_tab_friend_btn);
		mAddressImg = (ImageButton)findViewById(R.id.id_tab_address_btn);
		mSettingsImg = (ImageButton)findViewById(R.id.id_tab_settings_btn);
		
		LayoutInflater inflater = LayoutInflater.from(this);
		View tab01 = inflater.inflate(R.layout.tab01, null);
		View tab02 = inflater.inflate(R.layout.tab02, null);
		View tab03 = inflater.inflate(R.layout.tab03, null);
		View tab04 = inflater.inflate(R.layout.tab04, null);
		
		mViews.add(tab01);
		mViews.add(tab02);
		mViews.add(tab03);
		mViews.add(tab04);
		//创建ViewPager的 PageAdapter
		adapter = new PagerAdapter() {
			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				// 销毁View
				container.removeView(mViews.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// 初始化View
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				return mViews.size();
			}
		};
		viewPager.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		// 点击底部按钮时切换页面并改变图标颜色
		switch (v.getId()) {
		case R.id.id_tab_chat:
			viewPager.setCurrentItem(0);
			mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case R.id.id_tab_friend:
			viewPager.setCurrentItem(1);
			mFriendsImg.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case R.id.id_tab_address:
			viewPager.setCurrentItem(2);
			mAddressImg.setImageResource(R.drawable.tab_address_pressed);
			break;
		case R.id.id_tab_settings:
			viewPager.setCurrentItem(3);
			mSettingsImg.setImageResource(R.drawable.tab_settings_pressed);
			break;
		default:
			break;
		}
	}
	//将所有的图片都变暗
	private void resetImg(){
		mWeixinImg.setImageResource(R.drawable.tab_weixin_normal);
		mAddressImg.setImageResource(R.drawable.tab_address_normal);
		mFriendsImg.setImageResource(R.drawable.tab_find_frd_normal);
		mSettingsImg.setImageResource(R.drawable.tab_settings_normal);
	}
}
