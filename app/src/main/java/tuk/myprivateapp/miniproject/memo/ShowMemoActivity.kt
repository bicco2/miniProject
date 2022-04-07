package tuk.myprivateapp.miniproject.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text
import tuk.myprivateapp.miniproject.R

class ShowMemoActivity : AppCompatActivity() {

    lateinit var show_memo_content: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_memo)

        show_memo_content = findViewById(R.id.Show_memo_content)

        show_memo_content.setText(intent.getStringExtra("memocontext_text").toString())


    }
}