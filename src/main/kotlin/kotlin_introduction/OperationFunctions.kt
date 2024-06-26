package kotlin_introduction

fun main() {
    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "Bye ")

    operator fun String.get(range: IntRange) = substring(range)
    var str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])

}