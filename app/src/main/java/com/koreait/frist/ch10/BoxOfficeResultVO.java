package com.koreait.frist.ch10;

import java.util.List;

public class BoxOfficeResultVO {
    private String boxOfficeType;
    private String showRange;
    private List<DailyBoxOfficeVO> dailyBoxOfficeList;

    public String getBoxOfficeType() {
        return boxOfficeType;
    }

    public void setBoxOfficeType(String boxOfficeType) {
        this.boxOfficeType = boxOfficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }

    public List<DailyBoxOfficeVO> getDailyBoxOfficeList() {
        return dailyBoxOfficeList;
    }

    public void setDailyBoxOfficeList(List<DailyBoxOfficeVO> dailyBoxOfficeList) {
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }

}


