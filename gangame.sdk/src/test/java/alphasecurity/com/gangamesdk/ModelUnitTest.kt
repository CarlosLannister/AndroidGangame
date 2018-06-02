package alphasecurity.com.gangamesdk

import alphasecurity.com.gangamesdk.serializer.TopGameDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.Assert
import org.junit.Test

class ModelUnitTest {

    val JSON_DEAL = "{" +
        "\"internalName\" : \"PLANESCAPETORMENTENHANCEDEDITION\"," +
        "\"title\": \"Planescape: Torment Enhanced Edition\"," +
        "\"metacriticLink\": \"/game/pc/planescape-torment---enhanced-edition\", " +
        "\"dealID\": \"TfPt8pXs2mAWlAAfuWji5bU86IOE8uO8JLvminGn2aw%3D\"," +
        "\"storeID\": \"1\", " +
        "\"gameID\": \"167738\", " +
        "\"salePrice\": \"3.99\", " +
        "\"normalPrice\": \"19.99\", " +
        "\"isOnSale\": \"1\", " +
        "\"savings\": \"80.040020\", " +
        "\"metacriticScore\": \"85\", " +
        "\"steamRatingText\": \"Overwhelmingly Positive\", " +
        "\"steamRatingPercent\": \"95\", " +
        "\"steamRatingCount\": \"616\", " +
        "\"steamAppID\": \"466300\", " +
        "\"releaseDate\": 1491868800, " +
        "\"lastChange\": 1527875051, " +
        "\"dealRating\": \"9.6\", " +
        "\"thumb\": \"https://steamcdn-a.akamaihd.net/steam/apps/466300/capsule_sm_120.jpg?t=1515532267\"" +
        "}"

    val JSON_TOP_GAME = "{" +
        "\"appid\": 10, " +
        "\"name\": \"Counter-Strike\", " +
        "\"developer\": \"Valve\", " +
        "\"publisher\": \"Valve\", " +
        "\"score_rank\": 97, " +
        "\"positive\": 110768, " +
        "\"negative\": 2726, " +
        "\"userscore\": 96, " +
        "\"owners\": \"10,000,000 .. 20,000,000\", " +
        "\"average_forever\": 13985, " +
        "\"average_2weeks\": 669, " +
        "\"median_forever\": 230, " +
        "\"median_2weeks\": 6, " +
        "\"price\": \"999\", " +
        "\"initialprice\": \"999\", " +
        "\"discount\": \"0\" " +
        "}"

    @Test
    fun dealsParsingTest(){
        val gson = Gson()
        val deal = gson.fromJson(JSON_DEAL, Deal::class.java)

        Assert.assertEquals(deal.title, "Planescape: Torment Enhanced Edition")
        Assert.assertEquals(deal.metacriticScore, 85)
        Assert.assertEquals(deal.steamRating, 95)
        Assert.assertEquals(deal.salePrice, 3.99F)
        Assert.assertEquals(deal.normalPrice, 19.99F)
        Assert.assertEquals(deal.thumb, "https://steamcdn-a.akamaihd.net/steam/apps/466300/capsule_sm_120.jpg?t=1515532267")
    }

    @Test
    fun topGameParsingTest() {
        val gson = GsonBuilder().registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .create()

        val topGame = gson.fromJson(JSON_TOP_GAME, TopGame::class.java)

        Assert.assertEquals(topGame.title, "Counter-Strike")
        Assert.assertEquals(topGame.steamRating, 97)
        Assert.assertEquals(topGame.owners, "10,000,000 .. 20,000,000")
        Assert.assertEquals(topGame.publisher, "Valve")
        Assert.assertEquals(topGame.thumb, "https://steamcdn-a.akamaihd.net/steam/apps/10/capsule_sm_120.jpg?t=1515532267")
    }
}