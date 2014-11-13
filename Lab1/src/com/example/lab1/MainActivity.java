package com.example.lab1;

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


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
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
				int randomInt = r.nextInt(100) + 1;
				//String strI = Integer.toString(randomInt);
				
				TextView t = (TextView)findViewById(R.id.randomText);
				t.setText(Integer.toString(randomInt));
				
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
}
