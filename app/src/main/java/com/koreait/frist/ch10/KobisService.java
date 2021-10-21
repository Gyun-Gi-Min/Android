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
    Call<WeeklyResultBodyVO> getWeeklyBoxOfficeVOList
    (@Query("key") String key, @Query("targetDt") String targetDt,@Query("weekGb") int weekGb);


}