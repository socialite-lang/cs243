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

// ArrayTable
public class Path_int_int_int_indexby0_range0to1274502_groupby0_id3 extends AbstractTableInst  {
	private static final long serialVersionUID = 1;

	public static int tableid() { return 3; }

	public static Path_int_int_int_indexby0_range0to1274502_groupby0_id3 create() { return new Path_int_int_int_indexby0_range0to1274502_groupby0_id3(0, 1274503); }
	public static Path_int_int_int_indexby0_range0to1274502_groupby0_id3 create(int base, int size) { return new Path_int_int_int_indexby0_range0to1274502_groupby0_id3(base, size); }
	public static Path_int_int_int_indexby0_range0to1274502_groupby0_id3 create(Integer base, Integer size) { return new Path_int_int_int_indexby0_range0to1274502_groupby0_id3(base.intValue(), size.intValue()); }
	int base;
	socialite.util.concurrent.NonAtomicByteArray filled;
	int col1[];
	int col2[];


 boolean isEmpty = true;

	public Path_int_int_int_indexby0_range0to1274502_groupby0_id3() { }
	public Path_int_int_int_indexby0_range0to1274502_groupby0_id3(int _base, int size) {
		base = _base;
		filled = new socialite.util.concurrent.NonAtomicByteArray(size);
		col1=new int[size];
		col2=new int[size];
;
	}

private int col1(int i) { return col1[i]; }
private int col2(int i) { return col2[i]; }


	public int size() { throw new UnsupportedOperationException(); }
	public boolean isEmpty() { return isEmpty; }
	public int id() { return 3; }
	public String name() { return "Path"; }

	public void init(int init1, int init2) {
		for (int i=0; i<filled.length(); i++) {
		    filled.set(i, (byte)1);
			col1[i]=init1;
			col2[i]=init2;
;
		}
	}

	public void clearQuick() { clear(); }

	public void clear() {
	    filled.fill((byte)0);
		isEmpty = true;
	}

	public void clear(int from, int to) {
		from -= base;
		to -= base;
	    filled.fill(from-(from%4), to+4, (byte)0);
		isEmpty = true;
	}

	public int virtualSliceNum() {
		Assert.not_supported();
		return 0; // this should not be called!	
	}

	public int totalAllocSize() {
		int totalAlloc = 8+filled.length();
		totalAlloc += 12+4*filled.length();
		totalAlloc += 12+4*filled.length();
		totalAlloc += 12+4*filled.length();

		return totalAlloc;
	}
	void rangeCheck(int i) {
		if (i<0 || i>=filled.length()) {
			throw new SociaLiteException("Value out of range for Path 0'th column: "+(i+base));
		}
	}
	public boolean contains(int a0, int a1, int a2) {
		int i=(int)(a0-base); rangeCheck(i);
		if (filled.get(i)!=1) return false;

		if (true&&(col1(i)==(a1))&&(col2(i)==(a2)))
			return true;
		return false;
	}
	public boolean contains(int a0, int a1, int a2, boolean[] dontcare) {
		if (dontcare[0]) {
			for (int i=0; i<filled.length(); i++) {
				if (filled.get(i)!=1) continue;
				if (true&&(dontcare[1] || col1(i)==(a1))&&(dontcare[2] || col2(i)==(a2)))
					return true;
			}
			return false;
		}
		int i=(int)(a0-base); rangeCheck(i);
		if (filled.get(i)!=1) return false;

		if (true&&(dontcare[1] || col1(i)==(a1))&&(dontcare[2] || col2(i)==(a2)))
			return true;
		return false;
	}

	public boolean insert(int a0, int a1, int a2) {
        int i=(int)(a0-base); rangeCheck(i);
		if (filled.get(i)==1) {
			if (contains(a0, a1, a2)) return false;

			String msg = "Cannot insert the tuple {"+a0+","+a1+","+a2 +"} to Path\n";
	 		msg += "Path already contains {"+a0+","+col1(i)+","+col2(i) +"} with the same 1st (array index) column\n";
	 		msg += "To insert the tuple, declare Path with nested columns.\n";
	 		throw new SociaLiteException(msg);
		}
		if (isEmpty) isEmpty = false;

		col1[i] = a1;
		col2[i] = a2;

		filled.unsafeSet(i, (byte)1);
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
	public boolean insertAtomic(int a0, int a1, int a2) {
		int i=(int)(a0-base); rangeCheck(i);
		if (!filled.compareAndSet(i, (byte)0, (byte)-1)) {
		    while(filled.get(i)!=1) {}
			if (filled.get(i)==1 && contains(a0, a1, a2)) return false;

			String msg = "Cannot insert the tuple {"+a0+","+a1+","+a2 +"} to Path\n";
	 		msg += "Path already contains {"+a0+","+col1(i)+","+col2(i) +"} with the same 1st (array index) column\n";
	 		msg += "To insert the tuple, declare Path with nested columns.\n";
	 		throw new SociaLiteException(msg);
		}

		if (isEmpty) isEmpty = false;

		col1[i] = a1;
		col2[i] = a2;

		filled.compareAndSet(i, (byte)-1, (byte)1);
		return true;
	}*/

	public void iterate(VisitorImpl v) {
		if (isEmpty) return;
		for (int i=0; i<filled.length(); i++) {
			if (filled.get(i)==1) {
				boolean $cont=v.visit(i+base, col1(i), col2(i));
				if (!$cont) return;
			}
		}
	}
	public void iterate_range_0(int _from, int _to, VisitorImpl v) {
		int from=(int)(_from-base); rangeCheck(from);
		int to=(int)(_to-base); rangeCheck(to);
		for (int i=from; i<=to; i++) {
			if (filled.get(i)==1) {
				boolean $cont=v.visit(i+base, col1(i), col2(i));
				if (!$cont) return;
			}
		}
	}
	public void iterate_by_0(int n, VisitorImpl v) {
		int i=(int)(n-base); rangeCheck(i);
		if (i<0||i>=filled.length()) return;
		if (filled.get(i)==1) {
			boolean $cont=v.visit(n ,col1(i),col2(i));
			if (!$cont) return;
		}
	}

	
	public int groupby(int a0) {
		int i=(int)(a0-base); rangeCheck(i);
		assert filled.get(i)==1;

		if (true) {
			return col1[i];
		} else {
			throw new SociaLiteException("Unexpected groupby operation");
		}		
	}
	public boolean contains(int a0) {
		int i=(int)(a0-base); rangeCheck(i);
		if (filled.get(i)!=1) return false;

		if (true)
			return true;
		throw new SociaLiteException("Unexpected contains(for groupby) operation");
	}
	public boolean update(int a0, int a1, int a2) {
		int i=(int)(a0-base); rangeCheck(i);
		assert filled.get(i)==1;
		col1[i] = a1;
		col2[i] = a2;
;		
		return true;
	}

}