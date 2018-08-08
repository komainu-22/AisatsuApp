package jp.techacademy.akatsuki.hajime.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        }
        mTextView = (TextView)findViewById(R.id.textView);
    }


    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS",String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        if (hourOfDay < 10 & hourOfDay >= 2 ){
                            mTextView.setText("おはよう");
                        }else if (hourOfDay < 18 & hourOfDay >=10){
                            mTextView.setText("こんにちは");
                        }else {
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                0,
                0,
                true
        );


        timePickerDialog.show();

    }



}
