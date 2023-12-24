package com.kenanhaciyev.lesson03mydatatransfer.features.newproduct

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kenanhaciyev.lessondatatransfer.features.newproduct.AddProdactViewModul
import com.kenanhaciyev.lessondatatransfer.databinding.ActivtyAddProdactBinding

class AddProdactActivity: AppCompatActivity() {
    lateinit var binding:ActivtyAddProdactBinding
    lateinit var viewModul: AddProdactViewModul


    override fun onCreate(savedInstanceState: Bundle?) { //
        super.onCreate(savedInstanceState)

        viewModul = ViewModelProvider(this).get(AddProdactViewModul::class.java)


        binding= ActivtyAddProdactBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun observerAll(){
        viewModul.newProdactCallback.observe(this){

        }
        viewModul.errorDescription.observe(this){
             if (!it.isNullOrEmpty()){
                 Toast(baseContext).show()
             }
        }
    }
    fun removeAll(){
        viewModul.newProdactCallback.removeObservers(this)
        viewModul.errorDescription.removeObservers(this)
    }

    override fun onResume() {
        super.onResume()
        observerAll()
    }

    override fun onPause() {
        super.onPause()
        removeAll()
    }
}