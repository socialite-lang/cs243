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

// dynamicTable
public final class Path_int_int_indexby0_groupby0_id1 extends AbstractTableInst {
	private static final long serialVersionUID = 1;

	public static int tableid() { return 1; }
	public static Path_int_int_indexby0_groupby0_id1 create() { return new Path_int_int_indexby0_groupby0_id1(); }	

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
	SPosIndex index0;

	SPosIndex groupbyMap;

	public Path_int_int_indexby0_groupby0_id1() {
		nodeList = new SArrayList<Node>();
		nodeList.add(new Node$Init());
		index0 = new SPosIndex();

			groupbyMap = index0;
	}

	public int id() { return 1; }
    public int size() { assert false; return -1; }
    public String name() { return "Path"; }

    public boolean isEmpty() { return nodeList.getQuick(0).len() == 0; }
	public String toString() {
		String str="Table Path(id=1):";
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
		index0.clear();

		if(groupbyMap!=null) groupbyMap.clear();
	}

	public boolean contains(final int a0, final int a1) {
			final boolean[] contains = new boolean[] {false};
			index0.iterateBy(a0, new IntVisitor() {
				public boolean visit(int val) {
					int pos = getPos(val);
		            int offset = getOffset(val);
		            Node n = nodeList.getQuick(pos);
		            if (n.contains_at(a0, a1, offset)) {
		                contains[0] = true;
		                return false;
		            }
		            return true;
				}
			});
			return contains[0];
	}
	public boolean contains(final int a0, final int a1, final boolean[] dontcare) {
		if (!dontcare[0]) {
			final boolean[] contains = new boolean[] {false};
			index0.iterateBy(a0, new IntVisitor() {
				public boolean visit(int val) {
					int pos = getPos(val);
		            int offset = getOffset(val);
		            Node n = nodeList.getQuick(pos);
		            if (n.contains_at(a0, a1, offset, dontcare)) {
		                contains[0] = true;
		                return false;
		            }
		            return true;
				}
			});
			return contains[0];
		}
		for (int i=0; i<nodeList.size(); i++) {
			Node n = nodeList.getQuick(i); 
            if (n.contains(a0, a1, dontcare))
        	    return true;
        }
		return false;
	}

	void addToIndex(int a0 ,int pos) {
	    index0.add(a0, pos);

	}
	void addToGroupbyMap(int a0,int pos) {
	    	if (groupby) { ensureGroupbyMap(); }
	    	if (groupbyMap == null) { return; }
     		assert groupbyMap == index0;
	}

	public boolean insert(int a0, int a1) {
		if (contains(a0,a1)) return false;
		Node last = nodeList.getQuick(nodeList.size()-1);
		int nodePos = nodeList.size()-1;
	    if (last.isFull()) {
			last = Node.alloc();
			nodeList.add(last);
			nodePos = nodeList.size()-1;
	    }
        int offset = last.insert(a0, a1);
		int pos = makePos(nodePos, offset);
        addToIndex(a0 ,pos);
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
	public void iterate_by_0(int a, final VisitorImpl v) {
		index0.iterateBy(a, new IntVisitor() {
			public boolean visit(int val) {
	        	int pos = getPos(val);
	            int offset = getOffset(val);
	            Node n = nodeList.getQuick(pos);
		        return n.iterate_at(v, offset);
		    }
		});
	}

/**
	public void iterate_part_from_0(int from, boolean inclusive, final VisitorImpl v) {
        index0.iterateFrom(from, inclusive,
            new IntVisitor() {
                public boolean visit(int val) {
                    int pos = getPos(val);
	            	int offset = getOffset(val);
	            	Node n = nodeList.getQuick(pos);
		        	return n.iterate_at(v, offset);
                }
            });
	}
	public void iterate_part_to_0(int to, boolean inclusive, final VisitorImpl v) {
        index0.iterateTo(to, inclusive,
            new IntVisitor() {
                public boolean visit(int val) {
                	int pos = getPos(val);
	            	int offset = getOffset(val);
	            	Node n = nodeList.getQuick(pos);
		        	return n.iterate_at(v, offset);
                }
            });
    }
    public void iterate_part_from_to_0(int from, boolean fromInclusive, int to, boolean toInclusive, final VisitorImpl v) {
        index0.iterateFromTo(from, fromInclusive, to, toInclusive,
            new IntVisitor() {
                public boolean visit(int val) {
                	int pos = getPos(val);
	            	int offset = getOffset(val);
	            	Node n = nodeList.getQuick(pos);
		        	return n.iterate_at(v, offset);
                }
            });
    }

*/
}