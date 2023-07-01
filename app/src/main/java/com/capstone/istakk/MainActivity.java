package com.capstone.istakk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.capstone.istakk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home) {
                // Replace with the appropriate fragment for the Home button
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.history) {
                // Replace with the appropriate fragment for the History button
                replaceFragment(new HistoryFragment());
            } else if (item.getItemId() == R.id.inventory) {
                // Replace with the appropriate fragment for the Inventory button
                replaceFragment(new InventoryFragment());
            } else if (item.getItemId() == R.id.form) {
                // Replace with the appropriate fragment for the Form button
                replaceFragment(new FormFragment());
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
