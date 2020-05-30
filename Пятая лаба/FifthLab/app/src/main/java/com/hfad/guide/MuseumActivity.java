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

public class MuseumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);

        ListView museumList = findViewById(R.id.museum_list);

        String[] museumTitle = getResources().getStringArray(R.array.museum_title);
        String[] museumDescription = getResources().getStringArray(R.array.museum_description);
        String[] museumAddress = getResources().getStringArray(R.array.museum_address);
        String[] museumTimeWork= getResources().getStringArray(R.array.museum_time_work);
        int[] museumImages = {R.drawable.museum1, R.drawable.museum2, R.drawable.museum3};

        MyAdapter adapter = new MyAdapter(
                this, museumTitle, museumDescription, museumAddress, museumTimeWork, museumImages);
        museumList.setAdapter(adapter);
    }

    //Создания своего класса адаптера
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] titles;
        String[] descriptions;
        String[] addresses;
        String[] timeWorks;
        int[] images;

        MyAdapter(Context c, String[] title, String[] description, String[] address, String[] timeWork, int[] image) {
            super(c, R.layout.museum_custom_list, R.id.title_museum, title);
            this.context = c;
            this.titles = title;
            this.descriptions = description;
            this.addresses = address;
            this.timeWorks = timeWork;
            this.images = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row_style = layoutInflater.inflate(R.layout.museum_custom_list, parent, false);
            ImageView image = row_style.findViewById(R.id.image_museum);
            TextView textTitle = row_style.findViewById(R.id.title_museum);
            TextView textDescription = row_style.findViewById(R.id.descriptions_museum);
            TextView textAddress = row_style.findViewById(R.id.address_museum);
            TextView textTimeWork = row_style.findViewById(R.id.time_work_museum);

            image.setImageResource(images[position]);
            textTitle.setText(titles[position]);
            textDescription.setText(descriptions[position]);
            textAddress.setText(addresses[position]);
            textTimeWork.setText(timeWorks[position]);

            return row_style;
        }
    }
}
