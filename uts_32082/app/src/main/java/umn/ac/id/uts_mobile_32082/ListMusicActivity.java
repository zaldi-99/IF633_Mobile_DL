package umn.ac.id.uts_mobile_32082;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static umn.ac.id.uts_mobile_32082.LoginActivity.wasLogin;
import static umn.ac.id.uts_mobile_32082.MainActivity.musicFiles;

public class ListMusicActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MusicAdapter musicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_music);
        getSupportActionBar().setTitle("List Music");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        showStartDialog();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        if (!(musicFiles.size() < 1)){
            musicAdapter = new MusicAdapter(this, musicFiles);
            recyclerView.setAdapter(musicAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        }
        if(wasLogin){
            showStartDialog();
            wasLogin = false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if (id == R.id.goProfile){
            Intent intent = new Intent(ListMusicActivity.this, ProfileActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        if (id == R.id.goLogout){
            Intent intent = new Intent(ListMusicActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showStartDialog(){
        new AlertDialog.Builder(this).setTitle("Selamat Datang").setMessage("Mochamad Rizky Zaldi - 00000032082")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }




}