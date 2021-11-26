package org.sweppy.waveberry.hudposition.impl;

public interface IRenderConfig {

    public abstract void save(ScreenPosition pos);

    public ScreenPosition load();

}
