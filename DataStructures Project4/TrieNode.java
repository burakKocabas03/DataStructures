package dataStc4;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> cocuklar;
    boolean kelimeninSonu;

    public TrieNode() {
        this.cocuklar = new HashMap<>();
        this.kelimeninSonu = false;
    }
}

 class Trie {
    private TrieNode kok;

    public Trie() {
        this.kok = new TrieNode();
    }

    public void ekle(String kelime) {
        TrieNode current = kok;

        for (char harf : kelime.toCharArray()) {
            current = current.cocuklar.computeIfAbsent(harf, k -> new TrieNode());
        }

        current.kelimeninSonu = true;
    }

    // Arama, silme gibi ek metodlar buraya eklenebilir.

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Ekleme metodunu test et
        trie.ekle("elma");
        trie.ekle("armut");
        trie.ekle("art");
        trie.ekle("bardak");

        // Trie'de kelimelerin olup olmadığını test et
        System.out.println(" 'elma' kelimesi mevcut mu? " + trie.ara("elma"));
        System.out.println(" 'armut' kelimesi mevcut mu? " + trie.ara("armut"));
    }

    private boolean ara(String kelime) {
        TrieNode current = kok;

        for (char harf : kelime.toCharArray()) {
            current = current.cocuklar.get(harf);

            if (current == null) {
                return false; // Önek bulunamadı
            }
        }

        return current.kelimeninSonu;
    }
}
