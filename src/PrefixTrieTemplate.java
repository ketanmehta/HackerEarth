import java.util.*;

class Trie {
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        RegistrationSystem root = new RegistrationSystem();
        for(int i=0; i<n; i++){
            root.add(sc.next());
        }
        for(int i=0; i<q; i++){
            root.find(sc.next());
        }

    }
    public int childCount = 0;
    public char c;
    public boolean wordComplete = false;
    public Map<Character, Trie> childNodeMap = new HashMap<>();
    public Trie(){

    }
    public void add(String word){
        Trie current = this;
        for(char c : word.toCharArray()){
            Trie node = current.childNodeMap.get(c);
            if(node == null){
                node = new Trie();
                node.c = c;
                node.childCount++;
                node.wordComplete = true;
                current.childNodeMap.put(c, node);
            }
            else{
                node.childCount++;
            }
            current = node;
        }
    }
    public void find(String prefix){
        Trie current = this;
        for(char c : prefix.toCharArray()){
            Trie node = current.childNodeMap.get(c);
            if(node == null){
                System.out.println(0);
                return ;
            }
            current = node;
        }
        System.out.println(current.childCount);
    }
}
