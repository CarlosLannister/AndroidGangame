package alphasecurity.com.gangame.deals

import alphasecurity.com.commons.BaseListFragment
import alphasecurity.com.commons.DataBindingRecyclerAdapter
import alphasecurity.com.gangame.BR
import alphasecurity.com.gangame.Deal
import alphasecurity.com.gangame.R
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View

class DealsFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (listAdapter as DataBindingRecyclerAdapter<Deal>).items.addAll(getDummyDeals())
        listAdapter.notifyDataSetChanged()
    }

    fun getDummyDeals(): ArrayList<Deal> {
        return arrayListOf(Deal("Counter Strike", 0.99F, 9.99F,
                80, 80,
                "https://0901.static.prezi.com/preview/uluorts4rigx3gqob2ictrnawd6jc3sachvcdoaizecfr3dnitcq_0_0.png"))
    }
}
