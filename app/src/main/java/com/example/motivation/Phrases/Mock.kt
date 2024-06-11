package com.example.motivation.Phrases

import com.example.motivation.infrastructure.MotivationConstants
import kotlin.random.Random


data class Phrase(val description:String, val categoryId:Int)

class Mock {
    private val all = MotivationConstants.FILTER.ALL
    private val smile = MotivationConstants.FILTER.SMILE
    private val brightness = MotivationConstants.FILTER.BRIGHTNESS


    private val listPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", smile),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", smile),
        Phrase("Quando está mais escuro, vemos mais estrelas!", smile),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", smile),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", smile),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", smile),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", brightness),
        Phrase("Você perde todas as chances que você não aproveita.", brightness),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", brightness),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", brightness),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", brightness),
        Phrase("Se você acredita, faz toda a diferença.", brightness),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", brightness)
    )

    fun getPhrase(value: Int):String{
        val filtered = listPhrase.filter { it. categoryId == value || value == all }
        return filtered[Random.nextInt(filtered.size)].description
    }
}