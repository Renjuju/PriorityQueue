import java.util.*;

public class PriorityQueue<T>{

    private HashMap<Integer, ArrayList<T>> map = new HashMap<>();

    public void insert(T value, int priority) {
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
        if(map.get(max).size() == 0) {
            map.remove(max);
            return getMaxList();
        } else {
            return map.get(max);
        }

    }

    public T ExtractMax() {
       ArrayList<T> maxList = getMaxList();
        T val = maxList.iterator().next();
        maxList.remove(0);
        return val;
    }

}