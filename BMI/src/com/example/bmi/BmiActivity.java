package com.example.bmi;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class BmiActivity extends Activity {
	Button calculateButton;
	Button resetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        
        
        calculateButton = (Button) findViewById(R.id.calculateButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        
        resetButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View view) {
		if(view == resetButton){
			EditText inWeigth = (EditText) findViewById(R.id.weight);
			inWeigth.setText("");
			EditText inHeight = (EditText) findViewById(R.id.length);
			inHeight.setText("");
			
			TextView result = (TextView) findViewById(R.id.result);
			result.setText(Float.toString(0));
			
			TextView message = (TextView) findViewById(R.id.message);
			message.setText("");
			
		}
        	}
        }); 
        calculateButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				String funnyMessage = "";
				
				if(view == calculateButton){
					Calculate calc = new Calculate();
					EditText inWeigth = (EditText) findViewById(R.id.weight);
					EditText inHeight = (EditText) findViewById(R.id.length);
					
					int weigth = Integer.parseInt(inWeigth.getText().toString());
					int height = Integer.parseInt(inHeight.getText().toString());
					float bmi = calc.convert(weigth, height);
					
					if(bmi > 30){
						funnyMessage = "No more cake for you!";
					}
					if(bmi <= 18){
						funnyMessage = "More cake for you!";
					}
					if(bmi > 18 && bmi <= 25){
						funnyMessage = "You're normal!";
					}
					if(bmi > 25 && bmi < 30){
						funnyMessage = "You're getting fat!";
					}
					
					TextView result = (TextView) findViewById(R.id.result);
					result.setText(Float.toString(bmi));
					
					TextView message = (TextView) findViewById(R.id.message);
					message.setText(funnyMessage);
					
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
