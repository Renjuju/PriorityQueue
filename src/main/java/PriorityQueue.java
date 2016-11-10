import java.lang.reflect.Array;
import java.util.*;

public class PriorityQueue<T>{
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.insert("Hello", 3);
        queue.insert("Hellosasd", 2);
        queue.insert("ello", 3);
        queue.ExtractMax();
        System.out.println(queue.maximum());

    }

    private HashMap<Integer, ArrayList<T>> map = new HashMap<>();

    public void insert(T value, int priority) {
        System.out.println("Inserting " + value);
        ArrayList<T> list;
        if(map.containsKey(priority)) {
            list = map.get(priority);
            list.add(value);
        } else {
            list = new ArrayList<T>();
            list.add(value);
        }
        map.put(priority, list);
    }

    public T maximum() {
        return getMaxList().get(0);
    }

    private ArrayList<T> getMaxList() {
        Iterator it = map.entrySet().iterator();
        Integer max = Integer.MIN_VALUE;
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(Integer.parseInt(pair.getKey().toString()) > max) {
                max = Integer.parseInt(pair.getKey().toString());
            }
        }
        return map.get(max);
    }
    public T ExtractMax() {
       ArrayList<T> maxList = getMaxList();
        T val = maxList.get(0);
        maxList.remove(0);
        return val;
    }

}