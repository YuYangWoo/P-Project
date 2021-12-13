package com.example.smartdelivery.ui.main.view.fragment

import android.util.Log
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingassignment.ui.base.BaseFragment
import com.example.smartdelivery.R
import com.example.smartdelivery.data.model.response.TrackingDetail
import com.example.smartdelivery.data.model.response.TrackingResponse
import com.example.smartdelivery.databinding.FragmentDetailBinding
import com.example.smartdelivery.ui.main.adapter.InvoiceAdapter
import com.example.smartdelivery.ui.main.view.dialog.ProgressDialog
import com.example.smartdelivery.ui.main.viewmodel.MainViewModel
import com.example.smartdelivery.util.Resource
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {
    private val args: DetailFragmentArgs by navArgs()
    private val mainViewModel: MainViewModel by sharedViewModel()
    private val progressDialog: ProgressDialog by lazy { ProgressDialog(requireContext())}
    private lateinit var invoiceResult: TrackingResponse
    private val TAG = "DetailFragment"
    private val invoiceAdapter = InvoiceAdapter()
    override fun init() {
        super.init()
        requireActivity().findViewById<TextView>(R.id.txtToolbar).text = "송장 확인"
        initInvoiceList()
    }

    private fun initInvoiceList() {
        mainViewModel.requestInvoice(args.company, args.invoice)

        mainViewModel.invoice.observe(viewLifecycleOwner, androidx.lifecycle.Observer { resource ->
            when (resource.status) {
                Resource.Status.SUCCESS -> {
                    progressDialog.dismiss()
                    when (resource.data!!.code()) {
                        200 -> {
                            invoiceResult = resource.data.body()!!
                            with(binding.recyclerView) {
                                val decoration = DividerItemDecoration(requireActivity().applicationContext, DividerItemDecoration.VERTICAL)
                                addItemDecoration(decoration)
                                adapter = invoiceAdapter.apply {
                                    data = invoiceResult.trackingDetails as ArrayList<TrackingDetail>
                                    submitList(data)
                                }
                                layoutManager = LinearLayoutManager(requireContext())
                            }
                            Log.d(TAG, "initInvoiceList: ${invoiceResult}")
                            binding.data = invoiceResult

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
}