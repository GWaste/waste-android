package com.bangkit.waste.data

import com.bangkit.waste.model.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class Datasource {
    fun loadCategories(): List<Category> {
        val jsonString = """
            {
            	"category": [{
            			"id": 1,
            			"name": "Cardboard"
            		},
            		{
            			"id": 2,
            			"name": "Glass"
            		},
            		{
            			"id": 3,
            			"name": "Metal"
            		},
            		{
            			"id": 4,
            			"name": "Plastic"
            		},
            		{
            			"id": 5,
            			"name": "Paper"
            		}
            	]
            }
        """.trimIndent()
        
        val container = Json.decodeFromString<CategoryContainer>(jsonString)
        
        return container.category
    }

    fun loadProducts(): List<Product> {
        val jsonString = """
            {
                "products": [{
                    "id": 1,
                    "name": "Celengan dari Kardus",
                    "image": "https://i1.wp.com/seruni.id/wp-content/uploads/2020/02/Celengan-dari-Kardus-Bekas.jpg",
                    "category_id": 1,
                    "ingredient": ["Kardus bekas", "Tali sepatu berwarna (bebas)", "Pensil", "Penggaris", "Paku", "Cutter"],
                    "step": ["Sebelum membuat celengan dari kardus bekas, sebaiknya tentukan lebih dulu seberapa besar celengan yang akan kamu buat.", "Gambar pola tersebut menggunakan pensil dan penggaris di atas kardus. Pastikan garisnya tidak miring untuk menjaga bentuk celengan agar simetris.", "Potong kardus yang suda dibuat pola dengan menggunakan cutter ataupun gunting.", "Langkah yang selanjutnya, lubangi sisi samping kardus menggunakan paku. Untuk melubanginya, kamu harus melipat kardus tersebut, dampai celengan berbentuk kubus, dan lihat sisi mana saja yang perlu dijahit menggunakan tali sepatu. Dan lubangi secara sejajar.", "Pastikan lubang tersebut tidak berdempetan dan memiliki jarak yang sama, anatara lubang yang satu dan lainnya.", "Jika sudah, kamu hanya perlu menjahit setiap sisi yang sudah dilubangi menggunakan tali sepatu.", "Untuk menjahitnya, mulailah dari dalam, agar jahitannya lebih terlihat rapi. Jika celenganmu sudah jadi, jangan lupa untuk memeberi celah pada bagian atas celengan menggunakan cutter, celengan sudah siap digunakan."],
                    "link_yt": "Xz47ibsOPPI",
                    "favorite": false
                }, {
                    "id": 2,
                    "name": "Keranjang Alat Tulis",
                    "image": "https://i0.wp.com/seruni.id/wp-content/uploads/2020/02/Keranjang-Alat-Tulis.jpg",
                    "category_id": 1,
                    "ingredient": ["Kardus sepatu", "Beberapa isian guluangan tisu bekas", "Kertas kado", "Gunting", "Lem tembak", "Isolasi kertas"],
                    "step": ["Siapkan alat dan bahan yang dibutuhkan. Bersihkan kardus sepatu dari debu-debu yang menempel. Bagian kardus yang digunakan hanya bagian badannya saja, ya.", "Kemudian, lapisi semua bagian badan kardus dengan kertas kado. Rekatkan dengan isolasi kertas.", "Siapkan beberapa isian gulungan tisu yang berbentuk seperti tabung. Gulungan ini nantinya akan berguna sebagai sekat antara jenis alat tulis satu dan yang lainnya.", "Rekatkan tabung tersebut dengan posisi berdiri di bagian dalam badan kardus. Gunakan lem tembak agar merekat lebih erat.", "Susun semua koleksi alat tulismu. Keranjang alat tulis dari kardus sepatu sudah siap menghiasi meja belajarmu."],
                    "link_yt": "DdZWisG6t-Q",
                    "favorite": false
                }, {
                    "id": 3,
                    "name": "Tempat Tisu",
                    "image": "https://i1.wp.com/seruni.id/wp-content/uploads/2020/02/Tempat-Tisu-dari-Kardus-Bekas.jpg",
                    "category_id": 1,
                    "ingredient": ["Kardus bekas (utamakan dengan jenis yang tebal)", "Kertas kado", "Cat air (warna sesuai selera)", "Gunting", "Lem (superglue)", "Pensil", "Penggaris", "Tisu dengan ukuran medium"],
                    "step": ["Pertama-tama, kamu harus mengukur kardus sesuai panjang dan lebar tisu yang akan kamu masukkan ke dalam kotak.", "Kemudian, buatlah pola kotak tisu menggunakan pencil dan penggaris. Jika pola sudah selesai dibuat, potong pola tersebut menggunakan cutter ataupun gunting. Utamakan lubang pada bagian atas kardus agar lebih mudah mengambil tisu.", "Jangan lupa, berikan lem pada setiap sisi kardus, dan satukan satiap sisinya sampai membuat kotak tisu yang sempurna.", "Agar lebih cantik dan menarik, hias kotak tersebut menggunakan kertas kado. Kamu juga bisa menggunakan opsi lain, seperti lukisan abstrak agar kotak tosu lebih terlihat artistik."],
                    "link_yt": "gFa2xciZq4c",
                    "favorite": false
                }, {
                    "id": 4,
                    "name": "Pigura",
                    "image": "https://i0.wp.com/seruni.id/wp-content/uploads/2020/02/Pigura-dari-kardus-bekas.jpg",
                    "category_id": 1,
                    "ingredient": ["Kardus (pilih kardus yang tebal dan kuat)", "Gunting", "Cutter", "Pensil", "Penggaris", "Lem", "Hiasan", "Kertas putih atau hitam"],
                    "step": ["Pertama, siapkan beberapa bahan yang diperlukan. Kemudian, potong kardus menjadi sebuah kotak. Ukuran bingkai foto biasanya 4Ã—6 atau 5Ã—7. Atau bisa menyesuaikan dengan ukuran foto.", "Jika kamu telah memiliki kardus yang berukuran 6Ã—8, maka ini saatnya kamu memotong bagian tenga kardus tersebut.", "Agar bingkai foto terlihat semakin cantik, sebaiknya buatlah garis seperti double frame.", "Jika ingin terlihat semakin bagus, kamu bisa memakai apa saja untuk menghibas bingkai yang kamu buat. Bisa dengan cat air pun yang lainnya.", "Jangan lupa untuk membuat bagian belakang bingkai. Berikan lem pada setiap sudut bingkai foto. Rekatkan bingkai luar, inner liner dan foto. Bisa juga memakai selotip, tapi seiring dengan waktu selotip akan lepas.", "Terakhir, buatlah penyangga bingkai dengan kardus yang cukup tebal. Hiasi penyangga sesuai dengan keinginanmu. Kemudian tempelkan di bagian cover belakang bingkai foto.", "Pigura buatanmu pun selesai, dan sudah bisa digunakan."],
                    "link_yt": "_FZURaYwNs4",
                    "favorite": false
                }, {
                    "id": 5,
                    "name": "Bunga dari Kardus",
                    "image": "https://i1.wp.com/seruni.id/wp-content/uploads/2020/02/Bunga-dari-kardus.jpg",
                    "category_id": 1,
                    "ingredient": ["Kardus bekas", "Lem", "Gunting/ Cutter"],
                    "step": ["Jangan lupa siapkan alat dan bahan yang akan digunakan. Gunting kardus dengan ukuran kecil dan memanjang menjadi beberapa bagian.", "Kemudian, bentuklah kardus seolah-olah terlihat seperti batangnya. Untuk membuat daunnya, kamu bisa menggulung sedikit kardus tersebut, dan rekatkan dengan lem.", "Jika sudah, langsung saja membuat bunganya. Yaitu dengan cara menggulung karus menjadi lima gulungan kecil. Jangan lupa berikan lem agar gulungan tidak mudah terlepas.", "Selanjutnya, susun gulungan tersebut menjadi bentuk bunga dan diberikan lem.", "Buatlah bunga-bunga ini sebanyak mungkin, untuk menghiasi tangkai-tangkai yang kosong. Apabila semuanya sudah selesai, bunga berbahan dasar kardus bekas ini siap kamu tempelkan di ruang tamu atau dimana pun sesuka hatimu."],
                    "link_yt": "krax45z_t_0",
                    "favorite": false
                }, {
                    "id": 6,
                    "name": "Lampu Gantung",
                    "image": "https://i1.wp.com/seruni.id/wp-content/uploads/2020/02/Lampu-gantung-dari-kardus.jpg",
                    "category_id": 1,
                    "ingredient": ["Kardus bekas", "Lem tembak", "Lampu", "Tempat lampu", "Kabel", "Penggaris", "Cat semprot"],
                    "step": ["Langkah yang pertama potong kardus dengan ukuran panjang 60 cm dan lebar 21 cm. Atau bisa disesuaikan dengan ukuranmu sendiri.", "Kemudian, warnai kardus dengan cat putih untuk permukaan kardus. Permukaan yang dicat hanya satu sisi saja dan permukan yang dicat dijadikan sebagai warna dalam.", "Langkah selanjutnya, lipat kardus menjadi segilima. Sisi dalam kardus yang berwarna putih dan sisi luarnya warna kardus asli.", "Setelah kardus selesai dilipat, potong-potong kardus yang membentuk segilima tersebut menjadi banyak. Cara mudahnya dengan membentangkan lagi kardus tersebut, lalu dipotong.", "Setelah dipotong, lipat kembali kardus yang sudah dipotong menjadi segilima. Gunakan lem agar lipatan kartus tidak mudah terbuka.", "Susun kembali potongan kardus segilima tersebut dengan posisi belawanan dari kardus ke kardus lainnya. Gunakan lem agar melekat kuat. (lihat gambar)", "Langkah selanjutnya adalah membuat lembaran kardus berbentuk segilima. Hal ini berfungsi untuk tempat meletakkan lampu. Buat lubang di bagian tengah kardus berbentuk segilima tersebut, lalu pasang tempat untuk lampunya beserta kabelnya.", "Gabungkan lembaran kardus yang berbentuk segilima dengan potongan kardus yang disusun sebelumnya.", "Proses membuat lampu hias dari kardus sudah selesai. Kamu bisa menggunakan lampu hias tersebut di teras atau di ruang tamu rumah."],
                    "link_yt": "M_8oj5WmA1s",
                    "favorite": false
                }, {
                    "id": 7,
                    "name": "Topi Ulang Tahun",
                    "image": "https://i0.wp.com/seruni.id/wp-content/uploads/2020/02/Topi-ulang-tahun.jpg",
                    "category_id": 1,
                    "ingredient": ["Kardus", "Gunting", "Kertas kado", "Lem", "Pensil", "Penggaris"],
                    "step": ["Cara membuatnya tidak terlalu rumit, kamu bisa mulai dengan membuat desainnya terlebih dahulu dengan menggambar di atas kardus.", "Setelah selesai membuat pola, kardus tersebut bisa langsung dipotong sesuai dengan pola yang sudah digambar.", "Potongan tersebut, nantinya digabungkan dengan menggunakan lem hingga membentuk topi.", "Agar topi tidak terlihat monoton, gunakan cat atau kertas kado untuk memberikan warna pada topi tersebut.", "Selain itu, berikan hiasan lainnya yang bisa menjadikan topi terlihat lebih menarik.", "Topi ulang tahun siap digunakan."],
                    "link_yt": "3eh2_TyUs4I",
                    "favorite": false
                }, {
                    "id": 8,
                    "name": "Tempat Pensil dari Kardus Pasta Gigi",
                    "image": "https://i2.wp.com/seruni.id/wp-content/uploads/2020/02/Tempat-pensil.jpg",
                    "category_id": 1,
                    "ingredient": ["Kardus pasta gigi", "Kertas kado", "Gunting", "Lem"],
                    "step": ["Petama, lepaskan semua rekatan pada kardus pasta gigi. Kemudian potong kertas kado mengikuti bentuk kardus pasta gigi dan rekatkan pada permukaan luar kardus.", "Setelah semua permukaan luar tertutup, langkah selanjutnya adalah menutup permukaan dalam kardus dengan kertas kado dengan motif dan warna yang kamu suka.", "Tempat pensil dari kardus pasta gigi sudah siap digunakan."],
                    "link_yt": "U2iXkhIxsd0",
                    "favorite": false
                }, {
                    "id": 9,
                    "name": "Tas dari Kardus",
                    "image": "https://i2.wp.com/seruni.id/wp-content/uploads/2020/02/Tas-dari-kardus.jpg",
                    "category_id": 1,
                    "ingredient": ["Kardus bekas", "Tali rafia", "Gunting", "Tali untuk pegangan", "Kertas kado", "Lem", "Plastik transparan", "Jarum kasur"],
                    "step": ["Buat pola berbentuk persegi panjang, gunting kardus tersebut sebanyak lima sisi. Setelah itu, bungkus semua bagian dinging luar kardus dengan kertas kado dan jangan lupa rekatkan dengan lem.", "Kemudian bungkus lagi menggunakan plastik transparan agar lebih awet dan tahan air.", "Jahit semua pinggiran sisi tas tersebut dengan tali rafia dan jarum kasur.", "Setelah ke 5 sisi kardus terjahit, masing-masing sisi disatukan dengan cara dijahit juga.", "Selanjutnya beri lubang pegangan dan beri tali."],
                    "link_yt": "a1g5ZsWrCuA",
                    "favorite": false
                }, {
                    "id": 10,
                    "name": "Tempat Tidur Kucing",
                    "image": "https://i2.wp.com/seruni.id/wp-content/uploads/2020/02/Tempat-tidur-kucing-dari-kardus-bekas.jpg",
                    "category_id": 1,
                    "ingredient": ["Kardus bekas sepatu", "Gunting/ Cutter", "Lem superglue", "Kertas kado", "Hiasan pilihan", "Selimut kecil"],
                    "step": ["Sebelum membuat tempat tidur untuk kucing kesayanganmu, pastikan dulu ukurannya pas dengan kucingmu, ya. Agar nantinya ia dapat beristirahat dengan nyaman.", "Gunting bagian dalam kardus sebagai pintu masuk kucing menggunakan cutter maupun gunting.", "Agar memiliki kesan yang mewah, kamu bisa menghias tempat tidur ini menggunakan kertas kado dengan motif pilihanmu. Atau kamu juga bisa menambahkan nama kucingmu pada bagian depan agar tempat tidur lebih terlihat personal.", "Untuk selimut, pilihlah yang tidak terlalu tebal ataupun terlalu tipis. Karena kucing lebih cepat merasa panas, apabila selimut terlalu tebal, risiko mereka merasakan sesak napas lebih tinggi."],
                    "link_yt": "7LF1ddoIoSo",
                    "favorite": false
                }, {
                    "id": 11,
                    "name": "Frame Lilin",
                    "image": "https://sholehuddin.com/wp-content/uploads/2019/10/screen-1.jpg",
                    "category_id": 2,
                    "ingredient": ["Botol Kaca", "Tang", "Stan Lilin", "Besi"],
                    "step": ["Pertama potong bagian bawah botol kaca", "Pasang lilin ke stannya", "lilitkan dengan kawat", "Setelah itu bentuk sesuka hati kalian"],
                    "link_yt": "zQlh9Jlx4m4",
                    "favorite": false
                }, {
                    "id": 12,
                    "name": "Frame Lampu",
                    "image": "https://sholehuddin.com/wp-content/uploads/2019/10/1940427_79f49bc6-c0fb-4ecf-973f-80f69517fc7f_715_715.png",
                    "category_id": 2,
                    "ingredient": ["Botol Kaca", "Papan Kayu", "Rantai Besi", "Kabel", "Bor", "Paku", "Palu"],
                    "step": ["Pertama potong bagian bawah botol kaca", "Jangan terlalu banyak", "Jika anda tidak tau cara memotong botol kaca tulis di kolom komentar di paling bawah.", "Lalu lubangi papan kayu yang telah di siapkan tadi dengan bor", "Pasang mulut botol tadi ke lubang yang telah di buat", "Lalu ganjal dengan rantai supaya tidak jatuh"],
                    "link_yt": "yiV-_ZE57eM",
                    "favorite": false
                }, {
                    "id": 13,
                    "name": "Frame Lampu Dengan Simpel",
                    "image": "https://sholehuddin.com/wp-content/uploads/2019/10/10506294_2fa55faa_72ed_4be7_9012_6580cc498e28.jpg",
                    "category_id": 2,
                    "ingredient": ["Botol Kaca", "Kawat Besi", "Tang Gabus/Plastik Penyumbat"],
                    "step": ["Tinggal potong botol kaca", "Lalu masukan lampu yang telah anda sediakan", "Untuk penyumbatnya anda bisa gabus atau plastik yang sudah anda sediakan", "Jika anda belum jelas silahkan melihat gambar di atas."],
                    "link_yt": "AyJoYcrqG8c",
                    "favorite": false
                }, {
                    "id": 14,
                    "name": "Meja Hias",
                    "image": "https://sholehuddin.com/wp-content/uploads/2019/10/images.jpg",
                    "category_id": 2,
                    "ingredient": ["Botol Kaca", "Papan Kayu", "Bor", "Gergaji", "Cat Kayu/Pernis"],
                    "step": ["Potong papan kayu sesuai dengan keinginan anda", "Setelah itu haluskan dan cat dengan pernis atau cat kayu", "Lalu tunggu hingga kering", "Setelah kering lubangi papan kayu dengan bor", "Usahakan ukurannya sama dengan mulut botol kaca", "Jumlah lubang sesuaikan dengan jumlah botol yang akan anda gunakan", "Lalu pasang botol ke lubang-lubang yang telah anda buat"],
                    "link_yt": "bLLB0gOoCJo",
                    "favorite": false
                }, {
                    "id": 15,
                    "name": "Vas Bunga",
                    "image": "https://sholehuddin.com/wp-content/uploads/2019/10/kerajinan-pot-dari-botol-kaca.jpg",
                    "category_id": 2,
                    "ingredient": ["Botol Kaca", "Cat Warna", "Selotip"],
                    "step": ["Pertama berikan selotip ke botol", "Lalu anda bisa sesuaikan bentuknya dengan motif yang kamu inginkan", "Lalu cat seluruh botol dengan pewarna yang telah anda sediakan", "Setelah itu tunggu hingga kering", "Jika sudah kering lepas seluruh selotip."],
                    "link_yt": "6GzxKaahWs8",
                    "favorite": false
                }, {
                    "id": 16,
                    "name": "Hiasan Meja",
                    "image": "https://sholehuddin.com/wp-content/uploads/2019/10/00235148_13.jpg",
                    "category_id": 2,
                    "ingredient": ["Botol Kaca", "Pasir", "Hiasan"],
                    "step": ["Pertama potong botol kaca setengah bagian", "Lalu isi di dalamnya dengan pasir", "Setelah anda isi hiasan yang anda inginkan"],
                    "link_yt": "17HsWhOuMAc",
                    "favorite": false
                }, {
                    "id": 17,
                    "name": "Lampu Hias",
                    "image": "https://mesinpencacahplastik.id/wp-content/uploads/2019/09/kerajinan-dari-plastik-3.jpg",
                    "category_id": 4,
                    "ingredient": ["Botol bekas plastik", "Sendok plastik", "Lampu lengkap", "Pisau", "Obeng", "Lem", "Cat"],
                    "step": ["Sediakan bahan serta perlengkapan yang diperlukan.", "Kemudian, potong botol menjadi 2 bagian.", "Potong-potong sendok plastik.", "Sambungkan botol menggunakan sendok agar lebih cantik menggunakan lem.", "Cat sendok yang sudah ditempelkan.", "Potong-potong botol membentuk seperti daun nanas, lantas dicat.", "Pasang lampunya dan tiang untuk berdiri.", "Dan, lampu hias dari botol bekas pun siap untuk dipakai."],
                    "link_yt": "4Pln9sfpdVs",
                    "favorite": false
                }, {
                    "id": 18,
                    "name": "Bunga",
                    "image": "https://mesinpencacahplastik.id/wp-content/uploads/2019/09/kerajinan-dari-plastik-4.jpg",
                    "category_id": 4,
                    "ingredient": ["Plastik kresek (warna terserah, sesuai keinginan)", "Gunting", "Kawat", "Daun palsu"],
                    "step": ["Guntinglah sedikit bagian atas dan bagian bawah plastik.", "Lipatlah menjadi 4 bagian lalu gunting garis lipatan.", "Gabunglah ke 4 potongan plastik menjadi 1.", "Lipatlah seperti sedang membuat kipas dari kertas.", "Ikatlah kipas plastik  tersebut menggunakan kawat.", "Bukalah tiap lapisan plastik agar terlihat seperti bunga yang mekar.", "Tambahkan daun di bagian batang bunga."],
                    "link_yt": "FxVtBI8gN_o",
                    "favorite": false
                }, {
                    "id": 19,
                    "name": "Keranjang Buah",
                    "image": "https://i.ytimg.com/vi/4r44-58zbOg/maxresdefault.jpg",
                    "category_id": 4,
                    "ingredient": ["Cat Warna", "Lem Tembak", "Gunting", "Cutter", "Plastik Bekas", "Lem"],
                    "step": ["Bagian gelas yang diperlukan untuk membuat keranjang adalah atas dengan bentuk lingkaran. Maka dari itulah, pisahkan terlebih dahulu bahan tersebut menggunakan gunting atau cutter.", "Setelah itu, satukan lingkatan gelas secara teratur menggunakan lem tembak. Buatlah minimal tiga bagian dengan panjang minimal setengah meter. Pastikan setiap titik sudah menempel dengan benar agar tahan lama dan awet.", "Kemudian setelah selesai, gabungkan menjadi satu dan tempelkan di bagian ujungnya. Untuk tahapan yang terakhir buatlah bagian bawahnya dengan cara yang sama. Dan kemudian beri warna menggunakan cat sesuai selera."],
                    "link_yt": "4r44-58zbOg",
                    "favorite": false
                }, {
                    "id": 20,
                    "name": "Vas Bunga",
                    "image": "https://i.ytimg.com/vi/ym0bxKbIV9Y/maxresdefault.jpg",
                    "category_id": 4,
                    "ingredient": ["Gunting", "Spidol", "Pisau Cutter", "Botol Plastik", "Cat Secukupnya"],
                    "step": ["Bagian gelas yang diperlukan untuk membuat keranjang adalah atas dengan bentuk lingkaran. Maka dari itulah, pisahkan terlebih dahulu bahan tersebut menggunakan gunting atau cutter.", "Setelah itu, satukan lingkatan gelas secara teratur menggunakan lem tembak. Buatlah minimal tiga bagian dengan panjang minimal setengah meter. Pastikan setiap titik sudah menempel dengan benar agar tahan lama dan awet.", "Kemudian setelah selesai, gabungkan menjadi satu dan tempelkan di bagian ujungnya. Untuk tahapan yang terakhir buatlah bagian bawahnya dengan cara yang sama. Dan kemudian beri warna menggunakan cat sesuai selera."],
                    "link_yt": "ym0bxKbIV9Y",
                    "favorite": false
                }, {
                    "id": 21,
                    "name": "Celengan",
                    "image": "https://i.ytimg.com/vi/2i8cDlNAyD8/hqdefault.jpg",
                    "category_id": 4,
                    "ingredient": ["Selotip Warna", "Plastik", "Gunting", "Pisau Cutter", "Lem"],
                    "step": ["Tutup bagian atas gelas plastik dengan plastik warna sampai seluruh lubangnya tertutup.", "Kemudian rekatkan plastik warna tersebut disetiap sisi gelas plastik bekas dan potong dan rapikan dengan gunting.", "Jangan lupa untuk membuat lubang di bagian plastik warna yang sudah menutupi gelas plastik. Tidak perlu terlalu besar, minimal muat untuk 1 koin agar bisa masuk."],
                    "link_yt": "2i8cDlNAyD8",
                    "favorite": false
                }, {
                    "id": 22,
                    "name": "Tempat Charger HP",
                    "image": "https://i.ytimg.com/vi/-54tbdVDlA0/maxresdefault.jpg",
                    "category_id": 4,
                    "ingredient": ["Botol Plastik", "Pisau Cutter", "Kertas 1 Lembar", "Spidol", "Gunting"],
                    "step": ["Siapkan botol bekas pembersih lantai, sampo atau bedak, usahakan yang berbentuk kotak, kemudian gambar pola dengan spidol pada botol.", "Setelah selesai, potong sesuai pola yang telah digambar dengan gunting atau cuter dan buat lubang untuk menggantungkan tempat cas dengan steker cas.", "Dan langkah yang terakhir, haluskan semua bagian yang telah dipotong tadi dengan amplas sampai benar-benar halus agar tidak merusak hp kamu, dan tempat ngecas hp sudah dapat digunakan."],
                    "link_yt": "-54tbdVDlA0",
                    "favorite": false
                }, {
                    "id": 23,
                    "name": "Celengan",
                    "image": "https://i.ytimg.com/vi/361MlD_1Qu4/hqdefault.jpg",
                    "category_id": 4,
                    "ingredient": ["Botol Plastik", "Lem", "Kertas karton", "Gunting", "Pisau Cutter"],
                    "step": ["Tutup bagian atas gelas plastik dengan karton warna sampai seluruh lubangnya tertutup.", "Kemudian rekatkan karton tersebut disetiap sisi gelas plastik bekas dan potong dan rapikan dengan gunting lalu lem.", "Jangan lupa untuk membuat lubang di bagian plastik warna yang sudah menutupi gelas plastik. Tidak perlu terlalu besar, minimal muat untuk 1 koin agar bisa masuk."],
                    "link_yt": "361MlD_1Qu4",
                    "favorite": false
                }, {
                    "id": 24,
                    "name": "Jam Dinding",
                    "image": "http://i3.ytimg.com/vi/46K_4_U4MnY/hqdefault.jpg",
                    "category_id": 5,
                    "ingredient": ["majalah atau koran bekas", "gunting", "kepingan CD/DVD", "jarum", "benang", "mesin jam", "batu baterai"],
                    "step": ["pertama-tama sediakan bahan dan peralatan yang dibutuhkan", "lipat koran berbentuk gulungan, buatlah menjadi dua gulungan", "lubangi gulungan koran dengan jarum, lalu masukkan benang", "rangkai atau susunlah gulungan koran atau majalah tersebut memakai benang sampai berbentuk lingkaran", "letakkan kepingan CD di tengah-tengah lingkaran", "kemudian berikan angka sesuai jam pada umumnya", "pasang mesin jam dan jarum jamnya pada koran yang sudah dirangkai", "pasang juga baterai jam, pastikan jam berjalan dengan normal", "kerajinan tangan jam dari koran/majalah bekas sudah selesai dan siap digunakan"],
                    "link_yt": "46K_4_U4MnY",
                    "favorite": false
                }, {
                    "id": 25,
                    "name": "Tempat Pensil",
                    "image": "http://i3.ytimg.com/vi/Da183ku7OeA/maxresdefault.jpg",
                    "category_id": 5,
                    "ingredient": ["Koran bekas", "Lem", "Gunting", "Kaleng atau botol", "Pensil", "Tali untuk menghias"],
                    "step": ["Setelah selesai menyiapkan bahan. Siapkan kaleng kemudian potong koran sesuai dengan dasar kaleng tersebut.", "Potonglah beberapa lembar untuk dibuat gulungan, setelah selesai tempelkan gulungan tersebut pada kaleng dengan lem.", "Lalu rapikan gulungan koran tersebut sesuai dengan kaleng, setelah selesai beri hiasan tali paga untuk menambah penampilan tempat pensil agar terlihat cantik dan bagus dipandang.", "Dan tempat pensil dari koran sudah bisa digunakan. Demikianlah berbagai kerajinan tangan dari koran yang dapat saya bagikan."],
                    "link_yt": "Da183ku7OeA",
                    "favorite": false
                }, {
                    "id": 26,
                    "name": "Bunga",
                    "image": "http://i3.ytimg.com/vi/jLCNWWwIGro/hqdefault.jpg",
                    "category_id": 5,
                    "ingredient": ["Kertas krep.", "Gunting.", "Lem."],
                    "step": ["Gunting kertas krep menjadi kelopak-kelopak bunga.", "Gulung kertas krep secara melingkar yang akan digunakan sebagai kuncupnya.", "Rangkai potongan kelopak bunga pada kuncup dengan cara berlapis membentuk bunga mawar menggunakan lem."],
                    "link_yt": "jLCNWWwIGro",
                    "favorite": false
                }, {
                    "id": 27,
                    "name": "Amplop",
                    "image": "http://i3.ytimg.com/vi/q7znrvb1zO0/maxresdefault.jpg",
                    "category_id": 5,
                    "ingredient": ["Kertas kado atau kertas karton (bekas)", "Gunting.", "Lem."],
                    "step": ["Potong kertas kado atau kertas karton berbentuk hati.", "Putar kertas berbentuk hati sehingga bagian runcing berada di atas.", "Lipat kedua sisi lengkung ke arah dalam.", "Lipat bagian bawah sehingga membentuk tutupan kantong.", "Lem bagian lipatan tadi di sisi kanan dan kiri.", "Terakhir, lipat bagian yang runcing ke arah bawah sehingga menutupi kantong."],
                    "link_yt": "q7znrvb1zO0",
                    "favorite": false
                }, {
                    "id": 28,
                    "name": "Kalung",
                    "image": "http://i3.ytimg.com/vi/NSR3YwllfPQ/maxresdefault.jpg",
                    "category_id": 5,
                    "ingredient": ["Majalah bekas.", "Lem.", "Tali senar.", "Manik-manik (jika perlu).", "Pengait kalung."],
                    "step": ["Pasang salah satu ujung tali senar pada pengait kalung.", "Buat gulungan majalah dengan panjang kurang lebih 1,5 cm dengan lubang di bagian tengahnya.", "Gunakan lem untuk merekatkan gulungan.", "Masukkan beberapa manik-manik pada tali kemudian masukkan gulungan yang telah dibuat dengan motif selang-seling sampai ujung tali.", "Namun sisakan tali untuk dipasang pada pengait.", "Pasang ujung tali senar pada pengait sehingga kedua ujung senar terhubung dengan pengait.", "Buat gulungan majalah yang lebih besar berbentuk lingkaran.", "Pasangkan di bagian tengah tali sehingga menjadi bandul."],
                    "link_yt": "NSR3YwllfPQ",
                    "favorite": false
                }, {
                    "id": 29,
                    "name": "Lentera",
                    "image": "http://i3.ytimg.com/vi/p5d9msTWT6s/hqdefault.jpg",
                    "category_id": 5,
                    "ingredient": ["Kertas bekas/koran.", "Gunting.", "Selotip.", "Bola Lampu", "Kardus"],
                    "step": ["Lipat kertas karton atau koran bekas menjadi dua secara memanjang dengan ukuran kurang lebih 20 cm.", "Potong bagian yang terlipat dengan jarak 2 cm, tetapi jangan sampai terputus.", "Buka lipatan kemudian satukan kedua ujung kertas sehingga berbentuk tabung menggunakan selotip.", "Gunting kertas karton dengan panjang 15 cm dan lebar 2 cm.", "Pasang hasil guntingan tersebut pada bagian atas lentera menggunakan selotip sehingga menjadi pegangan.", "Letakkan bola lampu di dalam lentera."],
                    "link_yt": "p5d9msTWT6s",
                    "favorite": false
                }, {
                    "id": 30,
                    "name": "Asbak dari Kaleng Minuman Bekas",
                    "image": "https://i.ytimg.com/vi/DuwSq1VOWKg/hqdefault.jpg",
                    "category_id": 3,
                    "ingredient": ["Kaleng minuman bekas", "Spidol", "Pisau", "Gunting"],
                    "step": ["Siapkan kaleng minuman bekas dan alat yang akan digunakan.", "Buatlah pola gambar 2 garis di kaleng bekas dengan menggunakan spidol.", "Memotong bagian pinggir kaleng bekas dengan menggunakan pisau seperti pada contoh video tersebut.", "Merapikan bagian pinggir yang telah dipotong tersebut dengan menggunakan gunting.", "Menggunting kaleng bekas sampai batas yang telah ditandai dengan spidol seperti pada contoh video tersebut.", "Kemudian bagian yang telah digunting tersebut ditekuk secara horizontal seperti pada contoh video.", "kemudian dilipat secara menyilang seperti pada contoh video dan lakukan sampai selesai.", "Kemudian setelah itu jadilah sebuah asbak."],
                    "link_yt": "DuwSq1VOWKg",
                    "favorite": false
                }, {
                    "id": 31,
                    "name": "Tempat Pensil dari Kaleng Bekas Rokok",
                    "image": "https://i.ytimg.com/vi/hIzjUFDMOac/maxresdefault.jpg",
                    "category_id": 3,
                    "ingredient": ["Kaleng rokok bekas", "Kain flanel/felt", "Kawat", "Focallure blush on", "Lem tembak", "Gunting"],
                    "step": ["Siapkan kaleng bekas rokok dan kain flanel/felt warna putih ukuran 22 x 15 cm.", "Lem kain flanel dengan menggunakan lem tembak kemudian rekatkan dengan kaleng bekas tersebut lalu gulung sampai kaleng tertutup dengan kain flanel.", "Rapikan dengan gunting untuk memotong kain flanel yang tersisa.", "Lem bagian dalam kain flanel lalu rekatkan kedalam kaleng bekas seperti pada contoh video.", "Siapkan kain flanel warna putih ukuran persegi dan sesuaikan dengan ukuran diameter kaleng bekas di bagian bawah.", "Lem bagian bawah kaleng bekas dengan menggunakan lem tembak lalu rekatkan dengan kain flanel yang ukuran persegi tersebut.", "Gunting kain flanel yang tersisa dibagian bawah kaleng bekas tersebut.", "Siapkan kain flanel warna putih ukuran 5 x 9 cm sebanyak 2 buah untuk membuat telinga kelinci.", "Gunting kain flanel tersebut dengan membentuk kuping kelinci seperti pada contoh video.", "Rekatkan kedua kain flanel tersebut dengan menggunakan lem tembak.", "Setelah direkatkan kedua kain flanel tersebut, balik kain flanel tersebut seperti pada contoh video.", "Siapkan kain flanel warna pink ukuran 2,5 x 6 cm dan gunting kain flanel tersebut membentuk pola telinga kelinci.", "Rekatkan kain flanel warna pink dengan telinga kelinci kain flanel yang telah dibuat.", "Masukkan kawat kedalam telinga kelinci supaya tegak, lalu potong kawat yang tesisa, kemudian lem bagian bawah telinga.", "Lakukan langkah-langkah yang sama untuk membuat telinga kelinci yang satunya.", "Rekatkan kedua telinga kelinci kedalam kaleng bekas tersebut.", "Membuat mata dan mulut kelinci dengan kain flanel dan rekatkan.", "Tambahkan focallure blush on supaya lebih cantik."],
                    "link_yt": "hIzjUFDMOac",
                    "favorite": false
                }, {
                    "id": 32,
                    "name": "Vas Gantung Shabby dari Kaleng Bekas Kue",
                    "image": "https://i.ytimg.com/vi/a5v0w4K0oK0/maxresdefault.jpg",
                    "category_id": 3,
                    "ingredient": ["Kaleng bekas kue", "Tali goni", "Tang", "Stiker huruf", "Gunting", "Lem tembak", "Palu dan paku", "Bunga plastik", "Bekas roll benang", "Cutter", "Cat besi"],
                    "step": ["Siapkan kaleng dan tutup kaleng bekas kue.", "Potong tutup kaleng bekas kue menjadi 2 dengan menggunakan gunting.", "rapikan bagian pinggir yang telah dipotong dengan menggunakan tang dan tekuk kedalam.", "cat kaleng dan tutup kaleng dengan menggunakan cat besi/cat minyak/pilox dengan warna sesuai selera.", "Jemur kaleng dan tutup kaleng yang telah di cat dibawah sinar matahari sampai kering.", "Potong roll bekas benang menjadi 2 bagian", "Cat roll bekas benang yang telah dipotong dengan cat besi/cat minyak/pilox dengan warna sesuai selera.", "Jemur roll bekas benang yang telah dicat dibawah sinar matahari sampai kering.", "Setelah kaleng dan tutup kaleng kering, lem bagian pinggir penutup kaleng dengan lem tembak kemudian rekatkan dengan kaleng.", "Tempelkan stiker nama di penutup kaleng sesuai selera.", "Lubangi bagian pinggir kaleng sebanyak 2 lubang dengan menggunakan paku dan palu untuk tempat gantungan.", "Memotong tali goni kemudian masukkan kedalam lubang kaleng seperti pada contoh video.", "Untuk dipajang di meja, tempelkan roll bekas benang di bagian pinggir bawah kaleng.", "Masukkan bunga plastik kedalam tempat kaleng bekas tersebut dan jadilah vas gantung shabby."],
                    "link_yt": "a5v0w4K0oK0",
                    "favorite": false
                }]
            }
        """.trimIndent()
        
        val container = Json.decodeFromString<ProductContainer>(jsonString)

        return container.products
    }

    fun loadUkms(): List<Ukm> {
        val jsonString = """
            {
            	"ukm": [{
            			"id": 1,
            			"name": "Dedi Jaya",
            			"product_id": [24],
            			"status": 2,
            			"map": {
            				"location": "Kab. Klaten",
            				"position": null
            			},
            			"contact": {
            				"whatsapp": "6282242008036",
            				"instagram": "@Jora_aristya",
            				"facebook": null
            			}
            		},
            		{
            			"id": 2,
            			"name": "MS Gallery",
            			"product_id": [2, 4, 9],
            			"status": 2,
            			"map": {
            				"location": "Kota Surabaya",
            				"position": null
            			},
            			"contact": {
            				"whatsapp": "62811333761",
            				"instagram": "@ms.gallery.id",
            				"facebook": null
            			}
            		},
            		{
            			"id": 3,
            			"name": "Mendekor Indonesia",
            			"product_id": [3, 4, 8, 20, 28, 29],
            			"status": 2,
            			"map": {
            				"location": "Kota Tangerang",
            				"position": null
            			},
            			"contact": {
            				"whatsapp": "6281311501711",
            				"instagram": "@mendekorindonesia",
            				"facebook": null
            			}
            		},
            		{
            			"id": 4,
            			"name": "I.P Project",
            			"product_id": [4, 16],
            			"status": 2,
            			"map": {
            				"location": "Kota Yogyakarta",
            				"position": null
            			},
            			"contact": {
            				"whatsapp": "6289626824392",
            				"instagram": "@ipproject.id",
            				"facebook": null
            			}
            		},
            		{
            			"id": 5,
            			"name": "Souvenirzanfi74",
            			"product_id": [3, 4, 11, 21],
            			"status": 2,
            			"map": {
            				"location": "Kab. Purworejo",
            				"position": null
            			},
            			"contact": {
            				"whatsapp": "6289626824392",
            				"instagram": "@zanfi_craft",
            				"facebook": null
            			}
            		},
            		{
            			"id": 6,
            			"name": "MommyQMa Project",
            			"product_id": [16],
            			"status": 2,
            			"map": {
            				"location": "Kota Palembang",
            				"position": null
            			},
            			"contact": {
            				"whatsapp": "6281373003137",
            				"instagram": "@mommyqma.project",
            				"facebook": null
            			}
            		},
            		{
            			"id": 7,
            			"name": "bariq.craft",
            			"product_id": [15, 16, 24, 26, 28],
            			"status": 2,
            			"map": {
            				"location": "Kab. Aceh Barat",
            				"position": null
            			},
            			"contact": {
            				"whatsapp": "6282191443037",
            				"instagram": "@bariq.craft",
            				"facebook": null
            			}
            		},
            		{
            			"id": 8,
            			"name": "DimajopaCraft",
            			"product_id": [5, 18, 28],
            			"status": 2,
            			"map": {
            				"location": "Kota Cilegon",
            				"position": null
            			},
            			"contact": {
            				"whatsapp": "6287774000407",
            				"instagram": "@dimajopacraft",
            				"facebook": null
            			}
            		},
            		{
            			"id": 9,
            			"name": "Paperistic",
            			"product_id": [3, 4, 16],
            			"status": 2,
            			"map": {
            				"location": "Kota Liwa",
            				"position": null
            			},
            			"contact": {
            				"whatsapp": "628228587167",
            				"instagram": "@paperistic",
            				"facebook": null
            			}
            		},
            		{
            			"id": 10,
            			"name": "BisaAja Merchandise",
            			"product_id": [3, 4, 16],
            			"status": 2,
            			"map": {
            				"location": "Kota Jakarta Barat",
            				"position": null
            			},
            			"contact": {
            				"whatsapp": "628118111407",
            				"instagram": "@bisaaja_merchandise",
            				"facebook": null
            			}
            		}
            	]
            }
        """.trimIndent()

        val container = Json.decodeFromString<UkmContainer>(jsonString)

        return container.ukm
    }


    fun loadProductsFromCategory(categoryId: Int): List<Product> {
        val allProducts = loadProducts();
        
        return allProducts.filter { 
            it.categoryId == categoryId
        }
    }
}