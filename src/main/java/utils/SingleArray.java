package utils;

import com.common.TranDO;

import java.util.ArrayList;
import java.util.List;

public class SingleArray {

    private static List<TranDO> list = null;

    private SingleArray(){}

    public static List<TranDO> getInstance(){
        if(list == null){
            synchronized(SingleArray.class){
                if(list == null){
                    list = new ArrayList<>();
                }
            }
        }
        return list;
    }
}