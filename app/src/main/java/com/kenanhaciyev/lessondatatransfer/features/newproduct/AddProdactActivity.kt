package com.kenanhaciyev.lesson03mydatatransfer.features.newproduct

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kenanhaciyev.lesson03mydatatransfer.model.Prodact
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

        binding.viewModel= viewModul
        binding.lifecycleOwner=this


    }

    fun observerAll(){
        viewModul.newProdactCallback.observe(this){
            val intent= Intent()

         val prodact=Prodact(10, "alca", "turs")


            intent.putExtra("prodact",prodact)
            setResult(RESULT_OK, intent)

            finish()

        }
        viewModul.errorDescription.observe(this){
             if (!it.isNullOrEmpty()){
                 Toast.makeText(this, it,Toast.LENGTH_LONG).show()
             }
        }
    }
    fun removeAll(){
        viewModul.newProdactCallback.removeObservers(this)

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