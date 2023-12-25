package com.kenanhaciyev.lesson03mydatatransfer.features.productlist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.kenanhaciyev.lesson03mydatatransfer.features.newproduct.AddProdactActivity
import com.kenanhaciyev.lesson03mydatatransfer.model.Prodact
import com.kenanhaciyev.lessondatatransfer.features.productlist.MainActivtyViewModul

import com.kenanhaciyev.lessondatatransfer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModul: MainActivtyViewModul


    override fun onCreate(savedInstanceState: Bundle?) { //
        super.onCreate(savedInstanceState)
        viewModul = ViewModelProvider(this).get(MainActivtyViewModul::class.java)

        binding= ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner=this
        binding.viewModel=viewModul
        setContentView(binding.root)
    }

    fun openAddProdactActivity(){
        val intent = Intent(this,AddProdactActivity::class.java)
        newProdactLauncher.launch(intent)
    }


    private val newProdactLauncher=registerForActivityResult(ActivityResultContracts
        .StartActivityForResult()){resualt->
        if (resualt.resultCode== Activity.RESULT_OK){
            val item=resualt.data?.getParcelableExtra<Prodact>("prodact")
        }
    }

    fun removeObserver(){
        viewModul.addProdactObserver.removeObservers(this)
         viewModul.addProdactObserver.postValue(false)
    }

    fun observerAll(){
        viewModul.addProdactObserver.observe(this ){
            if (it){
                openAddProdactActivity()

            }
        }
    }

    override fun onResume() {
        super.onResume()
        observerAll()
    }

    override fun onPause() {
        super.onPause()
        removeObserver()

    }
}