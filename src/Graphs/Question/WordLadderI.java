package Graphs.Question;

import java.util.*;

class Pair<K, T>{
    K key;
    T val;

     public Pair(K key, T val) {
         this.key = key;
         this.val = val;
     }

     public K getKey() {
         return key;
     }

     public T getVal() {
         return val;
     }
 }

public class WordLadderI {
    public static void main(String[] args) {

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        int count = 0;
        // queue to add word which are present in list
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        // Hashset to add all word from list so that no repeated word occurs again;
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);

        while (!queue.isEmpty()){
            String word = queue.peek().getKey();
            int level = queue.peek().getVal();

            if (word.equals(endWord)){
                return level;
            }

            for (int i = 0; i < word.length(); i++){
                char [] arr = word.toCharArray();
                char original = arr[i];
                for (char ch = 'a'; ch <= 'z'; ch++){
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if (set.contains(newWord)){
                        set.remove(newWord);
                        queue.add(new Pair<>(newWord, level+1));
                    }

                }
                arr[i] = original;

            }


        }

        return count;
    }
}
