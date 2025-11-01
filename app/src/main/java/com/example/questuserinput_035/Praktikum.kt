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

