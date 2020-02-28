package map;

public class MapPos {
    int Pos_x;
    int Pos_y;
    int Chunk_x;
    int Chunk_y;

    public MapPos(int x, int y) {
        Pos_x = x;
        Pos_y = y;
        Chunk_x = Pos_x / 30;
        Chunk_y = Pos_y / 30;
    }
}
