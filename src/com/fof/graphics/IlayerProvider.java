package com.fof.graphics;

import java.util.List;

public interface IlayerProvider {
    void addlayer(layer layer);

    List<layer> getlayers();


    boolean requestUpdate();
}
