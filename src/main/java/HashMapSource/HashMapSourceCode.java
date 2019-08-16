package HashMapSource;

import java.util.HashMap;

/**
 * @author Yu
 */
public class HashMapSourceCode {
    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("余腾", "怡宝");

        System.out.println("余腾.hashCode-> h：" + "余腾".hashCode());//TODO 662853
        System.out.println("Object.hashCodeMethod：" + HashCodeMethod("余腾"));//TODO 662853


        System.out.println("HashMapPutKey->hash方法：" + HashMapPutKey("余腾"));//TODO 662863
        //TODO   hashcode值  h ->   1010 0001 1101 0100 0101  -> 662853
        //TODO        h >>> 16 ->   0000 0000 0000 0000 1010 0001 1101 0100 0101
        //TODO  h ^ (h >>> 16) ->   1010 0001 1101 0100 1111  -> 662863  // 因为 异或 的值只有最后四位变动 值变动较小
        //TODO  hash -> 662863 ->   1010 0001 1101 0100 1111

        //TODO tab[i = (n - 1) & hash]  -> (16 - 1) & hash
        //TODO                    15 ->   0000 0000 0000 0000 1111
        //TODO        hash -> 662863 ->   1010 0001 1101 0100 1111
        //TODO  index:(16 - 1) & hash->   0000 0000 0000 0000 1111
        //TODO  为什么数组长度要减1，16 -> 10000 ,15 -> 1111；如果不减 1，& 时，只会散列到 0 or 16 位置。
    }

    static final int HashMapPutKey(Object key) {
        int h;
        return (key == null) ? 0 : (h = HashCodeMethod((String) key)) ^ (h >>> 16);
    }
    /*
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
     */

    static public int HashCodeMethod(String str) {
        int h = 0;
        char[] value = str.toCharArray();
        if (h == 0 && value.length > 0) {
            char val[] = value;
            for (int i = 0; i < value.length; i++) {
                //TODO 转换为char[]数组，使数据中每个数据都转为 int 类型。
                h = 31 * h + val[i];
            }
        }
        return h;
    }
    /*
    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }
     */
}
/*
final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
     //TODO Node<K,V>[] tab -> Node数组
     //TODO Node<K,V> p     -> p = tab[i = (n - 1) & hash]) 数组索引位置
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    if ((tab = table) == null || (n = tab.length) == 0) //TODO 判断当前的数组是否已经进行了初始化
        n = (tab = resize()).length; //TODO 如果没有初始化，先进行初始化操作
    if ((p = tab[i = (n - 1) & hash]) == null) //TODO 判断当前索引位置是否为空，为空说明该位置还没有存储元素
        tab[i] = newNode(hash, key, value, null);//TODO 为空就创建新节点直接添加进数组当前 i 索引位置
    else { //TODO 说明当前 tab 索引位不为空
        //TODO 进入这里说明索引位置已经放入过数据了
        Node<K,V> e; K k;
        //TODO
        if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;//TODO 迭代器，failfast
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}
 */
