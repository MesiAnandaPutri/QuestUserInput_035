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

