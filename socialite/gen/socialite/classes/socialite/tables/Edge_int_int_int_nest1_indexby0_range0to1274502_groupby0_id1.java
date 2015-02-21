				 
package socialite.tables;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Arrays;
import gnu.trove.iterator.TIntObjectIterator;
import gnu.trove.iterator.TDoubleObjectIterator;
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.map.hash.TDoubleObjectHashMap;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.array.TLongArrayList;
import gnu.trove.list.array.TFloatArrayList;
import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.TIntCollection;
import gnu.trove.TDoubleCollection;
import socialite.eval.Manager;
import socialite.visitors.IntVisitor;
import socialite.visitors.ObjectVisitor;
import socialite.visitors.VisitorImpl;
import socialite.util.Assert;
import socialite.util.SociaLiteException;
import socialite.collection.SIntArrayList;
import socialite.collection.SLongArrayList;
import socialite.collection.SFloatArrayList;
import socialite.collection.SDoubleArrayList;
import socialite.collection.SIntConstArrayList;
import socialite.collection.SDoubleConstArrayList;
import socialite.collection.SArrayList;
import socialite.collection.SCollection;
import socialite.collection.SCollectionTmpl;
import socialite.collection.TupleVisitor;
import socialite.eval.TmpTablePool;
import socialite.util.concurrent.ConcurrentSoftQueue;
import socialite.util.concurrent.ConcurrentWeakQueue;
import socialite.resource.TableSliceMap;
import socialite.resource.DistTableSliceMap;
import socialite.type.*;
import socialite.util.ByteBufferPool;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.IOException;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// ArrayNestedTable
public class Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1 extends AbstractTableInst  {
	private static final long serialVersionUID = 1;

	public static int tableid() { return 1; }

	public static Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1 create() { return new Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1(0, 1274503); }
	public static Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1 create(int base, int size) { return new Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1(base, size); }
	public static Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1 create(Integer base, Integer size) { return new Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1(base.intValue(), size.intValue()); }
    static Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested updating = new Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested();

	int base;	

	socialite.util.concurrent.NonAtomicReferenceArray<Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested> nestedTables;
	boolean isEmpty = true;

	public Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1() { }
	public Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1(int _base, int size) {
		base = _base;		
;
		nestedTables = new socialite.util.concurrent.NonAtomicReferenceArray<Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested>(size);
	}


	public int size() { return -1; }
	public int id() { return 1; }
	public boolean isEmpty() { return isEmpty; }
    public String name() { return "Edge"; }

	public void clearQuick() {
		for (int i=0; i<nestedTables.length(); i++) {
			if (nestedTables.get(i)!=null) {
				nestedTables.get(i).clearQuick();
			}
		}
		isEmpty = true;
	}
	public void clear() {
		clearQuick();
	}
	public void clear(int from, int to) {
		from -= base;
		to -= base;
		for (int i=from; i<to; i++) {
			if (nestedTables.get(i)!=null) {
				nestedTables.get(i).clearQuick();
			}
		}
		isEmpty = true;
	}
	void rangeCheck(int i) {
		if (i<0 || i>=nestedTables.length()) {
			throw new SociaLiteException("Value out of range for Edge 0'th column: "+(i+base));
		}
	}

	public void iterate_range_0(int _from, int _to, VisitorImpl v) {
		if (isEmpty) return;
		int from=(int)(_from-base); rangeCheck(from);
		int to=(int)(_to-base); rangeCheck(to);
		for (int i=from; i<=to; i++) {
			if (nestedTables.get(i)!=null && !nestedTables.get(i).isEmpty()) {
				boolean cont=v.visit_0(i+base);
				if (cont) nestedTables.get(i).iterate(v);
			}
		}
	}	
	public void iterate(VisitorImpl v) {
		if (isEmpty) return;
		for (int i=0; i<nestedTables.length(); i++) {
			if (nestedTables.get(i)!=null && !nestedTables.get(i).isEmpty()) {
				boolean cont=v.visit_0(i+base);
				if (cont) nestedTables.get(i).iterate(v);
			}
		}
	}	
	public void iterate_by_0(int n, VisitorImpl v) {
		int i=(int)(n-base); rangeCheck(i);
		if (nestedTables.get(i)!=null && !nestedTables.get(i).isEmpty()) {
			boolean cont=v.visit_0(n);
			if (cont) nestedTables.get(i).iterate(v);
		}
	}

	



	public boolean contains_prefix(int n) {
		int i=(int)(n-base); rangeCheck(i);
		if (nestedTables.get(i)==null) return false;
		if (nestedTables.get(i).isEmpty()) return false;

		if (true)		
			return true;
		else return false;
	}
	public boolean contains(int n, int b1, int b2) {
		boolean contains_prefix=contains_prefix(n);
		if (!contains_prefix) return false;

		int i=(int)(n-base);
		return nestedTables.get(i).contains(b1, b2);
	}
	public boolean contains(int n, int b1, int b2, boolean[] dontcare) {
		if (dontcare[0]) {
			boolean contains=false;
			for (int i=0; i<nestedTables.length(); i++) {
				if (nestedTables.get(i)==null) continue;
				if (nestedTables.get(i).isEmpty()) continue;
				if (true)		
					contains = nestedTables.get(i).contains(b1, b2, Arrays.copyOfRange(dontcare, 1, dontcare.length));

				if (contains) return true;
			}
			return false;
		} 
		int i=(int)(n-base); rangeCheck(i);
		if (nestedTables.get(i)==null) return false;
		if (nestedTables.get(i).isEmpty()) return false;

		return nestedTables.get(i).contains(b1, b2, Arrays.copyOfRange(dontcare, 1, dontcare.length));
		
	}

	public boolean insert(int a0, int b1, int b2) {
		
		int i=(int)(a0-base); rangeCheck(i);
		if (nestedTables.get(i)!=null && !nestedTables.get(i).isEmpty()) {
			if (!contains_prefix(a0)) { 
				String msg = "Cannot insert the tuple {"+a0 +", ...} to Edge\n";
	 			msg += "Edge already contains {"+a0 +", ...} with the same 1st (array index) column\n";
	 			msg += "To insert the tuple, add the columns to the nested columns.\n";
	 			throw new SociaLiteException(msg);
	 		}
		}
		// inserting the values
	

		// insert into the nested table
		if (nestedTables.get(i)==null) nestedTables.set(i, Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested.create());
		if (isEmpty) isEmpty = false;
		nestedTables.get(i).insert(b1, b2);
		return true;
	}
	/*
	public void insertAtomic(Iterator<Tuple> iterator) {
        Tuple_int_int_int tuple;
	    while (iterator.hasNext()) {
	        tuple = (Tuple_int_int_int)iterator.next();
            insertAtomic((int)tuple._0,(int)tuple._1,(int)tuple._2);
	    }
	}
    public boolean insertAtomic(int a0, int b1, int b2) {
        int i=(int)(a0-base); rangeCheck(i);
        Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested nested;

        if (isEmpty) isEmpty = false;
        while (true) {
            nested = nestedTables.get(i);
            if (nested == null || nested.isEmpty()) {
                if (nested == updating)
                    continue;

                boolean success = nestedTables.compareAndSet(i, nested, updating);
                if (success) {
                    if (nested==null) nested = Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested.create();
                    nested.insertAtomic(b1, b2);
                    nestedTables.compareAndSet(i, updating, nested);
                    return true;
                }
            } else {
                assert nested != updating;
                if (true) {
                    return nested.insertAtomic(b1, b2);
                } else {
                    String msg = "Cannot insert the tuple {"+a0 +", ...} to Edge\n";
	 			    msg += "Edge already contains {"+a0 +", ...} with the same 1st (array index) column\n";
	 			    msg += "To insert the tuple, add the columns to the nested columns.\n";
	 			    throw new SociaLiteException(msg);
                }
            }
        }
    }*/


	// groupby operations
 // if(gbColumns) [
	 // if(gbNestedColumns) [
	  	public int groupby(int a0
	  									   , int b0) {
			int i=(int)(a0-base); rangeCheck(i);

			if (nestedTables.get(i)==null || nestedTables.get(i).isEmpty())
				throw new SociaLiteException("Unexpected groupby operation");

			if (true) {
				return nestedTables.get(i).groupby(b0);
			} else {
				throw new SociaLiteException("Unexpected groupby operation");
			}		
		}
		public boolean contains(int a0
								, int b0) {
			int i=(int)(a0-base); rangeCheck(i);
			if (nestedTables.get(i)==null || nestedTables.get(i).isEmpty())
				return false;

			if (true)
				return nestedTables.get(i).contains(b0);
			throw new SociaLiteException("Unexpected contains(for groupby) operation");
		}
		public boolean update(int a0,int b0,int b1) {
			int i=(int)(a0-base); rangeCheck(i);

			if (nestedTables.get(i)==null) nestedTables.set(i, Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested.create());

			if (true) {
				return nestedTables.get(i).update(b0,b1);
			}
			throw new SociaLiteException("Unexpected update(for groupby) operation");
		}
	 // // ] gbNestedColumns	
 // ] if(gbColumns)
}
// dynamicTable
 final class Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested extends AbstractTableInst {
	private static final long serialVersionUID = 1;

	public static int tableid() { return 1; }
	public static Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested create() { return new Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested(); }	

	static boolean groupby = false;
	static void setGroupby() {
		if (groupby == false) { groupby = true; }
	}
	static int makePos(int nodePos, int offset) { return (nodePos << 8) | offset; }
	static int getPos(int val) { return (val >> 8); }
	static int getOffset(int val) { return (val & 0xff); }

    static final class Node$Init extends Node {
        static final int INIT_CHUNK_SIZE=4;
        Node$Init() { super(INIT_CHUNK_SIZE); }
        boolean isFull() {
        	if (len < CHUNK_SIZE) return false;
        	return super.isFull();
        }
        int insert(int a0, int a1) {
        	if (len == col0().length) {
        		expand();
        	}
        	return super.insert(a0, a1);
        }
        void expand() {
        	int size = len*2;
        	int[] _col0 = new int[size];
        	int[] _col1 = new int[size];

        	System.arraycopy(col0, 0, _col0, 0, len);
        	System.arraycopy(col1, 0, _col1, 0, len);

        	col0 = _col0;
        	col1 = _col1;
            
        }
    }
    static class Node {
	    static ConcurrentWeakQueue<Node> pool = new ConcurrentWeakQueue<Node>();
	    static Node alloc() {
	    	Node n = pool.poll();
	        if (n == null) {
	            n = new Node();
	        } else {
	            n.init();
	        }
	        return n;
	    }
	    static void free(Node n) { pool.add(n); }

        static final int CHUNK_SIZE=128;

	    Object col0;
	    Object col1;

 int len;

        Node() { this(CHUNK_SIZE); }
        Node(int capacity) {
            col0 = new int[capacity];
            col1 = new int[capacity];

        }
        void init() {
            len = 0;
        }
        public void free() { Node.free(this); }

        boolean isFull() { return len() >= col0().length; }
        int len() { return len; }

        int[] col0() { return (int[])col0; }
        int[] col1() { return (int[])col1; }


        boolean contains(int a0, int a1, boolean[] dontcare) {
            for (int i=0; i<len(); i++) {
                if (true&& (dontcare[0]||col0()[i]==(a0))&& (dontcare[1]||col1()[i]==(a1))) {
                    return true;
                }
            }
            return false;
        }
        boolean contains(int a0, int a1) {
            for (int i=0; i<len(); i++) {
                if (true&& col0()[i]==(a0)&& col1()[i]==(a1)) {
                    return true;
                }
            }
            return false;
        }
        boolean contains_at(int a0, int a1, int at, boolean[] dontcare) {
            int i = at;
            return true&& (dontcare[0]||a0==(col0()[i]))&& (dontcare[1]||a1==(col1()[i]));
        }
        boolean contains_at(int a0, int a1, int at) {
            int i = at;
            return true&& a0==(col0()[i])&& a1==(col1()[i]);
        }
        int insert(int a0, int a1) {
            int l = len();
            assert l < col0().length;
            col0()[l] = a0;
            col1()[l] = a1;

            len = l+1;
            return l;
        }
        boolean iterate(VisitorImpl v) {
            int l = len();
            for (int i=0; i<l; i++) {
                boolean cont = v.visit(col0()[i], col1()[i]);
                if (!cont) return false;
            }
            return true;
        }
        boolean iterate_at(VisitorImpl v, int pos) {
            int l = len();
            assert pos < l;
            return v.visit(col0()[pos], col1()[pos]);
        }
	}
	SArrayList<Node> nodeList;
	SPosIndex groupbyMap;

	public Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1$Nested() {
		nodeList = new SArrayList<Node>();
		nodeList.add(new Node$Init());
	}

	public int id() { return 1; }
    public int size() { assert false; return -1; }
    public String name() { return "Edge"; }

    public boolean isEmpty() { return nodeList.getQuick(0).len() == 0; }
	public String toString() {
		String str="Table Edge(id=1):";
		return str + nodeList.getQuick(0).toString();
	}
	public void clearQuick() { clear(); }
	public void clear() {
		for (int i=0; i<nodeList.size(); i++) {
			Node n = nodeList.getQuick(i);
			nodeList.setQuick(i, null);
			n.free();
		}
		nodeList.resetQuick();
		nodeList.add(new Node$Init());
		if(groupbyMap!=null) groupbyMap.clear();
	}

	public boolean contains(final int a0, final int a1) {
		for (int i=0; i<nodeList.size(); i++) {
			Node n = nodeList.getQuick(i);
		    if (n.contains(a0, a1))
		        return true;
		}
		return false;
	}
	public boolean contains(final int a0, final int a1, final boolean[] dontcare) {
		for (int i=0; i<nodeList.size(); i++) {
			Node n = nodeList.getQuick(i); 
            if (n.contains(a0, a1, dontcare))
        	    return true;
        }
		return false;
	}

	void addToIndex(int pos) {
	}
	void addToGroupbyMap(int a0,int pos) {
	    	if (groupby) { ensureGroupbyMap(); }
	    	if (groupbyMap == null) { return; }
     		groupbyMap.add(a0, pos);
	}

	public boolean insert(int a0, int a1) {
		Node last = nodeList.getQuick(nodeList.size()-1);
		int nodePos = nodeList.size()-1;
	    if (last.isFull()) {
			last = Node.alloc();
			nodeList.add(last);
			nodePos = nodeList.size()-1;
	    }
        int offset = last.insert(a0, a1);
		int pos = makePos(nodePos, offset);
        addToIndex(pos);
        addToGroupbyMap(a0, pos);
		return true;
	}
	public boolean insertAtomic(int a0, int a1) {
        synchronized(this) {
            return insert(a0, a1);
        }
    }

 //  if (gbColumns) [
    	void ensureGroupbyMap() {
    		if (groupbyMap == null) { groupbyMap = new SPosIndex(); }
    	}
        public int groupby(int a0) {
    		setGroupby();
    		ensureGroupbyMap();
        	    int pos = groupbyMap.get(a0);

    		    int nodePos = getPos(pos);
    		    Node n = nodeList.getQuick(nodePos);
    		    int offset = getOffset(pos);
    		return n.col1()[offset];
    	}
    	public boolean contains(int a0) {
    	    setGroupby();
        	ensureGroupbyMap();
    	        int pos = groupbyMap.get(a0);

    	    return pos >= 0;
    	}
    	public boolean update(int a0, int a1) {
            setGroupby();
        	ensureGroupbyMap();
                int pos = groupbyMap.get(a0);

            if (pos < 0) { return insert(a0, a1); }
    	        int nodePos = getPos(pos);
    	        Node n = nodeList.getQuick(nodePos);
    	        int offset = getOffset(pos);
    	    n.col0()[offset] = a0;
    	    n.col1()[offset] = a1;

    	    return true;
    	}

 // ] if(gbColumns)

	public void iterate(VisitorImpl v) {
		for (int i=0; i<nodeList.size(); i++) {
			Node n = nodeList.getQuick(i);
		    boolean cont = n.iterate(v);
		    if (!cont) return;
		}
	}
/**
*/
}	