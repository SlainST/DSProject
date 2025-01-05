package dsproject;
import java.util.Arrays;

public class HeapTreeForTeams {
    private Team[] team;
    public int size;
    private int capacity;

    // Constructor
    public HeapTreeForTeams(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        team = new Team[capacity];
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
    private Team parent(int index) {
        return team[getParentIndex(index)];
    }

    // Get left child value
    private Team leftChild(int index) {
        return team[getLeftChildIndex(index)];
    }

    // Get right child value
    private Team rightChild(int index) {
        return team[getRightChildIndex(index)];
    }

    // Swap two elements
    private void swap(int indexOne, int indexTwo) {
        Team temp = team[indexOne];
        team[indexOne] = team[indexTwo];
        team[indexTwo] = temp;
    }

    // Ensure capacity
    private void ensureCapacity() {
        if (size == capacity) {
            team = Arrays.copyOf(team, capacity * 2);
            capacity *= 2;
        }
    }

    // Insert an element into the heap
    public void insert(Team teamm) {
        ensureCapacity();
        team[size] = teamm;
        size++;
        heapifyUp();
    }

    // Heapify up to maintain heap property
//    private void heapifyUp() {
//        int index = size - 1;
//        while (hasParent(index) && parent(index).totalPoint < team[index].totalPoint) {
//            swap(getParentIndex(index), index);
//            index = getParentIndex(index);
//        }
//    }
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index).totalPoint <= team[index].totalPoint) {
            if(parent(index).totalPoint == team[index].totalPoint){
                if (parent(index).goalDifference < team[index].goalDifference){
                    swap(getParentIndex(index), index);
                    index = getParentIndex(index);
                    }
                else{
                    break;
                }
            }
            if(parent(index).totalPoint < team[index].totalPoint){
                swap(getParentIndex(index), index);
                index = getParentIndex(index);  
            }
        }
    }

    // Remove the maximum element (root) from the heap
    public Team removeMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        Team max = team[0];
        team[0] = team[size - 1];
        size--;
        heapifyDown();
        return max;
    }

    // Heapify down to maintain heap property
//    private void heapifyDown() {
//        int index = 0;
//        while (hasLeftChild(index)) {
//            int largerChildIndex = getLeftChildIndex(index);
//            if (hasRightChild(index) && rightChild(index).totalPoint > leftChild(index).totalPoint) {
//                largerChildIndex = getRightChildIndex(index);
//            }
//
//            if (team[index].totalPoint > team[largerChildIndex].totalPoint) {
//                break;
//            } else {
//                swap(index, largerChildIndex);
//            }
//            index = largerChildIndex;
//        }
//    }
    private void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) {
        int largerChildIndex = getLeftChildIndex(index);
        
        // Determine which child has a higher totalPoint or needs tie-breaking based on goalDifference
        if (hasRightChild(index)) {
            if (rightChild(index).totalPoint > leftChild(index).totalPoint) {
                largerChildIndex = getRightChildIndex(index);
            } else if (rightChild(index).totalPoint == leftChild(index).totalPoint) {
                if (rightChild(index).goalDifference > leftChild(index).goalDifference) {
                    largerChildIndex = getRightChildIndex(index);
                }
            }
        }

        if (team[index].totalPoint < team[largerChildIndex].totalPoint) {
            swap(index, largerChildIndex);
        } else if (team[index].totalPoint == team[largerChildIndex].totalPoint) {
            if (team[index].goalDifference < team[largerChildIndex].goalDifference) {
                swap(index, largerChildIndex);
            } else {
                break;
            }
        } else {
            break;
        }
        index = largerChildIndex;
    }
}
}