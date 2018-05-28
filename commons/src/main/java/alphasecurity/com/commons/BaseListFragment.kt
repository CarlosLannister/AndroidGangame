package alphasecurity.com.commons

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_list.view.*

abstract class BaseListFragment : BaseFragment(){

    val listAdapter: RecyclerView.Adapter<*>
            get() = getAdapter()

    override fun getLayoutResId(): Int {
        return R.layout.fragment_list
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view?.list?.let {
            with(view.list){
                list.adapter = listAdapter
                list.layoutManager = LinearLayoutManager(context)
            }
        }
    }

    abstract fun getAdapter(): RecyclerView.Adapter<*>
}