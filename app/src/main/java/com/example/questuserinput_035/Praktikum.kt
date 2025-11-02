package com.example.questuserinput_035

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.SelectableDates

private fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormRegistrasi(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textKota by remember { mutableStateOf("") }
    var textTanggal by remember { mutableStateOf("") }
    var textRT by remember { mutableStateOf("") }
    var textRW by remember { mutableStateOf("") }
    var textUmur by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var checkSetuju by remember { mutableStateOf(false) }

    var showDatePicker by remember { mutableStateOf(false) }

    // State DatePicker dengan pembatasan tanggal (tidak bisa memilih hari di masa depan)
    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            return utcTimeMillis <= System.currentTimeMillis()
        }
    })

    var showDialog by remember { mutableStateOf(false) }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_registrasi),
            contentDescription = "Background Form",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = Color.White.copy(alpha = 0.55f),
                    shape = RoundedCornerShape(28.dp)
                )
        ) {

            Column(
                modifier = modifier
                    .padding(horizontal = 24.dp, vertical = 40.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Form Registrasi",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 28.dp)
                )

                //input nama
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    shape = RoundedCornerShape(size = 14.dp),
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Nama Lengkap") },
                    onValueChange = { textNama = it }
                )

                Spacer(modifier = Modifier.height(12.dp))

                // input kota
                OutlinedTextField(
                    value = textKota,
                    singleLine = true,
                    shape = RoundedCornerShape(size = 14.dp),
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Kota Asal") },
                    onValueChange = { textKota = it }
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Baris untuk Tanggal Lahir, RT, dan RW
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = textTanggal,
                        onValueChange = { }, // Biarkan kosong karena readOnly
                        readOnly = true,
                        singleLine = true,
                        shape = RoundedCornerShape(size = 14.dp),
                        modifier = Modifier.weight(weight = 1.5f),
                        label = { Text(text = "Tanggal Lahir") },
                        // Ikon kalender untuk memicu DatePicker
                        trailingIcon = {
                            IconButton(onClick = { showDatePicker = true }) {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = "Pilih Tanggal"
                                )
                            }
                        }
                    )

                    // Input RT
                    OutlinedTextField(
                        value = textRT,
                        singleLine = true,
                        shape = RoundedCornerShape(size = 14.dp),
                        modifier = Modifier.weight(weight = 0.7f),
                        label = { Text(text = "RT") },
                        onValueChange = { textRT = it }
                    )

                    // Input RW
                    OutlinedTextField(
                        value = textRW,
                        singleLine = true,
                        shape = RoundedCornerShape(size = 14.dp),
                        modifier = Modifier.weight(weight = 0.7f),
                        label = { Text(text = "RW") },
                        onValueChange = { textRW = it }
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Input Umur
                OutlinedTextField(
                    value = textUmur,
                    singleLine = true,
                    shape = RoundedCornerShape(size = 14.dp),
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Umur") },
                    onValueChange = { textUmur = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Pilihan Jenis Kelamin (Radio Button)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            )
                            Text(text = item)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Checkbox Persetujuan
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = checkSetuju,
                        onCheckedChange = { checkSetuju = it }
                    )
                    Text(
                        text = "Saya setuju dengan syarat dan ketentuan yang berlaku",
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Tombol Submit
                Button(
                    onClick = { showDialog = true },
                    enabled = checkSetuju, // Tombol hanya aktif jika Checkbox dicentang
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text("Submit")
                }
            }
        }


        // 1. DatePickerDialog
        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDatePicker = false
                            // Ambil tanggal yang dipilih (jika ada) dan format
                            datePickerState.selectedDateMillis?.let { millis ->
                                textTanggal = convertMillisToDate(millis)
                            }
                        }
                    ) { Text("Pilih") }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }) { Text("Batal") }
                }
            ) {
                DatePicker(state = datePickerState) // Tampilkan kalender
            }
        }

        // 2. AlertDialog untuk hasil submit
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Berhasil") },
                text = {
                    // Tampilkan semua data yang di-input
                    Column {
                        Text("Nama : $textNama")
                        Text("Kota Asal : $textKota")
                        Text("Tanggal Lahir : $textTanggal")
                        Text("RT : $textRT")
                        Text("RW : $textRW")
                        Text("Umur : $textUmur")
                        Text("Jenis Kelamin : $textJK")
                    }
                },
                confirmButton = {
                    Button(onClick = { showDialog = false }) { Text("OK") }
                }
            )
        }
    }
}