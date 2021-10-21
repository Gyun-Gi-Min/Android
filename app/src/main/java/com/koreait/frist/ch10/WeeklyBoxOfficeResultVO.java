package com.koreait.frist.ch10;

import java.util.List;

public class WeeklyBoxOfficeResultVO {
    private String boxOfficeType;
    private String showRange;
    private List<WeeklyBoxOfficeVO> WeeklyBoxOfficeVO;

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

    public List<com.koreait.frist.ch10.WeeklyBoxOfficeVO> getWeeklyBoxOfficeVO() {
        return WeeklyBoxOfficeVO;
    }

    public void setWeeklyBoxOfficeVO(List<com.koreait.frist.ch10.WeeklyBoxOfficeVO> weeklyBoxOfficeVO) {
        WeeklyBoxOfficeVO = weeklyBoxOfficeVO;
    }
}
