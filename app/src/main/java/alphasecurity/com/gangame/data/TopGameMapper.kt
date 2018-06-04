package alphasecurity.com.gangame.data

import alphasecurity.com.gangame.TopGame

object TopGameMapper {

    fun fromSdk(topGame: alphasecurity.com.gangamesdk.TopGame, position: Int): TopGame{
        return TopGame(topGame.title, topGame.owners, topGame.steamRating,
                topGame.publisher, topGame.price, position, topGame.thumb)
    }
}