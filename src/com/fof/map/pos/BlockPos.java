package com.fof.map.pos;

import com.fof.map.object.onMapBlock;
import org.jetbrains.annotations.NotNull;

public class BlockPos extends Pos{

    public BlockPos(int x,int y){
        super(x,y);
    }

    public BlockPos(@NotNull onMapBlock block){
        super();
        this.pos_x=block.blockPos.pos_x;
        this.pos_y=block.blockPos.pos_y;
    }
    public BlockPos(Pos pos){
        super(pos);
    }

    public int getX(){return this.pos_x;}
    public int getY(){return this.pos_y;}
}
