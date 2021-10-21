package com.koreait.frist.ch10;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KobisService {
    //일별 박스오피스
    @GET("boxoffice/searchDailyBoxOfficeList.json")
    Call<BoxOfficeResultBodyVO> boxofficeSearchDailyBoxOfficeList
            (@Query("key") String key, @Query("targetDt") String targetDt);


    //주간 박스오피스
    @GET("boxoffice/searchWeeklyBoxOfficeList.json")
    Call<WeeklyBoxOfficeResultBodyVO> weeklyBoxOfficeList
    (@Query("key") String key, @Query("targetDt") String targetDt
    );

   // http://www.kobis.or.kr/kobisopenapi/webservice/rest/?
    // key=bb6fb9e281037b0ab156c9615e5dcacd
    // &targetDt=20200909

}