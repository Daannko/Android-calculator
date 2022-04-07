package com.example.mobilkijava_proper;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mobilkijava_proper.databinding.ActivityMainBinding;
import com.example.mobilkijava_proper.databinding.FragmentBlankBinding;
import com.example.mobilkijava_proper.databinding.FragmentFirstBinding;

import java.io.IOError;


public class BlankFragment extends Fragment {

    private FragmentBlankBinding binding;
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentBlankBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(BlankFragment.this)
                        .navigate(R.id.action_BlankFragment_to_FirstFragment);
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(BlankFragment.this)
                        .navigate(R.id.action_BlankFragment_to_SecondFragment);
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(BlankFragment.this)
                        .navigate(R.id.action_BlankFragment_to_About);
            }
        });
        binding.buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().finish();
                System.exit(0);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}