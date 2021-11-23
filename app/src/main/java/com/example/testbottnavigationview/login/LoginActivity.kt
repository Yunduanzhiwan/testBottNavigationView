package com.example.testbottnavigationview.login

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.testbottnavigationview.MainActivity
import com.example.testbottnavigationview.R
import com.example.testbottnavigationview.util.ACache
import com.example.uiapplication.RegisterActivity
import kotlinx.android.synthetic.main.actvity_login.*
import org.jetbrains.anko.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mCache = ACache.get(this)
        val isLogined = mCache.getAsObject("isLogined")?:false as Boolean

        println("isLogined="+isLogined)

        if (isLogined==true)toMainActivity()

        //隐藏标题行
        getSupportActionBar()?.hide();

        setContentView(R.layout.actvity_login)

        btn_register.setOnClickListener(View.OnClickListener {

            toRegisterActivity()

        })

        login_button.setOnClickListener(this)

    }

    lateinit var et_account: EditText
    lateinit var et_password: EditText
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.login_button -> {
                et_account=loginAccount
                et_password=loginPassword
                if(et_account.text.toString().equals("admin")&&et_password.text.toString().equals("jiangshao888")){
                    //将登陆信息放入缓存
                    val mCache = ACache.get(this)
                    mCache.put("isLogined", true, 7 * ACache.TIME_DAY)//七天
//                    mCache.put("test_key2", "test value", 10) //保存10秒，如果超过10秒去获取这个key，将为null

                    toMainActivity()

                }
            }
        }
    }
    fun toMainActivity() {

        var intent = Intent(this, MainActivity::class.java)
        //不可返回到登录页面
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
//                    finish()
    }
    fun toRegisterActivity() {

        var intent = Intent(this, RegisterActivity::class.java)
        //不可返回到登录页面
//        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
//                    finish()
    }

}