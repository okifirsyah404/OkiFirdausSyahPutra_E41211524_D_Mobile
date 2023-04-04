package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.helper.DateHelper
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Note")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "date")
    var date: String = DateHelper.getCurrentDate()
) : Parcelable