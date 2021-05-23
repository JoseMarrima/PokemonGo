package com.example.pokemongo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.pokemongo.databinding.ActivityMainBinding
import com.example.pokemongo.model.myteam.MyTeamResponse
import com.google.android.material.tabs.TabLayout
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repo = ServiceLocator.provideTasksRepository(applicationContext)
        val disposible = CompositeDisposable()
        repo.getTeams()
        disposible.add(
            repo.getTeams()
                .subscribeOn(Schedulers.io())
                .subscribeWith(object: DisposableSingleObserver<MyTeamResponse>() {
                    override fun onSuccess(value: MyTeamResponse?) {
                        Log.d("TAG", "onSuccess: print ${value}")
                    }

                    override fun onError(e: Throwable?) {
                        Log.e("TAG", "onError print: ${e?.message}")
                    }

                })
        )
        adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        binding.apply {
            pager.adapter = adapter
            tabLayout.addTab(tabLayout.newTab().setText("Explore"))
            tabLayout.addTab(tabLayout.newTab().setText("Community"))
            tabLayout.addTab(tabLayout.newTab().setText("My Team"))
            tabLayout.addTab(tabLayout.newTab().setText("Captured"))

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    pager.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

            } )

            pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    tabLayout.selectTab(tabLayout.getTabAt(position))
                }
            })
        }


    }
}