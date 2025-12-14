package com.example.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.composables.DhikrCard
import com.example.compose.composables.MoodRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    username: String = "",
    onMoodSelected: (String) -> Unit = {}
) {
    val dhikrByEmotion = mapOf(
        // Original 20 emotions
        "Happy" to listOf("الحمد لله", "سبحان الله وبحمده", "لا إله إلا الله"),
        "Calm" to listOf("سبحان الله وبحمده", "سبحان الله العظيم", "اللهم اجعلني من الهادئين"),
        "Sad" to listOf(
            "اللهم إني أعوذ بك من الهم والحزن",
            "رب إني مسني الضر وأنت أرحم الراحمين",
            "أستغفر الله العظيم"
        ),
        "Anxious" to listOf(
            "أستغفر الله العظيم الذي لا إله إلا هو الحي القيوم وأتوب إليه",
            "اللهم لا سهل إلا ما جعلته سهلا وأنت تجعل الحزن إذا شئت سهلا",
            "أعوذ بكلمات الله التامات من شر ما خلق"
        ),
        "Angry" to listOf(
            "اللهم إني أعوذ بك من غضبك",
            "اللهم اجعل قلبي هادئا",
            "سبحان الله وبحمده"
        ),
        "Tired" to listOf("اللهم ربّ إني أعوذ بك من الكسل", "اللهم أعني على نشاطي", "سبحان الله"),
        "Stressed" to listOf(
            "اللهم لا سهل إلا ما جعلته سهلا",
            "اللهم اجعل لي فرجا ومخرجا",
            "أستغفر الله"
        ),
        "Lonely" to listOf(
            "اللهم اجعل لي من أمري فرجًا ومخرجًا",
            "اللهم اجمعني مع الصالحين",
            "رب اجعل لي نصيرا"
        ),
        "Guilty" to listOf(
            "رب اغفر لي وتب عليّ إنك أنت التواب الرحيم",
            "أستغفر الله وأتوب إليه",
            "اللهم تقبل توبتي"
        ),
        "Confused" to listOf(
            "اللهم أرشدني لأحسن أمري وقرّبني إلى الحق",
            "اللهم اجعل لي نورا في قلبي",
            "سبحان الله"
        ),
        "Hopeful" to listOf(
            "حسبنا الله ونعم الوكيل",
            "اللهم اجعل أموري سهلة",
            "اللهم اجعل لي خيرًا فيما أريد"
        ),
        "Fearful" to listOf(
            "أعوذ بكلمات الله التامات من شر ما خلق",
            "اللهم لا تجعل قلبي يخاف إلا منك",
            "سبحان الله وبحمده"
        ),
        "Grateful" to listOf("الحمد لله على كل حال", "اللهم اجعلني من الشاكرين", "سبحان الله"),
        "Excited" to listOf("اللهم اجعلني من الشاكرين", "الحمد لله دائما", "سبحان الله"),
        "Jealous" to listOf(
            "اللهم أعوذ بك من عين الحاسدين",
            "اللهم اجعل قلبي خاليا من الحسد",
            "سبحان الله"
        ),
        "Overwhelmed" to listOf(
            "اللهم إني أعوذ بك من الهم والحزن والعجز والكسل",
            "اللهم اجعل لي فرجا ومخرجا",
            "سبحان الله"
        ),
        "Peaceful" to listOf(
            "سبحان الله والحمد لله ولا إله إلا الله والله أكبر",
            "اللهم اجعلني من الهادئين",
            "سبحان الله"
        ),
        "Motivated" to listOf(
            "اللهم اجعلني ثابتًا على طاعتك",
            "اللهم أعني على عملي الصالح",
            "سبحان الله"
        ),
        "Regretful" to listOf(
            "رب اغفر لي ذنبي واهدني سبيلي",
            "أستغفر الله العظيم",
            "اللهم تقبل توبتي"
        ),

        // 10 additional emotions
        "Frustrated" to listOf("اللهم اجعل لي من أمري فرجًا", "سبحان الله وبحمده", "أستغفر الله"),
        "Lonely/isolated" to listOf("اللهم اجمعني مع الصالحين", "رب اجعل لي نصيرا", "سبحان الله"),
        "Overjoyed" to listOf("الحمد لله", "سبحان الله وبحمده", "لا إله إلا الله"),
        "Insecure" to listOf("اللهم اجعل قلبي مطمئنا", "أستغفر الله", "حسبنا الله ونعم الوكيل"),
        "Nostalgic" to listOf("اللهم اجعل ذكرياتي طيبة", "سبحان الله", "الحمد لله"),
        "Confident" to listOf("اللهم اجعلني قويًا على طاعتك", "سبحان الله", "الحمد لله"),
        "Embarrassed" to listOf("أستغفر الله", "اللهم اغفر لي ذنبي", "سبحان الله"),
        "Relaxed" to listOf(
            "سبحان الله والحمد لله",
            "اللهم اجعلني من الهادئين",
            "سبحان الله وبحمده"
        ),
        "Curious" to listOf("اللهم زدني علمًا نافعًا", "سبحان الله", "الحمد لله")
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
            text = "Hello, $username 👋",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(Modifier.height(6.dp))

        // Display Dhikr suggestions if mood is Sad or Anxious
        if (selectedMood == null) {
            Text(
                text = "How are you feeling today?",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(16.dp))

            // Mood selector (horizontal chips)
            MoodRow { mood ->
                selectedMood = mood
                onMoodSelected(mood)
            }

            Spacer(Modifier.height(24.dp))
        } else {
            selectedMood?.let { mood ->
                if (dhikrByEmotion.containsKey(mood)) {
                    Text(
                        text = "Recommended Dhikr for $mood:",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(Modifier.height(8.dp))
                    dhikrByEmotion[mood]?.forEach { dhikr ->
                        DhikrCard(dhikr)
                        Spacer(Modifier.height(8.dp))
                    }
                    Button(onClick = { selectedMood = null }) {
                        Text("Back to Mood List")
                    }
                    Spacer(Modifier.height(24.dp))
                }
            }
        }

    }

}
