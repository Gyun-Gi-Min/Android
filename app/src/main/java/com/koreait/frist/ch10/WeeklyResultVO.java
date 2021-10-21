package com.koreait.frist.ch10;

import java.util.List;

public class WeeklyResultVO {
    private String boxOfficeType;
    private String showRange;
    private List<WeeklyBoxOfficeVO> weeklyBoxOfficeVOList;

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

    public List<WeeklyBoxOfficeVO> getWeeklyBoxOfficeVOList() {
        return weeklyBoxOfficeVOList;
    }

    public void setWeeklyBoxOfficeVOList(List<WeeklyBoxOfficeVO> weeklyBoxOfficeVOList) {
        this.weeklyBoxOfficeVOList = weeklyBoxOfficeVOList;
    }
}
