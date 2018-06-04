package alphasecurity.com.gangame.data

import alphasecurity.com.gangame.Deal


object DealMapper {

    fun fromSdk(deal: alphasecurity.com.gangamesdk.Deal): Deal{
        return Deal(deal.title, deal.salePrice,
                deal.normalPrice, deal.metacriticScore, deal.steamRating, deal.thumb)
    }
}