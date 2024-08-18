package Day18of45;

import java.util.*;

class RandomizedCollection {
    private List<Integer> list;
    private Random r;
    
    public RandomizedCollection() {
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        boolean res = list.contains(val);
        list.add(val);
        return !res;
    }
    
    public boolean remove(int val) {
        return list.remove((Integer) val);
    }
    
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}
