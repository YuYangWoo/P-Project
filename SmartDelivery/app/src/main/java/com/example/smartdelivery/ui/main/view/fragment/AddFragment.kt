package com.example.smartdelivery.ui.main.view.fragment

import android.util.Log
import com.example.codingassignment.ui.base.BaseFragment
import com.example.smartdelivery.R
import com.example.smartdelivery.data.model.response.CompanyList
import com.example.smartdelivery.databinding.FragmentAddBinding
import com.example.smartdelivery.ui.main.view.dialog.ProgressDialog
import com.example.smartdelivery.ui.main.viewmodel.MainViewModel
import com.example.smartdelivery.util.Resource
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

class AddFragment : BaseFragment<FragmentAddBinding>(R.layout.fragment_add) {

    private val mainViewModel: MainViewModel by sharedViewModel()
    private val progressDialog: ProgressDialog by lazy { ProgressDialog(requireContext()) }
    private lateinit var companyList: CompanyList
    private val TAG = "AddFragment"
    override fun init() {
        super.init()
        requestCompanyList()
    }

    private fun requestCompanyList() {
        mainViewModel.requestCompany().observe(viewLifecycleOwner, androidx.lifecycle.Observer { resource ->
            when(resource.status) {
                Resource.Status.SUCCESS -> {
                    progressDialog.dismiss()
                    when(resource.data!!.code()) {
                        200 -> {
                            companyList = resource.data.body()!!
                            Log.d(TAG, "request:${companyList} ")

                        }
                        else -> {
                            toast(requireContext(), "${resource.message}")
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

}