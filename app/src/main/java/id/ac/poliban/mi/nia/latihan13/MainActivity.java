package id.ac.poliban.mi.nia.latihan13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edLastName = findViewById(R.id.edLastName);
        EditText edFirstName = findViewById(R.id.edFirstName);
        Button btLoad = findViewById(R.id.btLoad);
        Button btSave = findViewById(R.id.btSave);

        btLoad.setOnClickListener(v -> startActivity(new Intent(this, SecondActivity.class)));
        btSave.setOnClickListener(v -> {
            String file = "nia";
            SharedPreferences sp = getSharedPreferences(file, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            String lname = edLastName.getText().toString();
            String fname = edFirstName.getText().toString();

            editor.putString("lname", lname);
            editor.putString("fname", fname);
            editor.apply();

            Toast.makeText(this, "Saved it", Toast.LENGTH_SHORT).show();
        });
    }
}
