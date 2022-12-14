package com.tngen.hilttest.presentation.main

import android.util.Log
import androidx.lifecycle.*
import com.tngen.domain.HiltUseCase
import com.tngen.domain.RetrofitUseCase
import com.tngen.domain.entity.NoteEntity
import com.tngen.domain.model.HouseModel
import com.tngen.hilttest.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val hiltUseCase: HiltUseCase,
    private val retrofitUseCase: RetrofitUseCase
) :BaseViewModel(){
    private val _note = MutableLiveData<NoteEntity>()
    val note : LiveData<NoteEntity>
        get() = _note

    private val _house = MutableLiveData<List<HouseModel>>()
    val house : LiveData<List<HouseModel>>
        get() = _house


    init {
        viewModelScope.launch {
            _note.value = hiltUseCase.getNote()
        }
    }

    fun saveNote() {
        Log.d("MainViewModel", "dddddddd")
        viewModelScope.launch {
            _note.value?.let { hiltUseCase.saveNote(it) }

        }
        viewModelScope.launch {
            retrofitUseCase.execute()
        }
    }
}