package com.example.roomdb.view.route

import com.example.roomdb.R

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa

    const val itemIdArg = "idSiswa"

    // Route dengan argumen
    val routeWithArgs = "$route/{$itemIdArg}"

    // Fungsi untuk membuat route ke halaman Edit berdasarkan ID
    fun buatRouteDenganId(id: Int): String = "$route/$id"
}
