package com.example.actualreagistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    lateinit var etName:EditText
    lateinit var etDob:EditText
    lateinit var spnNationality:Spinner
    lateinit var etPhoneNumber:EditText
    lateinit var etEmail:EditText
    lateinit var etPassword:EditText
    lateinit var btnNext:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CastViews()
        clickRegister()

    }
    fun CastViews(){
        etName=findViewById(R.id.etName)
        etDob=findViewById(R.id.etDob)
        etPhoneNumber=findViewById(R.id.etPhoneNumber)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        spnNationality=findViewById(R.id.spnNationality)
        btnNext=findViewById(R.id.btnNext)

        var nationality = arrayOf("Kenya","Uganda","Rwanda","Tanzania","Ethopia","Sudan")
        var nationalityAdapter=ArrayAdapter(baseContext,android.R.layout.simple_spinner_dropdown_item,nationality)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnNationality.adapter=nationalityAdapter


    }
    fun clickRegister(){
        btnNext.setOnClickListener {
            var name=etName.text.toString()
            var dob=etDob.text.toString()
            var phonenumber=etPhoneNumber.text.toString()
            var email=etEmail.text.toString()
            var password=etPassword.text.toString()
            var nationality=""

            var details=Details(name,dob,phonenumber,email,password,nationality)
            var intent= Intent(baseContext,logInActivity::class.java)
            startActivity(intent)


        }
    }

}
data class Details(var name:String,var dob:String,var phoneNumber:String,var email:String,var password:String,var nationality:String)