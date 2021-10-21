package com.koreait.frist;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.koreait.frist.ch10.DailyBoxOfficeActivity;
import com.koreait.frist.ch10.DailyBoxOfficeVO;

public class Utils {

    public static int parseStringToint(String val) {
//        //문제가 되면 0리턴
//        //문제가 발생안되면 파싱.
//        //예외처리
//        int intVal = 0;
//        try{
//            intVal = Integer.parseInt(val);
//        }catch (Exception e) {
//            //예외가 발생되었을 때 실행되고 싶은 것들을 여기에다가
//            //작성하기
//            e.printStackTrace(); // 에러 내용 로그에 찍는다.
//        }finally {
//            // 에러가 터지든 안터지든 !!무조건!!
//            // 실행됐으면 하는 것들을 작성
//        }
//
//        return  intVal;
        return parseStringToInt(val,0);
    }


    public static int parseStringToInt(String val, int defVal){
        try {
           return Integer.parseInt(val);
        }catch (Exception e){
            return defVal;
        }
    }

    public static String getNumberComma(int val){
        return String.format("%,d",val);
    }

    public static String getNumberComma(String val){
//      int intVal = parseStringToint(val);
//      return getNumberComma(intVal);
        return getNumberComma(parseStringToint(val));
    }

}






