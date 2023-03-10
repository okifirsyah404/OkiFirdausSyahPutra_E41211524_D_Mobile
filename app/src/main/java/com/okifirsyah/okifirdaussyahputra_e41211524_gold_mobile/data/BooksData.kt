package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data

import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.enums.BookGenres
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.enums.BookLanguages
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.Book

object BooksData {
    private val booksTitle =
        arrayOf(
            "Atomic Habits",
            "Breath",
            "Shoe Dog",
            "Keajaiban Toko Kelontong Namiya",
            "The Psychology of Money",
            "Working backward",
            "Ikigai",
            "Pulang-Pergi",
            "The Intelligent Investor",
            "The Things You Can See Only When You Slow Down"
        )
    private val booksSubtitle = arrayOf(
        "Atomic Habits \"Cara Mudah dan Terbukti Untuk Membentuk kebiasaan Baik dan Menghilangkan Kebiasaan Buruk\"",
        "Breath: Cara Bernapas Dengan Benar",
        "Shoe Dog",
        "Keajaiban Toko Kelontong Namiya (The Miracles of the Namiya General Store/Namiya Zakkaten No Kiseki)",
        "The Psychology of Money. Timeless lessons on wealth, greed, and happiness",
        "Working Backwards: Insights, Stories, and Secrets from Inside Amazon",
        "Ikigai: The Japanese Secret to a Long and Happy Life",
        "Pulang-Pergi",
        "The Intelligent Investor: The Definitive Book on Value Investing",
        "The Things You Can See Only When You Slow Down: How to Be Calm in a Busy World"
    )
    private val booksAuthor =
        arrayOf(
            "James Clear",
            "James Nestor",
            "Phil Knight",
            "Keigo Higashino",
            "Morgan Housel",
            "Colin Bryar and Bill Carr",
            "Hector Garcia and Francesc Miralles",
            "Tere Liye",
            "Benjamin Graham",
            "Haemin Sunim"
        )
    private val booksGenre = arrayOf(
        BookGenres.SELF_IMPROVEMENT.value,
        BookGenres.LIFE_STYLE.value,
        BookGenres.BIOGRAPHY.value,
        BookGenres.MYSTERY.value,
        BookGenres.FINANCE.value,
        BookGenres.SELF_IMPROVEMENT.value,
        BookGenres.SELF_IMPROVEMENT.value,
        BookGenres.ACTION.value,
        BookGenres.FINANCE.value,
        BookGenres.LIFE_STYLE.value
    )
    private val booksPages = intArrayOf(352, 332, 386, 400, 256, 304, 208, 417, 640, 288)
    private val booksPublisher = arrayOf(
        "Gramedia Pustaka Utama",
        "Gramedia Pustaka Utama",
        "Simon & Schuster, Inc.",
        "Gramedia Pustaka Utama",
        "Harriman House",
        "St. Martin's Press",
        "Penguin Life",
        "Sabak Grip Nusantara",
        "Harper Collins",
        "Gramedia Pustaka Utama"
    )
    private val booksISBN =
        arrayOf(
            "9786020633176",
            "9780735213616",
            "9781471146725",
            "9786020648293",
            "9780857197689",
            "9781250267597",
            "9780143130727",
            "9786239554521",
            "9780060555665",
            "9786024813659"
        )
    private val booksPublishDate =
        arrayOf(
            "15 September 2019",
            "22 Juli 2021",
            "26 April 2016",
            "16 Desember 2020",
            "8 September 2020",
            "9 Februari 2021",
            "29 Agustus 2017",
            "1 Januari 2021",
            "21 Fevruari 2006",
            "20 April 2020"
        )
    private val booksDescription = arrayOf(
        "Orang mengira ketika Anda ingin mengubah hidup, Anda perlu memikirkan hal-hal besar. Namun pakar kebiasaan terkenal kelas dunia James Clear telah menemukan sebuah cara lain. Ia tahu bahwa perubahan nyata berasal dari efek gabungan ratusan keputusan kecil—dari mengerjakan dua push-up sehari, bangun lima menit lebih awal, sampai menahan sebentar hasrat untuk menelepon.\n" +
                "Ia menyebut semua tadi atomic habits.",
        "Tak ada yang lebih penting bagi kesehatan dan kesejahteraan kita selain bernapas: hirup udara, keluarkan, ulangi 25.000 kali sehari. Namun, sebagai suatu spesies, manusia telah kehilangan kemampuan untuk bernapas dengan benar, dengan konsekuensi yang serius. Dalam BREATH, James Nestor berkeliling dunia untuk menemukan ilmu pengetahuan yang tersembunyi di balik praktik pernapasan kuno untuk mencari tahu apa yang salah dan bagaimana memperbaikinya.\n" +
                "Penelitian modern menunjukkan bahwa membuat sedikit perubahan pada cara kita bernapas dapat: meningkatkan kinerja dalam berolahraga; meremajakan organ dalam; menghentikan dengkuran, alergi, asma, dan penyakit autoimun; bahkan bisa meluruskan tulang belakang yang mengalami skoliosis.\n" +
                "Kelihatannya tak mungkin, tapi ternyata mungkin. Menggali ribuan tahun kebijaksanaan kuno dan studi mutakhir dalam pulmonologi, psikologi, biokimia, dan fisiologi manusia, BREATH mengubah kebijaksanaan konvensional dari apa yang kita pikir kita ketahui tentang fungsi biologis paling dasar ini.\n" +
                "Setelah membaca buku ini, kita tak akan bernapas dengan cara yang sama lagi.",
        "Shoe Dog is a memoir by Nike co-founder Phil Knight. The memoir chronicles the history of Nike from its founding as Blue Ribbon Sports and its early challenges to its evolution into one of the world's most recognized and profitable companies. It also highlights certain parts of Phil Knight's life." +
                " Bill Gates named Shoe Dog one of his five favorite books of 2016 and called it \"An amazing tale, a refreshingly honest reminder of what the path to business success really looks like. It’s a messy, perilous, and chaotic journey, riddled with mistakes, endless struggles, and sacrifice. Phil Knight opens up in ways few CEOs are willing to do.\"",
        "Ketika tiga pemuda berandal bersembunyi di toko kelontong tak berpenghuni setelah melakukan pencurian, sepucuk surat misterius mendadak diselipkan ke dalam toko melalui lubang surat. Surat yang berisi permintaan saran. Sungguh aneh. " +
                "Namun, surat aneh itu ternyata membawa mereka dalam petualangan melintasi waktu, menggantikan peran kakek pemilik toko kelontong yang menghabiskan tahun-tahun terakhirnya memberikan nasihat tulus kepada orang-orang yang meminta bantuan. Hanya untuk satu malam. Dan saat fajar menjelang, hidup ketiga sahabat itu tidak akan pernah sama lagi...",
        "Doing well with money isn't necessarily about what you know. It's about how you behave. And behavior is hard to teach, even to really smart people. Money--investing, personal finance, and business decisions--is typically taught as a math-based field, where data and formulas tell us exactly what to do. But in the real world people don't make financial decisions on a spreadsheet." +
                " They make them at the dinner table, or in a meeting room, where personal history, your own unique view of the world, ego, pride, marketing, and odd incentives are scrambled together. In The Psychology of Money, award-winning author Morgan Housel shares 19 short stories exploring the strange ways people think about money and teaches you how to make better sense of one of life's most important topics.",
        "Working Backwards gives an insider's account of Amazon's approach to culture, leadership and best practices from two long-time, top-level Amazon executives.\n" +
                "Colin Bryar and Bill Carr joined Amazon in the late 90s. Their time at the company covered a period of unmatched innovation that brought products and services - including Kindle, Amazon Prime, Amazon Echo and Alexa, and Amazon Web Services - to life. Through the story of these innovations they reveal the principles and practices that drive Amazon's success.\n" +
                "Through their wealth of experience they offer unprecedented access to the 'Amazon way' as it was refined, articulated and proven to be repeatable, scalable and adaptable. Working Backwards shows how success is not achieved by the genius of any single leader, but rather through commitment to and execution of a set of well-defined, rigorously executed principles and practices that you can apply at your own company, no matter the size.\n",
        "According to the Japanese, everyone has an ikigai—a reason for living. And according to the residents of the Japanese village with the world’s longest-living people, finding it is the key to a happier and longer life. Having a strong sense of ikigai—where what you love, what you’re good at, what you can get paid for, and what the world needs all overlap—means that each day is infused with meaning. It’s the reason we get up in the morning." +
                " It’s also the reason many Japanese never really retire (in fact there’s no word in Japanese that means retire in the sense it does in English): They remain active and work at what they enjoy, because they’ve found a real purpose in life—the happiness of always being busy.",
        "Ada jodoh yang ditemukan lewat tatapan pertama.\n" +
                "Ada persahabatan yang diawali lewat sapa hangat.\n" +
                "Bagaimana jika takdir bersama ternyata,\n" +
                "diawali dengan pertarungan mematikan?\n" +
                "Lantas semua cerita berkelindan dengan,\n" +
                "pengejaran demi pengejaran mencari jawaban?\n" +
                "Pulang-Pergi",
        "The classic bestseller by Benjamin Graham, \"The Intelligent Investor\" has taught and inspired hundreds of thousands of people worldwide. Since its original publication in 1949, Benjamin Graham's book has remained the most respected guide to investing, due to his timeless philosophy of \"value investing\", which helps protect investors against the areas of possible substantial error and teaches them to develop long-term strategies with which they will be comfortable down the road." +
                " Over the years, market developments have borne out the wisdom of Graham's basic policies, and in today's volatile market, \"The Intelligent Investor\" is the most important book you will ever read on making the right decisions to protect your investments and make them a success. Featuring new chapter updates - which append every chapter of Graham's book, leaving his original text untouched - from noted financial journalist Jason Zweig, this HarperBusiness Essentials edition of the timeless classic offers readers even clearer understanding of Graham's wisdom as it should be applied today.",
        "The world moves fast, but that doesn’t mean we have to. This bestselling mindfulness guide by Haemin Sunim (which means “spontaneous wisdom”), a renowned Buddhist meditation teacher born in Korea and educated in the United States, illuminates a path to inner peace and balance amid the overwhelming demands of everyday life. \n" +
                "By offering guideposts to well-being and happiness in eight areas—including relationships, love, and spirituality—Haemin Sunim emphasizes the importance of forging a deeper connection with others and being compassionate and forgiving toward ourselves. The more than twenty full-color illustrations that accompany his teachings serve as calming visual interludes, encouraging us to notice that when you slow down, the world slows down with you."
    )
    private val booksLanguage =
        arrayOf(
            BookLanguages.ID.value,
            BookLanguages.ID.value,
            BookLanguages.EN.value,
            BookLanguages.ID.value,
            BookLanguages.EN.value,
            BookLanguages.EN.value,
            BookLanguages.EN.value,
            BookLanguages.ID.value,
            BookLanguages.EN.value,
            BookLanguages.ID.value
        )
    private val booksImage = intArrayOf(
        R.drawable.img_atomic_habits_cover,
        R.drawable.img_breath_cover,
        R.drawable.img_shoe_dog_cover,
        R.drawable.img_keajaiban_toko_kelontong_namiya_cover,
        R.drawable.img_the_psychology_of_money_cover,
        R.drawable.img_working_backwards_cover,
        R.drawable.img_ikigai_cover,
        R.drawable.img_pulang_pergi_cover,
        R.drawable.img_the_intelligent_investor_cover,
        R.drawable.img_the_things_you_can_see_only_when_you_slow_down_cover
    )

    val listData: ArrayList<Book>
        get() {
            val list = arrayListOf<Book>()
            for (position in booksTitle.indices) {
                val book = Book()

                book.title = booksTitle[position]
                book.subtitle = booksSubtitle[position]
                book.author = booksAuthor[position]
                book.genre = booksGenre[position]
                book.pages = booksPages[position]
                book.publisher = booksPublisher[position]
                book.isbn = booksISBN[position]
                book.publishDate = booksPublishDate[position]
                book.description = booksDescription[position]
                book.language = booksLanguage[position]
                book.cover = booksImage[position]
                list.add(book)
            }
            return list
        }
}