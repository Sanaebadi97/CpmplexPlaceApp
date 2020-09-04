package info.sanaebadi.placeapp.mvvm.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import info.sanaebadi.placeapp.mvvm.service.ConnectionDetector
import info.sanaebadi.placeapp.mvvm.ui.`interface`.ToolbarProperties
import javax.inject.Inject

abstract class BaseFragment : Fragment(), ToolbarProperties {

    @Inject
    lateinit var connectionDetector: ConnectionDetector
    private lateinit var networkStateBar: ConstraintLayout
    private lateinit var networkStateIcon: AppCompatImageView

    override val connectionDetectorEnabled = false

    @get:LayoutRes
    protected abstract val layoutResId: Int


    private val onBackPressedCallback: OnBackPressedCallback by lazy {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (!onBackPressed()) {
                onBackPressedCallback.isEnabled = false
                activity?.onBackPressed()
            }
        }
    }

    final override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        onBackPressedCallback.isEnabled = true
        initData(savedInstanceState)
    }

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view, savedInstanceState)
    }


    protected open fun initData(savedInstanceState: Bundle?) {
    }

    protected open fun initViews(view: View, savedInstanceState: Bundle?) {
    }

    /**
     * Invoked when back button is pressed, return true to consume the event
     */
    open fun onBackPressed(): Boolean {
        return false
    }

    protected fun navigateUp() = activity?.onBackPressed()


    open fun navigateToHome() {}


    fun hideKeyboard() {
        // Check if no view has focus:
        val view = activity?.currentFocus
        view?.let {
            val inputManager =
                activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?

            inputManager?.hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }


    open fun showErrorView(message: String, errorMessage: AppCompatTextView, view: View) {
        errorMessage.text = message
        view.visibility = View.VISIBLE
    }


    open fun hideErrorView(view: View) {
        view.visibility = View.GONE
    }

    open fun showEmptyView(view: View) {
        view.visibility = View.VISIBLE
    }

    open fun hideEmptyView(view: View) {
        view.visibility = View.GONE
    }


    open fun showLoading(view: View) {
        view.visibility = View.VISIBLE
    }

    open fun hideLoading(view: View) {
        view.visibility = View.GONE
    }

//    protected open fun detectNetConnection() {
//        connectionDetector.observe(viewLifecycleOwner, Observer {
//            if (!it.isConnected) {
//                if (connectionDetectorEnabled)
//                    networkStateIcon.visible()
//                else
//                    networkStateBar.visible()
//            } else {
//                networkStateBar.invisible()
//            }
//        })
//    }
}