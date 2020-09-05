package info.sanaebadi.placeapp.mvvm.feature.place.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.AndroidSupportInjection
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.places.PlaceListModel
import info.sanaebadi.placeapp.R
import info.sanaebadi.placeapp.databinding.FragmentPlaceBinding
import info.sanaebadi.placeapp.mvvm.base.BaseFragment
import info.sanaebadi.placeapp.mvvm.feature.place.view.adapter.PlaceAdapter
import info.sanaebadi.placeapp.mvvm.feature.place.viewModel.PlaceViewModel
import kotlinx.android.synthetic.main.fragment_place.*
import java.util.*
import javax.inject.Inject

class PlaceFragment : BaseFragment(), PlaceAdapter.ItemClickListener {

    private var binding: FragmentPlaceBinding? = null
    private var navController: NavController? = null
    private var data: PlaceListModel? = null

    private var placeTitle: String? = null
    private var placeShortAddress: String? = null
    private var placeDescription: String? = null
    private var placeBannerUrl: String? = null
    private var placeScore: Double? = null

    private var adapter: PlaceAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private val viewModel: PlaceViewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory).get(PlaceViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaceBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        viewModel.getPlaces()
        setUpObserver()
        onRetryClick()

        filterList()

    }

    private fun filterList() {
        binding?.editQuery?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                filter(s.toString())
            }
        })
    }

    private fun setUpRecyclerview() {
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding?.recyclerPlaces?.layoutManager = layoutManager
        binding?.recyclerPlaces?.setHasFixedSize(true)
    }

    private fun setUpAdapter(data: List<PlaceItem?>) {
        setUpRecyclerview()
        adapter = PlaceAdapter(this, data)
        binding?.recyclerPlaces?.adapter = adapter
    }

    //TODO:ADD NETWORK
    private fun onRetryClick() {
        binding?.viewError?.buttonTryAgain?.setOnClickListener { v -> viewModel.getPlaces() }
    }


    private fun setUpObserver() {
        viewModel.place.observe(viewLifecycleOwner, Observer { mutableViewModelModel ->

            when {
                mutableViewModelModel.isLoading() -> {
                    showLoading(binding?.loading)
                    hideEmptyView(binding?.viewEmpty?.viewEmpty)
                    hideErrorView(binding?.viewError?.viewError)
                }
                mutableViewModelModel.getThrowable() != null -> {
                    hideLoading(binding?.loading)
                    hideEmptyView(binding?.viewEmpty?.viewEmpty)
                    mutableViewModelModel.getThrowable()!!.message?.let {
                        showErrorView(
                            it,
                            binding?.viewError?.textErrorMessage,
                            view_error
                        )
                    }
                }
                else -> {
                    hideLoading(binding?.loading)
                    hideErrorView(binding?.viewError?.viewError)
                    data = mutableViewModelModel.getData()


                    if (data?.places?.size != 0) {
                        setUpAdapter(data?.places!!)
                    } else {
                        showEmptyView(binding?.viewEmpty?.viewEmpty)
                    }
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun showLoading(view: View?) {
        super.showLoading(view)
    }

    override fun hideLoading(view: View?) {
        super.hideLoading(view)
    }

    override fun showEmptyView(view: View?) {
        super.showEmptyView(view)
        binding?.recyclerPlaces?.visibility = View.GONE
    }

    override fun hideEmptyView(view: View?) {
        super.hideEmptyView(view)
        binding?.recyclerPlaces?.visibility = View.VISIBLE
    }

    override fun showErrorView(message: String?, textError: AppCompatTextView?, view: View?) {
        super.showErrorView(message, textError, view)
        binding?.recyclerPlaces?.visibility = View.GONE
    }

    override fun hideErrorView(view: View?) {
        super.hideErrorView(view)
    }

    companion object {
        const val TAG: String = "PlaceFragment"
    }

    override fun onItemClick(position: Int) {
        placeTitle = data?.places?.get(position)?.title
        placeShortAddress = data?.places?.get(position)?.shortAddress
        placeDescription = data?.places?.get(position)?.description
        placeScore = data?.places?.get(position)?.score
        placeBannerUrl = data?.places?.get(position)?.bannerUrl

        val bundle = bundleOf(
            "placeTitle" to placeTitle,
            "placeShortAddress" to placeShortAddress,
            "placeDescription" to placeDescription,
            "placeScore" to placeScore,
            "placeBannerUrl" to placeBannerUrl,
        )
        //navigate to details fragment with bundle
        navController!!.navigate(R.id.action_placeFragment_to_detailsFragment, bundle)


    }


    fun filter(text: CharSequence?) {
        val temp: MutableList<PlaceItem?> = ArrayList<PlaceItem?>()
        for (placeItem: PlaceItem? in data?.places!!) {
            if (placeItem?.title?.contains(text!!)!! || placeItem.shortAddress?.contains(text!!)!!) {
                temp.add(placeItem)
            }
        }
        adapter?.updateList(temp)
    }
}