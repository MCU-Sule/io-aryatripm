# Things to add

3. add error handling for this application
   list all error scenario that potentially happen ?

   - file tidak ditemukan
   - format file berbeda
   - directory tidak ada
   - saat membuka, isi kosong

4. is it better to save data on plain text or json ? why ?
   jika data memiliki format(seperti class), lebih baik json. Karena lebih mudah dalam membaca/merubah file.

5. is there a better format to json to store data on plain text ? name a couple of alternatives (min 2)

   - csv
   - xml

6. is it better to save data on file instead of a dedicated database ? is there a scenario where saving data on file be better ?
   jika data yang disimpan harus dapat diakses dengan cepat dan secara offline, maka menyimpan dalam file lebih baik

7. can you think of potentiall security problem when you allow java to freely change file on your computer ? how do we prevent that ?
   iya, karena bisa dengan mudah memindahkan ataupun menghapus data
   dengan mengenkripsi datas
