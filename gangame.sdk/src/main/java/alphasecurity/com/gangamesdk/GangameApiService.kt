package alphasecurity.com.gangamesdk

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GangameApiService {

    val apiClient: RetrofitGangameApi

    init {
        val apiClientConfig = Retrofit.Builder().baseUrl(Routes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()

        apiClient = apiClientConfig.create(RetrofitGangameApi::class.java)

    }
}