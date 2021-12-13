package com.example.smartdelivery.ui.main.view.activity


import android.util.Log
import com.example.smartdelivery.R
import com.example.smartdelivery.data.model.request.PackagesRequest
import com.example.smartdelivery.data.model.response.PackagesResponse
import com.example.smartdelivery.data.shared.MySharedPreferences
import com.example.smartdelivery.databinding.ActivityArriveBinding

import com.example.smartdelivery.ui.base.BaseActivity
import com.example.smartdelivery.ui.main.view.dialog.ProgressDialog
import com.example.smartdelivery.ui.main.viewmodel.PackagesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
//여기가 오류가 있어서 fail될걱같아요

class PackagesActivity :BaseActivity<ActivityArriveBinding>(R.layout.activity_arrive){ // 레이아웃이거맞나요??
    //일단 정보를 가져올수있나 확인해보려고 간단하게 했어요 요거 바인딩 자료형이 다른거 같은데 activity_arrive 를 xml로 하는거 맞죠?
    //택배 도착 조회 액티비티, 위의 빨간줄 create class하래서 버튼을 눌러놓음
    private var packagesResponse=PackagesResponse();
    private var packagesRequest=PackagesRequest();
    private val packagesViewModel:PackagesViewModel by viewModel()
    private val TAG="PackagesActivity"

    private val dialog by lazy {
        ProgressDialog(this)
    }
    //도착한 택배 정보 가져오기

    override fun init(){
        super.init()
        //아이디가 저장되어있어야하네
        //로그인이 되면 아이디가 기억이 되있나
        packagesRequest.id= MySharedPreferences.getUserId(this).toString()
            initViewModel()
    }

    //도착한 택배 서버 통신
    private fun initViewModel() {
        packagesViewModel.PackagesApiCall(packagesRequest).observe(this@PackagesActivity,
            androidx.lifecycle.Observer { resource ->
                when (resource.status) {
                    com.example.smartdelivery.util.Resource.Status.SUCCESS -> {
                        dialog.dismiss()
                        when (resource.data!!.code()) {
                            200 -> {
                                Log.d(TAG, "initViewModel: ${resource.data.body()!!}")
                                packagesResponse = resource.data.body()!!
                                /**
                                 * 여기 값들 저장하시면 될거 같아요 아 그냥 여기서 값을 저장하고 layout에 셋팅해주면 될까요?
                                 * 넹 여기 서 ui 작업해주시면되여 데이터 받아서
                                 * 그럼 아까처럼 commit하는데 아까 파일 다 포함시켜서 origin:jungha로 하면 될까요?
                                 * 아뇽 일단 jungha로 하시고 main에 넣어볼라구요 네 그럼 일단 실행해볼께요
                                 */
                                // ex packagesResponse.message
                            }
                            else -> {
                                toast(this, "에러요")
                            }
                        }
                    }
                }
            })
    }


    private  fun packagesApi(){
        if(packagesResponse.isSuccess){
            MySharedPreferences.setArriveComapanycode(this@PackagesActivity,binding.arriveCode.text.toString())
            MySharedPreferences.setArriveComapanycode(this@PackagesActivity,binding.arriveTime.text.toString())
               //그럼 위에거를 초록색 저기다가 가져다 놓을까요?

                //사진인데
//이미지도 string으로 받아야하나요?? 방법은 많은데 bytearray로 변환하는 방법도 있고 이미지가 어디서 오는데요??
            //지금 이게 택배 도착정보를 조회하는거여서 id를 주면 그 송장사진하고 택배사 시간을 가져오면됩니다
            // 그럼 string으로 저장하셔야할듯..??  glide써보셨어요?? 아니욯ㅎ 이게 서버통신하고 나서 데이터를 받는거라는거죠?
            //네 그래야해요 그런데 이거 왜 바인딩 값을 저장하는건가요,,,??ㅋㅋ 그냥 몰라서 해봤어요 ㅠㅠ 아아
//            MySharedPreferences.setArriveComapanycode(this@PackagesActivity,binding.arriveImg.text.toString())
        }
    }



}



