package com.fof.map;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class MapManager {
    public static MapManager VANILLA_INSTANCE = new MapManager();

    public void addMap(File file) {
        //TODO
        addMap(loadMap(file));
    }

    public void addMap(Map map) {
        MapMap.put(map.getMapName(), map);
    }


    public Map loadMap(File file) {
        //TODO
        return new com.fof.map.Map("DummyMap", 37294581L);
    }

    public Map dummy_Map() {
        return com.fof.map.Map.dummyMap;
    }

    /**
     * @apiNote Crate dummy MAP(id:"DummyMap")
     */
    private Map loadMap() {
        //TODO
        return new com.fof.map.Map("DummyMap", 37294581L);
    }

//    private MapManager() {
//        addMap(loadMap());
//    }

    private java.util.Map<String, com.fof.map.Map> MapMap = new HashMap<String, com.fof.map.Map>();

    public String[] getMapIDArray() {
        return MapMap.keySet().toArray(new String[0]);
    }

    public List<String> getMapIDList() {
        return (List<String>) MapMap.keySet();
    }

    public Map getMap(String id) {
        if (MapMap.containsKey(id)) {
            return MapMap.get(id);
        } else {
            return loadMap();
        }
    }

    public boolean isMapContain(Map map) {
        return MapMap.containsKey(map);
    }

}
