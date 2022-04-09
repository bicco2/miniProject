package tuk.myprivateapp.miniproject.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import tuk.myprivateapp.miniproject.R

class ShowMemoActivity : AppCompatActivity() {

    lateinit var show_memo_content: TextView
    lateinit var stateImg : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_memo)

        show_memo_content = findViewById(R.id.Show_memo_content)
        stateImg = findViewById(R.id.StateImg)


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

    }
}