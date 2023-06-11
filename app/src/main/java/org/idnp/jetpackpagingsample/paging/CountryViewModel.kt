package org.idnp.jetpackpagingsample.paging

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.room.Room
import kotlinx.coroutines.flow.Flow
import org.idnp.jetpackpagingsample.entities.Country
import org.idnp.jetpackpagingsample.model.CountryDatabase
import org.idnp.jetpackpagingsample.model.CountryRepository

class CountryViewModel(app: Application) : AndroidViewModel(app) {
    private val countryRepository: CountryRepository = CountryRepository()
    // Se crea una instancia del objeto dao utilizando la clase Room.
    private val dao = Room.databaseBuilder(app, CountryDatabase::class.java, "countries-db").build()
        .countryDao()

    fun items(): Flow<PagingData<Country>> {
        val pager = Pager(
            PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                prefetchDistance = 3
            )
        ){
            dao.pagingSource()
        }.flow.cachedIn(viewModelScope)

        return pager
    }
}