package com.example.roomdb.viewmodel

import com.example.roomdb.room.Siswa

data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)

fun Siswa.toDetailSiswa(): DetailSiswa =
    DetailSiswa(
        id = id,
        nama = nama,
        alamat = alamat,
        telpon = telpon
    )

fun DetailSiswa.toSiswa(): Siswa =
    Siswa(
        id = id,
        nama = nama,
        alamat = alamat,
        telpon = telpon
    )
fun Siswa.toUIStateSiswa(isValid: Boolean = false): UIStateSiswa {
    return UIStateSiswa(
        detailSiswa = DetailSiswa(
            id = id,
            nama = nama,
            alamat = alamat,
            telpon = telpon
        ),
        isEntryValid = isValid
    )
}

