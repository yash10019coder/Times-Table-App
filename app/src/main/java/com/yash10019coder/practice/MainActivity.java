package com.yash10019coder.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.yash10019coder.practice.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public void generateTable(int timesTableNumber){
        ArrayList<String> list = new ArrayList<String>();
        for (int i=1;i<=10;i++)
            list.add(String.valueOf(timesTableNumber*i));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        binding.listView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().hide();
//        ListView listView=findViewById(R.id.listView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.seekBar.setMin(2);
        }
        binding.seekBar.setMax(20);
        binding.seekBar.setProgress(2);
        generateTable(2);
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=2;
                int timesTableNumber;
                if(progress<min) {
                    timesTableNumber = min;
                    binding.seekBar.setProgress(min);
                }

                else
                    timesTableNumber=progress;
                generateTable(timesTableNumber);
//                Toast.makeText(MainActivity.this, String.valueOf(timesTableNumber), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

//        ArrayList<String> list = new ArrayList<String>();



//        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "You clicked this postion " + position, Toast.LENGTH_SHORT).show();
//                list.remove(position);
//            }
//        });
    }
}