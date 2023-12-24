package com.kenanhaciyev.lessondatatransfer.features.productlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivtyViewModul:ViewModel() {
    var addProdactObserver = MutableLiveData<Boolean>()

    fun onAddnewProdact(){

        addProdactObserver.postValue(true )

    }

}