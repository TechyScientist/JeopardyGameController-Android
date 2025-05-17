package com.johnnyconsole.android.jeopardygamecontroller_android.game

import java.io.Serializable

class Game: Serializable {

    companion object {
        enum class RoundID: Serializable {
            SINGLE_JEOPARDY,
            DOUBLE_JEOPARDY,
            FINAL_JEOPARDY
        }

        fun import(filename: String): Game? {
            //TODO: Write Import Code
            return null
        }
    }

    private inner class Round(val id: RoundID): Serializable {
        var categories = arrayOf("","","","","","")
        var pointValues = ArrayList<String>()
        var questions = arrayOf(
            ArrayList<String>(),
            ArrayList(),
            ArrayList(),
            ArrayList(),
            ArrayList(),
            ArrayList()
        )
        var answers = arrayOf(
            ArrayList<String>(),
            ArrayList(),
            ArrayList(),
            ArrayList(),
            ArrayList(),
            ArrayList()
        )
        var used = arrayOf(
            ArrayList<Boolean>(),
            ArrayList(),
            ArrayList(),
            ArrayList(),
            ArrayList(),
            ArrayList()
        )

        var finalCategory = ""
        var finalQuestion = ""
        var finalAnswer = ""

        init {
            if (id != RoundID.FINAL_JEOPARDY) {
                for (point in 200..1000 step 200){
                    pointValues.add(
                        if (id == RoundID.SINGLE_JEOPARDY) "$point"
                        else "${point * 2}"
                    )
                }
            }
        }

        fun setCategories(categoryList: Array<String>) {
            for(i in categories.indices){
                categories[i] = categoryList[i]
                for(j in 1..6) {
                    questions[i].add("")
                    answers[i].add("")
                }
            }
        }

        fun addQuestion(category: String, question: String, answer: String, value: String?) {
            if(id != RoundID.FINAL_JEOPARDY) {
                val categoryIndex = categories.indexOf(category)
                val pointValueIndex = pointValues.indexOf(value!!)

                questions[categoryIndex][pointValueIndex] = question
                answers[categoryIndex][pointValueIndex] = answer

            }
            else {
                finalCategory = category
                finalQuestion = question
                finalAnswer = answer
            }
        }

        fun getQuestion(category: String?, pointValue: String?): Array<String>? {
            if(id != RoundID.FINAL_JEOPARDY) {
                val categoryIndex = categories.indexOf(category!!)
                val pointValueIndex = pointValues.indexOf(pointValue!!)

                return if(!used[categoryIndex][pointValueIndex])
                    arrayOf(category, questions[categoryIndex][pointValueIndex], answers[categoryIndex][pointValueIndex])
                    else null
            }
            else return arrayOf(finalCategory, finalQuestion, finalAnswer)
        }
    }

    private var single = Round(RoundID.SINGLE_JEOPARDY)
    private var double = Round(RoundID.DOUBLE_JEOPARDY)
    private var final = Round(RoundID.FINAL_JEOPARDY)

    fun addQuestion(round: RoundID, category: String, value: String, question: String, answer: String) {
        when(round) {
            RoundID.SINGLE_JEOPARDY -> single.addQuestion(category, question, answer, value)
            RoundID.DOUBLE_JEOPARDY -> double.addQuestion(category, question, answer, value)
            else -> final.addQuestion(category, question, answer, null)
        }
    }

    fun getQuestion(round: RoundID, category: String, value: String): Array<String>? {
        return when(round) {
            RoundID.SINGLE_JEOPARDY -> single.getQuestion(category, value)
            RoundID.DOUBLE_JEOPARDY -> double.getQuestion(category, value)
            else -> final.getQuestion(null, null)
        }
    }

    fun export(filename: String) {
        //TODO: Write Export Code
    }


}