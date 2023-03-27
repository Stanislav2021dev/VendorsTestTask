package com.youarelaunched.challenge.presentationmodels.vendors

import com.youarelaunched.challenge.network.models.NetworkVendor

fun mapNetworkVendorToNetworkVendorPresentationModel(vendors: List<NetworkVendor>): List<VendorsPresentationModel> {
    return vendors.map { networkVendor ->
        VendorsPresentationModel(
            areaServed = networkVendor.areaServed,
            categories = networkVendor.categories?.map { category ->
                NetworkCategories(
                    imageUrl = category.image.mediaUrl,
                    name = category.name
                )
            } ?: emptyList(),
            companyName = networkVendor.companyName,
            coverPhotoUrl = networkVendor.coverPhoto.mediaUrl,
            isFavorite = networkVendor.favorite,
            tags = networkVendor.tags?.map {
                it.name
            } ?: emptyList()
        )
    }
}