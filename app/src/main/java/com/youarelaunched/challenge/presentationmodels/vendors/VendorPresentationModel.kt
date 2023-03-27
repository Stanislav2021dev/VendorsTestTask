package com.youarelaunched.challenge.presentationmodels.vendors

data class VendorsPresentationModel(
    val areaServed: String,
    val categories: List<NetworkCategories>,
    val companyName: String,
    val coverPhotoUrl: String,
    val isFavorite: Boolean,
    val tags: List<String>
)

data class NetworkCategories(
    val imageUrl: String,
    val name: String
)