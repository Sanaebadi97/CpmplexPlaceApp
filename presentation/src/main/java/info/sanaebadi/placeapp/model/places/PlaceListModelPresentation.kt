package info.sanaebadi.placeapp.model.places

import android.os.Parcel
import android.os.Parcelable
import info.sanaebadi.domain.model.base.BaseDomainModel
import info.sanaebadi.placeapp.mvvm.base.AdapterConstants
import info.sanaebadi.placeapp.mvvm.base.ViewType

data class PlaceListModelPresentation(
    val places: List<PlaceItemPresentation>? = null
) : BaseDomainModel

data class PlaceItemPresentation(
    val score: Double? = null,
    val shortAddress: String? = null,
    val bannerUrl: String? = null,
    val description: String? = null,
    val id: Int? = null,
    val iconUrl: String? = null,
    val title: String? = null
) :  ViewType, Parcelable {

    override fun getViewType(): Int = AdapterConstants.PLACE_LIST

    companion object CREATOR : Parcelable.Creator<PlaceItemPresentation> {
        override fun createFromParcel(parcel: Parcel): PlaceItemPresentation {
            return PlaceItemPresentation(parcel)
        }

        override fun newArray(size: Int): Array<PlaceItemPresentation?> {
            return arrayOfNulls(size)
        }
    }

    constructor(parcel: Parcel) : this(
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    )


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
}
