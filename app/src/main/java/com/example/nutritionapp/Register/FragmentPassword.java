package com.example.nutritionapp.Register;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nutritionapp.R;
import com.example.nutritionapp.databinding.FragmentPasswordBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragmentPassword extends Fragment {
    FragmentPasswordBinding binding;
    EditText textPass, textPassC;
    private FloatingActionButton next;
    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentPasswordBinding.inflate(inflater, container, false);
        View root= binding.getRoot();

        textPass= root.findViewById(R.id.text_pass);
        textPassC= root.findViewById(R.id.text_passc);
        next= root.findViewById(R.id.pass_next);

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedViewModel= new ViewModelProvider(getActivity()).get(SharedViewModel.class);
                if(textPass.getText().toString()!= null){
                    myEdit.putString("pass", textPass.getText().toString());
                    myEdit.commit();
//                sharedViewModel.setPass(textPass.getText().toString());
               }
            }
        });





        return inflater.inflate(R.layout.fragment_password, container, false);
    }
}