package com.example.tab.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tab.Fragments.CallsFragment;
import com.example.tab.Fragments.ChatsFragment;
import com.example.tab.Fragments.StatusFragment;

public class FragmentsAdapter extends FragmentStateAdapter {


    public FragmentsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new ChatsFragment();

            case 1: return new StatusFragment();

            case 2: return new CallsFragment();

            default: return new ChatsFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }


}
