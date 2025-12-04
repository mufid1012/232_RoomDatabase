package com.example.roomdb.viewmodel.provider

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdb.repositori.AplikasiSiswa
import com.example.roomdb.viewmodel.DetailViewModel
import com.example.roomdb.viewmodel.HomeViewModel
import com.example.roomdb.viewmodel.EntryViewModel
import androidx.lifecycle.createSavedStateHandle

object PenyediaViewModel {

    val Factory = viewModelFactory {

        // Home
        initializer {
            HomeViewModel(
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }

        // Entry
        initializer {
            EntryViewModel(
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }

        // Detail (PENTING: SavedStateHandle)
        initializer {
            val savedStateHandle = this.createSavedStateHandle()
            DetailViewModel(
                savedStateHandle = savedStateHandle,
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }
    }
}

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    this[APPLICATION_KEY] as AplikasiSiswa
