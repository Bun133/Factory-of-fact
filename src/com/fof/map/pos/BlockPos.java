package com.fof.map.pos;

import com.fof.game.main.fof_game;
import com.fof.map.object.onMapBlock;
import org.jetbrains.annotations.NotNull;

public class BlockPos extends Pos {

    public BlockPos(int x, int y) {
        super(x, y);
    }

    public BlockPos(@NotNull onMapBlock block) {
        super();
        this.pos_x = block.blockPos.pos_x;
        this.pos_y = block.blockPos.pos_y;
    }

    public BlockPos(Pos pos) {
        super(pos);
    }

//    public int getX() {
//        return this.pos_x;
//    }

//    public int getY() {
//        return this.pos_y;
//    }

    public boolean isZero() {
        return getPos_x() == 0 || getPos_y() == 0;
    }

    public boolean isWrong() {
        return getPos_x() <= 0 || getPos_y() <= 0;
    }

    public boolean InInAABB(Rect rect) {
        return rect.inRect(this.pos_x * fof_game.INSTANCE.BLOCK_SIZE, this.pos_y * fof_game.INSTANCE.BLOCK_SIZE);
    }

    /**
     * @return pixel単位でブロックの位置を返します。
     */
    public int getPixelPos_x() {
        return this.getPos_x() * fof_game.INSTANCE.BLOCK_SIZE;
    }

    /**
     * @return pixel単位でブロックの位置を返します。
     */
    public int getPixelPos_y() {
        return this.getPos_y() * fof_game.INSTANCE.BLOCK_SIZE;
    }

    /**
     * @return Blockのインデックスです。pixel単位ではありません
     */
    @Override
    public int getPos_x() {
        return super.getPos_x();
    }

    /**
     * @return Blockのインデックスです。pixel単位ではありません
     */
    @Override
    public int getPos_y() {
        return super.getPos_y();
    }
}
