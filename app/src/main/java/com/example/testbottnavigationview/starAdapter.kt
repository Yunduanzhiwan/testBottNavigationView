package com.example.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


import androidx.recyclerview.widget.RecyclerView
import com.example.task2_2.mode.User
import com.example.testbottnavigationview.R
import com.example.uibestpractice.ChatActivity


/*自定义适配器，新建一个类starAdapter，让这个适配器继承RecyclerView.Adapter
并将泛型指定为starAdapter.ViewHolder
*/
class starAdapter(val starList:List<Star>,var context: Context):RecyclerView.Adapter<starAdapter.ViewHolder>() {
    /*定义一个内部类ViewHolder，继承RecyclerView.ViewHolder,
    在ViewHolder的主构造函数中传入一个View参数,view参数就是RecyclerView
    子项的最外层布局，在类里可以获取布局文件中的控件实例*/
     var cont:Context = context

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){

        val starImage:ImageView=view.findViewById(R.id.starImage)


        val starName:TextView=view.findViewById(R.id.starName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view=LayoutInflater.from(parent.context)
           .inflate(R.layout.star_item,parent,false)
        val viewHolder=ViewHolder(view)

        viewHolder.itemView.setOnClickListener(){
            val positon=viewHolder.adapterPosition
            val star=starList[positon]
            Toast.makeText(parent.context,"You clicked view ${star.name}",Toast.LENGTH_LONG).show()
            toChat(positon,star)
        }
        viewHolder.starImage.setOnClickListener(){
            val position=viewHolder.adapterPosition
            val star=starList[position]
            Toast.makeText(parent.context,"You clicked image ${star.name}",Toast.LENGTH_LONG).show()
            toChat(position,star)
        }
        return  viewHolder
    }
    // onCreateViewHolder()用于创建一个ViewHolder实例，把加载出来的布局传入构造函数中

    fun toChat(position: Int, star: Star){
        var intent = Intent(cont, ChatActivity::class.java)
        var user= User(star.name,star.imageId)
        intent.putExtra("user",user)

        cont.startActivity(intent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val star=starList[position]
        holder.starImage.setImageResource(star.imageId)
        holder.starName.text=star.name
    }
//onBindViewHolder()用于对RecyclerView子项的数据地进行赋值，在每个子项被滚入屏幕时执行
    override fun getItemCount(): Int {
        val count=starList.size
        return count
    }
    //getItemCount()方法告诉RecyclerView一共有多少子项，直接返回数据源的长度

}