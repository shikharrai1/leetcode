class Pair{
    Character ch;
    int count;

    // constructor
    Pair(Character ch, int count){
        this.ch = ch;
        this.count = count;
    }
}
class Solution {
    public String removeSubstring(String s, int k) {
        Deque<Pair> deque = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!deque.isEmpty() && deque.peekLast().ch == c){
               // increase the count
               deque.peekLast().count++;
                }else{
                    
                    deque.addLast(new Pair(c,1));
                }
                 
            

            // check if deque contain 2 elements "(" and ")"
            while(deque.size() >= 2){
                // now check if last element is ")" and 2nd last element is "("
                Pair last = deque.peekLast();
                Pair secondLast = getSecondLast(deque);
                int kCount = 0;
               if(secondLast.ch == '(' && last.ch == ')'){
                kCount  = Math.min(k,Math.min(last.count,secondLast.count));
                if(kCount == k){
                    last.count -= k;
                    secondLast.count -= k;
                    if(last.count == 0){
                        deque.removeLast();
                    }if(!deque.isEmpty() && deque.peekLast().count == 0){
                         deque.removeLast();
                    }
                }else{
                    break;
                }
               }else{
                    break;
                }
            }
        }
            StringBuilder sb = new StringBuilder();
           for (Pair p : deque) {
            for (int i = 0; i < p.count; i++) {
                 sb.append(p.ch);
             }
             }
            return sb.toString();
        }
        // getSecondLast()
        public Pair getSecondLast(Deque<Pair> deque){
            Iterator<Pair> it = deque.descendingIterator();
            it.next();
            return it.next();
        }
    }
