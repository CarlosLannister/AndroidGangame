package alphasecurity.com.gangamesdk.serializer

import alphasecurity.com.gangamesdk.TopGame
import com.google.gson.*
import java.lang.reflect.Type

class ListTopGameDeserializer : JsonDeserializer<ArrayList<TopGame>> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): ArrayList<TopGame> {
        val jsonTopGame =  json.asJsonObject
                .entrySet()
                .map { (_, json) ->
                    json.asJsonObject
                }
        val gsonTopGame = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .create()
        val listTopGames = jsonTopGame.map { json ->
            gsonTopGame.fromJson(json, TopGame::class.java)
        }

        val arrayListTopGames : ArrayList<TopGame> = arrayListOf()
        arrayListTopGames.addAll(listTopGames)
        return arrayListTopGames
    }
}