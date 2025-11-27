package com.example.roomdb.viewmodel.provider

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdb.repositori.AplikasiSiswa

    import com.example.roomdb.viewmodel.HomeViewModel
import com.example.roomdb.viewmodel.EntryViewModel

object PenyediaViewModel {

    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }

        initializer {
            EntryViewModel(
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }
    }
}

/**
 * Fungsi ekstensi CreationExtras
 * Mengambil Application dan mengembalikan instance AplikasiSiswa
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[APPLICATION_KEY] as AplikasiSiswa)
