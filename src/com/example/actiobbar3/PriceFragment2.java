package com.example.actiobbar3;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
@SuppressLint({ "ValidFragment", "CutPasteId" })
public class PriceFragment2 extends Fragment {
	private LayoutInflater inflater;
	LinearLayout  ll_zhengge,ll_item3,ll_addView;//总体的inelayout
	RelativeLayout rl_image;//图片的布局
	TextView  tv_add,tv_del,tv_date;
	LinearLayout  ll_date;
	ImageView image;
	Button bt_edit,bt_del;
	private View view;
	boolean isExpander=true;
	boolean isExpander1=true;
	private ArrayList<View> mlist;
	private EditText edit;
	private String first;
	private EditText ed1;
	private EditText ed2;
	String testafter;
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
			edit=(EditText)view.findViewById(R.id.et_forward_price);
			TextView  tv=(TextView)view.findViewById(R.id.tv_forward_current_date);
				
			edit.addTextChangedListener(new TextWatcher() {
				
				private String s1;

				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub
					first=edit.getText().toString();
							
				}
			});
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
					final View view1 =inflater.inflate(R.layout.child_add_rate, null);
					ed1=(EditText)view1.findViewById(R.id.et_forward_price);
					tv_del.setVisibility(View.VISIBLE);
					// 关闭当前的3个item，消失
					ll_addView.addView(view1);
					closeLastView(view1);
					mlist.add(view1);
					ed1.addTextChangedListener(new TextWatcher() {
						@Override
						public void onTextChanged(CharSequence s, int start, int before, int count) {
							// TODO Auto-generated method stub
						}
						@Override
						public void beforeTextChanged(CharSequence s, int start, int count,
								int after) {
							// TODO Auto-generated method stub
						}
						@Override
						public void afterTextChanged(Editable s) {
							// TODO Auto-generated method stub
							testafter=ed1.getText().toString();
						}
					});
					ed2=(EditText)mlist.get(mlist.size()-1).findViewById(R.id.et_forward_price);
					ed2.setText(testafter);
					//ed2.setSelection(testafter.length());
					if(mlist.size()==1||mlist.size()==2){
						ed1.setText(first);
					//	ed1.setSelection(first.length());
					}
					final Button btdel=(Button)view1.findViewById(R.id.bt_child_del);
					final RelativeLayout  rl=(RelativeLayout) view1.findViewById(R.id.rl_image_child);
					 final ImageView im=(ImageView) view1.findViewById(R.id.imageView2);
					final LinearLayout lla1=(LinearLayout)view1.findViewById(R.id.ll_item3);
					 im.setImageResource(R.drawable.b);
					TextView tvdate=(TextView) view1.findViewById(R.id.tv_data);
					btdel.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							rl.setVisibility(View.GONE);
							lla1.setVisibility(View.GONE);
						if(mlist.size()==1){
							tv_del.setVisibility(View.GONE);
							image.setImageResource(R.drawable.b);
							ll_item3.setVisibility(View.VISIBLE);
							
						}	
							
						}
					});
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
		  rl_image.setOnClickListener(new OnClickListener() {
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
					//tv_del.setVisibility(View.VISIBLE);
					deleteLastView(tv_del);
					//openLastLView();
				}
			});
			return view;
	}
	protected void openLastLView() {
		for (int i = 0; i < mlist.size(); i++) {
			try {
			View view2 =mlist.get(i);
			ImageView  image12=(ImageView) view2.findViewById(R.id.imageView2);
				LinearLayout linearLayout2 = (LinearLayout)view2.findViewById(R.id.ll_item3);
				image12.setImageResource(R.drawable.b);
				linearLayout2.setVisibility(View.VISIBLE);
			}catch(Exception e){
				}
			}
		
	}
	protected void deleteLastView(View tv_del) {
		try {
			View view1 = mlist.get(mlist.size()-1 );
			
			ll_addView.removeView(view1);
			mlist.remove(view1);
			if(mlist.size()==1){
				//mLinAddForwardPrice.removeAllViews();
				//LinearLayout  lls=(LinearLayout) view1.findViewById(R.id.ll_item3);
				//ImageView  mi=(ImageView) view1.findViewById(R.id.imageView1);
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
					tv_del.setVisibility(View.GONE);
					image.setImageResource(R.drawable.a);
					ll_item3.setVisibility(View.GONE);
					
				}*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	}
