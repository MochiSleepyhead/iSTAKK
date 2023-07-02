package com.capstone.istakk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.capstone.istakk.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<homeRecyclerModel> homeRecyclerModels = new ArrayList<>();
    int[] homeProduct_images = {R.drawable.baseline_question_mark_24, R.drawable.baseline_question_mark_25,R.drawable.baseline_question_mark_26,
    R.drawable.baseline_question_mark_27, R.drawable.baseline_question_mark_28, R.drawable.baseline_question_mark_29, R.drawable.baseline_question_mark_30};

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUphomeRecyclerModels();

        RecyclerView recyclerView = findViewById(R.id.homeRecyclerView);

        homeRecyclerViewAdapter adapter = new homeRecyclerViewAdapter(this, homeRecyclerModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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

    private void setUphomeRecyclerModels(){
        String[] homeProduct_names = getResources().getStringArray(R.array.homeRecycler_product_names);
        String[] homeProduct_stock = getResources().getStringArray(R.array.homeRecycler_status);
        String[] homeProduct_status = getResources().getStringArray(R.array.homeRecycler_stock);

        for(int i= 0; i<homeProduct_names.length; i++){
            homeRecyclerModels.add(new homeRecyclerModel(homeProduct_names[i],
                    homeProduct_stock[i],
                    homeProduct_status[i],
                    homeProduct_images[i]));
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
