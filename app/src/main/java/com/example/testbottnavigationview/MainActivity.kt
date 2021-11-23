package com.example.testbottnavigationview

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment


import android.view.MenuItem
import android.view.SurfaceControl
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {

    var fragments = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //隐藏标题行
        supportActionBar?.hide();

        fragments.add(left())
        fragments.add(middle())
        fragments.add(right())


//
//

        val adatpter = MyAdapter(supportFragmentManager, fragments)
//
        var viewPager = findViewById<ViewPager>(R.id.viewPager1)

//
        viewPager.adapter = adatpter
        viewPager.offscreenPageLimit=fragments.size


//        var Transaction = supportFragmentManager.beginTransaction()
//        Transaction.replace(R.id.item1,left())
//
//
//        Transaction.commit()


        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)




        bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item: MenuItem ->
            (



                    when (item.itemId) {

                        R.id.item1 -> {

                            viewPager.currentItem=0
                            true
                        }
                        R.id.item2 -> {

                            viewPager.currentItem=1
                            true
                        }
                        R.id.item3 -> {
//                            AlertDialog.Builder(this)
//                                .setTitle("提示")
//                                .setMessage("id="+viewPager.currentItem)
//                                .setPositiveButton(
//                                    "确定",
//                                    DialogInterface.OnClickListener { dialog, which ->
//
//
//                                    })
//                                .show()
                            viewPager.currentItem=2
                            true
                        }
                        else -> false
                    }
                    )

        })

    }


}

