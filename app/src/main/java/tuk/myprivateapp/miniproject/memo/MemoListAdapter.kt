package tuk.myprivateapp.miniproject.memo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tuk.myprivateapp.miniproject.R

class MemoListAdapter (myRecyclerviewInterface: MyRecyclerviewInterface): RecyclerView.Adapter<MemoListViewHolder>() {
    val TAG: String = "로그"

    private var memoList = ArrayList<MyMemo>()

    private var myRecyclerviewInterface :MyRecyclerviewInterface? = null

    // 생성자
    init {
        this.myRecyclerviewInterface = myRecyclerviewInterface
    }

    // 뷰홀더가 생성 되었을때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoListViewHolder {

        // 연결할 레이아웃 설정

        return MemoListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item, parent, false), this.myRecyclerviewInterface!!)
    }

    // 목록의 아이템수
    override fun getItemCount(): Int {
        return this.memoList.size
    }

    // 뷰와 뷰홀더가 묶였을때
    override fun onBindViewHolder(holder: MemoListViewHolder, position: Int) {
        Log.d(TAG, "MyRecyclerAdapter - onBindViewHolder() called / position: $position")
        holder.bind(this.memoList[position])

    }

    // 외부에서 데이터 넘기기
    fun submitList(memoList: ArrayList<MyMemo>){
        this.memoList = memoList
    }

}