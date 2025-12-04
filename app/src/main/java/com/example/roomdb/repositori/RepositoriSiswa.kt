package com.example.roomdb.repositori

import com.example.roomdb.room.Siswa
import com.example.roomdb.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
    fun getSiswaStream(id: Int): Flow<Siswa?>

    // ➕ TAMBAHKAN INI
    suspend fun deleteSiswa(siswa: Siswa)

    suspend fun updateSiswa(siswa: Siswa)

}

class OfflineRepositoriSiswa(
    private val siswaDAO: SiswaDao
) : RepositoriSiswa {

    override fun getAllSiswaStream(): Flow<List<Siswa>> =
        siswaDAO.getAllSiswa()

    override suspend fun insertSiswa(siswa: Siswa) =
        siswaDAO.insertSiswa(siswa)

    override fun getSiswaStream(id: Int): Flow<Siswa?> =
        siswaDAO.getSiswa(id)

    // ➕ TAMBAHKAN INI
    override suspend fun deleteSiswa(siswa: Siswa) =
        siswaDAO.deleteSiswa(siswa)

    override suspend fun updateSiswa(siswa: Siswa) =
        siswaDAO.updateSiswa(siswa)
}
