package info.sanaebadi.placeapp.mvvm.feature.place.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import dagger.android.support.DaggerFragment
import info.sanaebadi.domain.model.place.PlaceData
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.placeapp.databinding.FragmentDetailsBinding
import info.sanaebadi.placeapp.mvvm.base.PlacesView
import info.sanaebadi.placeapp.util.loadUrl

class DetailsFragment : DaggerFragment(), PlacesView {

    private var binding: FragmentDetailsBinding? = null
    private var navController: NavController? = null

    private var placeTitle: String? = null
    private var placeShortAddress: String? = null
    private var placeDescription: String? = null
    private var placeBannerUrl: String? = null
    private var placeScore: Double? = null
    private var isFav: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        placeTitle = requireArguments().getString("placeTitle")
        placeShortAddress = requireArguments().getString("placeShortAddress")
        placeDescription = requireArguments().getString("placeDescription")
        placeBannerUrl = requireArguments().getString("placeBannerUrl")
        placeScore = requireArguments().getDouble("placeScore")
        isFav = requireArguments().getBoolean("isFav")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUi()

    }

    private fun initializeUi() {
        binding?.textPlaceTitle?.text = placeTitle
        binding?.textPlaceDescription?.text = placeDescription
        binding?.textPlaceShortAddress?.text = placeShortAddress
        binding?.textPlaceScore?.text = placeScore.toString()

        binding?.imagePlaceBanner?.loadUrl(placeBannerUrl!!)


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun showDetails(places: PlaceData) {
        for (position in places.favoriteIds.favoriteIds!!.indices) {
            for (placeItem: PlaceItem in places.places) {
                if (places.favoriteIds.favoriteIds!![position] == placeItem.id) {
                    binding?.textFavorite?.visibility = View.VISIBLE
                }
            }
            for (promotedItem: PromotedItem in places.promotedList) {
                if (places.favoriteIds.favoriteIds!![position] == promotedItem.id) {
                    binding?.textFavorite?.visibility = View.VISIBLE
                }

            }
        }
    }

    override fun showError(error: String) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun showEmpty() {
        TODO("Not yet implemented")
    }

    override fun hideError() {
        TODO("Not yet implemented")
    }

    override fun hideEmpty() {
        TODO("Not yet implemented")
    }
}