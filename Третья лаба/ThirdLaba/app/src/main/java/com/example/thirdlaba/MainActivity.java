package com.example.thirdlaba;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Switch switcher;

    EditText editTexName;
    EditText editTextPhone;
    EditText editTextEmailAddress;
    EditText editTextCardNumber;
    EditText editTextCviCard;

    Button payButton;

    Pizza pizza;
    TextView total;
    double total_price;
    String name_Pay;
    String name_Size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        payButton = findViewById(R.id.buttonPay);

        pizza = new Pizza();
        total = findViewById(R.id.total);

        editTexName = findViewById(R.id.name);
        editTextPhone = findViewById(R.id.phone);

        editTextCardNumber = findViewById(R.id.numberCard);
        editTextCviCard = findViewById(R.id.cviCard);

        switcher = findViewById(R.id.switcherButton);
        editTextEmailAddress = findViewById(R.id.emailAddress);

        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    editTextEmailAddress.setEnabled(true);
                }else{
                    editTextEmailAddress.setEnabled(false);
                }
            }
        });

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.payment, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        name_Pay = text;
        if(text.equals("Банковская карта")){
            editTextCardNumber.setEnabled(true);
            editTextCviCard.setEnabled(true);
            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }
        else{
            editTextCardNumber.setEnabled(false);
            editTextCviCard.setEnabled(false);
            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void payOrder(View view) {

        if(total_price == 0 || total_price == 100 || total_price == 150 || total_price == 200){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Внимание");
                alert.setMessage("Вы не выбрали наполнитель или размер пиццы!");
                alert.setPositiveButton("Окей", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Продолжайте покупку", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.create().show();
        }
        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Заказ принят");
                alert.setMessage("Оплата: " + name_Pay + "\nРазмер пиццы: " + name_Size + "\nИтого сумма заказа: " + total_price);
                alert.setPositiveButton("Окей", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Спасибо что выбираете нас !!!", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.create().show();
        }
    }

    public void radioClicked(View view) {


        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rb1:
                if(checked)
                    pizza.setPizza_size_price(100);
                name_Size = "маленький";
                break;
            case R.id.rb2:
                if(checked)
                    pizza.setPizza_size_price(150);
                name_Size = "средний";
                break;
            case R.id.rb3:
                if(checked)
                    pizza.setPizza_size_price(200);
                name_Size = "большой";
                break;
        }

        total.setText(calculate_total() + " рублей");
    }

    public void checkboxClicked(View view) {


        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.cb1:
                if(checked)
                    pizza.setGrib_price(30);
                else
                    pizza.setGrib_price(0);
                break;
            case R.id.cb2:
                if(checked)
                    pizza.setKolbasa_price(40);
                else
                    pizza.setKolbasa_price(0);
                break;
            case R.id.cb3:
                if(checked)
                    pizza.setSalami_price(55);
                else
                    pizza.setSalami_price(0);
                break;
            case R.id.cb4:
                if(checked)
                    pizza.setAnanas_price(35);
                else
                    pizza.setAnanas_price(0);
                break;
        }
        total.setText(calculate_total() + " рублей");
    }


    private double calculate_total(){

        total_price = pizza.getPizza_size_price() + pizza.getGrib_price() + pizza.getKolbasa_price() + pizza.getSalami_price() + pizza.getAnanas_price();
        return total_price;

    }

}
