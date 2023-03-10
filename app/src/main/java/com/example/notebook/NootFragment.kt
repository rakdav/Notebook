package com.example.notebook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView

class NootFragment : Fragment() {
    private lateinit var noot:Noot
    private lateinit var nootImage:ImageView
    private lateinit var titleNoot:EditText
    private lateinit var descNoot:EditText
    private lateinit var addFoto:Button
    private lateinit var addDate:Button
    private lateinit var save:Button
    private lateinit var isSolved:CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        noot= Noot()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view=inflater.inflate(R.layout.fragment_noot, container, false)
        nootImage=view.findViewById(R.id.imageView)
        titleNoot=view.findViewById(R.id.editTextTextPersonName)
        descNoot=view.findViewById(R.id.editTextTextMultiLine)
        addFoto=view.findViewById(R.id.button)
        addDate=view.findViewById(R.id.button2)
        save=view.findViewById(R.id.button3)
        isSolved=view.findViewById(R.id.checkBox)
        return view
    }
}