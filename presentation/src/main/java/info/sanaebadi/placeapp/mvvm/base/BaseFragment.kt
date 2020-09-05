package info.sanaebadi.placeapp.mvvm.base

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    open fun showLoading(view: View?) {
        view?.visibility = View.VISIBLE
    }

    open fun hideLoading(view: View?) {
        view?.visibility = View.GONE
    }

    open fun showEmptyView(view: View?) {
        view?.visibility = View.VISIBLE
    }

    open fun hideEmptyView(view: View?) {
        view?.visibility = View.GONE
    }

    open fun showErrorView(message: String?, textError: AppCompatTextView?, view: View?) {
        view?.visibility = View.VISIBLE
        textError?.text = message
    }

    open fun hideErrorView(view: View?) {
        view?.visibility = View.GONE
    }
}