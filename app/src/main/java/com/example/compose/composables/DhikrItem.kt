package com.example.compose.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R

@Composable
fun DhikrItem(
    text: String,
    remaining: Int,
    title: String? = null,
    desc: String? = null,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End // aligns children to the right
            ) {
                if (title != null ) {
                    Text(
                        text = title,
                        modifier = Modifier.padding(bottom = 10.dp),
                        fontSize = 24.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        color = colorResource(R.color.purple_500),
                        textAlign = TextAlign.Right // ensures the text starts from the right
                    )
                }

                Text(
                    text = text,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        lineHeight = 30.sp
                    ),
                    textAlign = TextAlign.Right // ensures the text starts from the right
                )

                desc?.let {
                    Text(
                        text = desc,
                        modifier = Modifier.padding(top = 10.dp),
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        color = colorResource(R.color.purple_500),
                        textAlign = TextAlign.Right // ensures the text starts from the right
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = onClick) {
                Text("$remaining")
            }
        }
    }
}


