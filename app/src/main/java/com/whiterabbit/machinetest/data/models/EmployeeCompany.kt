package com.whiterabbit.machinetest.data.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class EmployeeCompany(
    @SerializedName("name")
    val companyName: String?,

    @SerializedName("catchPhrase")
    val catchPhrase: String?,

    @SerializedName("bs")
    val bs: String?,

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(companyName)
        parcel.writeString(catchPhrase)
        parcel.writeString(bs)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EmployeeCompany> {
        override fun createFromParcel(parcel: Parcel): EmployeeCompany {
            return EmployeeCompany(parcel)
        }

        override fun newArray(size: Int): Array<EmployeeCompany?> {
            return arrayOfNulls(size)
        }
    }
}
