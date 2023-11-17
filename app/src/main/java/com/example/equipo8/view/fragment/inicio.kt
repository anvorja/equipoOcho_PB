package com.example.equipo8.view.fragment

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import androidx.core.animation.doOnEnd
import androidx.navigation.fragment.findNavController
import com.example.equipo8.R
import com.example.equipo8.databinding.FragmentInicioBinding
import kotlin.random.Random


class inicio : Fragment() {
    private lateinit var binding: FragmentInicioBinding
    private lateinit var reproductor: MediaPlayer
    private lateinit var sonidoBotellaGirando: MediaPlayer
    private var rotacion = 0f
    private var animacion = false
    private var sonido = false
    private var url = "https://play.google.com/store/apps/details?id=com.nequi.MobileApp&hl=es_419&gl=es"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInicioBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        efectoParpadeoBoton()
        escuchaBotellaRotacion()
        activarMusica()
        escuhaDelToolbar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        reproductor.stop()
        reproductor.release()
    }

    private fun escuhaDelToolbar() {
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.parlante -> {

                    sonido = if(sonido){
                        item.setIcon(R.drawable.silenciar)
                        reproductor.setVolume(0.0f, 0.0f)
                        false
                    }else{
                        item.setIcon(R.drawable.sonido)
                        reproductor.setVolume(1.0f, 1.0f)
                        true

                    }
                }
                R.id.instrucciones -> {
                    findNavController().navigate(R.id.action_home2_to_instructions)
                }

                R.id.calificacion -> {
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }

                R.id.social_media -> {
                    val text = "Deberías dejar el miedo y jugar a retos con tus amigos. Visita Play Store y descarga Pico Botella\n\n$url"
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT, text)
                    startActivity(Intent.createChooser(intent, "Compartir aplicación"))
                }
                R.id.agregar_reto -> {
                    findNavController().navigate(R.id.inicioGame_a_retos)
                }

            }
            true
        }
    }


    private fun reproducirSonidoBotella() {
        sonidoBotellaGirando = MediaPlayer.create(requireView().context, R.raw.sonido_botella)
        sonidoBotellaGirando.start()    }

    private fun activarMusica() {
        reproductor = MediaPlayer.create(requireView().context, R.raw.intro_game)
        reproductor.isLooping = true
        reproductor.start()
        sonido = true
    }

    fun giroAleatorioBotella(): Int {
        return Random.nextInt(361)
    }

    private fun escuchaBotellaRotacion() {
        binding.btnPlayBotella.setOnClickListener {
            reproducirSonidoBotella()
            efectoRotacionEnBotella()
        }
    }

    private fun efectoRotacionEnBotella() {
        if (!animacion) {
            rotacion += giroAleatorioBotella()
            animacion = true
            binding.botella.animate()
                .rotation(rotacion)
                .setDuration(3000)
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {}

                    override fun onAnimationEnd(animation: Animator) {
                        animacion = false
                        iniciarConteo()
                    }

                    override fun onAnimationCancel(animation: Animator) {}

                    override fun onAnimationRepeat(animation: Animator) {}
                })
                .start()
        }
    }

    private fun iniciarConteo() {
        val animadorConteoRegresivo = ValueAnimator.ofInt(3, -1)
        animadorConteoRegresivo.duration = 4000
        animadorConteoRegresivo.interpolator = LinearInterpolator()
        animadorConteoRegresivo.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            binding.conteo.text = value.toString()
        }
        animadorConteoRegresivo.doOnEnd {
            binding.conteo.text = ""

        }
        animadorConteoRegresivo.start()
    }

    private fun efectoParpadeoBoton() {
        val establecerColor = Color.parseColor("#FFA500")
        val parpadeo = ValueAnimator.ofObject(ArgbEvaluator(), Color.TRANSPARENT, establecerColor, Color.TRANSPARENT)

        parpadeo.duration = 1000
        parpadeo.repeatMode = ValueAnimator.REVERSE
        parpadeo.repeatCount = Animation.INFINITE

        parpadeo.addUpdateListener { animation ->
            val color = animation.animatedValue as Int
            binding.btnPlayBotella.backgroundTintList = ColorStateList.valueOf(color)
        }

        parpadeo.start()
    }

}
