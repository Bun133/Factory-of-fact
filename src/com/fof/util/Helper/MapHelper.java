package com.fof.util.Helper;

public class MapHelper {

    /**
     * @param range
     * @return 最初のChunkを0つめとして、半径をrangeとしたときのChunkの数を返します。
     */
    public static int getCircleChunksLong(int range) {
        return 1 + (4 + (range * 4)) * range / 2;
        //1+((range+1)*4)*range/2でいいんじゃないかと言う質問は受け付けない
    }

    /**
     * @param range
     * @param Slice
     * @return
     * @apiNote 半径rangeの中心を0とした断層的インデックスをSliceとしたときのその断層上のChunkを返します。
     */
    public static int getCircleChunksSliceCount(int range, int Slice) {
        return (range - Math.abs(Slice)) * 2 + 1;
    }


    /**
     * @param AxisLong
     * @return
     * @apiNote 半径を軸に、左右の直線の長さをAxisLongとし、片方の直線の長さを返します。
     */

    //For Example....
    //3→1
    //5→2
    public static int getCircleHalfAxis(int AxisLong) {
        return (AxisLong - 1) / 2;
    }
}
