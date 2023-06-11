package org.idnp.jetpackpagingsample.model

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.idnp.jetpackpagingsample.entities.Country

@Dao
interface CountryDao {
    // Permite insertar una lista de objetos "Country" en la BD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(countries: List<Country>)

    // Permite insertar un objeto de tipo "Country" en la BD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(country: Country)

    // TODO:
    @Query("SELECT * FROM countries")
    fun pagingSource(): PagingSource<Int, Country>

    @Query("DELETE FROM countries")
    suspend fun clearAll()
}