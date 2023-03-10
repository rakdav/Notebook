package com.example.notebook

import androidx.lifecycle.ViewModel

class NootListViewModel:ViewModel() {
    val noots= mutableListOf<Noot>()
    init {
        for (i in 0 until 50)
        {
            val noot=Noot()
            noot.title="Noot №$i"
            noot.isSolved=i%2==0
            noots+=noot
        }
    }
}