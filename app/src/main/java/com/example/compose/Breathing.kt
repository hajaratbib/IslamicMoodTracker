package com.example.compose

enum class BreathAction {
    INHALE,
    EXHALE,
    HOLD
}

data class BreathingStep(
    val action: BreathAction,
    val durationSeconds: Int,
    val label: String
)

data class BreathingPattern(
    val name: String,
    val description: String,
    val steps: List<BreathingStep>
)

val boxBreathing = BreathingPattern(
    name = "Box Breathing",
    description = "Calm your nervous system",
    steps = listOf(
        BreathingStep(BreathAction.INHALE, 4, "Inhale"),
        BreathingStep(BreathAction.HOLD, 4, "Hold"),
        BreathingStep(BreathAction.EXHALE, 4, "Exhale"),
        BreathingStep(BreathAction.HOLD, 4, "Hold")
    )
)

val fourSevenEight = BreathingPattern(
    name = "4–7–8 Breathing",
    description = "Relax and prepare for sleep",
    steps = listOf(
        BreathingStep(BreathAction.INHALE, 4, "Inhale"),
        BreathingStep(BreathAction.HOLD, 7, "Hold"),
        BreathingStep(BreathAction.EXHALE, 8, "Exhale")
    )
)

val breathingPatterns = listOf(
    BreathingPattern(
        name = "Focus Breathing",
        description = "Best for: Work, studying",
        steps = listOf(
            BreathingStep(BreathAction.INHALE, 5, "Inhale"),
            BreathingStep(BreathAction.EXHALE, 5, "Exhale")
        )
    ),
    BreathingPattern(
        name = "Box Breathing",
        description = "Best for: Calm and grounding",
        steps = listOf(
            BreathingStep(BreathAction.INHALE, 4, "Inhale"),
            BreathingStep(BreathAction.HOLD, 4, "Hold"),
            BreathingStep(BreathAction.EXHALE, 4, "Exhale"),
            BreathingStep(BreathAction.HOLD, 4, "Hold")
        )
    ),
    BreathingPattern(
        name = "4–7–8 Breathing",
        description = "Best for: Relaxation and sleep",
        steps = listOf(
            BreathingStep(BreathAction.INHALE, 4, "Inhale"),
            BreathingStep(BreathAction.HOLD, 7, "Hold"),
            BreathingStep(BreathAction.EXHALE, 8, "Exhale")
        )
    )
)