package com.example.tab02;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends FragmentActivity implements OnClickListener{
	private LinearLayout mTabWeixin;
	private LinearLayout mTabFriends;
	private LinearLayout mTabAddress;
	private LinearLayout mTabSettings;
	
	private ImageButton mWeixinImg;
	private ImageButton mFriendsImg;
	private ImageButton mAddressImg;
	private ImageButton mSettingsImg;
	
	private Fragment tab001;
	private Fragment tab002;
	private Fragment tab003;
	private Fragment tab004;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }
    private void initView() {
		
		mTabWeixin = (LinearLayout)findViewById(R.id.id_tab_chat);
		mTabAddress = (LinearLayout)findViewById(R.id.id_tab_address);
		mTabFriends = (LinearLayout)findViewById(R.id.id_tab_friend);
		mTabSettings = (LinearLayout)findViewById(R.id.id_tab_settings);
		
		mWeixinImg = (ImageButton)findViewById(R.id.id_tab_chat_btn);
		mFriendsImg = (ImageButton)findViewById(R.id.id_tab_friend_btn);
		mAddressImg = (ImageButton)findViewById(R.id.id_tab_address_btn);
		mSettingsImg = (ImageButton)findViewById(R.id.id_tab_settings_btn);
		//设置默认选中第0页
		setSelect(0);
	}
	private void initEvent() {
		// 设置事件
		mTabAddress.setOnClickListener(this);
		mTabFriends.setOnClickListener(this);
		mTabSettings.setOnClickListener(this);
		mTabWeixin.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		//点击是默认所有图片都变暗
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
	//设置选中第几页，使用FragmentManager进行控制
	private void setSelect(int i){
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		hideFragment(transaction);
		//改变内容区域，把图片设置为亮的
		switch (i) {
		case 0:
			if(tab001 == null){
				tab001 = new WeixinFragment();
				//添加Fragment到 container
				transaction.add(R.id.container, tab001);
			}else{
				//显示Fragment
				transaction.show(tab001);
			}
			//更改图片
			mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case 1:
			if(tab002 == null){
				tab002 = new FriendsFragment();
				transaction.add(R.id.container, tab002);
			}else{
				transaction.show(tab002);
			}
			mFriendsImg.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case 2:
			if(tab003 == null){
				tab003 = new AddressFragment();
				transaction.add(R.id.container, tab003);
			}else{
				transaction.show(tab003);
			}
			mAddressImg.setImageResource(R.drawable.tab_address_pressed);
			break;
		case 3:
			if(tab004 == null){
				tab004 = new SettingsFragment();
				transaction.add(R.id.container, tab004);
			}else{
				transaction.show(tab004);
			}
			mSettingsImg.setImageResource(R.drawable.tab_settings_pressed);
			break;

		default:
			break;
		}
		//提交事务
		transaction.commit();
	}
	//隐藏所有的Fragment
	private void hideFragment(FragmentTransaction transaction) {
		if(tab001 != null){
			transaction.hide(tab001);
		}
		if(tab002 != null){
			transaction.hide(tab002);
		}
		if(tab003 != null){
			transaction.hide(tab003);
		}
		if(tab004 != null){
			transaction.hide(tab004);
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
