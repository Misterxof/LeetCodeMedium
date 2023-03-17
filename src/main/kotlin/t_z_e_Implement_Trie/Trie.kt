package t_z_e_Implement_Trie

import java.util.TreeMap

class Trie {
    class TrieNode {
        val children = TreeMap<Char, TrieNode>()
        var isKey = false
    }

    private val root = TrieNode()

    fun insert(word: String) {
        var trieNode = root

        for (i in word.indices) {
            if (!trieNode.children.containsKey(word[i]))
                trieNode.children[word[i]] = TrieNode()
            trieNode = trieNode.children[word[i]]!!
        }

        trieNode.isKey = true
    }

    fun search(word: String): Boolean {
        var trieNode = root

        for (i in word.indices) {
            if (!trieNode.children.containsKey(word[i]))
                return false
            trieNode = trieNode.children[word[i]]!!
        }

        return trieNode.isKey
    }

    fun startsWith(prefix: String): Boolean {
        var trieNode = root

        for (i in prefix.indices) {
            if (!trieNode.children.containsKey(prefix[i]))
                return false
            trieNode = trieNode.children[prefix[i]]!!
        }

        return true
    }
}