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


    // 211. Design Add and Search Words Data Structure
    fun searchWithDots(word: String): Boolean {
        return searchWithDots(word, 0, root)
    }

    fun searchWithDots(word: String, index: Int, trieNode: TrieNode): Boolean {
        if (index == word.length) return trieNode.isKey

        if (word[index] == '.') {
            trieNode.children.values.forEach {
                if (searchWithDots(word, index + 1, it))
                    return true
            }
            return false
        } else {
            if (!trieNode.children.containsKey(word[index]))
                return false
            return searchWithDots(word, index + 1, trieNode.children[word[index]]!!)
        }
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