package alphasecurity.com.gangamesdk

object Routes {

    const val CHEAP_SHARK_STEAM_STORE = "1"

    const val BASE_URL = "https://steamspy.com/api.php/"
    const val BASE_URL_STEAM_SPY = "https://steamspy.com/api.php"
    const val BASE_URL_CHEAP_SHARK = "https://www.cheapshark.com/api/1.0"

    const val GET_TOP_100_GAMES = BASE_URL_STEAM_SPY + "?request=top100in2weeks"
    const val GET_MOST_OWNED_GAMES = BASE_URL_STEAM_SPY + "?request=top100owned"
    const val GET_DEALS = BASE_URL_CHEAP_SHARK + "/deals?storeID=" + CHEAP_SHARK_STEAM_STORE

}