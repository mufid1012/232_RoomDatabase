package com.example.roomdb.view.route

import androidx.annotation.StringRes
import com.example.roomdb.R

object DestinasiDetailSiswa {
    const val route = "detail_siswa"
    const val itemIdArg = "itemId"

    @StringRes
    val titleRes = R.string.detail_siswa

    fun buatRouteDenganId(id: Int): String = "$route/$id"
}
