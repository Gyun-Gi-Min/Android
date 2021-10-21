package com.koreait.frist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.koreait.frist.ch07.BookPersonActivity;
import com.koreait.frist.ch10.DailyBoxOfficeActivity;
import com.koreait.frist.ch10.WeeklyBoxOfficeActivity;

import picsum.PicsumActivity;

public class menuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        //int 1
        int result = Utils.parseStringToInt("11",5);
        Log.i("myLog","1:"+result);




    }
    public void call (View v){
        Intent intent = new Intent(Intent.ACTION_VIEW
                , Uri.parse("tel:010-1111-2222"));
        startActivity(intent);
    }
    public void moveToActivity(View v){
        int id = v.getId();
        Class c = null;
        switch (id){
            case R.id.menuBtn1:
                c = MainActivity.class;
                break;
            case R.id.menuBtn2:
                c = LinearActivity.class;
                break;
            case R.id.menuBtn3:
                c = ConstraintActivity.class;
                break;
            case R.id.menuBtn4:
                c = WriteActivity.class;
                break;
            case R.id.menuBtn5:
                c = BookPersonActivity.class;
                break;
            case R.id.menuBtn6:
                c = ImageViewActivity.class;
                break;
            case R.id.menuBtn7:
                c = PicsumActivity.class;
                break;
            case R.id.menuBtn8:
                c = DailyBoxOfficeActivity.class;
                break;
            case R.id.menuBtn9:
                c = WeeklyBoxOfficeActivity.class;
                break;

        }

        if(c==null){
            Snackbar.make(v,"준비중!",Snackbar.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
    public void moveToActivityWithText(View v){
        TextView tv = (TextView)v;
        String text = (String)tv.getText();
        Log.i("mylog", text);

        Class c = null;

        switch (text){
            case "메인":
                c = MainActivity.class;
                break;
            case "리니어레이아웃":
                c = MainActivity.class;
                break;
            case "제약레이아웃":
                c = MainActivity.class;
                break;
        }
        c = MainActivity.class;

        c = LinearActivity.class;

        c = ConstraintActivity.class;

        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}