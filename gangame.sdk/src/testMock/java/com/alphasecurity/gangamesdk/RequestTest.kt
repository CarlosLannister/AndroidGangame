package com.alphasecurity.gangamesdk

import alphasecurity.com.gangamesdk.GangameApiService
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

class RequestTest {

    @Test
    fun dealsRequest_success() {
        val apiService = GangameApiService()
        val response = apiService.apiClient.getDeals().execute()
        val deals = response.body()

        val parser = JsonParser()
        val jsonResponse: JsonArray = parser.parse(MockResponses.DEALS_RESPONSE).asJsonArray

        Assert.assertTrue(response.isSuccessful)

        deals?.let {
            Assert.assertEquals(deals.size, jsonResponse.size())

            deals.zip(jsonResponse).forEach { (deal, jsonDeal) ->
                with(jsonDeal.asJsonObject) {
                    Assert.assertEquals(deal.title, this["title"].asString)
                    Assert.assertEquals(deal.metacriticScore, this["metacriticScore"].asInt)
                    Assert.assertEquals(deal.steamRating, this["steamRatingPercent"].asInt)
                    Assert.assertEquals(deal.thumb, this["thumb"].asString)
                }
            }
        }
    }


    @Test
    fun topRatedRequest_success() {
        val apiService = GangameApiService()
        val response = apiService.apiClient.getTopRatedGames().execute()
        val games = response.body()

        val parser = JsonParser()
        val jsonResponse: List<JsonObject> = parser.parse(MockResponses.TOP_100_GAMES).
                asJsonObject
                .entrySet()
                .map { (_, json) ->
                    json.asJsonObject
                }

        Assert.assertTrue(response.isSuccessful)

        games?.let {
            Assert.assertEquals(games.size, jsonResponse.size)

            games.zip(jsonResponse).forEach { (topGame, jsonTopGame) ->
                with(jsonTopGame.asJsonObject) {
                    Assert.assertEquals(topGame.title, this["name"].asString)
                    Assert.assertEquals(topGame.steamRating, this["score_rank"].asInt)
                    Assert.assertEquals(topGame.publisher, this["publisher"].asString)
                    Assert.assertEquals(topGame.owners, this["owners"].asString)
                    Assert.assertEquals(topGame.thumb, "https://steamcdn-a.akamaihd.net/steam/apps/${this["appid"].asInt}/capsule_sm_120.jpg?t=1515532267")
                }
            }
        }
    }
}