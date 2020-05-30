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

public class TheatersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theaters);

        ListView attractionsList = findViewById(R.id.theaters_list);

        String[] attractionsTitle = getResources().getStringArray(R.array.theatres_title);
        String[] attractionsDescription = getResources().getStringArray(R.array.theatres_description);
        String[] attractionsAddress = getResources().getStringArray(R.array.theatres_address);
        int[] attractionsImages = {R.drawable.theater1, R.drawable.theater2, R.drawable.theater3};

        MyAdapter adapter = new MyAdapter(
                this, attractionsTitle, attractionsDescription, attractionsAddress, attractionsImages);
        attractionsList.setAdapter(adapter);
    }

    //Создания своего класса адаптера
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] titles;
        String[] descriptions;
        String[] addresses;
        int[] images;

        MyAdapter(Context c, String[] title, String[] description, String[] address, int[] image) {
            super(c, R.layout.theater_list_custom, R.id.title_attractions, title);
            this.context = c;
            this.titles = title;
            this.descriptions = description;
            this.addresses = address;
            this.images = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row_style = layoutInflater.inflate(R.layout.theater_list_custom, parent, false);
            ImageView image = row_style.findViewById(R.id.image_attractions);
            TextView textTitle = row_style.findViewById(R.id.title_attractions);
            TextView textDescription = row_style.findViewById(R.id.descriptions_attractions);
            TextView textAddress = row_style.findViewById(R.id.address_attractions);

            image.setImageResource(images[position]);
            textTitle.setText(titles[position]);
            textDescription.setText(descriptions[position]);
            textAddress.setText(addresses[position]);

            return row_style;
        }
    }
}
