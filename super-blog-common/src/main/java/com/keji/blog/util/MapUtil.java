package com.keji.blog.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

/**
 * Map集合工具类
 *
 * @author wb-ny291824
 * @version $Id: MapUtil.java, v 0.1 2018-03-26 15:15 wb-ny291824 Exp $$
 */
public class MapUtil {

    /**
     * 根据map的值排序
     * @param map map
     * @param <K> key 的类型
     * @param <V> value的类型
     * @param reverse 是否倒序
     * @return LinkedHashMap
     */
    @SuppressWarnings("unchecked")
    public static<K,V extends Comparable> LinkedHashMap<K , V> sortByValue(Map<K ,V> map,Boolean reverse) {
        ArrayList<Entry<K, V>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Comparator.comparing(Entry::getValue));
        if (reverse) {
            Collections.reverse(entryList);
        }
        LinkedHashMap<K , V> linkedHashMap = Maps.newLinkedHashMap();
        entryList.forEach(e->linkedHashMap.put(e.getKey(),e.getValue()));
        return linkedHashMap;
    }
}
