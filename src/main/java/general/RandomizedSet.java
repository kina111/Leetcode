/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/*
Task: Remove, Insert and GetRandom in O(1) average
      Each elements should has the same probability of being returned

Sol: Using ArrayList + HashMap<Value, Index> to restore the index of value in array
Time: O(n) for n query, Space: O(n)
*/
public class RandomizedSet {

    private final HashMap<Integer, Integer> map;
    private final ArrayList<Integer> arr;
    private static Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        arr.add(val);
        map.put(val, arr.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int lastElementInArr = arr.get(arr.size() - 1);
        int idxOfValInMap = map.get(val);
        
        arr.set(idxOfValInMap, lastElementInArr);
        
        arr.remove(arr.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIdx = rand.nextInt(arr.size());
        return arr.get(randomIdx);
    }

    
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean insert = randomizedSet.insert(5);
        insert = randomizedSet.insert(6);
        insert = randomizedSet.insert(7);
        insert = randomizedSet.insert(8);

        boolean remove = randomizedSet.remove(5);
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());

    }
}
