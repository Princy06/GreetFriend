package com.example.myapplication44;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class GreetFriend extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    Button button;
    TextView tv;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet_friend);
        tv=findViewById(R.id.tv);
        name=findViewById(R.id.name);
        button=findViewById(R.id.button);
        button.setOnClickListener(this);
        name.setOnClickListener(this);
        b=findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
              next();
            }
        });

    }
    public void next()
    {
        Intent intent = new Intent(this,counter.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        String friendName=name.getText().toString();
        Date date=new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        String greeting = null;
        if(hour>=6 && hour<12)
        {
            greeting="good morning";
        }
        else
        {
            if(hour>=12 && hour<17)
            {
                greeting="good afternoon";
            }
            else
            {
                if(hour>=17 && hour<21)
                {
                    greeting="good evening";
                }
                else
                {
                    if(hour>=21 && hour<24)
                    {
                        greeting="good night";
                    }
                }
            }
        }
        switch(view.getId())
        {
            case R.id.button:
                tv.setText(greeting +" "+ friendName);
                break;
              default:
                  break;
        }

    }
}
