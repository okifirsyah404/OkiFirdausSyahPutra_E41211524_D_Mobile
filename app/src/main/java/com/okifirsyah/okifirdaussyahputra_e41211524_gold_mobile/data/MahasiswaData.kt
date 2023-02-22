package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data

import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.models.Mahasiswa

object MahasiswaData {

    private val studentNames = arrayOf(
        "Oki Firdaus Syah Putra",
        "Ardi Setiawan",
        "Dwi Lestari Sari",
        "Hadi Santoso Putra",
        "Maya Putri",
        "Agus Wijaya Nugraha",
        "Sari Dewi Nuryanti",
        "Rudi Hidayat Sutanto",
        "Dewi Susanti",
        "Budi Cahyono",
        "Citra Indah Lestari",
        "Endah Sari",
        "Iwan Setiawan Putra",
        "Ratna Sari Kartika",
        "Fajar Pratama Kusuma",
        "Ayu Nurul Hidayah",
        "Rina Puspita",
        "Ahmad Surya Saputra",
        "Retno Indah Triyani",
        "Joko Santoso",
        "Dian Setyawan"
    )

    private val nimNumbers = arrayOf(
        "E41211524",
        "E42325678",
        "E56723487",
        "E69874563",
        "E84623578",
        "E96534782",
        "E07865431",
        "E12354897",
        "E25678941",
        "E39865437",
        "E42369874",
        "E56789421",
        "E62369875",
        "E77896432",
        "E82369874",
        "E97896432",
        "E02369875",
        "E16789421",
        "E21369874",
        "E37896432",
        "E42369875"
    )

    private val phoneNumbers = arrayOf(
        "081234567890",
        "087654321098",
        "081298765432",
        "081212345678",
        "085678901234",
        "085432109876",
        "082345678901",
        "087654321234",
        "082345678901",
        "085432109876",
        "087654321234",
        "081234567890",
        "081298765432",
        "085678901234",
        "082345678901",
        "081234567890",
        "081212345678",
        "085432109876",
        "085678901234",
        "081298765432",
        "082345678901"
    )

    val listData: ArrayList<Mahasiswa>
        get() {
            val list = arrayListOf<Mahasiswa>()
            for (position in studentNames.indices) {
                val mahasiswa = Mahasiswa(
                    studentNames[position],
                    nimNumbers[position],
                    phoneNumbers[position]
                )
                list.add(mahasiswa)
            }
            return list
        }


}