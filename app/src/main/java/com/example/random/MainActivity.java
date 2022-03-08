package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int rand;

    private EditText startET, endET, countET;
    private Button randomBtn;
    private TextView resultTV;
    private Switch aSwitch;

    boolean switchState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startET = findViewById(R.id.startET);
        endET = findViewById(R.id.endET);
        countET = findViewById(R.id.countET);

        randomBtn = findViewById(R.id.btnRandom);
        resultTV = findViewById(R.id.resultTV);
        aSwitch = findViewById(R.id.swRepeat);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    switchState = true;
                    Toast.makeText(getApplicationContext(), "on", Toast.LENGTH_SHORT).show();
                } else {
                    switchState = false;
                    Toast.makeText(getApplicationContext(), "off", Toast.LENGTH_SHORT).show();
                }
                Log.d("TAG", "switch State:" + switchState);
            }
        });

        //instantiate Random Class
        Random random = new Random();
        randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int start = Integer.parseInt(startET.getText().toString());
                int end = Integer.parseInt(endET.getText().toString());
                int count = Integer.parseInt(countET.getText().toString());

                rand = random.generateRandomInt(start, end);
                String randStr = String.valueOf(rand);
                resultTV.append(randStr + " ");

                if (switchState == true) {
                    final Handler handler = new Handler(Looper.getMainLooper());
                    for (int i = 0; i < count-1; i++) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                rand = random.generateRandomInt(start, end);
                                String randStr = String.valueOf(rand);
                                resultTV.append(randStr + " ");
                            }
                        }, 1000);
                    }
                }
            }
        });

    }
}