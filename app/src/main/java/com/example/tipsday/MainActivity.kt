package com.example.tipsday

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tipsday.databinding.ActivityMainBinding
import androidx.activity.OnBackPressedCallback

class MainActivity : AppCompatActivity(), TipAdapter.OnTipClickListener, DetailFragment.OnBackClickListener {
    lateinit var binding: ActivityMainBinding
    private val tipAdapter = TipAdapter(this)
    private val headerAdapter = HeaderAdapter()
    private lateinit var concatAdapter: ConcatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBackPressedHandler()
        init()
    }

    private fun setupBackPressedHandler() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStack()

                    binding.root.post {
                        if (supportFragmentManager.backStackEntryCount == 0) {
                            if (binding.viewSwitcher.displayedChild == 1) {
                                binding.viewSwitcher.showPrevious()
                            }
                        }
                    }
                } else {
                    finish()
                }
            }
        })
    }

    private fun init() {
        binding.apply {

            concatAdapter = ConcatAdapter()
            concatAdapter.addAdapter(headerAdapter)
            concatAdapter.addAdapter(tipAdapter)

            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = concatAdapter
        }
    }

    override fun onTipClick(tip: DataTip, position: Int) {
        val fragment = DetailFragment.newInstance(tip)
        fragment.setOnBackClickListener(this)

        if (binding.viewSwitcher.displayedChild == 0) {
            binding.viewSwitcher.showNext()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack("detail_fragment")
            .commit()
    }

    override fun onBackClick() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()

            binding.root.post {
                if (supportFragmentManager.backStackEntryCount == 0) {
                    if (binding.viewSwitcher.displayedChild == 1) {
                        binding.viewSwitcher.showPrevious()
                    }
                }
            }
        }
    }
}