package collections.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public class SortedHashSetDemo {
    public static void main(String[] args){
        SortedSet s = new SortedSet() {
            @Override
            public Comparator comparator() {
                return null;
            }

            @Override
            public SortedSet subSet(Object o, Object e1) {
                return null;
            }

            @Override
            public SortedSet headSet(Object o) {
                return null;
            }

            @Override
            public SortedSet tailSet(Object o) {
                return null;
            }

            @Override
            public Object first() {
                return null;
            }

            @Override
            public Object last() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] objects) {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection collection) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
    }
}