package com.example.sulavtimsina.listviewtry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
// This class should be subclassed by all classes which want the options menu
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //this method will inflate the menu resource into java
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.first:
                Intent intent = new Intent(getApplicationContext(), SecondExample.class);
                startActivity(intent);
                return true;
            case R.id.second:
                startActivity(new Intent(this, ArrayAdapterImple.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
