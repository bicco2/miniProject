package tuk.myprivateapp.miniproject.memo

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_recycler_item.view.*
import tuk.myprivateapp.miniproject.R

class MemoListViewHolder(itemView: View,
                         recyclerviewInterface: MyRecyclerviewInterface):
    RecyclerView.ViewHolder(itemView),
    View.OnClickListener
{

    val TAG: String = "로그"

    private val usernameTextView = itemView.user_name_txt
    private val feelImgTextView = itemView.feel_img_txt
    private val profileImageView = itemView.profile_img

    private var myRecyclerviewInterface : MyRecyclerviewInterface? = null

    // 기본 생성자
    init {
        Log.d(TAG, "MyViewHolder - init() called")

        itemView.setOnClickListener(this)
        this.myRecyclerviewInterface = recyclerviewInterface

    }


    // 데이터와 뷰를 묶는다.
    fun bind(myMemo: MyMemo){
        Log.d(TAG, "MyViewHolder - bind() called")

        // 텍스트뷰 와 실제 텍스트 데이터를 묶는다.
        usernameTextView.text = myMemo.name
        feelImgTextView.text = myMemo.profileImage

        if(myMemo.profileImage=="2131231210"){
            profileImageView.setImageResource(R.drawable.frame1after)
        }
        if(myMemo.profileImage=="2131231211"){
            profileImageView.setImageResource(R.drawable.frame2after)
        }
        if(myMemo.profileImage=="2131231212"){
            profileImageView.setImageResource(R.drawable.frame3after)
        }
        if(myMemo.profileImage=="2131231213"){
            profileImageView.setImageResource(R.drawable.frame4after)
        }


    }

    override fun onClick(p0: View?) {
        Log.d(TAG, "MyViewHolder - onClick() called")

        this.myRecyclerviewInterface?.onItemClicked(adapterPosition)

    }


}
