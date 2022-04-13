package tuk.myprivateapp.miniproject.memo

import android.util.Log

class MyMemo(var name: String? = null, var profileImage: String? = null) {

    val TAG: String = "로그"

    // 기본 생성자
    init {
        Log.d(TAG, "MyModel - init() called")
    }

}
