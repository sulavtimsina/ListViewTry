package com.example.sulavtimsina.listviewtry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArrayAdapterImple extends MenuActivity {

    ArrayAdapter<String> myAdapter;
    ArrayList<String> myList;
    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindList();
        addFromInput();
    }

    private void addFromInput() {
        findViewById(R.id.txtAddNew).setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    if(keyCode == KeyEvent.KEYCODE_ENTER){
                        String newText;
                        newText = ((TextView) findViewById(R.id.txtAddNew)).getText().toString();
                        ((TextView) findViewById(R.id.txtAddNew)).setText("");
                        myList.add(0,newText);
                        myAdapter.notifyDataSetChanged();
                    }
                }
                return false;
            }
        });
    }

    private void bindList() {
        myList = new ArrayList<>();
        for(int i=1; i<=10; i++){
            myList.add("Item: "+i);
        }
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, myList );
        myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Short Item No. "+position,Toast.LENGTH_SHORT).show();
            }
        });

        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Long Item No. "+position,Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }
}
