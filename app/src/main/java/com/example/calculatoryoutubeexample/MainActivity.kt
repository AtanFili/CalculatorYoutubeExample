package com.example.calculatoryoutubeexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import javax.xml.xpath.XPathExpressionException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       //Numbers
        tvOne.setOnClickListener { appendOnExpresstion("1",true) }
        TvTwo.setOnClickListener { appendOnExpresstion("2",true) }
        TvThree.setOnClickListener { appendOnExpresstion("3",true) }
        tvFour.setOnClickListener { appendOnExpresstion("4",true) }
        TvFive.setOnClickListener { appendOnExpresstion("5",true) }
        TvSix.setOnClickListener { appendOnExpresstion("6",true) }
        tvSeven.setOnClickListener { appendOnExpresstion("7",true) }
        TvEight.setOnClickListener { appendOnExpresstion("8",true) }
        TvNine.setOnClickListener { appendOnExpresstion("9",true) }
        TvZero.setOnClickListener { appendOnExpresstion("0",true) }
        tvDot.setOnClickListener { appendOnExpresstion(".",true) }

        //Operators

        TvPlus.setOnClickListener { appendOnExpresstion("+",false) }
        TvMinus.setOnClickListener { appendOnExpresstion("-",false) }
        TvMultiplication.setOnClickListener { appendOnExpresstion("*",false) }
        TvDivide.setOnClickListener { appendOnExpresstion("/",false) }
        TvOpen.setOnClickListener { appendOnExpresstion("(",false) }
        TvClose.setOnClickListener { appendOnExpresstion(")",false) }

        TvClear.setOnClickListener {
            tvExpression.text=""
            tvResult.text=""
        }
        TvBack.setOnClickListener{
            val string=tvExpression.text.toString()
            if (string.isNotEmpty()){
                tvExpression.text=string.substring(0,string.length-1)
            }
            tvResult.text=""
        }

        TvEquals.setOnClickListener {
            try {

                val expression= ExpressionBuilder(tvExpression.text.toString()).build()
                val result=expression.evaluate()
                val longResult=result.toLong()
                if(result==longResult.toDouble())
                    tvResult.text=longResult.toString()
                else
                    tvResult.text=result.toString()
            }catch (e:Exception){
                Log.d("Exception","message:"+e.message)
            }
        }






    }

    fun appendOnExpresstion(string: String,canClear:Boolean){

        if(canClear){
            tvResult.text=""
            tvExpression.append(string)
        }else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text=""
        }
        }
}
