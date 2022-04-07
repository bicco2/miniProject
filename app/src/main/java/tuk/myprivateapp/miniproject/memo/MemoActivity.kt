package tuk.myprivateapp.miniproject.memo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import tuk.myprivateapp.miniproject.MainActivity
import tuk.myprivateapp.miniproject.R
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MemoActivity : AppCompatActivity() {

    lateinit var memoContent : EditText

    lateinit var btnToMain : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)
        memoContent = findViewById(R.id.MemoContent)

        btnToMain = findViewById(R.id.button)

        var fileName : String

        fileName = (intent.getStringExtra("Myear").toString() + "_"
                + intent.getStringExtra("day").toString() + ".txt")

        var strSDpath = Environment.getExternalStorageDirectory().absolutePath
        var myDir = File("$strSDpath/mydiary")
        myDir.mkdir()


        btnToMain.setOnClickListener {

            var file1 = File(strSDpath + "/myDiary/" + fileName)
            var str = memoContent.text.toString()
            try {
                var fos = FileOutputStream(file1)
                fos.write(str.toByteArray())
                fos.close()
                Toast.makeText(applicationContext, "$fileName 이 저장됨", Toast.LENGTH_SHORT).show()

            } catch (e : IOException) {
                Toast.makeText(this, "에러", Toast.LENGTH_SHORT).show()
            }

            val intentToMain = Intent(applicationContext, MainActivity::class.java)
            //인텐트 스택 삭제
            intentToMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentToMain)
        }


    }
}