package com.example.roomdb.repositori

import com.example.roomdb.room.Siswa
import com.example.roomdb.room.SiswaDao
import kotlinx.coroutines.flow.Flow


interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val siswaDAO: SiswaDao
) : RepositoriSiswa {

    override fun getAllSiswaStream(): Flow<List<Siswa>> =
        siswaDAO.getAllSiswa()

    override suspend fun insertSiswa(siswa: Siswa) =
        siswaDAO.insertSiswa(siswa)
}
