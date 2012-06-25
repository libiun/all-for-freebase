package design.patterns.strategy;

import java.util.List;

public class Environment {

    private SortInterface sortInterface;

        public Environment(){
    }

    public Environment(SortInterface sortInterface) {
        this.sortInterface = sortInterface;
    }


    public void setSortInterface(SortInterface sortInterface) {
        this.sortInterface = sortInterface;
    }

    public void Sort(List<Person> list) {
        this.sortInterface.sort(list);
    }
}
