package umn.ac.id.uts_mobile_32082;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    String uname = "uasmobile";
    String pass = "uasmobilegenap";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        getSupportActionBar().setTitle("Login Page");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validate
                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(LoginActivity.this,"Empty Input", Toast.LENGTH_LONG).show();
                }
                else if (username.getText().toString().equals(uname)){
                    //check password
                    if (password.getText().toString().equals(pass)){
                        //change route nanti
                        //sekarang masih toast
                        Toast.makeText(LoginActivity.this,"Login Success", Toast.LENGTH_LONG).show();
                        moveToListMusic();
                    }else{
                        Toast.makeText(LoginActivity.this,"Invalid username/password", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this,"Invalid username/password", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void moveToListMusic() {
        Intent intent = new Intent(this, ListMusicActivity.class);
        startActivity(intent);
    }
}