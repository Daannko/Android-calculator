package com.example.mobilkijava_proper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilkijava_proper.databinding.FragmentAboutBinding;
import com.example.mobilkijava_proper.databinding.FragmentBlankBinding;


public class About extends Fragment {

    private FragmentAboutBinding binding;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(About.this)
                        .navigate(R.id.action_AboutToBlank);
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentAboutBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }
}