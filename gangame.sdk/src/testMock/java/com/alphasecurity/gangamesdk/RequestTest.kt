package com.alphasecurity.gangamesdk

import alphasecurity.com.gangamesdk.GangameApiService
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import org.junit.Assert
import org.junit.Test

class RequestTest {

    @Test
    fun dealsRequest_success(){
        val apiService = GangameApiService()
        val response = apiService.apiClient.getDeals().execute()
        val deals = response.body()

        val parser  = JsonParser()
        val jsonResponse: JsonArray = parser.parse(MockResponses.DEALS_RESPONSE).asJsonArray

        Assert.assertTrue(response.isSuccessful)

        deals?.let {
            Assert.assertEquals(deals.size, jsonResponse.size())

            deals.zip(jsonResponse).forEach { (deal, jsonDeal) ->
                with(jsonDeal.asJsonObject){
                    Assert.assertEquals(deal.title, this["title"].asString)
                    Assert.assertEquals(deal.metacriticScore, this["metacriticScore"].asInt)
                    Assert.assertEquals(deal.steamRating, this["steamRatingPercent"].asInt)
                    Assert.assertEquals(deal.thumb, this["thumb"].asString)
                }
            }
        }

    }
}