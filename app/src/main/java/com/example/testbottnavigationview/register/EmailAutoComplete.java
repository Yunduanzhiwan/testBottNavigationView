package com.example.testbottnavigationview.register;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import com.example.testbottnavigationview.util.EmailUtil;


@SuppressLint("AppCompatCustomView")
public class EmailAutoComplete extends AutoCompleteTextView {
    private static final String[] emailSuffix = { "@qq.com", "@163.com", "@126.com", "@gmail.com", "@sina.com", "@hotmail.com",
            "@yahoo.cn", "@sohu.com", "@foxmail.com", "@139.com", "@yeah.net",  "@vip.qq.com", "@vip.sina.com" };

    public EmailAutoComplete(Context context){
        super(context);
        init(context);
    }
    public EmailAutoComplete(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context){
        final MyAdapter adapter = new MyAdapter(context);
        setAdapter(adapter);

        addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();



                adapter.mList.clear();
                if (input.length() > 0) {
                    for (int i = 0; i < emailSuffix.length; ++i) {
                        if(EmailUtil.isEmail(input + emailSuffix[i])){
                            adapter.mList.add(input + emailSuffix[i]);
                        }else {

                            return;
                        }
                    }
                }
                adapter.notifyDataSetChanged();
                showDropDown();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        });
        // default=2 当输入一个字符的时候就开始检测
        setThreshold(1);
    }


}