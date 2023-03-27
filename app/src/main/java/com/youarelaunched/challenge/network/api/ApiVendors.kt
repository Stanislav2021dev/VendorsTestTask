package com.youarelaunched.challenge.network.api

import com.youarelaunched.challenge.network.models.NetworkVendor

interface ApiVendors {

    suspend fun getVendors(): List<NetworkVendor>
}