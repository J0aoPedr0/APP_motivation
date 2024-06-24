package com.example.motivation.Phrases

import com.example.motivation.infrastructure.MotivationConstants
import kotlin.random.Random


data class Phrase(val description:String, val categoryId:Int, val lang:String)

class Mock {
    private val all = MotivationConstants.FILTER.ALL
    private val smile = MotivationConstants.FILTER.SMILE
    private val brightness = MotivationConstants.FILTER.BRIGHTNESS

    private val pt = MotivationConstants.LANGUAGE.PORTUGUESE
    private val en = MotivationConstants.LANGUAGE.ENGLISH
    private val fr = MotivationConstants.LANGUAGE.FRENCH


    private val listPhrase = listOf<Phrase>(

        //FRASES EM PORTUGUÊS

        Phrase("Não sabendo que era impossível, foi lá e fez.", smile, pt),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", smile, pt),
        Phrase("Quando está mais escuro, vemos mais estrelas!", smile, pt),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", smile, pt),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", smile, pt),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", smile, pt),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", brightness, pt),
        Phrase("Você perde todas as chances que você não aproveita.", brightness, pt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", brightness, pt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", brightness, pt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", brightness, pt),
        Phrase("Se você acredita, faz toda a diferença.", brightness, pt),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", brightness, pt),

        // FRASES EM INGLÊS

        Phrase("Not knowing it was impossible, he went there and did it.", smile, en),
        Phrase("You are not defeated when you lose, you are defeated when you give up!", smile, en),
        Phrase("When it's darker, we see more stars!", smile, en),
        Phrase("Insanity is always doing the same thing and expecting a different result.", smile, en),
        Phrase("Don't stop when you're tired, stop when you're done.", smile, en),
        Phrase("What can you do now that has the biggest impact on your success?", smile, en),
        Phrase("The best way to predict the future is to invent it.", brightness, en),
        Phrase("You lose every chance you don't take.", brightness, en),
        Phrase("Failure is the spice that flavors success.", brightness, en),
        Phrase(" As long as we are not committed, there will be hesitation!", brightness, en),
        Phrase("If you don't know where you want to go, any way will do.", brightness, en),
        Phrase("If you believe, it makes all the difference.", brightness, en),
        Phrase("Risks must be taken, because the greatest danger is not risking anything!", brightness, en),

        //FRASES EM FRANCÊS

        Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", smile, fr),
        Phrase("Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!", smile, fr),
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", smile, fr),
        Phrase("La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.", smile, fr),
        Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", smile, fr),
        Phrase("Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?", smile, fr),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", brightness, fr),
        Phrase("Vous perdez toutes les chances que vous ne prenez pas.", brightness, fr),
        Phrase("L'échec est l'épice qui parfume le succès.", brightness, fr),
        Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", brightness, fr),
        Phrase("Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.", brightness, fr),
        Phrase("Si vous croyez, cela fait toute la différence.", brightness, fr),
        Phrase("Il faut prendre des risques, car le plus grand danger est de ne rien risquer!", brightness, fr)
    )

    fun getPhrase(value: Int, lang:String):String{
        val filtered = listPhrase.filter { it. categoryId == value || value == all && it.lang == lang }
        return filtered[Random.nextInt(filtered.size)].description
    }
}