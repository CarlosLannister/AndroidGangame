package alphasecurity.com.gangame.owned

import alphasecurity.com.commons.BaseListFragment
import alphasecurity.com.commons.DataBindingRecyclerAdapter
import alphasecurity.com.gangame.BR
import alphasecurity.com.gangame.Deal
import alphasecurity.com.gangame.R
import alphasecurity.com.gangame.TopGame
import alphasecurity.com.gangame.data.GangameDataSource
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View

class TopOwnedFragment : BaseListFragment(){

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun onResume() {
        super.onResume()
        showTopOwnedGames()
    }

    private fun showTopOwnedGames() {
        GangameDataSource.getTopOwnedGames().subscribe({ list ->
            replaceItems(list)
        }, {error ->
            showError(error)
        })
    }

    private fun replaceItems(list: List<TopGame>){
        with (listAdapter as DataBindingRecyclerAdapter<TopGame>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable){
        error.printStackTrace()
    }
}
