package org.idnp.jetpackpagingsample.model

import android.util.Log
import org.idnp.jetpackpagingsample.entities.Country

class CountryRepository() {
    fun getCountries(nextPageNumber: Int): ArrayList<Country> {
        Log.d("[-> Numero de Pagina: ", nextPageNumber.toString())

        val countries = arrayListOf<Country>()
        var country: Country
        // determinar el rango de índices en el bucle for
        val start: Int = 100 * nextPageNumber
        val end: Int = start + 20

        for (i in start..end) {
            country = Country(
                id = i,
                name_en = "Name_en $i", // Es una forma de concatenar el valor de la variable "i" al final de la cadena "Name_en"
                name_es = "Name_es $i",
                continent_en = "Continent_en $i",
                continent_es = "Continent_es $i",
                capital_en = "Capital_en $i",
                capital_es = "Capital_es $i",
                dial_code = "Dial_code $i",
                code_2 = "Code_2 $i",
                code_3 = "Code_3 $i",
                tld = "Tld $i",
                km2 = i * 1000
            )

            countries.add(country)
        }

        return countries
    }
}