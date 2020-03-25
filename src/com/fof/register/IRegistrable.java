package com.fof.register;

import com.fof.events.RegisterEvent;

public interface IRegistrable {
    void register(RegisterEvent event);
}
