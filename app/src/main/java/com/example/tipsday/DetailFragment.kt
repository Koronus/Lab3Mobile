package com.example.tipsday

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tipsday.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private var onBackClickListener: OnBackClickListener? = null

    companion object {
        private const val ARG_TIP = "tip"

        fun newInstance(tip: DataTip): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_TIP, tip)
                }
            }
        }
    }

    fun setOnBackClickListener(listener: OnBackClickListener) {
        onBackClickListener = listener

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val tip = arguments?.getParcelable<DataTip>(ARG_TIP)

        if (tip != null) {
            setupUI(tip)
        }

        setupBackButton()
    }

    private fun setupUI(tip: DataTip) = with(binding) {
        numberDetail.setText(tip.numberTipId)
        titleDetail.setText(tip.titleId)
        imageDetail.setImageResource(tip.imageId)
        fullTextDetail.setText(tip.fullTextDetailId)

    }

    private fun setupBackButton() {

        if (binding.buttonBack != null) {


            binding.buttonBack.setOnClickListener {


                if (onBackClickListener != null) {
                    onBackClickListener?.onBackClick()
                } else {
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        onBackClickListener = null
    }

    interface OnBackClickListener {
        fun onBackClick()
    }
}