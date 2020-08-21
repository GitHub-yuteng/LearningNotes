package ZTest.CollectionOfNull;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Yu
 */
public class List_Set_Map {


    @Test
    public void testArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        Assert.assertEquals(2, list.size()); // success
    }

    @Test
    public void testLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        list.add(null);
        list.add(null);
        Assert.assertEquals(2, list.size()); // success
    }

    @Test
    public void testHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put(null, "1");
        map.put("2", null);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "->" + value);
        }
        Assert.assertEquals(2, map.size()); //OK size = 2
    }

    @Test
    public void testTreeMap() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put(null, null);
        Assert.assertEquals(1, map.size()); //Error NullPointException
    }

    @Test
    public void testHashSet() {
        HashSet<String> set = new HashSet<>();
        set.add(null);
        Assert.assertEquals(1, set.size()); //OK size = 1

//        set.add(null);
//        Assert.assertEquals(2,set.size()); //Error size = 1

    }

    @Test
    public void testTreeSet() {
        TreeSet<String> set = new TreeSet<>();
        set.add(null); //Error NullPointException
    }

    @Test
    public void VectorTest() {
        Vector box = new Vector();
        box.add(null);
        box.add(null);
        Assert.assertEquals(2, box.size()); //ok
    }

    @Test
    public void HashTableTest() {
        Hashtable table = new Hashtable();
        table.put(new Object(), null); //Exception
//        table.put(null,new Object()); //Exception
//        table.put(null,null); //Exception
        Assert.assertEquals(1, table.size());//NullPointerException
    }

    @Test
    public void ConcurrentHashMapTest() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(null, "");
    }
}
