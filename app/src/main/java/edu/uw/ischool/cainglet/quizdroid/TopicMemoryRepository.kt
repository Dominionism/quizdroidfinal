package edu.uw.ischool.cainglet.quizdroid

class TopicMemoryRepository: TopicRepository {
    private val topicList = listOf(
        Topic(
            title = "Math",
            shortDescription = "Basic Arithmetic Problems",
            longDescription = "The Math category focuses on improving basic arithmetic skills.",
            questions = mutableListOf(
                Question(
                    questionText = "2 + 2",
                    options = listOf(
                        "1", "2", "3", "4"
                    ),
                    correctOptionIndex = 3
                ),
                Question(
                    questionText = "4 + 4",
                    options = listOf(
                        "6", "7", "8", "9"
                    ),
                    correctOptionIndex = 2
                )
            )
        ),
        Topic(
            title = "Physics",
            shortDescription = "Basic Physics Problems",
            longDescription = "The Physics category focuses on improving basic physics skills.",
            questions = mutableListOf(
                Question(
                    questionText = "Why does a balloon filled with helium float?",
                    options = listOf(
                        "Because helium is much lighter than air.",
                        "Because it was decided by the universe.",
                        "Because balloons were invented by aliens.",
                        "Because air is lighter than helium."
                    ),
                    correctOptionIndex = 0
                ),
                Question(
                    questionText = "If you drop a ball, what causes it's downward acceleration?",
                    options = listOf(
                        "Gravity",
                        "Black Magic",
                        "Alien Intervention",
                        "Air"
                    ),
                    correctOptionIndex = 0
                )
            )
        ),
        Topic(
            title = "Marvel Superheroes",
            shortDescription = "Basic Hero Features",
            longDescription = "The Marvel Superheroes category focuses on hero features.",
            questions = mutableListOf(
                Question(
                    questionText = "Which superhero wields a hammer?",
                    options = listOf(
                        "Thor", "Hulk", "Spiderman", "Iron Man"
                    ),
                    correctOptionIndex = 0
                ),
                Question(
                    questionText = "Which superhero shoots webs?",
                    options = listOf(
                        "Thor", "Hulk", "Spiderman", "Iron Man"
                    ),
                    correctOptionIndex = 2
                )
            )
        )
    )

    override fun retrieveTopics(): List<Topic> {
        return topicList
    }
}