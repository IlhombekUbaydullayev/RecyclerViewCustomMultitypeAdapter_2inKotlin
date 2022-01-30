package com.example.recyclerviewcustommultitypeadapter_2inkotlin

import adapter.CustomAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.Member

class MainActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun initView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = GridLayoutManager(this,1)
    }

    private fun refreshAdapter(members : List<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView!!.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()

        for (i in 0..29) {
            if (i == 0 || i == 5 || i == 16 || i == 25) {
                members.add(Member("Ilhombek" + i, "Ubaydullayev" + i,1))
            }else if (i == 3 || i == 12 || i == 20) {
                members.add(Member("Ilhombek" + i,"Ubaydullayev" + i,2))
            }
            else {
                members.add(Member("Ilhombek" + i,"Ubaydullahyev" + i,0))
            }
        }
        return members
    }
}