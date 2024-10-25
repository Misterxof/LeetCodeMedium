package o_t_th_th_Remove_SubFolders_Filesystem

class RemoveSubFoldersFilesystem {
    fun removeSubfolders(folder: Array<String>): List<String> {
        val resultList = mutableListOf<String>()
        folder.sort()

        folder.forEach { folder ->
            var curStr = ""

            loop@ for (i in folder.indices) {
                curStr += folder[i]

                if (folder[i] == '/') continue@loop

                if (resultList.contains(curStr) && (i + 1 == folder.length || folder[i + 1] == '/')) {
                    curStr = ""
                    break
                }
            }

            if (curStr.isNotEmpty()) resultList.add(curStr)
        }

        return resultList
    }
}

fun main() {
    var folders = RemoveSubFoldersFilesystem().removeSubfolders(arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f"))
    folders.forEach { print("$it, ") }
    folders = RemoveSubFoldersFilesystem().removeSubfolders(arrayOf("/a/b/c", "/a/b/ca", "/a/b/d"))
    println()
    folders.forEach { print("$it, ") }
}