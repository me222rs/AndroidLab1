package com.example.allapplications;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VaxjoWeatherAdapter extends ArrayAdapter {
	private List<WeatherForecast> values;
	private Context context;
	
	
	
	public VaxjoWeatherAdapter(Context context, List<WeatherForecast> list) {
		super(context, R.layout.weatheradapterview, list);
		this.context = context;
		this.values = list;
	}
	
	//http://stackoverflow.com/questions/10120119/how-does-the-getview-method-work-when-creating-your-own-custom-adapter
	//http://stackoverflow.com/questions/25381435/unconditional-layout-inflation-from-view-adapter-should-use-view-holder-patter
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		//Get all the TextViews in weatheradapterview
		View view = vi.inflate(R.layout.weatheradapterview, parent, false);
		TextView textView = (TextView) view.findViewById(R.id.weather);
		TextView rain = (TextView) view.findViewById(R.id.rain);
		TextView endDate = (TextView) view.findViewById(R.id.endDate);
		TextView temperature = (TextView) view.findViewById(R.id.temperature);
		TextView wind = (TextView) view.findViewById(R.id.wind);
		TextView startDate = (TextView) view.findViewById(R.id.startDate);
		ImageView image = (ImageView) view.findViewById(R.id.weatherImage);
		
		//Set the values of the TextViews
		WeatherForecast weatherForecast = values.get(position);
		//Name of the weather
		textView.setText(weatherForecast.getWeatherName());
		//Date
		startDate.setText("Fra: " + weatherForecast.getStartYYMMDD() + " " + weatherForecast.getStartHHMM());
		endDate.setText("Til: " + weatherForecast.getEndYYMMDD() + " " + weatherForecast.getEndHHMM());
		//Temperature
		temperature.setText(String.valueOf(weatherForecast.getTemp() + "�C"));
		//Rain
		rain.setText(String.valueOf("Regn: " + weatherForecast.getRain() + "mm"));
		//Wind
		wind.setText(String.valueOf("Vind: " + weatherForecast.getWindSpeed() + "m/s"));		
		
		// Here should the different pictures be shown i some way
		//I used only the most common weathers (image 1-15 on the web page)
		//I put them in the same order as they were on the web page in the switch statement and it seems they show the right weather
		
		switch (weatherForecast.getWeatherCode()) {
	        case 1:
				image.setImageResource(R.drawable.img1);
				break;
		    case 2:
		    	image.setImageResource(R.drawable.img2);
				break;
		    case 3:
		    	image.setImageResource(R.drawable.img3);
				break;
		    case 4:
		    	image.setImageResource(R.drawable.img4);
				break;
		    case 5:
		    	image.setImageResource(R.drawable.img5);
				break;
		    case 6:
		    	image.setImageResource(R.drawable.img6);
				break;
		    case 7:
		    	image.setImageResource(R.drawable.img7);
				break;
		    case 8:
		    	image.setImageResource(R.drawable.img8);
				break;
		    case 9:
		    	image.setImageResource(R.drawable.img9);
				break;
		    case 10:
		    	image.setImageResource(R.drawable.img10);
				break;
		    case 11:
		    	image.setImageResource(R.drawable.img11);
				break;
		    case 12:
		    	image.setImageResource(R.drawable.img12);
				break;
		    case 13:
		    	image.setImageResource(R.drawable.img13);
				break;
		    case 14:
		    	image.setImageResource(R.drawable.img14);
				break;
		    case 15:
		    	image.setImageResource(R.drawable.img15);
	            break;
		}
 
		return view;
	}
}
