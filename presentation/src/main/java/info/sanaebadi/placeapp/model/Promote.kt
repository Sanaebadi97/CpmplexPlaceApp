package info.sanaebadi.placeapp.model

import android.os.Parcel
import android.os.Parcelable
import info.sanaebadi.placeapp.mvvm.base.AdapterConstants
import info.sanaebadi.domain.model.base.ViewType


data class Promote(
    val score: Double? = null,
    val shortAddress: String? = null,
    val bannerUrl: String? = null,
    val description: String? = null,
    val id: Int? = null,
    val iconUrl: String? = null,
    val title: String? = null
) : ViewType, Parcelable {
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

    override fun getViewType() = AdapterConstants.PLACE_PROMOTED
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

    companion object CREATOR : Parcelable.Creator<Promote> {
        override fun createFromParcel(parcel: Parcel): Promote {
            return Promote(parcel)
        }

        override fun newArray(size: Int): Array<Promote?> {
            return arrayOfNulls(size)
        }
    }
}