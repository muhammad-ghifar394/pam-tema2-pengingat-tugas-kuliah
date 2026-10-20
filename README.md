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
![Image Alt](https://github.com/AW2606/fotodokumtugas/blob/df78344158af137167cd25af14f97d68b2c49e0a/DOKUM/PAM/Pertemuan1/Pert1.png)


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
