## Pertemuan 1. Membuat repo, mengisi tema, dan nama anggota

# Tema 2. Pengingat Tugas Kuliah

## Identitas Kelompok

| No. | Nama Anggota | NIM | Jabatan |
| :-: | :--- | :--- | :--- |
| 1 | Adhitya Warman | 124140007 | Ketua |
| 2 | Roy Kurniawan | 124140024 | Anggota |
| 3 | Muhammad Ghifar | 124140091 | Anggota |
| 4 | Reza Lesmana Julgi | 124140115 | Anggota |

## Dokumentasi

<img src="https://github.com/AW2606/fotodokumtugas/blob/df78344158af137167cd25af14f97d68b2c49e0a/DOKUM/PAM/Pertemuan1/Pert1.png" alt="Dokumentasi Pertemuan 1" width="200">


## Pertemuan 2. Model Data, Coroutines, dan Flow

Yang dibuat minggu ini:

- Model data `Tugas`, `MataKuliah`, dan sealed class `StatusTugas` (Belum Dikerjakan, Dikerjakan, Selesai) di `commonMain/model`.
- Sumber data palsu `SumberTugasPalsu` dengan `delay` dan `Flow` perubahan status di `commonMain/data`.
- Test kecil `SumberTugasPalsuTest` yang mencetak perubahan status ke konsol.

| Nama Anggota | Bagian |
| :--- | :--- |
| Adhitya Warman | Model data |
| Roy Kurniawan | Sumber data palsu |
| Muhammad Ghifar | Coroutines dan Flow |
| Reza Lesmana Julgi | Test / bukti berjalan |

Jalankan dengan `./gradlew :shared:jvmTest`, contoh keluarannya:

```
Sebelum collect
Belum dikerjakan
Dikerjakan 50%
Selesai, dikumpulkan 2026-10-26 21.00
Sesudah collect
```

## Dokumentasi
![Image Alt](https://github.com/AW2606/fotodokumtugas/blob/306be806e3176316e191b77e8d986c41721e1383/DOKUM/PAM/Pertemuan2/dokum.png)

## Pertemuan 3. Layar Daftar untuk Tema Kelompok

Yang dibuat minggu ini:

- Layar daftar menggunakan `LazyColumn` yang menampilkan data tugas dari `daftarTugasPalsu`.
- Komponen `CardTugas` untuk menampilkan informasi tugas (judul, mata kuliah, tenggat, dan catatan) beserta label status dari sealed class `StatusTugas`.
- Fungsi `olahDaftarTugas` di `PengolahanTugas.kt` untuk mengurutkan tugas sebelum ditampilkan berdasarkan tenggat waktu (`sortedBy`).
- Komponen `TombolTambahTugas` sebagai tombol aksi utama (Floating Action Button / FAB) pada `Scaffold`.
- Penambahan data dummy di `DataTugasPalsu.kt` menjadi 10 item tugas.

| Nama Anggota | Bagian |
| :--- | :--- |
| Adhitya Warman | Logika pengolahan data (`PengolahanTugas.kt`) dan integrasi layar utama (`App.kt`) |
| Roy Kurniawan | Penyiapan 10 data tugas dummy di `DataTugasPalsu.kt` |
| Muhammad Ghifar | Pembuatan composable `CardTugas.kt` |
| Reza Lesmana Julgi | Pembuatan FAB `AksiTugas.kt` dan dokumentasi |

## Dokumentasi
![Dokumentasi Pertemuan 3](DOKUM_PERTEMUAN_3.png)

