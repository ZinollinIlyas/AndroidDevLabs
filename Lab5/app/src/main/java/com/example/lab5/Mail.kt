package com.example.lab5

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable

data class Mail(var name: String?, var title: String?, var content: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(title)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mail> {
        override fun createFromParcel(parcel: Parcel): Mail {
            return Mail(parcel)
        }

        override fun newArray(size: Int): Array<Mail?> {
            return arrayOfNulls(size)
        }


    }

}