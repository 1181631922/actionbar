package com.example.actiobbar3;

import java.util.ArrayList;
import java.util.List;

import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.Window;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class MainActivity extends FragmentActivity {

	FragViewPager fragViewPager;
	ViewPager viewPager;
	private ActionBar actionBar;
	private List<Fragment> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		setViewpager();
		setActionBar();
	}

	@SuppressLint("NewApi")
	private void setActionBar() {
		actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setDisplayShowTitleEnabled(true);
		// actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.a));
		String titles[] = { "成交价", "成交量", "基数" };
		for (int i = 0; i <= titles.length - 1; i++) {
			actionBar.addTab(actionBar.newTab().setText(titles[i])
					.setTabListener(new myTabListener()));

		}
	}

	class myTabListener implements ActionBar.TabListener {

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			int pos = tab.getPosition();
			viewPager.setCurrentItem(pos);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}

	}

	private void setViewpager() {
		data = getData();
		fragViewPager = new FragViewPager(getSupportFragmentManager());
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		viewPager.setAdapter(fragViewPager);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

	}

	class FragViewPager extends FragmentPagerAdapter {

		public FragViewPager(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			return data.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

	}

	private List<Fragment> getData() {
		// TODO Auto-generated method stub
		List<Fragment> list = new ArrayList<Fragment>();
		PriceFragment2 priceFragment = new PriceFragment2();
		CountFragment countFragment = new CountFragment();
		JishuFragment jishuFragment = new JishuFragment();
		list.add(priceFragment);
		list.add(countFragment);
		list.add(jishuFragment);
		return list;
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */
}
