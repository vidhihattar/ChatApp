package com.example.tab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.tab.Adapters.FragmentsAdapter;
import com.example.tab.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FragmentsAdapter FragmentsAdapter;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        auth = FirebaseAuth.getInstance();

        setContentView(binding.getRoot());

        FragmentManager fm = getSupportFragmentManager();
        FragmentsAdapter = new FragmentsAdapter(fm, getLifecycle());

        binding.viewpager.setAdapter(FragmentsAdapter);


        String [] tabTtiles={"Chats","Calls","Status"};
        new TabLayoutMediator(binding.tablayout, binding.viewpager,(myTabLayout, position) ->
                myTabLayout.setText(tabTtiles[position])).attach();

        binding.btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.logout:auth.signOut();
                            Intent intent = new Intent(MainActivity.this, Login_activity.class);
                            startActivity(intent);
                            break;

                        }
                        return true;
                    }
                });
            }
        });
    }






}