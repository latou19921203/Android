package com.example.a61555.maintenance_demo10.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 61555 on 2017/8/22.
 */

public class TimePointsUtils {

    static public List<Map<String, Object>> getTimePointsList() {
        List<Map<String, Object>> timePointMapList = new ArrayList<>();
        for (int i=0; i<24; i++) {
            Map map = new HashMap();
            if (i < 10)
                map.put("timePoint", "0"+i+":00");
            else
                map.put("timePoint", i+":00");
            timePointMapList.add(map);
        }
        return timePointMapList;
    }

    static public List<Map<String, Object>> getTimePointsListEach4Hour() {
        List<Map<String, Object>> timePointMapList = new ArrayList<>();
        for (int i=0; i<24; i+=4) {
            Map map = new HashMap();
            if (i < 10)
                map.put("timePoint", "0"+i+":00");
            else
                map.put("timePoint", i+":00");
            timePointMapList.add(map);
        }
        return timePointMapList;
    }
}
