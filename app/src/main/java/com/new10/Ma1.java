package com.new10;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;

public class Ma1 extends Activity {

	TextView tv1,tv2,tv3;
	Button submit,next;
	RadioGroup rg;
	RadioButton rb1,rb2,rb3,rb4;
	int x=0;
	String n="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ma1);
		
		tv1=(TextView) findViewById(R.id.textView1);
		tv2=(TextView) findViewById(R.id.textView2);
		tv3=(TextView) findViewById(R.id.textView3);
		
		rb1=(RadioButton) findViewById(R.id.radio0);
		rb2=(RadioButton) findViewById(R.id.radio1);
		rb3=(RadioButton) findViewById(R.id.radio2);
		rb4=(RadioButton) findViewById(R.id.radio3);
		
		submit=(Button) findViewById(R.id.button1);
		next=(Button) findViewById(R.id.button2);
		
		rg=(RadioGroup) findViewById(R.id.radioGroup1);
		String s="Q1 - State whether the rational number 29/343 is  : ";
		tv1.setText(s);
		rb1.setText("Terminating");
		rb2.setText("Non Terminating Repeating");
		rb3.setText("Non Terminating");
		rb4.setText("Non Terminating Non Repeating");
		submit.setText("Submit");
		next.setText("Next");
		
		
		Bundle extra=getIntent().getExtras();
		if(extra!=null)
		{
			n=extra.getString("name");
		}
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(rb1.isChecked())
				{
					Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
					
				}
				if(rb2.isChecked())
				{

					Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT).show();
					x++;
					Animation a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadefast);   
					
					rb2.setTextColor(Color.GREEN);
					rb2.startAnimation(a);
					next.setTextColor(Color.GREEN);
					next.startAnimation(a);}
				if(rb3.isChecked())
				{
					Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();

				}
				if(rb4.isChecked())
				{
					Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
				
				}

			}
		});
		
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i=new Intent(getApplicationContext(), Ma2.class);
				String	y=Integer.toString(x);
				Bundle extra=new Bundle();
				extra.putString("key", y);
				extra.putString("name", n);
				i.putExtras(extra);
				startActivity(i);

			}
		});
		
	}
}
