package alphasecurity.com.gangamesdk

import com.google.gson.annotations.SerializedName

data class Deal(var title: String,
                var salePrice: Float,
                var normalPrice: Float,
                var metacriticScore: Int,
                @SerializedName("steamRatingPercent") var steamRating: Int,
                var thumb: String)

data class TopGame(@SerializedName("name") var title: String,
                   val publisher: String,
                   @SerializedName("score_rank") var steamRating: Int,
                   val owners: String,
                   val price: Float,
                   var thumb: String)