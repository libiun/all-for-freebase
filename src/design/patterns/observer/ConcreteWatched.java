package design.patterns.observer;

import java.util.*;

/**
 * 具体主题角色
 */
public class ConcreteWatched implements Watched {

    private List<Watcher> list=new ArrayList<Watcher>();

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers(String str) {
        for (Watcher watcher:list){
            watcher.update(str);
        }
    }

}
