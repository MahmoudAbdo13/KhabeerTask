package com.mahomud.khabeertask.ui.fragments

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.mahomud.khabeertask.databinding.FragmentHomeBinding
import com.mahomud.khabeertask.ui.UserViewModel
import kotlinx.coroutines.launch
import java.util.*

class HomeFragment : Fragment() {

    private val args: HomeFragmentArgs by navArgs()
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        lifecycleScope.launch {
            viewModel.getpayroll(args.token).observe(viewLifecycleOwner){
                var salary:Double = (it.Payroll.Allowences[0].SAL_VALUE + it.Payroll.Allowences[1].SAL_VALUE) - it.Payroll.Deduction[0].SAL_VALUE

                val salaryTxt = "%,.2f".format(Locale.ENGLISH, salary)

                binding.itemDoctorCircle.max = 100

                val totalSalary = ((it.Payroll.Allowences[0].SAL_VALUE + it.Payroll.Allowences[1].SAL_VALUE)/it.Payroll.Deduction[0].SAL_VALUE) * 100
                Log.e("TAG", "onViewCreated: $totalSalary")
                binding.itemDoctorCircle.progress= totalSalary.toInt()
                binding.itemDoctorName.text = it.Payroll.Employee[0].EMP_DATA_AR
                binding.itemDoctorSpecialization.text = it.Payroll.Employee[0].JOBNAME_AR
                binding.itemDoctorDate.text = it.Payroll.Date
                binding.itemDoctorWorth.text = "${(it.Payroll.Allowences[0].SAL_VALUE + it.Payroll.Allowences[1].SAL_VALUE)} ج"
                binding.itemDoctorCut.text = "${it.Payroll.Deduction[0].SAL_VALUE} ج"
                binding.itemDoctorSalary.text = "$salaryTxt ج"
                binding.itemDoctorTotalSalaryData.text = "$salaryTxt ج"
                binding.salary.text = "${it.Payroll.Allowences[0].SAL_VALUE} ج"
                binding.cut.text = "${it.Payroll.Deduction[0].SAL_VALUE} ج"
                binding.work.text = "${it.Payroll.Allowences[1].SAL_VALUE} ج"
                binding.cut.paintFlags = binding.cut.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
        }


        
        
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}