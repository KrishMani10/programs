package mani.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class DataList <E> extends ArrayList<E> {


    public DataList(){}
//    private int size =0;
//
//    private static final int DEFAULT_CAPACITY =100;
//
//    private Object[] elements;
//
//
//    public DataList() {
//        elements = new Object[DEFAULT_CAPACITY];
//    }
//
//   //add method
////
//    public boolean add (E e) {
// //       return super.add(e);
//        if(size== elements.length) {
//            checkCapacity();
//        }
//        elements[size++] =e;
//        return false;
//    }
//
//   //get method
//
//    @SuppressWarnings("unchecked")
//    public E get(int i) {
////        return super.get(i);
//        if(i>=size || i<0) {
//            throw new IndexOutOfBoundsException("Index : "  +i+ ", size : " +i);
//        }
//        return (E) elements [i];
//    }
//
//
//    //remove method
//
//    @SuppressWarnings("unchecked")
//    public E remove(int i) {
//       // return  super.remove(i);
//        if(i>=size || i<0) {
//            throw new IndexOutOfBoundsException("Index : " +i+ " , size : " +i);
//        }
//        Object item = elements[i];
//        int numberElements = elements.length - (i+1);
//        System.arraycopy(elements,i+1,elements,i,numberElements);
//        size--;
//        return (E) item;
//    }
//
//    //get size of list
//
//    public int size(){
//    //    return super.size();
//       return size;
//    }
//
//    //print method
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append('[');
//        for(int i=0;i<size;i++){
//            sb.append(elements[i].toString());
//            if(i<size-1){
//                sb.append(",");
//            }
//        }
//        sb.append("]");
//        return sb.toString();
//    }
//
//    private void checkCapacity() {
//        int newSize = elements.length*2;
//        elements = Arrays.copyOf(elements,newSize);
//    }
//
//

}
