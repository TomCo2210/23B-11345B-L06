package com.example.a23b_11345b_l06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a23b_11345b_l06.Fragments.ListFragment;
import com.example.a23b_11345b_l06.Fragments.MapFragment;
import com.example.a23b_11345b_l06.Interfaces.CallBack_SendClick;

public class MainActivity extends AppCompatActivity {

    private ListFragment listFragment;
    private MapFragment mapFragment;

    private CallBack_SendClick callBack_sendClick = new CallBack_SendClick() {
        @Override
        public void userNameChosen(String name) {
            mapFragment.zoomOnRecord(name);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragments();

        beginTransactions();
    }

    private void beginTransactions() {
        getSupportFragmentManager().beginTransaction().add(R.id.main_FRAME_list, listFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_FRAME_map, mapFragment).commit();
    }

    private void initFragments() {
        listFragment = new ListFragment();
        listFragment.setCallBack_sendClick(callBack_sendClick);
        mapFragment = new MapFragment();
    }
}