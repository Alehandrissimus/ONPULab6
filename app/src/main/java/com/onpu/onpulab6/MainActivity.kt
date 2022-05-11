package com.onpu.onpulab6

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.onpu.onpulab6.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private val ELEMENT_COUNT = 28
    private val COLUMNS_COUNT = 4

    lateinit var binding: ActivityMainBinding
    lateinit var rvAdapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupRecycleView()
    }

    private fun setupBinding() {
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupRecycleView() {
        rvAdapter = RVAdapter {
            val dialogFragment = ChooseDialog(it)
            dialogFragment.show(supportFragmentManager, "tag")
        }
        binding.container.apply {
            layoutManager = GridLayoutManager(context, COLUMNS_COUNT)
            adapter = rvAdapter
        }

        rvAdapter.submitList(setupData())
    }

    private fun setupData(): List<ItemModel> {
        val models = mutableListOf<ItemModel>()
        for (i in 1..ELEMENT_COUNT) {
            models.add(
                ItemModel(
                    number = Random.nextInt(99),
                    color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
                )
            )
        }
        return models
    }

}