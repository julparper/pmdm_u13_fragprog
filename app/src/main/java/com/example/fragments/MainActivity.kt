package com.example.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentActionsListener {

    companion object{
        const val NOMBRE = "nombre"
    }
    private lateinit var binding: ActivityMainBinding;
    private var derechaRojo = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val bundle = Bundle()
            bundle.putString(NOMBRE, "Hola")
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<RedFragment>(binding.frgDer.id, args = bundle)
                add<BlueFragment>(binding.frgIzq.id, args = bundle)
            }
        }

    }

    fun intercambiar(view: View){
        supportFragmentManager.commit {
            setReorderingAllowed(true)

            if(!derechaRojo) {
                replace<RedFragment>(binding.frgDer.id)
                replace<BlueFragment>(binding.frgIzq.id)
            }else{
                replace<BlueFragment>(binding.frgDer.id)
                replace<RedFragment>(binding.frgIzq.id)
            }
            derechaRojo = !derechaRojo
        }
    }

    override fun onClickFragmentButton() {
        Toast.makeText(this, "Se ha pulsado el botón", Toast.LENGTH_SHORT).show()
    }
}