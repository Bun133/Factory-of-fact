package map;

public class MapRect {
    public Chunk[] Rect_Chunks;
    public MapPos LEFT_UP;
    public MapPos RIGHT_DOWN;

    public MapRect(MapPos left_up, MapPos right_down) {
        LEFT_UP = left_up;
        RIGHT_DOWN = right_down;
    }

    public MapRect(map.Map map, MapPos left_up, MapPos right_down) {
        LEFT_UP = left_up;
        RIGHT_DOWN = right_down;
    }

}
