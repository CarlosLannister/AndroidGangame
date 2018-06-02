package alphasecurity.com.gangamesdk

import alphasecurity.com.gangamesdk.serializer.TopGameDeserializer
import com.alphasecurity.gangamesdk.GangameClientConfig
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GangameApiService(val apiConfig: GangameApiConfig = GangameClientConfig()) {

    val apiClient: RetrofitGangameApi

    init {
        val gson = GsonBuilder().registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .create()

        val apiClientConfig = Retrofit.Builder().baseUrl(Routes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))

        apiConfig.setupConfig(apiClientConfig)

        apiClient = apiClientConfig.build().create(RetrofitGangameApi::class.java)
    }
}