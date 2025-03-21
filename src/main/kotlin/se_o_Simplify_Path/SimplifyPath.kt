package se_o_Simplify_Path

import java.lang.StringBuilder

class SimplifyPath {
    fun simplifyPath2(path: String): String {
        val res = StringBuilder()
        var result = ArrayDeque<Char>()
        var prev = ' '

        loop@ for (i in path.indices) {
            when {
                prev == '/' && path[i] == '/' -> {
                    continue@loop
                }
                prev == '/' && path[i] != '/' && path[i] != '.' -> {
                    prev = path[i]
                    result.add(prev)
                }
                prev != '.' && path[i] == '.' -> {
                    prev = path[i]
                }
                prev == '.' && path[i] == '.' -> {
                    if (path.lastIndex >= i + 1 && path[i + 1] == '.') {
                        if(result.last() != '.') {
                            repeat(3) {
                                result.add('.')
                            }
                        }else result.add('.')
                    } else if (path.lastIndex >= i + 1 && path[i + 1] != '/') {
                        if(result.last() != '.') {
                            repeat(2) {
                                result.add('.')
                            }
                        } else result.add('.')
                        prev = path[i + 1]
                    } else if (result.last() != '.') {
                        if (result.size > 1) result.removeLast()

                        while (result.last() != '/') {
                            result.removeLast()
                        }
                        prev = '/'
                    }
                }
                prev == '.' && path[i] != '.' -> {
                    if (path.lastIndex >= i + 1 && path[i] != '/' && path[i + 1] != '/') {
                        result.add('.')
                        result.add(path[i])
                    }
                    prev = path[i]
                }
                else -> {
                    result.add(path[i])
                    prev = path[i]
                }
            }
        }
        if (result.size > 1 && result.last() == '/') result.removeLast()

        result.forEach { res.append(it) }
        return res.toString()
    }

    fun simplifyPath(path: String): String {
        val res = StringBuilder()
        var result = ArrayDeque<Char>()
        var prev = ' '

        loop@ for (i in path.indices) {
            when {
                prev == '/' && path[i] == '/' -> {
                    continue@loop
                }
                prev == '/' && path[i] != '/' && path[i] != '.' -> {
                    prev = path[i]
                    result.add(prev)
                }
                prev != '.' && path[i] == '.' -> {
                    prev = path[i]
                }
                prev == '.' && path[i] == '.' -> {
                    if (path.lastIndex >= i + 1 && path[i + 1] == '.') {
                        if(result.last() != '.') {
                            repeat(3) {
                                result.add('.')
                            }
                        }else result.add('.')
                    } else if (path.lastIndex >= i + 1 && path[i + 1] != '/') {
                        if(result.last() != '.') {
                            repeat(2) {
                                result.add('.')
                            }
                        } else result.add('.')
                        prev = path[i + 1]
                    } else if (result.last() != '.') {
                        if (result.size > 1) result.removeLast()

                        while (result.last() != '/') {
                            result.removeLast()
                        }
                        prev = '/'
                    }
                }
                prev == '.' && path[i] != '.' -> {
                    if (path.lastIndex >= i + 1 && path[i] != '/' && path[i + 1] != '/') {
                        result.add('.')
                        result.add(path[i])
                    }
                    prev = path[i]
                }
                else -> {
                    result.add(path[i])
                    prev = path[i]
                }
            }
        }
        if (result.size > 1 && result.last() == '/') result.removeLast()

        result.forEach { res.append(it) }
        return res.toString()
    }
}

fun main() {
//    println(SimplifyPath().simplifyPath("/home/"))
//    println(SimplifyPath().simplifyPath("/../"))
//    println(SimplifyPath().simplifyPath("/home//foo/"))
//    println(SimplifyPath().simplifyPath("/a/./b/../../c/"))
//    println(SimplifyPath().simplifyPath("/a/../../b/../c//.//"))
//    println(SimplifyPath().simplifyPath("/a//b////c/d//././/.."))
//    println(SimplifyPath().simplifyPath("/"))
//    println(SimplifyPath().simplifyPath("/..."))
    println(SimplifyPath().simplifyPath("/.....hidden"))
    println(SimplifyPath().simplifyPath("/.aa/....hidden"))
}