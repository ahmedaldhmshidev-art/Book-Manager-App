package com.example.passdata_using_callbacklambda_book.AVH

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.passdata_using_callbacklambda_book.databinding.CaredBookBinding
import com.example.passdata_using_callbacklambda_book.modle.Book

enum class ActionBook {EDIT , DELETE}
typealias OnBookAction = (Book , ActionBook) -> Unit

class BookAdapter : ListAdapter<Book, BookAdapter.VH>(DiffCallback()) {

    private var onBookAction : OnBookAction? = null
    fun setOnBookAction(listener : OnBookAction ){
        onBookAction = listener
    }

//    او بهذا الشكل مفصله
//    private var one :((Book , ActionBook) -> Unit)? = null
//    fun setOnBookAction(listener : (Book , ActionBook) -> Unit) {
//    one = listener
//}

//    دالة عمل inflater للتصميم العنصر الذي سيظهر في recyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH
    { val form = LayoutInflater.from(parent . context)
        val inflate = CaredBookBinding.inflate(form , parent , false)
        return VH(inflate)
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        val dataBook = getItem(position)
        holder.build(dataBook)
    }

    inner class VH(val binding: CaredBookBinding) : RecyclerView.ViewHolder(binding.root) {

//        pass Data to UI and onClick
        fun build(book : Book){
            binding.titleBookIdCaredBook    .text = book . title
            binding.contentBookIdCaredBook  .text = book . content
            binding.releaseAtBookIdCaredBook.text = formatDate(book.releaseAt)
            binding.authorBookIdCaredBook   .text = book.author

    binding.caredBookId.setOnClickListener{
        onBookAction?.invoke(book , ActionBook.EDIT)
    }
    binding.caredBookId.setOnLongClickListener{
      onBookAction?.invoke(book , ActionBook.DELETE)
      true
    }

        }

    }
//دالة تحويل التاريخ الحالي الي شكل 1/21/2020
    fun formatDate(timestamp: Long): String {
        val date = java.util.Date(timestamp)
        val format = java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale.getDefault())
        return format.format(date)
    }

}
//  من اجل تحويل ال adapter ال listAdapter يتحدث تماتيك
class DiffCallback : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Book, newItem: Book) = oldItem == newItem
}