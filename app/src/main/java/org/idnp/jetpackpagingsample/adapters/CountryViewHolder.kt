package org.idnp.jetpackpagingsample.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.idnp.jetpackpagingsample.R
import org.idnp.jetpackpagingsample.entities.Country

class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val idText = view.findViewById(R.id.textViewId) as TextView

    private val nameEnText = view.findViewById(R.id.textViewNameEn) as TextView
    private val nameEsText = view.findViewById(R.id.textViewNameEs) as TextView
    private val continentEnText = view.findViewById(R.id.textViewContinentEn) as TextView
    private val continentEsText = view.findViewById(R.id.textViewContinentEs) as TextView
    private val capitalEnText = view.findViewById(R.id.textViewCapitalEn) as TextView
    private val capitalEsText = view.findViewById(R.id.textViewCapitalEs) as TextView
    private val dialCodeText = view.findViewById(R.id.textViewDialCode) as TextView
    private val code2Text = view.findViewById(R.id.textViewCode2) as TextView
    private val code3Text = view.findViewById(R.id.textViewCode3) as TextView
    private val tldText = view.findViewById(R.id.textViewTld) as TextView
    private val km2Text = view.findViewById(R.id.textViewKm2) as TextView

    fun bind(country: Country) {
        with(country) {
            idText.text = id.toString()

            nameEnText.text = name_en
            nameEsText.text = name_es
            continentEnText.text = continent_en
            continentEsText.text = continent_es
            capitalEnText.text = capital_en
            capitalEsText.text = capital_es
            dialCodeText.text = dial_code
            code2Text.text = code_2
            code3Text.text = code_3
            tldText.text = tld
            km2Text.text = km2.toString()
        }
    }
}