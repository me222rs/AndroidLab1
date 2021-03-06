package com.example.allapplications;



import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ColorDisplay extends Activity {
	Button displayColor;
	String errorMessage = "";
	int color;
	TextView background;
	Integer red;
	Integer blue;
	Integer green;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_display);
        

       background = (TextView) findViewById(R.id.background);
       displayColor = (Button) findViewById(R.id.displayColor);
        
        displayColor.setOnClickListener(new OnClickListener() {
        	public void onClick(View view) {
		if(view == displayColor){
			
			try{
			
			EditText redInput = (EditText) findViewById(R.id.red);
			EditText blueInput = (EditText) findViewById(R.id.blue);
			EditText greenInput = (EditText) findViewById(R.id.green);
			
			red = Integer.parseInt(redInput.getText().toString());
			blue = Integer.parseInt(blueInput.getText().toString());
			green = Integer.parseInt(greenInput.getText().toString());
			
			color = Color.rgb(red, green, blue);
			
			if(red > 255|| blue > 255 || green > 255){
				Toast.makeText(ColorDisplay.this, "The primary colors must have a value between 1-255",	Toast.LENGTH_SHORT).show();
			}

			else{
			//TextView color = (TextView) findViewById(R.id.background);
			background.setBackgroundColor(color);
			}
			}catch(NumberFormatException e){
				
			}
		}
        	}
        }); 
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.color_display, menu);
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
	  savedInstanceState.putInt("Color", color);
	}
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
	  super.onRestoreInstanceState(savedInstanceState);
	  // Restore state from savedInstanceState
	  int myString = savedInstanceState.getInt("Color");
 	  background.setBackgroundColor(myString);
	}
}
