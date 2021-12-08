package com.example.smartdelivery.ui.main.view.fragment

import android.util.Log
import android.widget.ArrayAdapter
import com.example.codingassignment.ui.base.BaseFragment
import com.example.smartdelivery.R
import com.example.smartdelivery.data.model.response.Company
import com.example.smartdelivery.data.model.response.CompanyList
import com.example.smartdelivery.data.model.response.TrackingResponse
import com.example.smartdelivery.databinding.FragmentAddBinding
import com.example.smartdelivery.ui.main.view.dialog.ProgressDialog
import com.example.smartdelivery.ui.main.viewmodel.MainViewModel
import com.example.smartdelivery.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

class AddFragment : BaseFragment<FragmentAddBinding>(R.layout.fragment_add) {

    private val mainViewModel: MainViewModel by sharedViewModel()
    private val progressDialog: ProgressDialog by lazy { ProgressDialog(requireContext()) }
    private lateinit var companyList: CompanyList
    private lateinit var invoiceResult: TrackingResponse
    private val TAG = "AddFragment"
    override fun init() {
        super.init()
        mainViewModel.requestCompanyList()
        companyObserver()
        invoiceObserver()
        inqueryInvoice()
    }

    private fun invoiceObserver() {
        mainViewModel.invoice.observe(viewLifecycleOwner, androidx.lifecycle.Observer { resource ->
            when(resource.status) {
                Resource.Status.SUCCESS -> {
                    progressDialog.dismiss()
                    when(resource.data!!.code()) {
                        200 -> {
                            invoiceResult = resource.data.body()!!
                            Log.d(TAG, "invoiceObserver: ${invoiceResult.toString()}")
                        }
                        else -> {
                            toast(requireContext(), "${resource.data.code()} ${resource.message}")
                        }
                    }
                }
                Resource.Status.LOADING -> {
                    progressDialog.show()

                }
                Resource.Status.ERROR -> {
                    toast(requireContext(), "${resource.message}")
                    Log.d(TAG, "requestCompanyList: ${resource.message}")
                    progressDialog.dismiss()
                }
            }
        })
    }
    private fun companyObserver() {
        mainViewModel.companyList.observe(viewLifecycleOwner, androidx.lifecycle.Observer { resource ->
            when(resource.status) {
                Resource.Status.SUCCESS -> {
                    progressDialog.dismiss()
                    when(resource.data!!.code()) {
                        200 -> {
                            companyList = resource.data.body()!!
                            val spinnerAdapter = ArrayAdapter<Company>(requireContext(), android.R.layout.simple_spinner_item, companyList.companies)
                            binding.spinner.adapter = spinnerAdapter
                        }
                        else -> {
                            toast(requireContext(), "${resource.data.code()} ${resource.message}")
                        }
                    }
                }
                Resource.Status.LOADING -> {
                    progressDialog.show()

                }
                Resource.Status.ERROR -> {
                    toast(requireContext(), "${resource.message}")
                    Log.d(TAG, "requestCompanyList: ${resource.message}")
                    progressDialog.dismiss()
                }
            }
        })
    }

    private fun inqueryInvoice() {
        binding.btnInsert.setOnClickListener {
            mainViewModel.requestInvoice(companyList.companies[binding.spinner.selectedItemPosition].Code, binding.edtInvoice.text.toString())
        }
    }
}