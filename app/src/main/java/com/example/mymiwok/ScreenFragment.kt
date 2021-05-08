package com.example.mymiwok

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ScreenFragment : Fragment() {
    lateinit var list: MutableList<String>
    lateinit var listMiwok: MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = requireView().findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter()

        }
        list = arguments!!.getStringArrayList("english")!!
        listMiwok = arguments!!.getStringArrayList("miwok")!!
    }

   inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
        //numbers


//        private val kode = arrayOf(
//            "one",
//            "two", "three", "four",
//            "five", "six", "seven",
//            "eight", "nine", "ten"
//        )
//
//        private val kategori = arrayOf(
//            "lutti",
//            "otiiko", "tolookosu", "oyyisa",
//            "massokka", "temmokka", "kenekaku",
//            "kawinta", "wo'e", "na'aacha"
//        )
        //numbers

        //family

        //family

        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
            val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.single_item, viewGroup, false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
            var mMediaPlayer: MediaPlayer? = null

            viewHolder.itemCode.text = list[i]
            viewHolder.itemCategory.text = listMiwok[i]

            viewHolder.itemView.setOnClickListener {

                if (mMediaPlayer == null) {
                    mMediaPlayer =
                        MediaPlayer.create(viewHolder.itemCategory.context, R.raw.color_black)
                    mMediaPlayer!!.start()
                } else mMediaPlayer!!.start()

            }

        }

        override fun getItemCount(): Int {
            return list.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var itemCode: TextView = itemView.findViewById(R.id.textMiwok)
            var itemCategory: TextView = itemView.findViewById(R.id.textEng)

//            init {
//                itemView.setOnClickListener{
//                    var mMediaPlayer: MediaPlayer? = null
//                    mMediaPlayer = MediaPlayer.create(itemView.context, R.raw.color_black)
//                }
//            }


//            init {
//                itemView.setOnClickListener {
//                    val position: Int = adapterPosition
//                    val context = itemView.context
//                    val intent = Intent(context, ScreenFragment::class.java).apply {
//                        putExtra("NUMBER", position)
//                        putExtra("CODE", itemCode.text)
//                        putExtra("CATEGORY", itemCategory.text)
//
//                    }
//                    context.startActivity(intent)
//                }
//            }
        }
    }
}


