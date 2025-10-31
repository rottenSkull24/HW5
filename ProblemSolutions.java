/******************************************************************
 *
 *   Jesus Ortega / 002 
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        if (list2 == null || list2.length == 0) return true; // empty set is subset of any set
        if (list1 == null || list1.length == 0) return false; // non-empty set cannot be subset of empty set

        Set<Integer> set = new HashSet<>();
        for (int v : list1) { // O(n) time complexity
            set.add(v);
        }

        for (int v : list2) {
            if (!set.contains(v)) return false; // O(1) average time complexity for contains
        } 

        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        /*if (array == null || k < 1 || k > array.length) {
            throw new IllegalArgumentException("Invalid array or k");
        }*/
        // Min-heap of size k: root is the k-th largest element after processing all elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : array) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        if (array1 == null) array1 = new int[0]; // handle null arrays
        if (array2 == null) array2 = new int[0]; // handle null arrays

        List<Integer> list = new ArrayList<>(array1.length + array2.length);
        for (int v : array1) list.add(v);
        for (int v : array2) list.add(v);

        Collections.sort(list);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }

}