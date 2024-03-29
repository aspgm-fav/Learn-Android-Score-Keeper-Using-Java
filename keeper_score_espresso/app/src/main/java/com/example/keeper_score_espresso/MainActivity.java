package com.example.keeper_score_espresso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int score_1 = 0;
    private int score_2 = 0;
    private boolean night_mode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        night_mode = getIntent().getBooleanExtra("nightMode",false);
        if(night_mode){
            setTheme(R.style.AppThemeDark);
        } else {
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        if (night_mode) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            Intent intent = new Intent(this,MainActivity.class);
            if(!night_mode){
                intent.putExtra("nightMode",true);
            } else{
                intent.putExtra("nightMode",false);
            }
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void minus_1(View view) {
        score_1--;
        TextView score_text = (TextView)findViewById(R.id.score_1);
        if (score_text != null) {
            score_text.setText(String.valueOf(score_1));
        }
    }

    public void plus_1(View view) {
        score_1++;
        TextView score_text = (TextView)findViewById(R.id.score_1);
        if (score_text != null) {
            score_text.setText(String.valueOf(score_1));
        }
    }

    public void minus_2(View view) {
        score_2--;
        TextView score_text = (TextView)findViewById(R.id.score_2);
        if (score_text != null) {
            score_text.setText(String.valueOf(score_2));
        }
    }

    public void plus_2(View view) {
        score_2++;
        TextView score_text = (TextView)findViewById(R.id.score_2);
        if (score_text != null) {
            score_text.setText(String.valueOf(score_2));
        }
    }


}
