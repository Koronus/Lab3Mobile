package com.example.tipsday

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataTip(
    @StringRes val numberTipId: Int,
    @StringRes val titleId: Int,
    @DrawableRes val imageId: Int,
    @StringRes val descriptionId: Int,
    @StringRes val fullTextDetailId: Int
) : Parcelable

