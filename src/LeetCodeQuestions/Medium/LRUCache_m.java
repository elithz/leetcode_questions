package LeetCodeQuestions.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LRUCache_m {
    class LRUCache {

        int capacity;
        Map<Integer, ArrayList<Integer>> map;
        int age;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.age = 0;
            this.map = new HashMap<Integer, ArrayList<Integer>>();
        }

        public int get(int key) {
            if(this.map.containsKey(key)){
                age ++;
                this.map.get(key).set(0, age);
                return this.map.get(key).get(this.map.get(key).size() - 1);
            }else
                return -1;
        }

        public void put(int key, int value) {
            if(this.map.containsKey(key)){
                age ++;
                this.map.get(key).add(value);
                this.map.get(key).set(0, age);
            }else if(this.map.size() < this.capacity){
                age ++;
                ArrayList<Integer> arrlist = new ArrayList<>();
                arrlist.add(age);
                arrlist.add(value);
                this.map.put(key, arrlist);
            }else{
                int deleteKey = 0;
                int minAge = Integer.MAX_VALUE;
                for(Map.Entry<Integer, ArrayList<Integer>> entry : this.map.entrySet()){
                    if(entry.getValue().get(0) < minAge){
                        minAge = entry.getValue().get(0);
                        deleteKey = entry.getKey();
                    }
                }
                this.map.remove(deleteKey);
                age ++;
                ArrayList<Integer> arrlist = new ArrayList<>();
                arrlist.add(age);
                arrlist.add(value);
                this.map.put(key, arrlist);
            }

        }
    }

}
