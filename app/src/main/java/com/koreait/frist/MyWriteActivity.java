package com.koreait.frist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.LinkedList;
import java.util.List;

public class MyWriteActivity extends AppCompatActivity {
    private EditText edt;
    private Button btn;
    private RecyclerView ryList;

    private List<String> list;
    private SimpleTextAdapter sta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_write);

        edt = findViewById(R.id.etMsg);
        btn = findViewById(R.id.btnSend);
        ryList = findViewById(R.id.ryCle);

        list = new LinkedList<>();

        LinearLayoutManager lle = new LinearLayoutManager(this);
        ryList.setLayoutManager(lle);

        SimpleTextAdapter ddl = new SimpleTextAdapter(list);
        ryList.setAdapter(ddl);
    }
}