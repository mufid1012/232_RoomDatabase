package com.example.roomdb.view.route

/**
 * Interface untuk mendefinisikan setiap destinasi navigasi dalam aplikasi.
 */
interface DestinasiNavigasi {

    /**
     * Nama unik untuk menentukan jalur route untuk composable.
     */
    val route: String

    /**
     * String resource ID yang berisi judul yang akan ditampilkan di layar halaman.
     */
    val titleRes: Int
}
