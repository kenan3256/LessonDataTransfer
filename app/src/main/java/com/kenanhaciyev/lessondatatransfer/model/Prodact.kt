package com.kenanhaciyev.lesson03mydatatransfer.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class Prodact(
                    val id: Int,
                    val name: String,
                    val description: String
):Parcelable
