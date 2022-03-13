package com.whiterabbit.machinetest.data.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class EmployeeAddress(
    @SerializedName("street")
    val street: String?,

    @SerializedName("suite")
    val suite: String?,

    @SerializedName("city")
    val city: String?,

    @SerializedName("zipcode")
    val zipcode: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(street)
        parcel.writeString(suite)
        parcel.writeString(city)
        parcel.writeString(zipcode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EmployeeAddress> {
        override fun createFromParcel(parcel: Parcel): EmployeeAddress {
            return EmployeeAddress(parcel)
        }

        override fun newArray(size: Int): Array<EmployeeAddress?> {
            return arrayOfNulls(size)
        }
    }
}
