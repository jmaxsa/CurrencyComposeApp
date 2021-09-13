package br.com.jm.cryptocurrencyapp.domain.repository

import br.com.jm.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import br.com.jm.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}