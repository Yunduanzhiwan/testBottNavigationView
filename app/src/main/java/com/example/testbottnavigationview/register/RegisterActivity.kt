package com.example.uiapplication

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.testbottnavigationview.MainActivity
import com.example.testbottnavigationview.R
import com.example.testbottnavigationview.util.ACache
import com.example.testbottnavigationview.util.EmailUtil
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContentView(R.layout.activity_register)


//        val data_citys = listOf<String>("广州", "上海", "北京")
//        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data_citys)
//        spliner_city.adapter = arrayAdapter


        val data_school = listOf<String>("广东东软", "大连东软", "广东外语外贸")
        val schoolAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data_school)
//        edit_school.setAdapter(schoolAdapter)
        btn_register.setOnClickListener(this)
    }

    fun getData() {
        val user = ed_username.text

    }


    override fun onClick(v: View?) {

        //  Toast.makeText(this,"dianjl",Toast.LENGTH_LONG).show()
        when (v?.id) {
           R.id.btn_register ->{
               if(hasUser()){

                   return
               }
               //可以注册
               if(canRegister()){

               }
           }
        }
    }


    fun hasUser():Boolean{



        return false
    }
    fun canRegister():Boolean{
        val username=ed_username.text.toString()
        val password=ed_password.text.toString()
        val password_Confirm=ed_confirmPassword.text.toString()
        val email=ed_email.text.toString()
        val sex=sexRaidoGroup.checkedRadioButtonId.toString()

        if(username.length<5||username.length>10){
            return false
        }
        if(password.length<6||password.length>20){
            return false
        }
        if(password_Confirm.length<6||password_Confirm.length>20){
            return false
        }
        if(!password.equals(password_Confirm)){
            return false
        }

        if(!EmailUtil.isEmail(email)){
            return false
        }

        return true
    }

    fun toContactActivity() {

        var intent = Intent(this, MainActivity::class.java)
        //不可返回到登录页面
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
//                    finish()
    }
}
