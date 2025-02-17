package o_z_se_n_Letter_Tile_Possibilities

class LetterTilePossibilities {
    fun numTilePossibilities(tiles: String): Int {
        val set = HashSet<String>()

        makeTiles("", tiles, set)
        return set.size
    }

    fun makeTiles(seq: String, leftLetters: String, set: HashSet<String>) {
        if (seq.isNotEmpty()) set.add(seq)
        if (leftLetters.isEmpty()) return

        for (i in leftLetters.indices) {
            makeTiles(
                seq + leftLetters[i],
                leftLetters.substring(0..i - 1) + leftLetters.substring(i + 1),
                set
            )
        }
    }
}

fun main() {
    println(LetterTilePossibilities().numTilePossibilities("AAB"))
    println(LetterTilePossibilities().numTilePossibilities("AAABBC"))
    println(LetterTilePossibilities().numTilePossibilities("V"))
}