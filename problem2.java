package s30.Strings-2;

public class problem2 {
    //TC:- O(n)
    //SC:- O(n)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new ArrayList<Integer>();
            if(p.length() > s.length()) return  list; // Base Condition
           
                int N=s.length(); // Array1 of s
                int M=p.length(); // Array2 of p
                int[]count = freq(p); // intialize only 1 time
                
                int[]currentCount = freq(s.substring(0, M)); // freq function, update every-time according to sliding window
                
                if(areSame(count,currentCount)) // areSame function
                    list.add(0);
            
                int i;
                for(i=M;i<N;i++){ // going from 3 to 9 in above example
                    currentCount[s.charAt(i-M) - 'a']--; // blue pointer, decrement frequency
                    currentCount[s.charAt(i)-'a']++; // red pointer, increment frequency
                    if(areSame(count,currentCount)){ // now check, both array are same
                        list.add(i-M+1); // if we find similar add their index in our list
                    }
                }
            return list;
        }
        private boolean areSame(int[] x, int[] y){
            for(int i = 0; i < 26; i++){
                if(x[i] != y[i]) // compare all the frequency & doesnn't find any di-similar frequency return true otherwise false
                    return false;
            }
            
            return true;
        }
      private int[] freq(String s){
            int[] count = new int[26]; // create array of size 26
            for(int i = 0; i < s.length(); i++){
                count[s.charAt(i) - 'a']++; // update acc. to it's frequency
            }
            
            return count; // and return count 
        }
    }
}
