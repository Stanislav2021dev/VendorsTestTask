package com.youarelaunched.challenge.data.network.models

import com.google.gson.annotations.SerializedName
import com.youarelaunched.challenge.network.models.NetworkListMeta
import com.youarelaunched.challenge.network.models.NetworkVendor

data class NetworkVendorsData(
    @SerializedName("vendors")
    val vendors: List<NetworkVendor>,
    @SerializedName("meta")
    val meta: NetworkListMeta?
)