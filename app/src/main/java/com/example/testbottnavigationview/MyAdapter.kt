package com.example.testbottnavigationview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class MyAdapter: FragmentPagerAdapter {


    private var fragments: MutableList<Fragment>? = null


    constructor(fm: FragmentManager, fragments: MutableList<Fragment>) : super(fm) {
        this.fragments = fragments
    }

    override fun getCount(): Int {
        return fragments?.size!!
    }

    override fun getItem(position: Int): Fragment {
        return fragments?.get(position)!!
    }
}