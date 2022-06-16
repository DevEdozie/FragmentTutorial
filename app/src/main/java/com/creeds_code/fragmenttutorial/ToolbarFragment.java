package com.creeds_code.fragmenttutorial;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.creeds_code.fragmenttutorial.databinding.FragmentToolbarBinding;

public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    FragmentToolbarBinding binding;
    private static int seekvalue = 10;
    ToolbarListener activityCallback;

    public interface ToolbarListener{
        public void onButtonClick(int position, String text);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            //Cast context to be of type ToolbarListener
            activityCallback = (ToolbarListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
            + "must implement ToolbarListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentToolbarBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //button listener
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(view);
            }
        });
    }

    public void buttonClicked(View view){
        activityCallback.onButtonClick(seekvalue,
                binding.editText1.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser){
        seekvalue = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}