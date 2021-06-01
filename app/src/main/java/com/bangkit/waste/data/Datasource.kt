package com.bangkit.waste.data

import com.bangkit.waste.model.Category
import com.bangkit.waste.model.Product

class Datasource {
    fun loadCategories(): List<Category> {
        return listOf(
            Category(
                1,
                "Cardboard",
            ),
            Category(
                2,
                "Glass",
            ),
            Category(
                3,
                "Metal",
            ),
            Category(
                4,
                "Plastic",
            ),
            Category(
                5,
                "Paper",
            ),
        )
    }

    fun loadProducts(): List<Product> {
        return listOf(
            Product(
                1,
                "Celengan dari Kardus",
                "https://i1.wp.com/seruni.id/wp-content/uploads/2020/02/Celengan-dari-Kardus-Bekas.jpg",
                1,
                listOf(
                    "Kardus bekas",
                    "Tali sepatu berwarna (bebas)",
                    "Pensil",
                    "Penggaris",
                    "Paku",
                    "Cutter",
                ),
                listOf(
                    "Sebelum membuat celengan dari kardus bekas, sebaiknya tentukan lebih dulu seberapa besar celengan yang akan kamu buat.",
                    "Gambar pola tersebut menggunakan pensil dan penggaris di atas kardus. Pastikan garisnya tidak miring untuk menjaga bentuk celengan agar simetris.",
                    "Potong kardus yang suda dibuat pola dengan menggunakan cutter ataupun gunting.",
                    "Langkah yang selanjutnya, lubangi sisi samping kardus menggunakan paku. Untuk melubanginya, kamu harus melipat kardus tersebut, dampai celengan berbentuk kubus, dan lihat sisi mana saja yang perlu dijahit menggunakan tali sepatu. Dan lubangi secara sejajar.",
                    "Pastikan lubang tersebut tidak berdempetan dan memiliki jarak yang sama, anatara lubang yang satu dan lainnya.",
                    "Jika sudah, kamu hanya perlu menjahit setiap sisi yang sudah dilubangi menggunakan tali sepatu.",
                    "Untuk menjahitnya, mulailah dari dalam, agar jahitannya lebih terlihat rapi. Jika celenganmu sudah jadi, jangan lupa untuk memeberi celah pada bagian atas celengan menggunakan cutter, celengan sudah siap digunakan.",
                ),
                "https://www.youtube.com/watch?v=Xz47ibsOPPI",
                false,
            ),
            Product(
                2,
                "Keranjang Alat Tulis",
                "https://i0.wp.com/seruni.id/wp-content/uploads/2020/02/Keranjang-Alat-Tulis.jpg",
                1,
                listOf(
                    "Kardus sepatu",
                    "Beberapa isian guluangan tisu bekas",
                    "Kertas kado",
                    "Gunting",
                    "Lem tembak",
                    "Isolasi kertas",
                ),
                listOf(
                    "Siapkan alat dan bahan yang dibutuhkan. Bersihkan kardus sepatu dari debu-debu yang menempel. Bagian kardus yang digunakan hanya bagian badannya saja, ya.",
                    "Kemudian, lapisi semua bagian badan kardus dengan kertas kado. Rekatkan dengan isolasi kertas.",
                    "Siapkan beberapa isian gulungan tisu yang berbentuk seperti tabung. Gulungan ini nantinya akan berguna sebagai sekat antara jenis alat tulis satu dan yang lainnya.",
                    "Rekatkan tabung tersebut dengan posisi berdiri di bagian dalam badan kardus. Gunakan lem tembak agar merekat lebih erat.",
                    "Susun semua koleksi alat tulismu. Keranjang alat tulis dari kardus sepatu sudah siap menghiasi meja belajarmu."
                ),
                "https://www.youtube.com/watch?v=DdZWisG6t-Q",
                false,
            ),
        )
    }
}