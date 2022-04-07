package com.example.mobilkijava_proper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import java.math.BigDecimal;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mobilkijava_proper.databinding.FragmentFirstBinding;
import com.google.android.material.snackbar.Snackbar;

public class FirstFragment extends Fragment implements View.OnClickListener {

    private FragmentFirstBinding binding;
    private EditText disp;
    private double number;
    private char eq = '?';


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    public void addText(String val)
    {
        if(eq == ' ')
        {
            disp.setText("0");
            eq = '!';
            number = 0;
        }
        String text = disp.getText().toString();
        if(text.length() == 1 && text.charAt(0) == '0' && !val.equals("."))
            text = val;
        else
        {
            if(val.equals(".") && text.contains(".")) return;
            text = text + val;
        }

        disp.setText(text);
    }

    public void add()
    {

        if(eq != ' ') number = number + Double.parseDouble(disp.getText().toString());
        disp.setText("0");
        eq = '+';
    }
    public void sub()
    {
        if(number == 0 && (eq == '?' || eq == '!'))
        {
            number = Double.parseDouble(disp.getText().toString());
        }
        else if(eq != ' ')  number = number - Double.parseDouble(disp.getText().toString());
        disp.setText("0");
        eq = '-';
    }
    public void div()
    {
        if(number == 0 && (eq == '?' || eq == '!'))
        {
            number = Double.parseDouble(disp.getText().toString());
        }
        else if(eq != ' ')
        {
            if(Double.parseDouble(disp.getText().toString()) == 0)
            {
                eq = 'n';
                return;
            }
            number = number / Double.parseDouble(disp.getText().toString());
        }
        disp.setText("0");
        eq = '/';
    }
    public void mul()
    {
        if(number == 0 && (eq == '?' || eq == '!'))
        {
            number = Double.parseDouble(disp.getText().toString());
        }
        else if(eq != ' ')
        {
            number = number * Double.parseDouble(disp.getText().toString());
        }
        disp.setText("0");
        eq = '*';
    }
    public void equal()
    {
        switch (eq)
        {
            case '-':
                sub();
                eq =' ';
                break;
            case ' ':
                break;
            case '+':
                add();
                eq =' ';
                break;
            case '/':
                div();
                if(eq == 'n')
                {
                    Toast.makeText(getContext(), "You cant divide by 0", Toast.LENGTH_LONG).show();
                    disp.setText("0");
                    eq = ' ';
                    return;
                }
                eq =' ';
                break;
            case '*':
                mul();
                eq =' ';
                break;
        }
        if(number % 1 == 0) disp.setText(String.valueOf((int) number));
        else  disp.setText(String.valueOf(number));
    }
    public void percent()
    {
        disp.setText(String.valueOf(Double.parseDouble(disp.getText().toString())/100));
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        disp = (EditText)  getView().findViewById(R.id.display);
        disp.setTextColor(getResources().getColor(R.color.white));
        view.findViewById(R.id.button0).setOnClickListener(this);
        view.findViewById(R.id.button1).setOnClickListener(this);
        view.findViewById(R.id.button2).setOnClickListener(this);
        view.findViewById(R.id.button3).setOnClickListener(this);
        view.findViewById(R.id.button4).setOnClickListener(this);
        view.findViewById(R.id.button5).setOnClickListener(this);
        view.findViewById(R.id.button6).setOnClickListener(this);
        view.findViewById(R.id.button7).setOnClickListener(this);
        view.findViewById(R.id.button8).setOnClickListener(this);
        view.findViewById(R.id.button9).setOnClickListener(this);
        view.findViewById(R.id.button_clear).setOnClickListener(this);
        view.findViewById(R.id.button_minus_plus).setOnClickListener(this);
        view.findViewById(R.id.button_comma).setOnClickListener(this);
        view.findViewById(R.id.button_plus).setOnClickListener(this);
        view.findViewById(R.id.button_minus).setOnClickListener(this);
        view.findViewById(R.id.button_equals).setOnClickListener(this);
        view.findViewById(R.id.button_percent).setOnClickListener(this);
        view.findViewById(R.id.button_div).setOnClickListener(this);
        view.findViewById(R.id.button_multiply).setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                addText("1");
                break;
            case R.id.button2:
                addText("2");
                break;
            case R.id.button3:
                addText("3");
                break;
            case R.id.button4:
                addText("4");
                break;
            case R.id.button5:
                addText("5");
                break;
            case R.id.button6:
                addText("6");
                break;
            case R.id.button7:
                addText("7");
                break;
            case R.id.button8:
                addText("8");
                break;
            case R.id.button9:
                addText("9");
                break;
            case R.id.button0:
                addText("0");
                break;
            case R.id.button_clear:
                if(disp.getText().toString().equals("0")) {
                    number = 0;
                }
                else{
                    disp.setText("0");
                }
                break;
            case R.id.button_minus_plus:
                String text;
                if(!disp.getText().toString().equals("0")) {
                    if(eq == ' ')
                    {
                        number *= -1;
                    }

                    if(disp.getText().charAt(0) == '-') {
                        text = disp.getText().toString().substring(1);
                    }
                    else{
                        text = "-" + disp.getText().toString();
                    }
                    disp.setText(text);
                }
                break;
            case R.id.button_comma:
                addText(".");
                break;
            case R.id.button_plus:
                add();
                break;
            case R.id.button_minus:
                sub();
                break;
            case R.id.button_equals:
                equal();
                break;
            case R.id.button_div:
                div();
                break;
            case R.id.button_multiply:
                mul();
                break;
            case R.id.button_percent:
                percent();
                break;
         default:
                break;
        }
    }
}