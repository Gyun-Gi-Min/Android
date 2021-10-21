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
import android.widget.ImageView;
import android.widget.TextView;

import com.koreait.frist.R;
import com.koreait.frist.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DailyBoxOfficeActivity extends AppCompatActivity {

    private  DailyBoxOfficeAdapter adapter;

    private DatePicker dpTargetDt;
    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_box_office);
        adapter = new DailyBoxOfficeAdapter();

        dpTargetDt = findViewById(R.id.dpTargetDt);
        rvList = findViewById(R.id.rvList);
        rvList.setAdapter(adapter);

        network("20211019");
    }

    private void network(String targetDt) {
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://www.kobis.or.kr/kobisopenapi/webservice/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KobisService service = rf.create(KobisService.class);
        final String KEY = "2f14d810f75c29ab879f8a8895f690de";
        Call<BoxOfficeResultBodyVO> call = service.boxofficeSearchDailyBoxOfficeList(KEY, targetDt);

        call.enqueue(new Callback<BoxOfficeResultBodyVO>() {
            @Override
            public void onResponse(Call<BoxOfficeResultBodyVO> call, Response<BoxOfficeResultBodyVO> res) {
                if (res.isSuccessful()) {

                    BoxOfficeResultBodyVO vo = res.body();
                    BoxOfficeResultVO resultVo = vo.getBoxOfficeResult();

                    List<DailyBoxOfficeVO> list = resultVo.getDailyBoxOfficeList();

                    List<DailyBoxOfficeVO> list2 = vo.getBoxOfficeResult().getDailyBoxOfficeList();

                    adapter.setList(list);
                    //list2 를 쓰면 resultVo , list 날려도됨.
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure (Call < BoxOfficeResultBodyVO > call, Throwable t){

            }
        });

    }
    public void clkSearch(View v){
        int day = dpTargetDt.getDayOfMonth();
        int mon = dpTargetDt.getMonth();
        int year = dpTargetDt.getYear();
        String date = String.format("%s%02d%02d", year, mon, day);
        network(date);
        Log.i("myLog", date);
/*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(year, mon, day);
        String date = sdf.format(c.getTime());
*/
    }
}

class DailyBoxOfficeAdapter extends RecyclerView.Adapter<DailyBoxOfficeAdapter.MyViewHolder> {

    private List<DailyBoxOfficeVO> list;

    public void setList(List<DailyBoxOfficeVO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DailyBoxOfficeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_daily_boxoffice, parent, false);
        return new DailyBoxOfficeAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyBoxOfficeAdapter.MyViewHolder holder, int position) {
        DailyBoxOfficeVO vo = list.get(position);
        holder.setItem(vo);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        // play icon은 xml에 바로 src로 바로 뿌림
        private TextView tvTitle;
        private TextView tvAudienceCnt;

        public MyViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvAudienceCnt = v.findViewById(R.id.tvAudienceCnt);
        }

        public void setItem(DailyBoxOfficeVO vo) {
            tvTitle.setText(vo.getMovieNm());
            // TODO 해야하는일 적기.
//            String aaa = Utils.getNumberComma(vo.getAudiCnt());
//            tvAudienceCnt.setText(aaa+"명");
            tvAudienceCnt.setText(getNumberComma(vo.getAudiCnt())+"명");
        }




    }
}