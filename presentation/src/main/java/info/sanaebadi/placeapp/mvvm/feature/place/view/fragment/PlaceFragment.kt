package info.sanaebadi.placeapp.mvvm.feature.place.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import info.sanaebadi.domain.model.place.PlaceData
import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import info.sanaebadi.domain.model.place.places.PlaceListModel
import info.sanaebadi.domain.model.place.promoted.PromotedListModel
import info.sanaebadi.placeapp.R
import info.sanaebadi.placeapp.databinding.FragmentPlaceBinding
import info.sanaebadi.placeapp.mvvm.base.PlacesView
import info.sanaebadi.placeapp.mvvm.feature.place.adapter.PlaceAdapter
import info.sanaebadi.placeapp.mvvm.feature.place.viewModel.PlaceViewModel
import javax.inject.Inject

class PlaceFragment : DaggerFragment(), PlacesView {


    companion object {
        const val TAG: String = "PlaceFragment"
    }

    private var binding: FragmentPlaceBinding? = null
    private var navController: NavController? = null
    private var placeData: PlaceListModel? = null
    private var favoriteData: FavoriteListItem? = null
    private var promotedData: PromotedListModel? = null

    private var placeTitle: String? = null
    private var placeShortAddress: String? = null
    private var placeDescription: String? = null
    private var placeBannerUrl: String? = null
    private var placeScore: Double? = null
    private var isFav: Boolean = false


    @Inject
    lateinit var viewModel: PlaceViewModel

    private val placeAdapter by lazy {
        PlaceAdapter { position ->

//            placeTitle = data?.places?.get(position)?.title
//            placeShortAddress = data?.places?.get(position)?.shortAddress
//            placeDescription = data?.places?.get(position)?.description
//            placeScore = data?.places?.get(position)?.score
//            placeBannerUrl = data?.places?.get(position)?.bannerUrl

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

        }
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
        viewModel.getPlaces()
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
        }
    }


    override fun showError(error: String) {
        binding?.viewError?.viewError?.visibility = View.VISIBLE
        binding?.viewError?.textErrorMessage?.text = error
    }

    override fun showEmpty() {
        binding?.viewEmpty?.viewEmpty?.visibility = View.VISIBLE
    }

    override fun showLoading() {
        placeAdapter.addLoadingItem()
    }

    override fun hideLoading() {
        placeAdapter.removeLoadingItem()
    }


}