package com.HomeWork8;

import java.util.Iterator;

public class Task2 implements Iterable<Integer> {
    Integer[][] matrix;

    Task2() {
        matrix = new Integer[][]{
                {1, 5, 4, 4, 4, 4, 4, 3,},
                {1, 5, 6, 6, 6, 6, 6, 3,},
                {1, 2, 2, 2, 2, 2, 2, 3,}};
    }

    public Task2(Integer[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new spiralMatrixIterator();
    }

    public class spiralMatrixIterator implements Iterator<Integer> {
        int MaxCount = matrix.length * matrix[0].length;
        int count = 0;
        int i = 0;
        int j = 0;
        int v = 0;
        int iMax = matrix.length - 1;
        int jMax = matrix[i].length - 1;

        @Override
        public boolean hasNext() {
            if (count < MaxCount) {
                count++;
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Integer next() {
            if (i < iMax - v && j == v) {
                return matrix[i++][j];
            }
            else if (i == iMax - v && j < jMax - v) {
                return matrix[i][j++];
            }
            else if (i > v && j >= jMax - v) {
                if (i == v + 1) {
                    v++;
                }
                return matrix[i--][j];
            }
            else if (i <= v && j > v) {
                return matrix[i][j--];
            }
            else {
                return matrix[i][j];
            }
        }
    }
}
