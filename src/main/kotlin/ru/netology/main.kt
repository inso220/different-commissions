package ru.netology

fun main () {
    val fee = calculateFee("Mastercard", 0.00, 41000.00)
    println(fee)
}

fun calculateFee (card: String, monthTotal: Double, amount: Double): Any {
    var result = when (card) {
        "Mastercard", "Maestro" -> if (monthTotal > 300 && monthTotal < 75000) 0.0 else amount * 0.006 + 20
        "Visa", "Мир" -> if (amount * 0.0075 < 35) 35.0 else amount * 0.0075
        else -> 0.0
    }
    return if (amount > 150000 || monthTotal > 600000)
        "Лимит превышен"
    else if (card == "VK Pay" && amount > 15000 || card == "VK Pay" && monthTotal > 40000)
        "Лимит превышен"
    else
        result
}

