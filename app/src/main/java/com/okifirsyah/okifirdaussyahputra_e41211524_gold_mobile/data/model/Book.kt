package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model

import android.os.Parcel
import android.os.Parcelable

data class Book(
    var title: String? = "",
    var subtitle: String? = "",
    var author: String? = "",
    var genre: String? = "",
    var pages: Int = 0,
    var publisher: String? = "",
    var isbn: String? = "",
    var publishDate: String? = "",
    var description: String? = "",
    var cover: Int = 0,
    var language: String? = "",
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(subtitle)
        parcel.writeString(author)
        parcel.writeString(genre)
        parcel.writeInt(pages)
        parcel.writeString(publisher)
        parcel.writeString(isbn)
        parcel.writeString(publishDate)
        parcel.writeString(description)
        parcel.writeInt(cover)
        parcel.writeString(language)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }
}