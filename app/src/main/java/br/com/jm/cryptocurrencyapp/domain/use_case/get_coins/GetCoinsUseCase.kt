package br.com.jm.cryptocurrencyapp.domain.use_case.get_coins

import br.com.jm.cryptocurrencyapp.common.Resource
import br.com.jm.cryptocurrencyapp.data.remote.dto.toCoin
import br.com.jm.cryptocurrencyapp.domain.model.Coin
import br.com.jm.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}