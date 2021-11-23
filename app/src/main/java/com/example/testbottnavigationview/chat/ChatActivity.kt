package com.example.uibestpractice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task2_2.mode.User

import com.example.testbottnavigationview.R

class ChatActivity : AppCompatActivity(), View.OnClickListener {

    private val msgList = ArrayList<Msg>()

    private lateinit var adapter: MsgAdapter

    private lateinit var receiver:TextView
    private lateinit var recyclerView:RecyclerView
    private lateinit var user: User
    private lateinit var send :Button
    private lateinit var inputText:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            //隐藏标题行
        supportActionBar?.hide();


        setContentView(R.layout.activity_chat)



        inputText=findViewById<EditText>(R.id.inputText)
        send=findViewById<Button>(R.id.send)
        receiver=findViewById<TextView>(R.id.receiver)
        recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        user  = intent.getSerializableExtra("user") as User

        receiver.text= user.username




        initMsg(user)
        val layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager
        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }
        recyclerView.adapter = adapter
        send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            send -> {
                val content = inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size - 1) // 当有新消息时，刷新RecyclerView中的显示
                    recyclerView.scrollToPosition(msgList.size - 1)  // 将 RecyclerView定位到最后一行
                    inputText.setText("") // 清空输入框中的内容
                }
            }
        }
    }

    private fun initMsg(user: User) {
        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is "+user.username+". Nice talking to you. ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}
