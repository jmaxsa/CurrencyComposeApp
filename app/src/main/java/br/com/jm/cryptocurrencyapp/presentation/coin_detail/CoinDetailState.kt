package br.com.jm.cryptocurrencyapp.presentation.coin_detail

import br.com.jm.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)