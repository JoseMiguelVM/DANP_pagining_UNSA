package org.idnp.jetpackpagingsample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.idnp.jetpackpagingsample.adapters.CountryAdapter
import org.idnp.jetpackpagingsample.model.CountryDatabase
import org.idnp.jetpackpagingsample.paging.CountryViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.country_activity_main)

        val viewModel by viewModels<CountryViewModel>()
        val recyclerView = findViewById<RecyclerView>(R.id.country_recycler_view)
        val pagingAdapter = CountryAdapter()

        recyclerView.adapter = pagingAdapter
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }

        lifecycleScope.launch {
            viewModel.items().collectLatest { pageData ->
                pagingAdapter.submitData(pageData)
            }
        }

        prePopDB()
    }

    // Populate Country Database
    private fun prePopDB() {
        val dao = Room.databaseBuilder(this, CountryDatabase::class.java, "countries-db").build()
            .countryDao()

        GlobalScope.launch {
            for (i in countries_data.indices) {
                dao.insert(
                    countries_data[i]
                )
            }
        }
    }
}