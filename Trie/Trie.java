package Trie;

public class Trie {
    TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        // dummy node to traverse
        TrieNode temp = root;
        for ( int i = 0; i < word.length(); i++ ){
            if(!temp.containsKey(word.charAt(i))){
                temp.put(word.charAt(i));
            }
            // moving to the next node
            temp = temp.get(word.charAt(i));
        }
        // setting the last node as false
        temp.setEnd();
    }

    public boolean search(String word){
        // dummy node to traverse
        TrieNode temp = root;
        for ( int i = 0; i < word.length(); i++ ){
            if ( !temp.containsKey(word.charAt(i)))
                return false;
            temp = temp.get(word.charAt(i));
        }
        return temp.isEnd();
    }

    public boolean startsWith(String prefix){
        TrieNode temp = root;
        for ( int i = 0; i < prefix.length(); i++ ){
            if ( !temp.containsKey(prefix.charAt(i)))
                return false;
            temp = temp.get(prefix.charAt(i));
        }
        return true;
    }

    public static void main(String [] args){
        Trie obj = new Trie();
        obj.insert("saurav");
        obj.insert("nitu");
        obj.insert("sona");
        obj.insert("sonu");
        System.out.println("trie contains sona : " + obj.search("sona"));
        System.out.println("trie contains nitu : " + obj.search("nitu"));
        System.out.println("trie contains nitin: " + obj.search("nitin"));
        System.out.println("contains prefix nit : " + obj.startsWith("s"));
    }
}


class TrieNode{
    private TrieNode [] nodes;
    private boolean end;
    public TrieNode(){
        nodes = new TrieNode[26];
        end = false;
    }

    public boolean containsKey(char ch){
        return nodes[ch-'a'] != null;
    }

    public void put(char ch){
        nodes[ch-'a'] = new TrieNode();
    }

    public TrieNode get(char ch ){
        return nodes[ch-'a'];
    }

    public void setEnd(){
        end = true;
    }

    public boolean isEnd(){
        return end;
    }
}