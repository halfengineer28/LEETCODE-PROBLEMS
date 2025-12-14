package Graphs.Question;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {

    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList ){
        List<List<String>> ans  = new ArrayList<>();
        // queue to store all the list of answers;
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(beginWord)));

        // set to check and remove words which are used;
        Set<String> set = new HashSet<>(wordList);

        // to track used string used list of string;
        List<String> used_ones = new ArrayList<>();
        used_ones.add(beginWord);
        int level = 0;


        while (!queue.isEmpty()){
            List<String> vec = queue.poll();

            if (vec.size() > level){
                level++;
                for (String it : used_ones){
                    set.remove(it);
                }
            }


            String word = vec.get(vec.size()-1);
            if (word.equals(endWord)){
                if (ans.size() == 0){
                    ans.add(new ArrayList<>(vec));
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);

                }
            }

            for (int i = 0; i < word.length(); i++){
                char [] charArray = word.toCharArray();
                char original = charArray[i];
                for (char ch = 'a'; ch <= 'z'; ch++){
                    charArray[i] = ch;
                    String newWord = new String(charArray);
                    if (set.contains(newWord)){
                        vec.add(newWord);
                        queue.add(new ArrayList<>(vec));
                        used_ones.add(newWord);
                        vec.remove(vec.size()-1);

                    }

                }
                charArray[i] = original;
            }




        }
        return ans;
    }
}
