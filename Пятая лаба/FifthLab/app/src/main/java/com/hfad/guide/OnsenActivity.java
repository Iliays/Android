package com.hfad.guide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class OnsenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onsen);

        ListView restaurantList = findViewById(R.id.restaurant_list);

        String[] restaurantTitle = getResources().getStringArray(R.array.onsen_title);
        String[] restaurantDescription = getResources().getStringArray(R.array.onsen_description);
        String[] restaurantAddress = getResources().getStringArray(R.array.onsen_address);
        String[] restaurantTimeWork = getResources().getStringArray(R.array.onsen_time_work);
        String[] restaurantRating = getResources().getStringArray(R.array.onsen_rating);
        int[] restaurantImages = {R.drawable.onsen1, R.drawable.onsen2, R.drawable.onsen3};

        MyAdapter adapter = new MyAdapter(
                this, restaurantTitle, restaurantDescription,
                restaurantAddress, restaurantTimeWork, restaurantRating, restaurantImages);
        restaurantList.setAdapter(adapter);
    }

    //Создания своего класса адаптера
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] titles;
        String[] descriptions;
        String[] addresses;
        String[] timeWorks;
        String[] ratings;
        int[] images;

        MyAdapter(Context c, String[] title, String[] description, String[] address,
                  String[] timeWork, String[] rating, int[] image) {
            super(c, R.layout.onsen_custom_list, R.id.title_restaurant, title);
            this.context = c;
            this.titles = title;
            this.descriptions = description;
            this.addresses = address;
            this.timeWorks = timeWork;
            this.ratings = rating;
            this.images = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row_style = layoutInflater.inflate(R.layout.onsen_custom_list, parent, false);
            ImageView image = row_style.findViewById(R.id.image_restaurant);
            TextView textTitle = row_style.findViewById(R.id.title_restaurant);
            TextView textDescription = row_style.findViewById(R.id.descriptions_restaurant);
            TextView textAddress = row_style.findViewById(R.id.address_restaurant);
            TextView textTimeWork = row_style.findViewById(R.id.time_work_restaurant);
            TextView textRating = row_style.findViewById(R.id.rating);

            image.setImageResource(images[position]);
            textTitle.setText(titles[position]);
            textDescription.setText(descriptions[position]);
            textAddress.setText(addresses[position]);
            textTimeWork.setText(timeWorks[position]);
            textRating.setText(ratings[position]);

            return row_style;
        }
    }
}
