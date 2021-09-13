package br.com.jm.cryptocurrencyapp.data.repository

import br.com.jm.cryptocurrencyapp.data.remote.CoinPaprikaApi
import br.com.jm.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import br.com.jm.cryptocurrencyapp.data.remote.dto.CoinDto
import br.com.jm.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}