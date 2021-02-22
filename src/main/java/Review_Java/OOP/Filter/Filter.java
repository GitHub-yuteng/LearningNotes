package Review_Java.OOP.Filter;

/**
 * @Auther: YT
 * @Date: 2021/02/19/19:44
 * @Description: 接口，有一个更加形象的叫法，那就是协议（contract）
 * 抽象类更多的是为了代码复用，而接口就更侧重于解耦。
 * 接口是对行为的一种抽象，相当于一组协议或者契约
 * 接口强调某一方面的统一，抽象强调共性的复用
 * 接口的定义只表明做什么，而不是怎么做
 *
 * 如果我们要表示一种 is-a 的关系，并且是为了解决代码复用的问题，我们就用抽象类；
 * 如果我们要表示一种 has-a 关系，并且是为了解决抽象而非代码复用的问题，那我们就可以使用接口。
 *
 * 从类的继承层次上来看，抽象类是一种自下而上的设计思路，先有子类的代码重复，然后再抽象成上层的父类（也就是抽象类）。
 * 而接口正好相反，它是一种自上而下的设计思路。我们在编程的时候，一般都是先设计接口，再去考虑具体的实现。
 *
 * 从软件工程角度考虑 时间，成本，范围
 */
public interface Filter {

    void doFilter(RpcRequest req) throws RpcException;
}