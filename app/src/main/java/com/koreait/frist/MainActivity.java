
package com.koreait.frist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        View v = new View();
//        clkBtn(v);
    }
    //이벤트 연결(event binding) 버튼 클릴시 실행될 메소드 연결
    public void clkBtn(View v){
        // v.getText();
        Button btn = (Button) v;
        String btnText = (String)btn.getText();
        Toast.makeText(this, btnText + "를 클릭했어요"
                , Toast.LENGTH_LONG).show();

    }


        //누를때 마다 1씩 증가
        //v에 담겨있는 객체주소값을 TextView타입으로 저장할 수 있으면 true 아니면 false
    public void ddd(View v){
        if(v instanceof TextView){
            TextView tv = (TextView) v;
            String val = (String)tv.getText();
            int intVal = Integer.parseInt(val);
            intVal+=1;
            String parseStrVal = String.valueOf(intVal);
            tv.setText(parseStrVal);
        }



        //context:맥락
    }
}