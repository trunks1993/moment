package com.ijnkj.util;


import java.util.Map;

public class MapUtil {

    public static Map<?, ?> objectToMap(Object obj)  throws Exception {
        if(obj == null)
            return null;

        return new org.apache.commons.beanutils.BeanMap(obj);
    }

}
