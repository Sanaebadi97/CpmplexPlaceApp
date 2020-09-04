package info.sanaebadi.placeapp.mvvm.feature.place.view.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProvider
import info.sanaebadi.placeapp.R
import info.sanaebadi.placeapp.mvvm.base.BaseFragment
import info.sanaebadi.placeapp.mvvm.feature.place.viewModel.PlaceViewModel
import javax.inject.Inject

class PlaceFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_place

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PlaceViewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory).get(PlaceViewModel::class.java)
    }

    override fun initViews(view: View, savedInstanceState: Bundle?) {
        super.initViews(view, savedInstanceState)
        viewModel.getPlaces()

    }

    private fun setUpObserver() {
        viewModel.place.observe(this)
    }

    override fun showLoading(view: View) {
        super.showLoading(view)
    }

    override fun hideLoading(view: View) {
        super.hideLoading(view)
    }

    override fun showEmptyView(view: View) {
        super.showEmptyView(view)
    }

    override fun hideEmptyView(view: View) {
        super.hideEmptyView(view)
    }

    override fun showErrorView(message: String, errorMessage: AppCompatTextView, view: View) {
        super.showErrorView(message, errorMessage, view)
    }

    override fun hideErrorView(view: View) {
        super.hideErrorView(view)
    }


    override val toolbarTitle: String
        get() = TODO("Not yet implemented")
    override val toolbarBackground: Drawable
        get() = TODO("Not yet implemented")
    override val toolbarActionIcon: Drawable
        get() = TODO("Not yet implemented")
    override val toolbarSettigIcon: Drawable
        get() = TODO("Not yet implemented")
    override val outBoxSettingIcon: Drawable
        get() = TODO("Not yet implemented")
    override val toolbarSettingEnabled: Boolean
        get() = TODO("Not yet implemented")
    override val isToolbarVisible: Boolean
        get() = TODO("Not yet implemented")
    override val toolbarActionEnabled: Boolean
        get() = TODO("Not yet implemented")
    override val outBoxActionEnabled: Boolean
        get() = TODO("Not yet implemented")
    override val searchToolbarEnabled: Boolean
        get() = TODO("Not yet implemented")
    override val searchViewQueryHint: String
        get() = TODO("Not yet implemented")
    override val searchViewInputType: Int
        get() = TODO("Not yet implemented")
    override var searchViewIsCleared: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun onToolbarActionIconClick() {
        TODO("Not yet implemented")
    }

    override fun onToolbarSettingIconClick() {
        TODO("Not yet implemented")
    }
}