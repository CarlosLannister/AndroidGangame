package alphasecurity.com.gangame.deals

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
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class DealsFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
    }

    override fun onResume() {
        super.onResume()
        showDeals()
    }

    private fun showDeals() {
        GangameDataSource.getDeals().subscribe({ list ->
            replaceItems(list)
        }, {error ->
            showError(error)
        })
    }

    private fun replaceItems(list: List<Deal>){
        with (listAdapter as DataBindingRecyclerAdapter<Deal>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable){
        error.printStackTrace()
    }
}
