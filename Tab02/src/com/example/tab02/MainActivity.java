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
		//����Ĭ��ѡ�е�0ҳ
		setSelect(0);
	}
	private void initEvent() {
		// �����¼�
		mTabAddress.setOnClickListener(this);
		mTabFriends.setOnClickListener(this);
		mTabSettings.setOnClickListener(this);
		mTabWeixin.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		//�����Ĭ������ͼƬ���䰵
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
	//����ѡ�еڼ�ҳ��ʹ��FragmentManager���п���
	private void setSelect(int i){
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		hideFragment(transaction);
		//�ı��������򣬰�ͼƬ����Ϊ����
		switch (i) {
		case 0:
			if(tab001 == null){
				tab001 = new WeixinFragment();
				//���Fragment�� container
				transaction.add(R.id.container, tab001);
			}else{
				//��ʾFragment
				transaction.show(tab001);
			}
			//����ͼƬ
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
		//�ύ����
		transaction.commit();
	}
	//�������е�Fragment
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
	//�����е�ͼƬ���䰵
	private void resetImg(){
		mWeixinImg.setImageResource(R.drawable.tab_weixin_normal);
		mAddressImg.setImageResource(R.drawable.tab_address_normal);
		mFriendsImg.setImageResource(R.drawable.tab_find_frd_normal);
		mSettingsImg.setImageResource(R.drawable.tab_settings_normal);
	}
}
