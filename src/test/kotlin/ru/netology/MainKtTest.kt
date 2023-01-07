package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateFeeForVisa() {
        val card = "Visa"
        val monthTotal = 0.00
        val amount = 41000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals(307.5, result)
    }

    @Test
    fun calculateFeeForVisaWithFewerAmount() {
        val card = "Visa"
        val monthTotal = 0.00
        val amount = 3000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals(35.0, result)
    }


    @Test
    fun calculateFeeForMastercard() {
        val card = "Mastercard"
        val monthTotal = 0.00
        val amount = 41000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals(266.0, result)
    }

    @Test
    fun calculateFeeForMaestro() {
        val card = "Maestro"
        val monthTotal = 0.00
        val amount = 41000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals(266.0, result)
    }

    @Test
    fun calculateFeeForMastercardWithFewerMaxMonthTotal() {
        val card = "Mastercard"
        val monthTotal = 2000.00
        val amount = 41000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateFeeForMastercardWithOverMaxMonthTotal() {
        val card = "Mastercard"
        val monthTotal = 200000.00
        val amount = 41000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals(266.0, result)
    }

    @Test
    fun calculateFeeForAllOverLimitAmount() {
        val card = "Mastercard"
        val monthTotal = 2000.00
        val amount = 200000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals("Лимит превышен", result)
    }

    @Test
    fun calculateFeeForAllOverLimitMonthTotal() {
        val card = "Mastercard"
        val monthTotal = 650000.00
        val amount = 20000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals("Лимит превышен", result)
    }

    @Test
    fun calculateFeeForAllOverLimitAll() {
        val card = "Mastercard"
        val monthTotal = 650000.00
        val amount = 200000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals("Лимит превышен", result)
    }

    @Test
    fun calculateFeeForVKPay() {
        val card = "VK Pay"
        val monthTotal = 2000.00
        val amount = 14000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals(0.0, result)
    }

    @Test
    fun calculateFeeForVKPayAllOverLimit() {
        val card = "VK Pay"
        val monthTotal = 50000.00
        val amount = 25000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals("Лимит превышен", result)
    }

    @Test
    fun calculateFeeForVKPayMonthTotalOverLimit() {
        val card = "VK Pay"
        val monthTotal = 50000.00
        val amount = 14000.00

        val result = calculateFee(card, monthTotal, amount)

        assertEquals("Лимит превышен", result)
    }

}
