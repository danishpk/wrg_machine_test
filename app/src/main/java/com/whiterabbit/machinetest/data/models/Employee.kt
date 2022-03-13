package com.whiterabbit.machinetest.data.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "employees")
data class Employee(

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String?,

    @SerializedName("username")
    @ColumnInfo(name = "username")
    val username: String?,

    @SerializedName("email")
    @ColumnInfo(name = "email")
    val email: String?,

    @SerializedName("profile_image")
    @ColumnInfo(name = "profile_image")
    val profileImage: String?,

    @SerializedName("address")
    @Embedded
    val employeeAddress: EmployeeAddress?,

    @SerializedName("geo")
    @Embedded
    val geo: Geo?,

    @SerializedName("phone")
    @ColumnInfo(name = "phone")
    val phone: String?,

    @SerializedName("website")
    @ColumnInfo(name = "website")
    val website: String?,

    @SerializedName("company")
    @Embedded
    val employeeCompany: EmployeeCompany?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(EmployeeAddress::class.java.classLoader),
        parcel.readParcelable(Geo::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(EmployeeCompany::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeString(email)
        parcel.writeString(profileImage)
        parcel.writeParcelable(employeeAddress, flags)
        parcel.writeParcelable(geo, flags)
        parcel.writeString(phone)
        parcel.writeString(website)
        parcel.writeParcelable(employeeCompany, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Employee> {
        override fun createFromParcel(parcel: Parcel): Employee {
            return Employee(parcel)
        }

        override fun newArray(size: Int): Array<Employee?> {
            return arrayOfNulls(size)
        }
    }
}
