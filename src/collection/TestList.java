package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Test the method of Collection Interface
 *
 * @author by jacksonli
 */
public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // test the size(),isEmpty(),add(),toArray(),clear() of List
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("jackson");
        list.add("li");
        System.out.println(list);
        System.out.println(list.size());
        Object[] objects = list.toArray();
        list.clear();
        System.out.println(list);
        // test the sort() of List
        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(3);
        sortedList.add(2);
        sortedList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // lambda
        sortedList.sort((o1, o2) -> o2 - o1);
        System.out.println(list);
    }
}
