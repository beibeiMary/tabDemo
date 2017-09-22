package com.example.tab03;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends FragmentActivity implements OnClickListener{
	private ViewPager viewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments = new ArrayList<Fragment>();
	
	private LinearLayout mTabWeixin;
	private LinearLayout mTabFriends;
	private LinearLayout mTabAddress;
	private LinearLayout mTabSettings;
	
	private ImageButton mWeixinImg;
	private ImageButton mFriendsImg;
	private ImageButton mAddressImg;
	private ImageButton mSettingsImg;
	
	Fragment tab001;
	Fragment tab002;
	Fragment tab003;
	Fragment tab004;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }
    
    private void initView() {
		viewPager = (ViewPager)findViewById(R.id.container);
    	
		mTabWeixin = (LinearLayout)findViewById(R.id.id_tab_chat);
		mTabAddress = (LinearLayout)findViewById(R.id.id_tab_address);
		mTabFriends = (LinearLayout)findViewById(R.id.id_tab_friend);
		mTabSettings = (LinearLayout)findViewById(R.id.id_tab_settings);
		
		mWeixinImg = (ImageButton)findViewById(R.id.id_tab_chat_btn);
		mFriendsImg = (ImageButton)findViewById(R.id.id_tab_friend_btn);
		mAddressImg = (ImageButton)findViewById(R.id.id_tab_address_btn);
		mSettingsImg = (ImageButton)findViewById(R.id.id_tab_settings_btn);
		
		tab001 = new WeixinFragment();
		tab002 = new FriendsFragment();
		tab003 = new AddressFragment();
		tab004 = new SettingsFragment();
		
		mFragments.add(tab001);
		mFragments.add(tab002);
		mFragments.add(tab003);
		mFragments.add(tab004);
		
		mAdapter = new FragmentPagerAdapter( getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				return mFragments.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				return mFragments.get(arg0);
			}
		};
		viewPager.setAdapter(mAdapter);
	}
	private void initEvent() {
		// 设置事件
		mTabAddress.setOnClickListener(this);
		mTabFriends.setOnClickListener(this);
		mTabSettings.setOnClickListener(this);
		mTabWeixin.setOnClickListener(this);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				//当前选中的Fragment 下标
				int currentItem = viewPager.getCurrentItem();
				//把图片全设置为暗的
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

	@Override
	public void onClick(View v) {
		resetImg();
		switch (v.getId()) {
		case R.id.id_tab_chat:
			setSelect(0);
			break;
		case R.id.id_tab_friend:
			setSelect(1);
			break;
		case R.id.id_tab_address:
			setSelect(2);
			break;
		case R.id.id_tab_settings:
			setSelect(3);
			break;
		default:
			break;
		}
	}
	private void setSelect(int i){
		//改变内容区域，把图片设置为亮的
		switch (i) {
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
		//切换Fragment
		viewPager.setCurrentItem(i);
	}
	//将所有的图片都变暗
	private void resetImg(){
		mWeixinImg.setImageResource(R.drawable.tab_weixin_normal);
		mAddressImg.setImageResource(R.drawable.tab_address_normal);
		mFriendsImg.setImageResource(R.drawable.tab_find_frd_normal);
		mSettingsImg.setImageResource(R.drawable.tab_settings_normal);
	}
}
