package com.wikipedia.myapplication.user

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
                val name: String? = null,
                val website: String? = null,
                val email: String? = null
) : Parcelable {

}