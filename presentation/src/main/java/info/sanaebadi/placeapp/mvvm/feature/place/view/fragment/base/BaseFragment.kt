package info.sanaebadi.placeapp.mvvm.feature.place.view.fragment.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import info.sanaebadi.placeapp.R

abstract class BaseFragment : Fragment() {

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


}