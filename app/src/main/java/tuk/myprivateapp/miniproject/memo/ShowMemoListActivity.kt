package tuk.myprivateapp.miniproject.memo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_show_memo_list.*
import tuk.myprivateapp.miniproject.R
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class ShowMemoListActivity : AppCompatActivity(), MyRecyclerviewInterface {

    val SP_NAME = "memo_sp_storage"

    // 데이터를 담을 그릇 즉 배열
    var memoList = ArrayList<MyMemo>()

    var memoFiles : Array<File>? = null

    private lateinit var myRecyclerAdapter: MemoListAdapter

    // 뷰가 화면에 그려질때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_memo_list)

        memoFiles = File(Environment.getExternalStorageDirectory().absolutePath + "/mydiary").listFiles()

        // memoFiles의 배열에 있는 파일 즉 존재하는 파일 갯수만큼 for문을 돌린다 .
        for (i in (memoFiles!!.size-1) downTo 0){

            //파일 읽어와서 그 내용을 myMemo로 넘겨준다.
            var file1 = memoFiles!![i]
            var str_context : String
            var exchan : String = memoFiles!![i].name //이거 파일 이름이니까 그냥 나중에 날짜 쓸 때 쓰면 될듯?

            try {
                var inFs = FileInputStream(file1)
                var txt = ByteArray(inFs.available())
                inFs.read(txt)
                str_context = txt.toString(Charsets.UTF_8).trim()
                var feelImg = readSharedPreference(exchan)
                val myMemo = MyMemo(name = str_context, profileImage = feelImg)
                this.memoList.add(myMemo)
                inFs.close()
            } catch (e : IOException) {
                Toast.makeText(this, "error",Toast.LENGTH_SHORT).show()
            }


        }


        // 어답터 인스턴스 생성
        myRecyclerAdapter = MemoListAdapter(this)

        myRecyclerAdapter.submitList(this.memoList)

        // 리사이클러뷰 설정
        my_recycler_view.apply {

            // 리사이클러뷰 방향 등 설정
            layoutManager = LinearLayoutManager(this@ShowMemoListActivity, LinearLayoutManager.VERTICAL, false)

            // 어답터 장착
            adapter = myRecyclerAdapter
        }

    }

    override fun onItemClicked(position: Int) {

        var name: String? = null

        // 값이 비어있으면 ""를 넣는다.
        // unwrapping - 언랩핑

        val title: String = this.memoList[position].name ?: ""

//        val title: String = name ?: "호호호"

//        AlertDialog.Builder(this)
//            .setTitle(title)
//            .setMessage("$title 와 함께하는 빡코딩! :)")
//            .setPositiveButton("오케이") { dialog, id ->
//                Log.d(TAG, "MainActivity - 다이얼로그 확인 버튼 클릭했음")
//            }
//            .show()

    }

    fun readSharedPreference(key:String):String{
        val sp = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        return sp.getString(key,"")?:""
    }

}
