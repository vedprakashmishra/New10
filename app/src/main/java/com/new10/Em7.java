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

public class Em7 extends Activity {

	TextView tv1,tv2,tv3;
	Button submit,next;
	RadioGroup rg;
	RadioButton rb1,rb2,rb3,rb4;
	String x ="",y="",n="";
	int a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_em7);
		
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
		String s="Q7 - Use Modals to fill : \n You  ____ see doctor at once.";
		tv1.setText(s);
		rb1.setText("may");
		rb2.setText("shall");
		rb3.setText("can");
		rb4.setText("must");
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
				
				Intent i=new Intent(getApplicationContext(), Em8.class);
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
