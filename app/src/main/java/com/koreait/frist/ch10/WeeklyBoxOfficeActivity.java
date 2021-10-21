package com.koreait.frist.ch10;

import static com.koreait.frist.Utils.getNumberComma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.koreait.frist.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeeklyBoxOfficeActivity extends AppCompatActivity {

    private WeeklyBoxOfficeAdapter wadapter;

    private DatePicker wTargetDt;
    private RecyclerView wList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_box_office);

        wadapter = new WeeklyBoxOfficeAdapter();

        wTargetDt = findViewById(R.id.wTargetDt);
        wList = findViewById(R.id.wList);
        wList.setAdapter(wadapter);


    }

    private void network(String wtargetDt){
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://www.kobis.or.kr/kobisopenapi/webservice/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KobisService service = rf.create(KobisService.class);
        final String KEY = "bb6fb9e281037b0ab156c9615e5dcacd";
        Call<WeeklyBoxOfficeResultBodyVO> call = service.weeklyBoxOfficeList(KEY, wtargetDt);

        call.enqueue(new Callback<WeeklyBoxOfficeResultBodyVO>() {
            @Override
            public void onResponse(Call<WeeklyBoxOfficeResultBodyVO> call, Response<WeeklyBoxOfficeResultBodyVO> res) {
                if(res.isSuccessful()){

                    WeeklyBoxOfficeResultBodyVO vo = res.body();
                    WeeklyBoxOfficeResultVO resultVo = vo.getWeeklyResult();

                    List<WeeklyBoxOfficeVO> list = resultVo.getWeeklyBoxOfficeVO();

                    wadapter.setList(list);
                    wadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<WeeklyBoxOfficeResultBodyVO> call, Throwable t) {

            }
        });
    }

    public void wclkSearch(View v){
        int day = wTargetDt.getDayOfMonth();
        int mon = wTargetDt.getMonth();
        int year = wTargetDt.getYear();
        String date = String.format("%s%02d%02d", year, mon, day);
        network(date);
        Log.i("myLog", date);
    }


}

class WeeklyBoxOfficeAdapter extends  RecyclerView.Adapter<WeeklyBoxOfficeAdapter.MyViewHolder>{

    private List<WeeklyBoxOfficeVO> list;

    public void  setList(List<WeeklyBoxOfficeVO> list){this.list=list;}



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_daily_boxoffice, parent, false);
        return new WeeklyBoxOfficeAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WeeklyBoxOfficeAdapter.MyViewHolder holder, int position) {
        WeeklyBoxOfficeVO vo = list.get(position);
        holder.setItem(vo);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class MyViewHolder extends  RecyclerView.ViewHolder{
        private TextView tvTitle;
        private TextView tvAudienceCnt;

        public MyViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvAudienceCnt = v.findViewById(R.id.tvAudienceCnt);
        }

        public void setItem(WeeklyBoxOfficeVO vo) {
            tvTitle.setText(vo.getMovieNm());
            // TODO 해야하는일 적기.
//            String aaa = Utils.getNumberComma(vo.getAudiCnt());
//            tvAudienceCnt.setText(aaa+"명");
            tvAudienceCnt.setText(getNumberComma(vo.getAudiCnt())+"명");
        }


    }
}

