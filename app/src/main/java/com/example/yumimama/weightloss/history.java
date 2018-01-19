package com.example.yumimama.weightloss;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yumimama on 1/17/18.
 */

public class history extends AppCompatActivity {
    private ListView lvHistory;
    private historyListAdapter adapter;
    private List<historyData> mHistoryList;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_history:
                    mTextMessage.setText(R.string.title_history);
                    Intent intent = new Intent(history.this, history.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_information:
                    mTextMessage.setText(R.string.title_information);
                    Intent intent1 = new Intent(history.this, MainActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.navigation_setting:
                    mTextMessage.setText(R.string.title_setting);
                    Intent intent2 = new Intent(history.this, setting.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);



        lvHistory = (ListView) findViewById(R.id.ls_history);

        mHistoryList = new ArrayList<>();

        mHistoryList.add(new historyData(1,"12/28","165cm and 130lbs ", "Drink Water, Especially Before Meals"));
        mHistoryList.add(new historyData(2,"12/30","165cm and 129lbs ", "Eat Eggs For Breakfast"));
        mHistoryList.add(new historyData(3,"1/3","165cm and 129lbs ", "Drink Coffee (Preferably Black)"));
        mHistoryList.add(new historyData(4,"1/5","165cm and 128lbs ", "Cook With Coconut Oil"));
        mHistoryList.add(new historyData(5,"1/7","165cm and 125lbs ", "Take a Glucomannan Supplement"));
        mHistoryList.add(new historyData(6,"1/9","165cm and 125lbs ", "Cut Back on Added Sugar"));
        mHistoryList.add(new historyData(7,"1/11","165cm and 123lbs ", " Go on a Low Carb Diet"));

        adapter = new historyListAdapter(getApplicationContext(),mHistoryList);
        lvHistory.setAdapter(adapter);

        lvHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "If you want to return, click Return! and the history ID is: " + view.getTag(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
