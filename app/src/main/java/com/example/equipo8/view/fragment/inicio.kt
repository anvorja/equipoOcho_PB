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
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var spinningMediaPlayer: MediaPlayer
    private var url = "https://play.google.com/store/apps/details?id=com.nequi.MobileApp&hl=es_419&gl=es"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater)
        return binding.root
    }


}
