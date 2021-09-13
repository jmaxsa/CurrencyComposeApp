package br.com.jm.cryptocurrencyapp.domain.use_case.get_coin

import br.com.jm.cryptocurrencyapp.common.Resource
import br.com.jm.cryptocurrencyapp.data.remote.dto.toCoinDetail
import br.com.jm.cryptocurrencyapp.domain.model.CoinDetail
import br.com.jm.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(message = e.localizedMessage ?: "An unexpected error ocurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}