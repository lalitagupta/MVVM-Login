package com.wikipedia.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserListResponse(val arrayList: ArrayList<User>
) : Parcelable {

}