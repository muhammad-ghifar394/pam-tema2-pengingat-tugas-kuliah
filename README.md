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
![Image Alt](https://github.com/AW2606/fotodokumtugas/blob/1b07e37eb86fde05b57a7885fdf0e28cc4cfb2c4/DOKUM/PAM/pertemuan3/dokum.jpeg)

## Pertemuan 4. State dan MVVM

### Yang dibuat minggu ini:

- Pembuatan form tambah tugas untuk memasukkan judul tugas, mata kuliah, dan tenggat waktu.
- Pembuatan komponen `KolomTeks.kt` sebagai input reusable yang bersifat stateless.
- Pengelolaan state aplikasi menggunakan `TugasUiState.kt`.
- Implementasi `TugasViewModel.kt` menggunakan `MutableStateFlow` dan `StateFlow`.
- Validasi input untuk memastikan judul dan mata kuliah tidak kosong.
- Integrasi form dengan `App.kt` agar tugas baru dapat ditambahkan ke daftar melalui tombol Simpan.
- Pengujian proses penambahan tugas dan validasi input pada `commonTest`.

### Pembagian Tugas Kelompok

| Nama Anggota | Bagian |
|---|---|
| Muhammad Ghifar | Pengelolaan state UI (`TugasUiState.kt`) dan ViewModel (`TugasViewModel.kt`) |
| Reza Lesmana Julgi | Pembuatan komponen input (`KolomTeks.kt`) dan form tambah tugas (`FormTambahTugas.kt`) |
| Adhitya Warman | Integrasi form dan ViewModel pada `App.kt`, serta tombol tambah (`AksiTugas.kt`) |
| Roy Kurniawan | Pengujian pada `commonTest` dan dokumentasi |

### Dokumentasi

**1. Form Tambah Tugas**

Screenshot tampilan form untuk memasukkan judul tugas, mata kuliah, dan tenggat waktu.

![Form Tambah Tugas](screenshots/pertemuan4-form.png)

**2. Daftar Tugas Setelah Data Ditambahkan**

Screenshot tampilan daftar tugas setelah tugas baru berhasil disimpan dan muncul pada daftar.

![Daftar Tugas Setelah Data Ditambahkan](screenshots/pertemuan4-hasil.png)

### Hasil Pengerjaan

Checkpoint Pertemuan 4 mengembangkan aplikasi Pengingat Tugas Kuliah dengan menerapkan konsep state dan MVVM. State dan logika penambahan tugas dikelola melalui ViewModel, sedangkan tampilan menggunakan komponen Compose yang reusable. Pengguna dapat mengisi form dan menambahkan tugas ke daftar. Pengujian dilakukan untuk memeriksa validasi input dan proses penambahan tugas.