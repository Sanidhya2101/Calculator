package com.example.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;


public class MainActivity extends AppCompatActivity {

    private TextView previous;
    private EditText display;
    private Button tan,sin,cos,expo,gcd,nCr,sinh,cosh,tanh,decimal,degbtn;
    private Boolean isfocus = false;
    private Boolean isdegree=false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previous = findViewById(R.id.secondary);
        display = findViewById(R.id.main);
        tan = findViewById(R.id.tan);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        expo = findViewById(R.id.expo);
        gcd = findViewById(R.id.gcd);
        nCr = findViewById(R.id.nCrbtn);
        sinh = findViewById(R.id.sinhbtn);
        cosh = findViewById(R.id.coshbtn);
        tanh = findViewById(R.id.tanhbtn);
        decimal = findViewById(R.id.decimalbtn);
        degbtn = findViewById(R.id.radbtn);




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

    public void nd2btn(View v)
    {
        if(isfocus==false)
        {
            tan.setText(R.string.taninverse);
            sin.setText(R.string.sininverse);
            cos.setText(R.string.cosinverse);
            expo.setText(R.string.power10);
            gcd.setText("lcm");
            nCr.setText("nPr");
            sinh.setText(R.string.sinhinverse);
            cosh.setText(R.string.coshinverse);
            tanh.setText(R.string.tanhinverse);
            decimal.setText(",");
            isfocus = true;
        }
        else
        {
            tan.setText("tan");
            sin.setText("sin");
            cos.setText("cos");
            expo.setText(R.string.expo);
            gcd.setText("gcd");
            nCr.setText("nCr");
            sinh.setText("sinh");
            cosh.setText("cosh");
            tanh.setText("tanh");
            decimal.setText(".");
            isfocus = false;
        }

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
    public void percentagebtn(View v)
    {
        updateText("%");
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
        if(!isfocus)
        {
            updateText(".");
        }
        else
        {
            updateText(",");
        }
    }


    public void sinbtn(View v)
    {
        if(!isfocus)
        {
            updateText("sin(");
        }
        else
        {
            updateText(this.getResources().getString(R.string.sininverse)+"(");
        }

    }
    public void cosbtn(View v)
    {
        if(!isfocus)
        {
            updateText("cos(");
        }
        else
        {
            updateText(this.getResources().getString(R.string.cosinverse)+"(");
        }
    }
    public void tanbtn(View v)
    {
        if(!isfocus)
        {
            updateText("tan(");
        }
        else
        {
            updateText(this.getResources().getString(R.string.taninverse)+"(");
        }
    }
    public void sinhbtn(View v)
    {
        if(!isfocus)
        {
            updateText("sinh(");
        }
        else
        {
            updateText(this.getResources().getString(R.string.sinhinverse)+"(");
        }
    }
    public void coshbtn(View v)
    {
        if(!isfocus)
        {
            updateText("cosh(");
        }
        else
        {
            updateText(this.getResources().getString(R.string.coshinverse)+"(");
        }
    }
    public void tanhbtn(View v)
    {
        if(!isfocus)
        {
            updateText("tanh(");
        }
        else
        {
            updateText(this.getResources().getString(R.string.tanhinverse)+"(");
        }
    }

    public void expbtn(View v)
    {
        if(!isfocus)
        {
            updateText("e^");
        }
        else
        {
            updateText("10^");
        }
    }
    public void squarebtn(View v)
    {
        updateText("^2");
    }
    public void xyexpobtn(View v)
    {
        updateText("^");
    }
    public void squarerootbtn(View v)
    {
        updateText("sqrt(");
    }
    public void factorialbtn(View v)
    {
        updateText("!");
    }
    public void xrootybtn(View v)
    {
        updateText("^(1/");
    }
    public void logbtn(View v)
    {
        updateText("log(");
    }
    public void gcdbtn(View v)
    {
        if(!isfocus)
        {
            updateText("gcd(");
        }
        else
        {
            updateText("lcm(");
        }
    }
    public void nCrbtn(View v)
    {
        if(!isfocus)
        {
            updateText("C(");
        }
        else
        {
            updateText("P(");
        }
    }
    public void pibtn(View v)
    {
        updateText("π");
    }
    public void radbtn(View v)
    {
        String val = display.getText().toString();

        if(val.isEmpty())
        {
            if(!isdegree)
            {
                degbtn.setText("deg");
            }
            else
            {
                degbtn.setText("rad");
            }
        }
        else
        {

            if(!isdegree)
            {
                if(val.equals("π"))
                {
                    val="3.141592653589793";
                }
                Double rad = Double.parseDouble(val);
                Double deg = Math.toDegrees(rad);
                display.setText(String.valueOf(deg));
                degbtn.setText("rad");
                isdegree=true;
            }
            else
            {
                if(val.equals("π"))
                {
                    val="3.141592653589793";
                }
                Double deg = Double.parseDouble(val);
                Double rad = Math.toRadians(deg);
                display.setText(String.valueOf(rad));
                degbtn.setText("deg");
                isdegree=false;
            }
        }


    }




    public void isprimebtn(View v)
    {
        updateText("isprime(");
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


        Function f = new Function("pow10","10^x","x");
        Function e = new Function("expo","e^x","x");
        Function sqr = new Function("sqr","x^2","x");
        Function xy = new Function("f(x,y)=y^x");
        Function p = new Function("P(x,y)=(x!)/((x-y)!)");



        eq = eq.replace("÷","/");
        eq = eq.replace("×","*");
        eq = eq.replace("%","/100");
        eq = eq.replace(this.getResources().getString(R.string.sininverse),"arcsin");
        eq = eq.replace(this.getResources().getString(R.string.cosinverse),"arccos");
        eq = eq.replace(this.getResources().getString(R.string.taninverse),"arctan");
        eq = eq.replace(this.getResources().getString(R.string.sinhinverse),"arcsinh");
        eq = eq.replace(this.getResources().getString(R.string.coshinverse),"arccosh");
        eq = eq.replace(this.getResources().getString(R.string.tanhinverse),"arctanh");
        eq = eq.replace("π","pi");
        eq = eq.replace("isprime","ispr");

        Expression exp = new Expression(eq,f,e,sqr,xy,p);

        String result = String.valueOf(exp.calculate());
        previous.setText(eqoriginal);
        display.setText(result);
        display.setSelection(result.length());

    }




}