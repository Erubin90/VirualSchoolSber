package com.HomeWork8;

import java.util.Iterator;

public class Task1 implements Iterable<Integer> {
    private int num;

    public Task1(Integer number){
        this.num = number;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new reversNumberIterator();
    }


    public class reversNumberIterator implements Iterator<Integer> {
        private int numClone = Math.abs(num);

        public boolean hasNext() {
            if (numClone > 0) {
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public Integer next() {
            int digit = numClone % 10;
            numClone /= 10;
            return digit;
        }
    }
}




