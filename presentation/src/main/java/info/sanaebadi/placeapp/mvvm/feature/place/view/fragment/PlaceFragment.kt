package info.sanaebadi.placeapp.mvvm.feature.place.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.domain.model.place.PlaceData
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.placeapp.R
import info.sanaebadi.placeapp.databinding.FragmentPlaceBinding
import info.sanaebadi.placeapp.mvvm.base.PlacesView
import info.sanaebadi.placeapp.mvvm.feature.place.view.adapter.PlaceAdapter
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewModel.PlaceViewModel
import info.sanaebadi.placeapp.util.ConnectionHelper
import javax.inject.Inject

class PlaceFragment : DaggerFragment(), PlacesView {


    companion object {
        const val TAG: String = "PlaceFragment"
    }

    private var binding: FragmentPlaceBinding? = null
    private var navController: NavController? = null

    private var placeTitle: String? = null
    private var placeShortAddress: String? = null
    private var placeDescription: String? = null
    private var placeBannerUrl: String? = null
    private var placeScore: Double? = null
    private var isFav: Boolean = false

    lateinit var favView: View
    private var viewPosition: Int? = null

    @Inject
    lateinit var viewModel: PlaceViewModel

    private val placeAdapter by lazy {
        PlaceAdapter({ placeData, promoted ->

            placeTitle = placeData.title
            placeShortAddress = placeData.shortAddress
            placeDescription = placeData.description
            placeScore = placeData.score
            placeBannerUrl = placeData.bannerUrl

            placeTitle = promoted.title
            placeShortAddress = promoted.shortAddress
            placeDescription = promoted.description
            placeScore = promoted.score
            placeBannerUrl = promoted.bannerUrl

            val bundle = bundleOf(
                "placeTitle" to placeTitle,
                "placeShortAddress" to placeShortAddress,
                "placeDescription" to placeDescription,
                "placeScore" to placeScore,
                "placeBannerUrl" to placeBannerUrl,
                "isFav" to isFav
            )
            //navigate to details fragment with bundle
            navController!!.navigate(R.id.action_placeFragment_to_detailsFragment, bundle)

        }, { view, position ,placeItem , favoriteList ->
            run {
                    if (favoriteList.favoriteIds?.size != 0) {
                        for (i in 0 until favoriteList.favoriteIds?.size!!) {
                            if (favoriteList.favoriteIds!![i] == placeItem.places[position]!!.id) {
                                 view.visibility = View.VISIBLE
                                continue
                            }
                        }
                    }
                }
            }
        })
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
        viewModel.attachView(this)

        val connectionHelper = activity?.let { ConnectionHelper(it) }
        if (connectionHelper!!.isOnline()) {
            viewModel.getPlaces()
        } else {
            showError(getString(R.string.check_internet))
        }


        initAdapter()

    }

    override fun onDestroyView() {
        viewModel.detachView()
        super.onDestroyView()
    }

    private fun initAdapter() {
        binding?.recyclerPlaces?.layoutManager = LinearLayoutManager(context)
        binding?.recyclerPlaces?.setHasFixedSize(true)
        binding?.recyclerPlaces?.adapter = placeAdapter
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun showDetails(places: PlaceData) {
        with(placeAdapter) {
            addItemsToList(places.promotedList)
            addItemsToList(places.places)
            notifyDataSetChanged()
            filterList(places)
            filterFavorite(places)
            notifyDataSetChanged()

            showFavIcon(places)


        }
    }



    private fun PlaceAdapter.filterFavorite(
        places: PlaceData
    ): Unit? {
        return binding?.switchFavorite?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                val temp: MutableList<ViewType> = ArrayList()

                for (position in places.favoriteIds.favoriteIds!!.indices) {
                    for (placeItem: PlaceItem in places.places) {
                        if (places.favoriteIds.favoriteIds!![position] == placeItem.id) {
                            temp.add(placeItem)
                        }
                    }
                    for (promotedItem: PromotedItem in places.promotedList) {
                        if (places.favoriteIds.favoriteIds!![position] == promotedItem.id) {
                            temp.add(promotedItem)
                        }

                    }
                }


                placeAdapter.updateList(temp)
            } else {
                addItemsToList(places.promotedList)
                addItemsToList(places.places)
                notifyDataSetChanged()
            }

        }
    }

    private fun filterList(places: PlaceData): Unit? {
        return binding?.editQuery?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                filterWords(places, s)
            }
        })
    }


    private fun filterWords(
        places: PlaceData,
        s: Editable
    ) {
        val temp: MutableList<ViewType> = ArrayList()

        for (placeItem: PlaceItem in places.places) {
            if (placeItem.title?.contains(s.toString())!!) {
                temp.add(placeItem)
            }
        }
        for (promotedItem: PromotedItem in places.promotedList) {
            if (promotedItem.title?.contains(s.toString())!!) {
                temp.add(promotedItem)

            }

        }

        placeAdapter.updateList(temp)
    }


    override fun showError(error: String) {
        binding?.viewError?.viewError?.visibility = View.VISIBLE
        binding?.viewError?.textErrorMessage?.text = error
    }

    override fun showEmpty() {
        binding?.viewEmpty?.viewEmpty?.visibility = View.VISIBLE
    }

    override fun hideError() {
        binding?.viewError?.viewError?.visibility = View.GONE
    }

    override fun hideEmpty() {
        binding?.viewEmpty?.viewEmpty?.visibility = View.GONE
    }

    override fun showLoading() {
        placeAdapter.addLoadingItem()
    }

    override fun hideLoading() {
        placeAdapter.removeLoadingItem()
    }


}