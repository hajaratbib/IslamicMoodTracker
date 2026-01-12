package com.example.compose.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.composables.DhikrCard
import com.example.compose.composables.MoodRow

@Composable
fun HomeScreen(
    context: Context,
    username: String,
    onMoodSelected: (Int) -> Unit = {}
) {
    val dhikrByEmotion = mapOf(
        // Original 20 emotions
        R.string.happy to listOf("الحمد لله", "سبحان الله وبحمده", "لا إله إلا الله"),
        R.string.calm to listOf(
            "سبحان الله وبحمده",
            "سبحان الله العظيم",
            "اللهم اجعلني من الهادئين"
        ),
        R.string.sad to listOf(
            "اللهم إني أعوذ بك من الهم والحزن",
            "رب إني مسني الضر وأنت أرحم الراحمين",
            "أستغفر الله العظيم"
        ),
        R.string.anxious to listOf(
            "أستغفر الله العظيم الذي لا إله إلا هو الحي القيوم وأتوب إليه",
            "اللهم لا سهل إلا ما جعلته سهلا وأنت تجعل الحزن إذا شئت سهلا",
            "أعوذ بكلمات الله التامات من شر ما خلق"
        ),
        R.string.angry to listOf(
            "اللهم إني أعوذ بك من غضبك",
            "اللهم اجعل قلبي هادئا",
            "سبحان الله وبحمده"
        ),
        R.string.tired to listOf(
            "اللهم ربّ إني أعوذ بك من الكسل",
            "اللهم أعني على نشاطي",
            "سبحان الله"
        ),
        R.string.stressed to listOf(
            "اللهم لا سهل إلا ما جعلته سهلا",
            "اللهم اجعل لي فرجا ومخرجا",
            "أستغفر الله"
        ),
        R.string.lonely to listOf(
            "اللهم اجعل لي من أمري فرجًا ومخرجًا",
            "اللهم اجمعني مع الصالحين",
            "رب اجعل لي نصيرا"
        ),
        R.string.guilty to listOf(
            "رب اغفر لي وتب عليّ إنك أنت التواب الرحيم",
            "أستغفر الله وأتوب إليه",
            "اللهم تقبل توبتي"
        ),
        R.string.confused to listOf(
            "اللهم أرشدني لأحسن أمري وقرّبني إلى الحق",
            "اللهم اجعل لي نورا في قلبي",
            "سبحان الله"
        ),
        R.string.hopeful to listOf(
            "حسبنا الله ونعم الوكيل",
            "اللهم اجعل أموري سهلة",
            "اللهم اجعل لي خيرًا فيما أريد"
        ),
        R.string.fearful to listOf(
            "أعوذ بكلمات الله التامات من شر ما خلق",
            "اللهم لا تجعل قلبي يخاف إلا منك",
            "سبحان الله وبحمده"
        ),
        R.string.grateful to listOf(
            "الحمد لله على كل حال",
            "اللهم اجعلني من الشاكرين",
            "سبحان الله"
        ),
        R.string.excited to listOf("اللهم اجعلني من الشاكرين", "الحمد لله دائما", "سبحان الله"),
        R.string.jealous to listOf(
            "اللهم أعوذ بك من عين الحاسدين",
            "اللهم اجعل قلبي خاليا من الحسد",
            "سبحان الله"
        ),
        R.string.overwhelmed to listOf(
            "اللهم إني أعوذ بك من الهم والحزن والعجز والكسل",
            "اللهم اجعل لي فرجا ومخرجا",
            "سبحان الله"
        ),
        R.string.peaceful to listOf(
            "سبحان الله والحمد لله ولا إله إلا الله والله أكبر",
            "اللهم اجعلني من الهادئين",
            "سبحان الله"
        ),
        R.string.motivated to listOf(
            "اللهم اجعلني ثابتًا على طاعتك",
            "اللهم أعني على عملي الصالح",
            "سبحان الله"
        ),
        R.string.regretful to listOf(
            "رب اغفر لي ذنبي واهدني سبيلي",
            "أستغفر الله العظيم",
            "اللهم تقبل توبتي"
        ),

        R.string.frustrated to listOf(
            "اللهم اجعل لي من أمري فرجًا",
            "سبحان الله وبحمده",
            "أستغفر الله"
        ),
        R.string.overjoyed to listOf("الحمد لله", "سبحان الله وبحمده", "لا إله إلا الله"),
        R.string.insecure to listOf(
            "اللهم اجعل قلبي مطمئنا",
            "أستغفر الله",
            "حسبنا الله ونعم الوكيل"
        ),
        R.string.nostalgic to listOf("اللهم اجعل ذكرياتي طيبة", "سبحان الله", "الحمد لله"),
        R.string.confident to listOf("اللهم اجعلني قويًا على طاعتك", "سبحان الله", "الحمد لله"),
        R.string.embarrassed to listOf("أستغفر الله", "اللهم اغفر لي ذنبي", "سبحان الله"),
        R.string.relaxed to listOf(
            "سبحان الله والحمد لله",
            "اللهم اجعلني من الهادئين",
            "سبحان الله وبحمده"
        ),
        R.string.curious to listOf("اللهم زدني علمًا نافعًا", "سبحان الله", "الحمد لله")
    )
    var selectedMood by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Greeting
        Text(
            text = stringResource(R.string.hello) + "$username 👋",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(Modifier.height(6.dp))

        // Display Dhikr suggestions if mood is Sad or Anxious
        if (selectedMood == null) {
            Text(
                text = stringResource(R.string.mood_question),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(16.dp))

            // Mood selector (horizontal chips)
            MoodRow { mood ->
                selectedMood = context.getString(mood)
                onMoodSelected(mood)
            }

            Spacer(Modifier.height(24.dp))
        } else {
            selectedMood?.let { mood ->
                for (element in dhikrByEmotion) {
                    if (stringResource(element.key) == mood) {
                        Text(
                            text = stringResource(R.string.recommended),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(Modifier.height(8.dp))
                        element.value.forEach { dhikr ->
                            DhikrCard(dhikr)
                            Spacer(Modifier.height(8.dp))
                        }
                        Button(onClick = { selectedMood = null }) {
                            Text(stringResource(R.string.back_list))
                        }
                        Spacer(Modifier.height(24.dp))
                    }
                }
            }
        }

    }

}
