package br.com.jm.cryptocurrencyapp.presentation.coin_list

import br.com.jm.cryptocurrencyapp.domain.model.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)