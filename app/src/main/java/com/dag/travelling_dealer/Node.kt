package kotlinversion

import com.dag.travelling_dealer.NodeData
import kotlin.math.pow
import kotlin.math.sqrt

class Node(var data: NodeData) {

    var path: Double? = null
    var following: Node? = null

    fun appendToEnd(data: NodeData) {

        val head = this
        val newNode = Node(data)

        val diffX = (head.data.x - data.x).toDouble().pow(2)
        val diffY = (head.data.y - data.y).toDouble().pow(2)
        newNode.path = sqrt((diffX + diffY))

        var temp: Node? = this
        while (temp!!.following != null) {
            temp = temp.following
        }
        temp.following = newNode
    }
    fun sumOfNodes(): Double {

        var sumOfNodes = 0.0

        val head = this

        var tempNode: Node? = head
        while (tempNode != null) {
            sumOfNodes += tempNode.path!!
            tempNode = tempNode.following
        }
        return sumOfNodes
    }

    fun deleteNode(data: NodeData): String {

        val head = this

        var tempNode: Node? = head
        var prevNode: Node? = null

        if (tempNode != null && tempNode.data.x == data.x && tempNode.data.y == data.y) {
            return "You can't delete the factory"
        }

        while (tempNode != null && !(tempNode.data.x == data.x && tempNode.data.y == data.y)) {
            prevNode = tempNode
            tempNode = tempNode.following
        }

        if (tempNode == null)
            return "(${data.x}, ${data.y}) is not found"

        prevNode?.following = tempNode.following
        return "(${data.x}, ${data.y}) is deleted"
    }
}