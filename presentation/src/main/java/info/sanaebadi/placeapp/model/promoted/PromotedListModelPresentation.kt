package info.sanaebadi.placeapp.model.promoted

import android.os.Parcel
import android.os.Parcelable
import info.sanaebadi.domain.model.base.BaseDomainModel
import info.sanaebadi.placeapp.mvvm.base.AdapterConstants
import info.sanaebadi.placeapp.mvvm.base.ViewType

data class PromotedListModelPresentation(
	val promotedList: MutableList<PromotedItemPresentation>? = null
) : BaseDomainModel


data class PromotedItemPresentation(
	val score: Double? = null,
	val shortAddress: String? = null,
	val bannerUrl: String? = null,
	val description: String? = null,
	val id: Int? = null,
	val iconUrl: String? = null,
	val title: String? = null
) :  ViewType, Parcelable {

    override fun getViewType() = AdapterConstants.PLACE_PROMOTED

    constructor(parcel: Parcel) : this(
		parcel.readValue(Double::class.java.classLoader) as? Double,
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readString()
	) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(score)
        parcel.writeString(shortAddress)
        parcel.writeString(bannerUrl)
        parcel.writeString(description)
        parcel.writeValue(id)
        parcel.writeString(iconUrl)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PromotedItemPresentation> {
        override fun createFromParcel(parcel: Parcel): PromotedItemPresentation {
            return PromotedItemPresentation(parcel)
        }

        override fun newArray(size: Int): Array<PromotedItemPresentation?> {
            return arrayOfNulls(size)
        }
    }
}