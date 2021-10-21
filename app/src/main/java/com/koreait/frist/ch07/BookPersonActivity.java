package com.koreait.frist.ch07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.koreait.frist.R;
import com.koreait.frist.Utils;

public class BookPersonActivity extends AppCompatActivity {
    private RecyclerView rvList;
    private PersonAdapter adapter;
    private EditText etName;
    private EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_person);

        rvList = findViewById(R.id.rvList);
        adapter = new PersonAdapter();

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);

        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);
        // adapter.notifyDataSetChanged();

        /*
        name이랑 age 받아와서 clkReg누르면 증록되도록..
        뭐부터 해야하는지 모르겟음.
         */

    }
    public void clkReg(View v){
        String name = etName.getText().toString();
        String age = etAge.getText().toString();

        int intAge = Utils.parseStringToint(age);

        if(intAge == 0){ //문자가 들어오면 false라서 0이 되는건가?
            Toast.makeText(this,"문제가 발생하였습니다.",Toast.LENGTH_SHORT).show();;
            return;

        }else{
            Person p = new Person(name,intAge);
            adapter.addItem(p);
            adapter.notifyDataSetChanged();
            etName.setText("");
            etAge.setText("");
        }



    }
}