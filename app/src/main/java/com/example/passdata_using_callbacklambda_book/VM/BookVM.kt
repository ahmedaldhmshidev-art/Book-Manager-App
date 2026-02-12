package com.example.passdata_using_callbacklambda_book.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.passdata_using_callbacklambda_book.modle.Book
import java.util.UUID

class BookVM : ViewModel() {
    private val bookResource = mutableListOf<Book>()

    private val _bookAll = MutableLiveData<List<Book>>()
    val bookAll : LiveData<List<Book>> = _bookAll

    fun fetchAllBook(){
        if (bookResource.isEmpty()){
            val addFirst = listOf(
                Book(id = UUID.randomUUID().toString() ,
                    title = "البدية" ,
                    content = "اول كتاب تجريبي" ,
                    releaseAt = System.currentTimeMillis() ,
                    author = "احمد"
                    )
            )
            bookResource.addAll(addFirst)

        }
        _bookAll.value = bookResource
    }
    fun addNewBook(book: Book){
        val current = (_bookAll.value ?: emptyList()).toMutableList()
        current.add(book)
        bookResource.clear()
        bookResource.addAll(current)
        _bookAll.value = current.toList() //  نسخة جديدة → يضمن تحديث الـ RecyclerView
    }

    fun update(id: String, book: Book){
        val current = (_bookAll.value ?: emptyList()).toMutableList()
        val index = current.indexOfFirst { it.id == id }
        if (index != -1){
            current[index] = book
            bookResource.clear()
            bookResource.addAll(current)
            _bookAll.value = current.toList() //  نسخة جديدة
        }
    }

    fun remove(id: String){
        val current = (_bookAll.value ?: emptyList()).toMutableList()
        val filtered = current.filterNot { it.id == id }
        bookResource.clear()
        bookResource.addAll(filtered)
        _bookAll.value = filtered.toList() //  نسخة جديدة
    }

    fun refreshBook() {
        _bookAll.value = bookResource.toList()
    }

}