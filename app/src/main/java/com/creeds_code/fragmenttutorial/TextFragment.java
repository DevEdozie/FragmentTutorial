package com.creeds_code.fragmenttutorial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creeds_code.fragmenttutorial.databinding.FragmentTextBinding;

public class TextFragment extends Fragment {

    FragmentTextBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTextBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void changeTextProperties(int fontsize, String text){
        binding.textView2.setTextSize(fontsize);
        binding.textView2.setText(text);
    }
}