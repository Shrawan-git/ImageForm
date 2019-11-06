package com.digitalorder.imageform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.digitalorder.imageform.adapter.ContactAdapter;
import com.digitalorder.imageform.model.Contacts;
import com.digitalorder.imageform.adapter.ContactAdapter;
import com.digitalorder.imageform.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText tvname, tvage;
    RadioButton rbf, rbm;
    RadioGroup radioGroup;
    Spinner spinnerimg;
    RecyclerView viewR;
    Button btnsave;
    String gender, name, age;
    int imageptn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvname = findViewById(R.id.txtname);
        tvage = findViewById(R.id.txtage);
        rbf = findViewById(R.id.rbf);
        rbm = findViewById(R.id.rbm);
        spinnerimg = findViewById(R.id.spinimg);
        viewR = findViewById(R.id.recycleV);
        btnsave = findViewById(R.id.btnsave);
        radioGroup = findViewById(R.id.genderG);
        final List<Contacts> detailcls = new ArrayList<>();
        final int[] title = {   //Images stored in Array
                (R.drawable.bridge),
                (R.drawable.logo),
                (R.drawable.rose),
                (R.drawable.noimage),

        };
        final String[] titlename = { //Array to show in spinner
                "",
                "bridge",
                "logo",
                "rose",
                "noimage",

        };
        ArrayAdapter<String> imgtitle = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, titlename);
        spinnerimg.setAdapter(imgtitle); //titlename to show in spinner

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validation
                if (!tvname.getText().toString().isEmpty()) {

                    name = tvname.getText().toString();

                    try {
                        int selectgender = radioGroup.getCheckedRadioButtonId();
                        RadioButton radioButton = findViewById(selectgender);
                        gender = radioButton.getText().toString();
                        if (!tvage.getText().toString().isEmpty()) {
                            age = (tvage.getText().toString());
                            int position = (spinnerimg.getSelectedItemPosition());
                            if (position != 0) {
                                //If position is 0 for select image then
                                imageptn = title[position - 1];
                                detailcls.add(new Contacts(name, age, gender, imageptn));
                                ContactAdapter contactAdapter = new ContactAdapter(MainActivity.this, detailcls);
                                viewR.setAdapter(contactAdapter);
                                viewR.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                Toast.makeText(MainActivity.this, "Save Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Please Select image", Toast.LENGTH_SHORT).show();

                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter age", Toast.LENGTH_SHORT).show();

                        }
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Please Select Gender", Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(MainActivity.this, "Please Enter name", Toast.LENGTH_SHORT).show();

                }

            }

        });


    }


}
