package com.dhenkanal.amadhenkanal.model

data class TempleModel(
    val imageRes: Int,
    val title: String,
    val about:String,
    val details:String,
    val location: String,
    val borderColor: Int,
    val latitude: Double,
    val longitude: Double,
    var isExpanded: Boolean = false

)
