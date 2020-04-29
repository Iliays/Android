package one.fun.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConfirnOrderActivity extends AppCompatActivity {

    EditText numberCard;
    EditText yearCard;
    EditText cvcCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirn_order);

        numberCard = findViewById(R.id.numberCard);
        yearCard = findViewById(R.id.yearCard);
        cvcCard = findViewById(R.id.cvcCard);
    }

    public void clickDownload(View view) {
        if (numberCard.getText().length() > 0 && yearCard.getText().length() > 0
                && cvcCard.getText().length() > 0){
            String name = getIntent().getStringExtra("nameSong");
            Toast.makeText(this, name + " - куплена", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
