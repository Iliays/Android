package com.hfad.guide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainList = findViewById(R.id.main_list);

        String[] titleCategory = getResources().getStringArray(R.array.title_category);
        String[] descriptionCategory = getResources().getStringArray(R.array.description_category);
        int[] imagesCategory = {R.drawable.main_theater, R.drawable.main_museum, R.drawable.main_onsen};

        //Адаптер для listView
        MyAdapter adapter = new MyAdapter(this, titleCategory, descriptionCategory, imagesCategory);
        mainList.setAdapter(adapter);

        //Обработчик для listView
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            Intent intent = new Intent(MainActivity.this, TheatersActivity.class);
                            startActivity(intent);
                        }
                        if (position == 1) {
                            Intent intent = new Intent(MainActivity.this, MuseumActivity.class);
                            startActivity(intent);
                        }
                        if (position == 2) {
                            Intent intent = new Intent(MainActivity.this, OnsenActivity.class);
                            startActivity(intent);
                        }
                    }
                };

        // Добавление обработчика к списковому представлению
        mainList.setOnItemClickListener(itemClickListener);
    }

    //Создания своего класса адаптера
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] titles;
        String[] descriptions;
        int[] images;

        MyAdapter(Context c, String[] title, String[] description, int[] image) {
            super(c, R.layout.custom_list_view, R.id.title_category, title);
            this.context = c;
            this.titles = title;
            this.descriptions = description;
            this.images = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row_style = layoutInflater.inflate(R.layout.custom_list_view, parent, false);
            ImageView image = row_style.findViewById(R.id.image_category);
            TextView textTitle = row_style.findViewById(R.id.title_category);
            TextView textDescription = row_style.findViewById(R.id.descriptions_category);

            image.setImageResource(images[position]);
            textTitle.setText(titles[position]);
            textDescription.setText(descriptions[position]);

            return row_style;
        }
    }
}
