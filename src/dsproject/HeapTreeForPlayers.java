/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsproject;

import java.util.Arrays;

/**
 *
 * @author slainst
 */
public class HeapTreeForPlayers {
    private Player[] player;
    private int size;
    private int capacity;

    // Constructor
    public HeapTreeForPlayers(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        player = new Player[capacity];
    }

    // Get index of parent
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    // Get index of left child
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    // Get index of right child
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Check if node has parent
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    // Check if node has left child
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    // Check if node has right child
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    // Get parent value
    private Player parent(int index) {
        return player[getParentIndex(index)];
    }

    // Get left child value
    private Player leftChild(int index) {
        return player[getLeftChildIndex(index)];
    }

    // Get right child value
    private Player rightChild(int index) {
        return player[getRightChildIndex(index)];
    }

    // Swap two elements
    private void swap(int indexOne, int indexTwo) {
        Player temp = player[indexOne];
        player[indexOne] = player[indexTwo];
        player[indexTwo] = temp;
    }

    // Ensure capacity
    private void ensureCapacity() {
        if (size == capacity) {
            player = Arrays.copyOf(player, capacity * 2);
            capacity *= 2;
        }
    }

    // Insert an element into the heap
    public void insert(Player playerr) {
      //  ensureCapacity();
        player[size] = playerr;
        size++;
        heapifyUp();
    }

    // Heapify up to maintain heap property
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index).goalScore < player[index].goalScore) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    // Remove the maximum element (root) from the heap
    public Player removeMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        Player max = player[0];
        player[0] = player[size - 1];
        size--;
        heapifyDown();
        return max;
    }

    // Heapify down to maintain heap property
    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int largerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index).goalScore > leftChild(index).goalScore) {
                largerChildIndex = getRightChildIndex(index);
            }

            if (player[index].goalScore > player[largerChildIndex].goalScore) {
                break;
            } else {
                swap(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }
}
