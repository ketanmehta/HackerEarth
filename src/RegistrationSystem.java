import java.util.*;

class RegistrationSystem {
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        RegistrationSystem root = new RegistrationSystem();
        for(int i=0; i<n; i++){
            root.add(sc.next());
        }

    }
    public int childCount = 0;
    public char c;
    public boolean wordComplete = false;
    public int numForNextNode = 0;
    public Map<Character, RegistrationSystem> childNodeMap = new HashMap<>();
    public RegistrationSystem(){

    }
    public void add(String word){
        RegistrationSystem current = this;
        boolean brandNew = false;
        for(char c : word.toCharArray()){
            RegistrationSystem node = current.childNodeMap.get(c);
            if(node == null){
                node = new RegistrationSystem();
                node.c = c;
                node.childCount++;
                node.wordComplete = true;
                current.childNodeMap.put(c, node);
                brandNew = true;
            }
            else{
                node.childCount++;
                brandNew = false;
            }
            current = node;
            if(!brandNew){

            }
        }
    }
    public void find(String prefix){
        RegistrationSystem current = this;
        for(char c : prefix.toCharArray()){
            RegistrationSystem node = current.childNodeMap.get(c);
            if(node == null){
                System.out.println(0);
                return ;
            }
            current = node;
        }
        System.out.println(current.childCount);
    }
}
