package com.lukaslechner.coroutineusecasesonandroid.usecases.coroutines.usecase2

import androidx.lifecycle.viewModelScope
import com.lukaslechner.coroutineusecasesonandroid.base.BaseViewModel
import com.lukaslechner.coroutineusecasesonandroid.mock.MockApi
import kotlinx.coroutines.launch
import timber.log.Timber

class Perform2SequentialNetworkRequestsViewModel(
    private val mockApi: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun perform2SequentialNetworkRequest() {
        uiState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val recentAndroidVersions = mockApi.getRecentAndroidVersions()
                val mostRecentAndroidVersions = recentAndroidVersions.last()
                val versionFeatures = mockApi().getAndroidVersionFeatures(mostRecentAndroidVersions.apiLevel)
                uiState.value = UiState.Success(versionFeatures)
            }catch (e: Exception){
                Timber.e(e)
                uiState.value = UiState.Error("Network Request Failed!")
            }
        }
    }
}