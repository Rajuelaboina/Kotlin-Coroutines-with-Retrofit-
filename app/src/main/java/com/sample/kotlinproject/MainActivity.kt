package com.sample.kotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
   private lateinit var name:EditText
   private lateinit var passWord:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv=findViewById<TextView>(R.id.textView)
        name=findViewById(R.id.editTextTextPersonName)
        passWord=findViewById(R.id.editTextTextPassword)
        val submit=findViewById<Button>(R.id.button)
        submit.setOnClickListener {
            name.text.toString()
             //bb=isAllFieldsChked(name1)
            /*if (isAllFieldsChked(name1) ){
                tv.text=name1
                Toast.makeText(applicationContext,"Login successfully",Toast.LENGTH_LONG).show()
                intent= Intent(applicationContext,MainActivity2::class.java)
                startActivity(intent)
            }else{

            }*/
            Toast.makeText(applicationContext,"Login successfully",Toast.LENGTH_LONG).show()
            intent= Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)
        }
        name.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                tv.text=p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }

   /* private fun isAllFieldsChked(name1: String): Boolean {
        if (name1.length<=3){
           name.setError("more then 3 char!")
            return false
        }
        if (passWord_ed.text.toString().isEmpty()){
            passWord_ed.setError("pasword field is empty")
            passWord_ed.requestFocus()
            return false
        }
        // after all validation return true.
        return true;
    }*/


}