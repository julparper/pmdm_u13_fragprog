package com.example.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.databinding.FragmentBlueBinding


class BlueFragment : Fragment() {

    private var _binding: FragmentBlueBinding? = null
    val binding get() = _binding!! //Helper

    //Creamos una variable privada de tipo FragmentActionsListener
    private var listener: FragmentActionsListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments!=null){
            Toast.makeText(this.activity, requireArguments().getString(MainActivity.NOMBRE) , Toast.LENGTH_SHORT).show()
        }
        binding.btnSumar.setOnClickListener{
            listener?.onClickFragmentButton()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBlueBinding.inflate(inflater, container, false)
        return binding.root
    }

    //El en método Attach se vincula la actividad y el fragmento. Asociamos la variable listener a la actividad, que implementa el listener.
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentActionsListener) {
            listener = context
        }
    }

    //Al desvincular la actividad y el fragmento liberamos el listener
    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}