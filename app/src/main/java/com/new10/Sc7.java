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

public class Sc7 extends Activity {

	TextView tv1,tv2,tv3;
	Button submit,next;
	RadioGroup rg;
	RadioButton rb1,rb2,rb3,rb4;
	String x ="",y="",n="";
	int a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sc7);
		
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
		String s="Q7 - Ethane have how many covalent bonds ?";
		tv1.setText(s);
		rb1.setText("4");
		rb2.setText("5");
		rb3.setText("6");
		rb4.setText("7");
		submit.setText("Submit");
		next.setText("Next");
		Bundle extra=getIntent().getExtras();
		if(extra!=null)
		{
			x=extra.getString("key");
			n=extra.getString("name");
		}
		
		a=Integer.parseInt(x);

		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(rb1.isChecked())
				{
					Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
					
				}
				if(rb2.isChecked())
				{
					Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();

				}
				if(rb3.isChecked())
				{
					Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();

				}
				if(rb4.isChecked())
				{
					Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT).show();
					a++;
					Animation a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadefast);   
					
					rb4.setTextColor(Color.GREEN);
					rb4.startAnimation(a);
					next.setTextColor(Color.GREEN);
					next.startAnimation(a);
				}

			}
		});
		
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i=new Intent(getApplicationContext(), Sc8.class);
				Bundle extra=new Bundle();
				y=Integer.toString(a);				
				extra.putString("key", y);
				extra.putString("name", n);
				i.putExtras(extra);
				startActivity(i);
			}
		});
		
	}
}
