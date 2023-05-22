import java.io.File
import java.nio.charset.Charset

    fun main() {
        val text = File("text.txt").readText()
        val sentences = splitIntoSentences(text)
        val wordsPerSentence = sentences.map { countWords(it) }

        println("Количество предложений: ${sentences.size}")
        println("Количество слов в каждом предложении: $wordsPerSentence")

        writeToFile(sentences, wordsPerSentence)
    }

    fun splitIntoSentences(text: String): List<String> {
        return text.split(".", "!", "?")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
    }

    fun countWords(sentence: String): Int {
        return sentence.split(" ")
            .filter { it.isNotEmpty() }
            .count()
    }

    fun writeToFile(sentences: List<String>, wordsPerSentence: List<Int>) {
        val resultFile = File("result.txt")
        resultFile.writeText("Количество предложений: ${sentences.size} \n", Charset.defaultCharset())
        resultFile.appendText("Количество слов в каждом предложении: $wordsPerSentence")
    }
