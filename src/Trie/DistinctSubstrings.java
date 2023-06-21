package Trie;


class Node2 {
    Node2 links[] = new Node2[26];

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    Node2 get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node2 node) {
        links[ch - 'a'] = node;
    }
};
public class DistinctSubstrings {
    public static int countDistinctSubstrings(String s)
    {
        Node2 root=new Node2();
        int n=s.length();
        int count=0;
        for (int i = 0; i < n; i++) {
            Node2 node=root;
            for (int j = i; j < n; j++) {
                if (!node.containsKey(s.charAt(j))){
                    node.put(s.charAt(j),new Node2());
                    count++;
                }
                node=node.get(s.charAt(j));
            }
        }
        return count+1;
    }
}
