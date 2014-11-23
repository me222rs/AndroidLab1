package com.example.allapplications;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class RandomActivity extends Activity {

	private int randomInt;
	private TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        
        
        
    }
    
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        Button button = (Button) findViewById(R.id.randomizeButton);
        
        button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Random r = new Random();
				randomInt = r.nextInt(100) + 1;
				//String strI = Integer.toString(randomInt);
				
				 t = (TextView)findViewById(R.id.randomText);
				 String s = Integer.toString(randomInt);
				 t.setText(s);
				
				//Toast.makeText(MainActivity.this, strI,	Toast.LENGTH_SHORT).show();
			}

		});
        
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
    
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
	  super.onSaveInstanceState(savedInstanceState);
	  // Save state to the savedInstanceState
	  savedInstanceState.putInt("randomInt", randomInt);
	}
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
	  super.onRestoreInstanceState(savedInstanceState);
	  // Restore state from savedInstanceState
	  int myString = savedInstanceState.getInt("randomInt");
	  t.setText(myString);
	}
}
