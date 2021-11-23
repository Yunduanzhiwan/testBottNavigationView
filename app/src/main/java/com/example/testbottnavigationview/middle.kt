package com.example.testbottnavigationview

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.recyclerview.Star
import com.example.recyclerview.starAdapter

class middle : Fragment(){

    private val starList=ArrayList<Star>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //隐藏标题行
            var v=inflater.inflate(R.layout.activity_contacts,container,false)

        val layoutManager=LinearLayoutManager(v.context)
        layoutManager.orientation=LinearLayoutManager.VERTICAL
//        var bt1=v.findViewById<Button>(R.id.button1)
        var recylerView = v.findViewById<RecyclerView>(R.id.recylerView)

        recylerView.layoutManager=layoutManager
        initStars()
        val adapter=starAdapter(starList,v.context)

        recylerView.adapter=adapter
//        bt1.setOnClickListener(View.OnClickListener {
//            AlertDialog.Builder(v.context)
//                .setTitle("提示")
//                .setMessage("你点了按钮1")
//                .setPositiveButton(
//                    "确定",
//                    DialogInterface.OnClickListener { dialog, which ->
//
//
//                    })
//                .show()
//        })


        return v
    }
    private fun initStars(){
        repeat(2){
            starList.add(Star("钟南山",R.drawable.s1_zhongnanshan))
            starList.add(Star("于敏",R.drawable.s2_yumin))
            starList.add(Star("申纪兰",R.drawable.s3_shenjilan))
            starList.add(Star("孙家栋",R.drawable.s4_sunjiadong))
            starList.add(Star("李延年",R.drawable.s5_liyannian))
            starList.add(Star("张富清",R.drawable.s6_zhangfuqing))
            starList.add(Star("袁隆平",R.drawable.s7_yuanlongping))
            starList.add(Star("黄旭华",R.drawable.s8_huangxuhua))
            starList.add(Star("屠呦呦",R.drawable.s9_tuyouyou))
            starList.add(Star("周兴铭",R.drawable.s10ys_zhuoxingming))
            starList.add(Star("叶培建",R.drawable.s11ys_yepeijian))
            starList.add(Star("王赤",R.drawable.s12_ys_wangchi))
            starList.add(Star("戴永久",R.drawable.s13_ys_daiyongjiu))
            starList.add(Star("刘少军",R.drawable.s14_ys_liushaojun))
        }
    }
}