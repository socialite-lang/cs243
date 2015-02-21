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

// dynamicNestedTable
public class Edge_int_int_nest1_indexby0_groupby0_id0 extends AbstractTableInst {
	private static final long serialVersionUID = 1;

	public static int tableid() { return 0; }
	public static Edge_int_int_nest1_indexby0_groupby0_id0 create() { return new Edge_int_int_nest1_indexby0_groupby0_id0(); }

	static boolean groupby = false;
	static void setGroupby() {
		if (groupby == false) {
			groupby = true;
			Edge_int_int_nest1_indexby0_groupby0_id0$Nested.setGroupby();
		}
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
        int insert(int a0, int b0) {
        	if (len == col0().length) {
        		expand();
        	}
        	return super.insert(a0, b0);
        }
        void expand() {
        	int size = len*2;
        	int[] _col0 = new int[size];

        	System.arraycopy(col0, 0, _col0, 0, len);

        	col0 = _col0;
            
        	Edge_int_int_nest1_indexby0_groupby0_id0$Nested[] _nested = new Edge_int_int_nest1_indexby0_groupby0_id0$Nested[size];
        	System.arraycopy(nested, 0, _nested, 0, len);
        	nested = _nested;
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

	    Edge_int_int_nest1_indexby0_groupby0_id0$Nested[] nested;
 int len;

        Node() { this(CHUNK_SIZE); }
        Node(int capacity) {
            col0 = new int[capacity];

            nested = new Edge_int_int_nest1_indexby0_groupby0_id0$Nested[capacity];
        }
        void init() {
            len = 0;
        }
        public void free() { Node.free(this); }

        boolean isFull() { return len() >= nested.length; }
        int len() { return len; }

        int[] col0() { return (int[])col0; }


        boolean contains(int a0, int b0, boolean[] dontcare) {
            for (int i=0; i<len(); i++) {
                if (true&& (dontcare[0]||col0()[i]==(a0))) {
                    return nested[i].contains(b0,
                                        Arrays.copyOfRange(dontcare, 1, dontcare.length));
                }
            }
            return false;
        }
        boolean contains(int a0, int b0) {
            for (int i=0; i<len(); i++) {
                if (true&& col0()[i]==(a0)) {
                    return nested[i].contains(b0);
                }
            }
            return false;
        }
        boolean contains_at(int a0, int b0, int at, boolean[] dontcare) {
            int len = len();
            assert len > at;
            int i = at;
            return true&& (dontcare[0]||a0==(col0()[i])) &&
                        nested[i].contains(b0,
                                    Arrays.copyOfRange(dontcare, 1, dontcare.length));
        }
        boolean contains_at(int a0, int b0, int at) {
            int len = len();
            assert len > at;
            int i = at;
            return true&& a0==(col0()[i]) &&
                        nested[i].contains(b0);
        }
        int insert(int a0, int b0) {
            int l = len();
            assert l < nested.length;
            col0()[l] = a0;

            if (nested[l] == null) { nested[l] = new Edge_int_int_nest1_indexby0_groupby0_id0$Nested(); }
            nested[l].insert(b0);
            len = l+1;
            return l;
        }
        boolean iterate(VisitorImpl v) {
            int l = len();
            for (int i=0; i<l; i++) {
                boolean cont=v.visit_0
                					(col0()[i]);
                if (cont) nested[i].iterate(v);
            }
            return true;
        }
        boolean iterate_at(VisitorImpl v, int pos) {
            int l = len();
            assert l > pos;
            boolean cont=v.visit_0
                                (col0()[pos]);
            if (cont) nested[pos].iterate(v);
            return true;
        }
	/**
        */
    }

    SArrayList<Node> nodeList;
    SPosIndex index0;

    public Edge_int_int_nest1_indexby0_groupby0_id0() {
		nodeList = new SArrayList<Node>();
		nodeList.add(new Node$Init());
        index0 = new SPosIndex();

    }

    public int id() { return 0; }
    public int size() { assert false; return -1; }
    public String name() { return "Edge"; }

    public boolean isEmpty() { return nodeList.getQuick(0).len() == 0; }
    public String toString() {
        String str="Table Edge(id=0):";
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

    }

    public boolean contains(final int a0, final int b0) {
        	final boolean[] contains = new boolean[] {false};
			index0.iterateBy(a0, new IntVisitor() {
				public boolean visit(int val) {
					int pos = getPos(val);
					int offset = getOffset(val);
        			Node n = nodeList.getQuick(pos);
        			if (n.contains_at(a0, b0, pos)) {
                        contains[0] = true;
                        return false;
                    }
                    return true;
				}
			});
			return contains[0];
    }
    public boolean contains(final int a0, final int b0, final boolean[] dontcare) {
        if (!dontcare[0]) {
        	final boolean[] contains = new boolean[] {false};
			index0.iterateBy(a0, new IntVisitor() {
				public boolean visit(int val) {
					int pos = getPos(val);
					int offset = getOffset(val);
        			Node n = nodeList.getQuick(pos);
        			if (n.contains_at(a0, b0, pos, dontcare)) {
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
            if (n.contains(a0, b0, dontcare))
                return true;
        }
        return false;
    }
    void addToIndex(int a0 ,int pos) {
        index0.add(a0, pos);

    }
	void addToGroupbyMap(int pos) {
	}

    boolean insert_with_prefix(final int a0, final int b0) {
        final boolean[] ret = new boolean[] {false};
        index0.iterateBy(a0, new IntVisitor() {
			public boolean visit(int val) {
        		int pos = getPos(val);
        		int offset = getOffset(val);
        		Node n = nodeList.getQuick(pos);
        		if (true&&(n.col0()[offset]==(a0))) {
                	n.nested[offset].insert(b0);
					ret[0] = true;
					return false;
				}
				return true;
        	}
        });
        return ret[0];
    }
    public boolean insert(final int a0, final int b0) {
        if (contains(a0,b0)) return false;
        if (!isEmpty()) {
            boolean inserted = insert_with_prefix(a0,b0);
            if (inserted) return true;
        }
        Node last = nodeList.getQuick(nodeList.size()-1);
        int nodePos = nodeList.size()-1;
        if (last.isFull()) {
        	last = Node.alloc();
	        nodeList.add(last);
	        nodePos = nodeList.size()-1;
        }
        int offset = last.insert(a0, b0);
        int pos = makePos(nodePos, offset);
        addToIndex(a0 ,pos);
        addToGroupbyMap(pos);
        return true;
    }
    public boolean insertAtomic(int a0, final int b0) {
        synchronized(this) {
            return insert(a0, b0);
        }
    }

 // ] if (gbColumns)

    public void iterate(VisitorImpl v) {
    	for (int i=0; i<nodeList.size(); i++) {
    		Node n = nodeList.getQuick(i);
            boolean cont = n.iterate(v);
            if (!cont) return;
        }
    }

    // iterate_by_[column-index] methods
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
    // iterate_part_[column-index] methods
    public void iterate_part_from_0(final int from, final boolean inclusive, final VisitorImpl v) {
          index0.iterateFrom(from,inclusive,
            new IntVisitor() {
                public boolean visit(int val) {
                	int pos = getPos(val);
                	int offset = getOffset(val);
                	Node n = nodeList.getQuick(pos);
                    return n.iterate_at(v, offset);
                }
            });
    }
    public void iterate_part_to_0(final int to, final boolean inclusive, final VisitorImpl v) {
          index0.iterateTo(to,inclusive,
            new IntVisitor() {
                public boolean visit(int val) {
                	int pos = getPos(val);
                	int offset = getOffset(val);
                	Node n = nodeList.getQuick(pos);
                    return n.iterate_at(v, offset);
                }
            });
    }
    public void iterate_part_from_to_0(final int from, final boolean fromInclusive,
                                                final int to, final boolean toInclusive, final VisitorImpl v) {
          index0.iterateFromTo(from,fromInclusive,to,toInclusive,
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
// dynamicTable
 final class Edge_int_int_nest1_indexby0_groupby0_id0$Nested extends AbstractTableInst {
	private static final long serialVersionUID = 1;

	public static int tableid() { return 0; }
	public static Edge_int_int_nest1_indexby0_groupby0_id0$Nested create() { return new Edge_int_int_nest1_indexby0_groupby0_id0$Nested(); }	

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
        int insert(int a0) {
        	if (len == col0().length) {
        		expand();
        	}
        	return super.insert(a0);
        }
        void expand() {
        	int size = len*2;
        	int[] _col0 = new int[size];

        	System.arraycopy(col0, 0, _col0, 0, len);

        	col0 = _col0;
            
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

 int len;

        Node() { this(CHUNK_SIZE); }
        Node(int capacity) {
            col0 = new int[capacity];

        }
        void init() {
            len = 0;
        }
        public void free() { Node.free(this); }

        boolean isFull() { return len() >= col0().length; }
        int len() { return len; }

        int[] col0() { return (int[])col0; }


        boolean contains(int a0, boolean[] dontcare) {
            for (int i=0; i<len(); i++) {
                if (true&& (dontcare[0]||col0()[i]==(a0))) {
                    return true;
                }
            }
            return false;
        }
        boolean contains(int a0) {
            for (int i=0; i<len(); i++) {
                if (true&& col0()[i]==(a0)) {
                    return true;
                }
            }
            return false;
        }
        boolean contains_at(int a0, int at, boolean[] dontcare) {
            int i = at;
            return true&& (dontcare[0]||a0==(col0()[i]));
        }
        boolean contains_at(int a0, int at) {
            int i = at;
            return true&& a0==(col0()[i]);
        }
        int insert(int a0) {
            int l = len();
            assert l < col0().length;
            col0()[l] = a0;

            len = l+1;
            return l;
        }
        boolean iterate(VisitorImpl v) {
            int l = len();
            for (int i=0; i<l; i++) {
                boolean cont = v.visit(col0()[i]);
                if (!cont) return false;
            }
            return true;
        }
        boolean iterate_at(VisitorImpl v, int pos) {
            int l = len();
            assert pos < l;
            return v.visit(col0()[pos]);
        }
	}
	SArrayList<Node> nodeList;
	public Edge_int_int_nest1_indexby0_groupby0_id0$Nested() {
		nodeList = new SArrayList<Node>();
		nodeList.add(new Node$Init());
	}

	public int id() { return 0; }
    public int size() { assert false; return -1; }
    public String name() { return "Edge"; }

    public boolean isEmpty() { return nodeList.getQuick(0).len() == 0; }
	public String toString() {
		String str="Table Edge(id=0):";
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
	}

	public boolean contains(final int a0) {
		for (int i=0; i<nodeList.size(); i++) {
			Node n = nodeList.getQuick(i);
		    if (n.contains(a0))
		        return true;
		}
		return false;
	}
	public boolean contains(final int a0, final boolean[] dontcare) {
		for (int i=0; i<nodeList.size(); i++) {
			Node n = nodeList.getQuick(i); 
            if (n.contains(a0, dontcare))
        	    return true;
        }
		return false;
	}

	void addToIndex(int pos) {
	}
	void addToGroupbyMap(int pos) {
	}

	public boolean insert(int a0) {
		Node last = nodeList.getQuick(nodeList.size()-1);
		int nodePos = nodeList.size()-1;
	    if (last.isFull()) {
			last = Node.alloc();
			nodeList.add(last);
			nodePos = nodeList.size()-1;
	    }
        int offset = last.insert(a0);
		int pos = makePos(nodePos, offset);
        addToIndex(pos);
        addToGroupbyMap(pos);
		return true;
	}
	public boolean insertAtomic(int a0) {
        synchronized(this) {
            return insert(a0);
        }
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