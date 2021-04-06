package umn.ac.id.week08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnTutor1, btnTutor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTutor1 = findViewById(R.id.btnTutorial1);
        btnTutor2 = findViewById(R.id.btnTutorial2);

        btnTutor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTutor1();
            }
        });

        btnTutor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTutor2();
            }
        });
        
    }
    private void openTutor1() {
        Intent intent = new Intent(this, Tutorial1.class);
        startActivity(intent);

    }

    private void openTutor2() {
        Intent intent = new Intent(this, Tutorial2.class);
        startActivity(intent);
    }


}