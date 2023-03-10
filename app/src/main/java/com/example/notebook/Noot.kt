package com.example.notebook

import android.icu.text.CaseMap.Title
import java.util.Date
import java.util.UUID

data class Noot (val id:UUID=UUID.randomUUID(),var title: String="",var foto:Int=0,
                 var date:Date=Date(),var desc:String="", var isSolved:Boolean=false){
}