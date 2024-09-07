// 7. Reverse Integer

fun reverse(x: Int): Int {
    var ans = 0
    var no = x

    while (no != 0) {
        val digit = no % 10
        if (ans > Int.MAX_VALUE / 10 || ans < Int.MIN_VALUE / 10) return 0
        ans = (ans * 10) + digit
        no /= 10
    }

    return ans
}