package design.patterns.observer;

/**
 * @author libiun
 * 抽象主题角色
 */
public interface Watched {

    public void addWatcher(Watcher watcher);
    public void removeWatcher(Watcher watcher);
    public void notifyWatchers(String str);
}
