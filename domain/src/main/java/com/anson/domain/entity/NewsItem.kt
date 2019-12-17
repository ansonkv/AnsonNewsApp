package com.anson.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsItem(
    val title: String,
    val imgUrl: String,
    val date: String,
    val details: String,
    val byLine:String
) : Parcelable
{

}