package com.CK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
//        System.out.println(randomSet.insert(1));
//        System.out.println(randomSet.remove(2));
//        System.out.println(randomSet.insert(2));
//        System.out.println(randomSet.getRandom());
//        System.out.println(randomSet.remove(1));
//        System.out.println(randomSet.insert(2));
//        System.out.println(randomSet.getRandom());
//        System.out.println(randomSet.insert(3));
//        System.out.println(randomSet.remove(2));
//        System.out.println(randomSet.getRandom());


        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.getRandom());

    }
}

class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( contain ) return false;
        locs.put( val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int upperBound = nums.size();
        int lowerBound = 0;
        int number = lowerBound + (int)(Math.random() * (upperBound - lowerBound));
        return nums.get( number );
    }
}