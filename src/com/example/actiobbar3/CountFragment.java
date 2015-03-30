package com.example.actiobbar3;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
/***
 * Fragment 是android3.0
 * 推出的一个程序片段(对象)
 * 此对象的生命周期依赖于
 * Activity对象
 * 
 * @author tarena
 *
 */
public class CountFragment extends Fragment{
	LinearLayout  ll_zhengge,ll_item3,ll_addView;//总体的inelayout
	RelativeLayout rl_image;//图片的布局
	TextView  tv_add,tv_del,tv_date;
	LinearLayout  ll_date;
	ImageView image;
	private View view;
	boolean isExpander=true;
	boolean isExpander1=true;
	private ArrayList<View> mlist;
	public View onCreateView(final LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		 view = inflater.inflate(R.layout.child_add_rate_basis, container, false);
		 mlist=new ArrayList<View>();
			ll_zhengge=(LinearLayout) view.findViewById(R.id.ll_zhengge);
			ll_item3=(LinearLayout) view.findViewById(R.id.ll_item3);
			ll_addView=(LinearLayout) view.findViewById(R.id.lin_add_forward_price);
			rl_image=(RelativeLayout) view.findViewById(R.id.rl_image);
			tv_add=(TextView)view .findViewById(R.id.tv_add);
			tv_del=(TextView)view.findViewById(R.id.tv_delete);
			image=(ImageView) view.findViewById(R.id.imageView1);
			tv_date=(TextView) view.findViewById(R.id.tv_forward_current_date);
			ll_date=(LinearLayout)view.findViewById(R.id.ll_date);
			mlist.add(view);
			tv_date.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(getActivity(), "hello", 0).show();
					
				}
			});
			tv_add.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					image.setImageResource(R.drawable.a);
					View view1 =inflater.inflate(R.layout.child_add_rate, null);
					ImageView  ima=(ImageView)view1.findViewById(R.id.imageView2);
				     ima.setImageResource(R.drawable.b);
					tv_del.setVisibility(View.VISIBLE);
					// 关闭当前的3个item，消失
					ll_addView.addView(view1);
					closeLastView(view1);
					mlist.add(view1);
					 final ImageView im=(ImageView) view1.findViewById(R.id.imageView2);
					final LinearLayout lla1=(LinearLayout)view1.findViewById(R.id.ll_item3);
					TextView tvdate=(TextView) view1.findViewById(R.id.tv_data);
					tvdate.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							Toast.makeText(getActivity(), "......", 0).show();
						}
					});
					im.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							if(isExpander1){
								im.setImageDrawable(getResources().getDrawable(R.drawable.a));
								//im.setImageResource(R.drawable.a);
								lla1.setVisibility(View.GONE);
								isExpander1=false;
							}else{
								im.setImageDrawable(getResources().getDrawable(R.drawable.b));
								//im.setImageResource(R.drawable.b);
								lla1.setVisibility(View.VISIBLE);
								isExpander1=true;
							}
							}
						});
				}
			});
		  image.setOnClickListener(new OnClickListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				//isExpander=(Boolean) v.getTag();
				if(isExpander){
					image.setImageResource(R.drawable.a);;
					ll_item3.setVisibility(View.GONE);
					isExpander=false;
				}else{
					image.setImageResource(R.drawable.b);
					ll_item3.setVisibility(View.VISIBLE);
					isExpander=true;
				}
				
			}
		});
			
			tv_del.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					image.setImageResource(R.drawable.a);
					ll_item3.setVisibility(View.GONE);
					tv_del.setVisibility(View.VISIBLE);
					deleteLastView(tv_del);
				}
			});
			return view;
	}
	protected void deleteLastView(View tv_del) {
		try {
			View view1 = mlist.get(mlist.size()-1 );
			
			ll_addView.removeView(view1);
			mlist.remove(view1);
			if(mlist.size()==1){
				//mLinAddForwardPrice.removeAllViews();
				LinearLayout  lls=(LinearLayout) view1.findViewById(R.id.ll_item3);
				ImageView  mi=(ImageView) view1.findViewById(R.id.imageView1);
				tv_del.setVisibility(View.GONE);
				ll_item3.setVisibility(View.VISIBLE);
				image.setImageDrawable(getResources().getDrawable(R.drawable.b));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected void closeLastView(View view2) {
		for (int i = 0; i < mlist.size(); i++) {
			try {
			View view =mlist.get(i);
			ImageView  image1=(ImageView) view.findViewById(R.id.imageView2);
				LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.ll_item3);
				image1.setImageResource(R.drawable.a);
				linearLayout.setVisibility(View.GONE);
				//xie1.12
				/*if(mlist.size()==1){
					image.setImageResource(R.drawable.b);
					ll_item3.setVisibility(View.VISIBLE);
					
				}*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
