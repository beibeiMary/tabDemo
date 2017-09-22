package com.example.tab04;

import android.R.integer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment extends Fragment{
	int pos;
	public TabFragment(int pos){
		this.pos = pos;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag, container,false);
		TextView tView = (TextView) view.findViewById(R.id.tv);
		tView.setText(TabAdapter.TITLES[pos]);
		return view;
	}
	
}
