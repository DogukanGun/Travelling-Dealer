package com.dag.travelling_dealer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dag.travelling_dealer.databinding.ActivityMainBinding
import kotlinversion.Node

class MainActivity : AppCompatActivity() {

    private var headNode: Node? = null
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        headNode = Node(NodeData(3,7))
        headNode?.path = 0.0
        addCustomerToList()

        sumOfNodes()
        headNode?.deleteNode(NodeData(1,10))
        headNode?.deleteNode(NodeData(1,4))
        headNode?.deleteNode(NodeData(2,1))
        headNode?.deleteNode(NodeData(5,2))
        headNode?.deleteNode(NodeData(6,5))
        headNode?.deleteNode(NodeData(8,4))
        headNode?.deleteNode(NodeData(8,9))
        headNode?.deleteNode(NodeData(9,2))
        headNode?.deleteNode(NodeData(3,7))

    }

    @SuppressLint("SetTextI18n")
    private fun sumOfNodes() {
        val sumOfNodes = headNode?.sumOfNodes()
        val stringSumOfNodes = String.format("%.5f", sumOfNodes)
        val stringTotalDistance = String.format("%.5f", sumOfNodes?.times(2))
        binding.textView.text = "$stringSumOfNodes - $stringTotalDistance"

    }
    private fun addCustomerToList() {

        headNode?.appendToEnd(NodeData(1,10))

        headNode?.appendToEnd(NodeData(1,4))

        headNode?.appendToEnd(NodeData(2,1))

        headNode?.appendToEnd(NodeData(5,2))

        headNode?.appendToEnd(NodeData(6,5))

        headNode?.appendToEnd(NodeData(8,4))

        headNode?.appendToEnd(NodeData(8,9))

        headNode?.appendToEnd(NodeData(9,2))
    }

}