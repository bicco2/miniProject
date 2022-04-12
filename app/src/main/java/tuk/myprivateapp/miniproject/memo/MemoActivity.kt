package tuk.myprivateapp.miniproject.memo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import tuk.myprivateapp.miniproject.MainActivity
import tuk.myprivateapp.miniproject.R
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MemoActivity : AppCompatActivity() {

    lateinit var fileName : String
    lateinit var strSDpath :String
    lateinit var myDir :File
    var radioBtnID: String? = null

    lateinit var memoContent : EditText

    lateinit var dayText: TextView

    lateinit var btnToMain : Button
    lateinit var btnToBack : Button

    lateinit var radioBtn1 : RadioButton
    lateinit var radioBtn2 : RadioButton
    lateinit var radioBtn3 : RadioButton
    lateinit var radioBtn4 : RadioButton
    lateinit var radio_group : RadioGroup

    val SP_NAME = "memo_sp_storage"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_memo)

        //초기 설정 함수
        fileInit()
        //완료 눌렀을 때 저장되게 하는 것
        btnToMain.setOnClickListener {

            if(radioBtnID != null && memoContent.text.toString() != ""){
                var file1 = File(strSDpath + "/myDiary/" + fileName)
                var str = memoContent.text.toString()
                try {
                    var fos = FileOutputStream(file1)
                    fos.write(str.toByteArray())
                    fos.close()
                    Toast.makeText(applicationContext, "$fileName 이 저장됨", Toast.LENGTH_SHORT).show()
                } catch (e: IOException) {
                    Toast.makeText(this, "에러", Toast.LENGTH_SHORT).show()
                }

                writeSharedPrefernce(fileName, radioBtnID!!)

                val intentToMain = Intent(applicationContext, MainActivity::class.java)
                //인텐트 스택 삭제
                intentToMain.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intentToMain)
            }
            else{
                Toast.makeText(this, "모든 항목을 작성해주세요.",Toast.LENGTH_SHORT).show()
            }

        }

        //취소 버튼
        btnToBack.setOnClickListener{
            onBackPressed()
        }


    }

    fun writeSharedPrefernce(key : String, value:String){
        val sp = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(key, value)
        editor.apply()
    }


    fun radio_button_click(view: View){
        val radio: RadioButton = findViewById(radio_group.checkedRadioButtonId)
        Toast.makeText(applicationContext,"On click : ${radio.id}", Toast.LENGTH_SHORT).show()
        radioBtnID = radio.id.toString()
    }

    fun fileInit(){
        memoContent = findViewById(R.id.MemoContent)
        btnToMain = findViewById(R.id.Finish_btn)
        btnToBack = findViewById(R.id.Cancel_btn)
        dayText = findViewById(R.id.DayText)

        radioBtn1 = findViewById(R.id.RadioBtn1)
        radioBtn2 = findViewById(R.id.RadioBtn2)
        radioBtn3 = findViewById(R.id.RadioBtn3)
        radioBtn4 = findViewById(R.id.RadioBtn4)
        radio_group = findViewById(R.id.radio_group)

        fileName = (intent.getStringExtra("Myear").toString() + "_"
                + intent.getStringExtra("day").toString() + ".txt")

        strSDpath = Environment.getExternalStorageDirectory().absolutePath
        myDir = File("$strSDpath/mydiary")
        myDir.mkdir()

        var dayTextView :String
        dayTextView =  intent.getStringExtra("day").toString() + " " + intent.getStringExtra("Myear").toString()

        dayText.setText(dayTextView)
    }


}