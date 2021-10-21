package com.koreait.frist.ch07;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.koreait.frist.R;
import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder> {

    List<Person> items = new ArrayList<>(); // setter는 주소값 자체를 바꿈.

    public void addItem(Person item){
        items.add(item);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Person item = items.get(position);
        // holder.setItem(item);

        holder.setItem(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvAge;

        public MyViewHolder(View v){
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //클로저(closure) 죽었어야했는데 안죽었따.
                    String name = tvName.getText().toString();
                    String age = tvAge.getText().toString();
                    Log.i("myLog",name+ ", " + age);

                    Snackbar.make(v,name+ ", "+age,Snackbar.LENGTH_SHORT).show();


                }
            });
            tvName = v.findViewById(R.id.tvName);
            tvAge = v.findViewById(R.id.tvAge);
        }
        public void setItem(Person item){
            tvName.setText(item.getName());
            //tvAge.setText(item.getAge); //정수값은 R에서 관리하고 있는 정수값만 들어갈 수 있다.
            //tvAge.setText(R.string.tv_01()); // 이렇게 stings,xml 에서 관리하고 있는 문자열을 입력할 때 사용
            tvAge.setText(item.getAge() + "살");
           /*
            // int aa =100;
            //R(resources0) 관리하고 있는 정수값을 줘야함.
            int a = R.string.app_name;
            tvAge.setText(a);+
            */
        }
    }
}
