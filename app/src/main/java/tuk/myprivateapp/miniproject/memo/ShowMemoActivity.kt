package tuk.myprivateapp.miniproject.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import tuk.myprivateapp.miniproject.R

class ShowMemoActivity : AppCompatActivity() {

    lateinit var show_memo_content: TextView
    lateinit var stateImg : ImageView
    lateinit var dayText : TextView
    lateinit var btnToBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_memo)

        show_memo_content = findViewById(R.id.Show_memo_content)
        stateImg = findViewById(R.id.StateImg)
        dayText = findViewById(R.id.DayText)
        btnToBack = findViewById(R.id.Cancel_btn)

        show_memo_content.setText(intent.getStringExtra("memocontext_text").toString())

        if(intent.getStringExtra("stateID").toString()=="2131231210"){
            stateImg.setImageResource(R.drawable.frame1after)
        }
        if(intent.getStringExtra("stateID").toString()=="2131231211"){
            stateImg.setImageResource(R.drawable.frame2after)
        }
        if(intent.getStringExtra("stateID").toString()=="2131231212"){
            stateImg.setImageResource(R.drawable.frame3after)
        }
        if(intent.getStringExtra("stateID").toString()=="2131231213"){
            stateImg.setImageResource(R.drawable.frame4after)
        }

        var dayTextView :String
        dayTextView =  intent.getStringExtra("day").toString() + " " + intent.getStringExtra("Myear").toString()
        dayText.setText(dayTextView)

        //뒤로가기 버튼
        btnToBack.setOnClickListener{
            onBackPressed()
        }

    }
}