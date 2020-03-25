package com.fof.register.ui;

import com.fof.graphics.IDrawable;
import com.fof.graphics.ui.IUI;

import java.util.ArrayList;
import java.util.List;

public class UIRegister {
    private List<IUI> UI=new ArrayList<IUI>();
    public void register(IUI ui){UI.add(ui);}
}
