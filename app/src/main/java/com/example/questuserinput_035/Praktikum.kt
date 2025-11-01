package com.example.questuserinput_035

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

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

    var showDialog by remember { mutableStateOf(false) }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    Box(modifier = Modifier.fillMaxSize()) {
        // Gambar background
        Image(
            painter = painterResource(id = R.drawable.bg_registrasi),
            contentDescription = "Background Form",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 40.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .align(Alignment.Center)
                .background(
                    color = Color.White.copy(alpha = 0.55f),
                    shape = RoundedCornerShape(28.dp)
                )
        )

        Column(
            modifier = modifier
                .padding(horizontal = 36.dp, vertical = 50.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Form Registrasi",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 28.dp)
            )

            // OutlinedTextField 1 - Nama
            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = RoundedCornerShape(size = 14.dp),
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = {
                    textNama = it
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // OutlinedTextField 2 - Kota
            OutlinedTextField(
                value = textKota,
                singleLine = true,
                shape = RoundedCornerShape(size = 14.dp),
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Kota Asal") },
                onValueChange = {
                    textKota = it
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Row untuk tanggal, RT, RW
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = textTanggal,
                    singleLine = true,
                    shape = RoundedCornerShape(size = 14.dp),
                    modifier = Modifier.weight(weight = 1.5f),
                    label = { Text(text = "Tanggal Lahir") },
                    onValueChange = {
                        textTanggal = it
                    }
                )

                OutlinedTextField(
                    value = textRT,
                    singleLine = true,
                    shape = RoundedCornerShape(size = 14.dp),
                    modifier = Modifier.weight(weight = 0.7f),
                    label = { Text(text = "RT") },
                    onValueChange = {
                        textRT = it
                    }
                )

                OutlinedTextField(
                    value = textRW,
                    singleLine = true,
                    shape = RoundedCornerShape(size = 14.dp),
                    modifier = Modifier.weight(weight = 0.7f),
                    label = { Text(text = "RW") },
                    onValueChange = {
                        textRW = it
                    }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // OutlinedTextField 3 - Umur
            OutlinedTextField(
                value = textUmur,
                singleLine = true,
                shape = RoundedCornerShape(size = 14.dp),
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Umur") },
                onValueChange = {
                    textUmur = it
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Jenis kelamin
            Row (
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
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

