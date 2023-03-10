package com.example.notebook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG="NootListFragment"
class NootListFragment:Fragment() {
    private lateinit var nootRecycleView:RecyclerView
    private var adapter:NootAdapter?=null
    private val nootListViewModel:NootListViewModel by lazy {
        ViewModelProviders.of(this).get(NootListViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_noot_list,container,false)
        nootRecycleView=view.findViewById(R.id.noot_recycle_view)
        nootRecycleView.layoutManager=LinearLayoutManager(context)
        updateUI()
        return view
    }
    private fun updateUI()
    {
        val noots=nootListViewModel.noots
        adapter=NootAdapter(noots)
        nootRecycleView.adapter=adapter
    }
    private inner class NootHolder(view:View):RecyclerView.ViewHolder(view),
            View.OnClickListener
    {
        private lateinit var noot: Noot
        val titleTextView:TextView=itemView.findViewById(R.id.noot_title)
        val dateTextView:TextView=itemView.findViewById(R.id.noot_date)
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(noot: Noot){
            this.noot=noot
            titleTextView.text=this.noot.title
            dateTextView.text=this.noot.date.toString()
        }

        override fun onClick(p0: View?) {
            Toast.makeText(context,"${noot.title} pressed",Toast.LENGTH_LONG).show()
        }

    }
    private inner class NootAdapter(var nootes:List<Noot>):RecyclerView.Adapter<NootHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NootHolder {
            val view=layoutInflater.inflate(R.layout.list_item_noot,parent,false)
            return NootHolder(view)
        }
        override fun onBindViewHolder(holder: NootHolder, position: Int) {
           val noot=nootes[position]
           holder.bind(noot)
        }
        override fun getItemCount(): Int {
            return nootes.size
        }

    }
    companion object{
        fun newInstance():NootListFragment{
            return NootListFragment()
        }
    }
}