package one.fun.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MusicLibraryItem> musicLibraryItems = new ArrayList<>();

        musicLibraryItems.add(new MusicLibraryItem(R.drawable.key,
                Utils.ITS_MY_LIFE.replace("_", " "),
                Utils.AUTHOR_ITS_MY_LIFE));
        musicLibraryItems.add(new MusicLibraryItem(R.drawable.key,
                Utils.LUCKY_STRIKE.replace("_", " "),
                Utils.AUTHOR_LUCKY_STRIKE));
        musicLibraryItems.add(new MusicLibraryItem(R.drawable.key,
                Utils.AUGUST.replace("_", " "),
                Utils.AUTHOR_AUGUST));
        musicLibraryItems.add(new MusicLibraryItem(R.drawable.key,
                Utils.SKILLET_HERO.replace("_", " "),
                Utils.AUTHOR_SKILLET_HERO));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new MusicLibraryAdapter(musicLibraryItems, this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }


}
