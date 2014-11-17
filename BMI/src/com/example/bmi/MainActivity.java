package com.example.bmi;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	Button calculateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				if(view == calculateButton){
					Calculate calc = new Calculate();
					EditText inWeigth = (EditText) findViewById(R.id.weight);
					EditText inHeight = (EditText) findViewById(R.id.length);
					
					int weigth = Integer.parseInt(inWeigth.getText().toString());
					int height = Integer.parseInt(inHeight.getText().toString());
					float bmi = calc.convert(weigth, height);
					
					TextView result = (TextView) findViewById(R.id.result);
					result.setText(Float.toString(bmi));
					//String s = Float.toString(bmi);
					//Toast.makeText(MainActivity.this, bmi,	Toast.LENGTH_SHORT).show();
				}
			
				
				
			}

		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
