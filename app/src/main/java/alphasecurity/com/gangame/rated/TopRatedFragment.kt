package alphasecurity.com.gangame.rated

import alphasecurity.com.commons.BaseListFragment
import alphasecurity.com.commons.DataBindingRecyclerAdapter
import alphasecurity.com.gangame.BR
import alphasecurity.com.gangame.R
import alphasecurity.com.gangame.TopGame
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View

class TopRatedFragment : BaseListFragment(){
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (listAdapter as DataBindingRecyclerAdapter<TopGame>).items.addAll(getDummyTopGame())
        listAdapter.notifyDataSetChanged()
    }

    fun getDummyTopGame(): ArrayList<TopGame>{
        return arrayListOf(TopGame("Counter Strike", 13407338, 80,
                "Valve",9.99F,
                1, "https://0901.static.prezi.com/preview/uluorts4rigx3gqob2ictrnawd6jc3sachvcdoaizecfr3dnitcq_0_0.png"))
    }

}