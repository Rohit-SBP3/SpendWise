package com.example.spendwise.data

data class CurrencyData(
    val code: String,   // Three-letter ISO 4217 currency code
    val country: String, // Country in which the currency is used
    val name: String    // Name of the currency
)

// List of currency data
val iso4217Currencies = listOf(
    CurrencyData(country = "AFGHANISTAN", name = "Afghani", code = "AFN"),
    CurrencyData(country = "ÅLAND ISLANDS", name = "Euro", code = "EUR"),
    CurrencyData(country = "ALBANIA", name = "Lek", code = "ALL"),
    CurrencyData(country = "ALGERIA", name = "Algerian Dinar", code = "DZD"),
    CurrencyData(country = "AMERICAN SAMOA", name = "US Dollar", code = "USD"),
    CurrencyData(country = "ANDORRA", name = "Euro", code = "EUR"),
    CurrencyData(country = "ANGOLA", name = "Kwanza", code = "AOA"),
    CurrencyData(country = "ANGUILLA", name = "East Caribbean Dollar", code = "XCD"),
    CurrencyData(country = "ARGENTINA", name = "Argentine Peso", code = "ARS"),
    CurrencyData(country = "ARMENIA", name = "Armenian Dram", code = "AMD"),
    CurrencyData(country = "AUSTRALIA", name = "Australian Dollar", code = "AUD"),
    CurrencyData(country = "AUSTRIA", name = "Euro", code = "EUR"),
    CurrencyData(country = "AZERBAIJAN", name = "Azerbaijan Manat", code = "AZN"),
    CurrencyData(country = "BAHRAIN", name = "Bahraini Dinar", code = "BHD"),
    CurrencyData(country = "BANGLADESH", name = "Taka", code = "BDT"),
    CurrencyData(country = "BARBADOS", name = "Barbados Dollar", code = "BBD"),
    CurrencyData(country = "BELGIUM", name = "Euro", code = "EUR"),
    CurrencyData(country = "BRAZIL", name = "Brazilian Real", code = "BRL"),
    CurrencyData(country = "CANADA", name = "Canadian Dollar", code = "CAD"),
    CurrencyData(country = "CHINA", name = "Yuan Renminbi", code = "CNY"),
)

// Mapping for multinational currency usage
val multiNationCurrencyMap = mapOf(
    "USD" to "US AND OTHERS",
    "EUR" to "EUROPEAN UNION",
    "XCD" to "CARIBBEAN ISLANDS",
    "AUD" to "AUSTRALIA AND OTHERS"
)

// Grouping currency data by code
val iso4217CurrenciesGrouped = iso4217Currencies.groupBy { it.code }.mapValues { (key, value) ->
    CurrencyData(
        code = key,
        country = multiNationCurrencyMap[key] ?: value.joinToString(", ") { it.country },
        name = value.first().name
    )
}