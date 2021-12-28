package com.udacity.shoestore.shoe.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    var images: List<String> = mutableListOf()
) : Parcelable