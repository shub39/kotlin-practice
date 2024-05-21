package com.example.coins30

import android.content.Context

class Coin(
    val imageRes: Int,
    val nameRes: Int,
    context: Context
) {
    val price: String = getPrice(imageRes, context)
}

private fun getPrice(
    imageRes: Int,
    context: Context
): String {
    val name: String = context.resources.getResourceName(imageRes)
    if (name.takeLast(1) == "0") {
        return "10"
    }
    return name.takeLast(1)
}

object DataSource {
    lateinit var coins: List<Coin>
    fun initialize(context: Context) {
        coins = listOf(
            Coin(R.drawable.icmr_5, R.string.icmr, context),
            Coin(R.drawable.ongc_5, R.string.ongc, context),
            Coin(R.drawable.rbi_10, R.string.rbi, context),
            Coin(R.drawable.dandi_5, R.string.dandi, context),
            Coin(R.drawable.abul_kalam_azad_5, R.string.abul, context),
            Coin(R.drawable.archive_5, R.string.archive, context),
            Coin(R.drawable.aviation_5, R.string.aviation, context),
            Coin(R.drawable.basaveshwara_5, R.string.basaveshwara, context),
            Coin(R.drawable.bhagat_5, R.string.bhagat, context),
            Coin(R.drawable.braille_2, R.string.braille, context),
            Coin(R.drawable.brihadeswar_5, R.string.brihadeswar, context),
            Coin(R.drawable.income_tax_5, R.string.tax, context),
            Coin(R.drawable.integration_2, R.string.integration, context),
            Coin(R.drawable.jagath_5, R.string.jagath, context),
            Coin(R.drawable.kamaraj_5, R.string.kamaraj, context),
            Coin(R.drawable.madan_mohan_5, R.string.madan, context),
            Coin(R.drawable.nehru_5, R.string.nehru, context),
            Coin(R.drawable.naoroji_5, R.string.naoroji, context),
            Coin(R.drawable.parliament_10, R.string.parliament, context),
            Coin(R.drawable.parliament_5, R.string.parliament, context),
            Coin(R.drawable.perarignar_5, R.string.perarignar, context),
            Coin(R.drawable.rajendra_prasad_5, R.string.rajendra, context),
            Coin(R.drawable.sardar_2, R.string.sardar, context),
            Coin(R.drawable.tagore_5, R.string.tagore, context),
            Coin(R.drawable.tulsi_5, R.string.tulsi, context),
            Coin(R.drawable.yoga_10, R.string.yoga, context)
        )
    }
}