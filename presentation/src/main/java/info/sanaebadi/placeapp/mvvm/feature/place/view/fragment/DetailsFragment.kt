package info.sanaebadi.placeapp.mvvm.feature.place.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import dagger.android.support.AndroidSupportInjection
import info.sanaebadi.placeapp.R
import info.sanaebadi.placeapp.databinding.FragmentDetailsBinding
import info.sanaebadi.placeapp.mvvm.base.BaseFragment

class DetailsFragment : BaseFragment() {

    private var binding: FragmentDetailsBinding? = null
    private var navController: NavController? = null

    private var placeTitle: String? = null
    private var placeShortAddress: String? = null
    private var placeDescription: String? = null
    private var placeBannerUrl: String? = null
    private var placeScore: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        placeTitle = requireArguments().getString("placeTitle")
        placeShortAddress = requireArguments().getString("placeShortAddress")
        placeDescription = requireArguments().getString("placeDescription")
        placeBannerUrl = requireArguments().getString("placeBannerUrl")
        placeScore = requireArguments().getDouble("placeScore")
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

        activity?.let {
            Glide.with(it)
                .load(placeBannerUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding?.imagePlaceBanner!!)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}