package com.kenanhaciyev.lessondatatransfer.features.newproduct

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddProdactViewModul : ViewModel() {
    val prodactCode=MutableLiveData<String>()
    val prodactName=MutableLiveData<String>()
    val prodactDescription=MutableLiveData<String>()
val errorDescription= MutableLiveData<String>()
val newProdactCallback=MutableLiveData<Boolean>()


    fun onNewProdactInsert(){
        if (prodactCode.value.isNullOrEmpty()
            || prodactName.value.isNullOrEmpty()
            || prodactDescription.value.isNullOrEmpty()  ){
            errorDescription.postValue(
                "Melumatlar duzgun doldurulmayib. Butun melumatlarin dolduruldugundan emin olun")
            return
        }
newProdactCallback.postValue(true)
    }


}