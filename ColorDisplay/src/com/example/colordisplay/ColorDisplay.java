package com.example.colordisplay;



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


public class ColorDisplay extends Activity {
	Button displayColor;
	String errorMessage = ""; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_display);

        
       displayColor = (Button) findViewById(R.id.displayColor);
        
        displayColor.setOnClickListener(new OnClickListener() {
        	public void onClick(View view) {
		if(view == displayColor){
			EditText redInput = (EditText) findViewById(R.id.red);
			EditText blueInput = (EditText) findViewById(R.id.blue);
			EditText greenInput = (EditText) findViewById(R.id.green);
			
			int red = Integer.parseInt(redInput.getText().toString());
			int blue = Integer.parseInt(blueInput.getText().toString());
			int green = Integer.parseInt(greenInput.getText().toString());
			
			if(red > 255 || blue > 255 || green > 255){
				errorMessage = "The primary colors can't have a value higher than 255";
				TextView error = (TextView) findViewById(R.id.errorMessage);
				error.setText(errorMessage);
			}

			else{
			//Clear the error message
		    TextView clearError = (TextView) findViewById(R.id.errorMessage);
		    clearError.setText("");
		    //Draw the color
			TextView color = (TextView) findViewById(R.id.background);
			color.setBackgroundColor(Color.rgb(red, green, blue));
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
}
