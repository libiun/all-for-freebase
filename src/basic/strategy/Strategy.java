package basic.strategy;
//策略模式：
//抽象策略角色：策略类，通常由一个接口或者抽象类实现(这个例子中的comparator接口)
//具体策略角色：包含了相关的算法和行为(匿名内部类，最下面实现的MyComparator类)
//环境角色：持有一个策略类的引用，最终给客户端调用。（treeset，持有策略类的引用）
public interface Strategy {
    public int calculate(int a,int b);
}
