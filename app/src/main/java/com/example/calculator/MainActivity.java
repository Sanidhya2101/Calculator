package com.example.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private TextView previous;
    private EditText display;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previous = findViewById(R.id.secondary);
        display = findViewById(R.id.main);

        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String newStr)
    {
        String oldStr = display.getText().toString();

        int cursorPos = display.getSelectionStart();

        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s",leftStr,newStr,rightStr));
        display.setSelection(cursorPos+newStr.length());
    }

    public void landscapebtn(View v)
    {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
    public void portraitbtn(View v)
    {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void zerobtn(View v)
    {
        updateText("0");
    }
    public void onebtn(View v)
    {
        updateText("1");
    }
    public void twobtn(View v)
    {
        updateText("2");
    }
    public void threebtn(View v)
    {
        updateText("3");
    }
    public void fourbtn(View v)
    {
        updateText("4");
    }
    public void fivebtn(View v)
    {
        updateText("5");
    }
    public void sixbtn(View v)
    {
        updateText("6");
    }
    public void sevenbtn(View v)
    {
        updateText("7");
    }
    public void eightbtn(View v)
    {
        updateText("8");
    }
    public void ninebtn(View v)
    {
        updateText("9");
    }

    public void plusbtn(View v)
    {
        updateText("+");
    }
    public void minusbtn(View v)
    {
        updateText("-");
    }
    public void multiplybtn(View v)
    {
        updateText("×");
    }
    public void dividebtn(View v)
    {
        updateText("÷");
    }

    public void rightbtn(View v)
    {
        updateText("(");
    }
    public void leftbtn(View v)
    {
        updateText(")");
    }
    public void decimalbtn(View v)
    {
        updateText(".");
    }

    public void nd2btn(View v)
    {

    }

    public void clearbtn(View v)
    {
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();

        if(cursorPos!=0 && textLength!=0)
        {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void acbtn(View v)
    {
        display.setText("");
        previous.setText("");
    }

    public void equalbtn(View v)
    {
        String eq = display.getText().toString();
        String eqoriginal = eq;

        eq = eq.replace("÷","/");
        eq = eq.replace("×","*");

        Expression exp = new Expression(eq);
        String result = String.valueOf(exp.calculate());
        previous.setText(eqoriginal);
        display.setText(result);
        display.setSelection(result.length());

    }




}