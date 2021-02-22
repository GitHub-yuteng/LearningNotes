package Review_Java.OOP.ShoppingCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: YT
 * @Date: 2021/02/19/18:45
 * @Description: OOP 思想
 * 静态方法将方法与数据分离，破坏了封装特性，是典型的面向过程风格
 */
public class ShoppingCart {

    private int itemsCount;
    private BigDecimal totalPrice;
    private List<ShoppingCartItem> items = new ArrayList<>();

    public int getItemsCount() {
        return this.itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 对于 itemsCount 和 totalPrice 这两个属性来说，定义一个 public 的 getter 方法，确实
     * 无伤大雅，毕竟 基本类型数据 getter 方法不会修改数据。但是，对于 items 属性就不一样了，这是因为
     * items 属性的 getter 方法，返回的是一个 List集合容器。外部调用者在拿到这个容器的引用之后，是可以操作容器内部数据的。
     * 也就是说，外部代码还是能修改 items 中的数据  比如 cart.getItems().clear(); 清空购物车
     * @return
     */
    public List<ShoppingCartItem> getItems() {
        /**
         * 不过，这样的实现思路还是有点问题。因为当调用者通过 ShoppingCart 的 getItems() 获
         * 取到 items 之后，虽然我们没法修改容器中的数据，但我们仍然可以修改容器中每个对象（ShoppingCartItem）的数据
         *
         * 这种情况如果数据量不大，返回一个拷贝对象即可。如果有效率考量，就要具体问题具体分析。
         */
        return Collections.unmodifiableList(this.items);
    }

    public void addItem(ShoppingCartItem item) {
        items.add(item);
        itemsCount++;
        totalPrice.add(item.getPrice());
    }

    /**
     * 定义清空购物车
     */
    public void clear() {
        items.clear();
        itemsCount = 0;
        totalPrice = BigDecimal.ZERO;
    }
}
