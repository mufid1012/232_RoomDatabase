package com.example.roomdb.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SiswaDao {

    @Query("SELECT * FROM tblSiswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List<Siswa>>

    @Query("SELECT * FROM tblSiswa WHERE id = :id")
    fun getSiswa(id: Int): Flow<Siswa?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSiswa(siswa: Siswa)

    // ➕ Tambahkan ini
    @Delete
    suspend fun deleteSiswa(siswa: Siswa)
}
