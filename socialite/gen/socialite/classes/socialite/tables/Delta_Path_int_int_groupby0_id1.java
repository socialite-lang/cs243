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

// fixedSizeTable
public final class Delta_Path_int_int_groupby0_id1 extends TmpTableInst {
	private static final long serialVersionUID = 1;

	public static int tableid() { return 2; }		

	public static Delta_Path_int_int_groupby0_id1 create() { return new Delta_Path_int_int_groupby0_id1(131072); }	
	public static Delta_Path_int_int_groupby0_id1 create(int size) { return new Delta_Path_int_int_groupby0_id1(size); }	
	public static Delta_Path_int_int_groupby0_id1 createSmall() {
		int capacity=131072/10;
		if (capacity < 1) capacity = 1; 
		return new Delta_Path_int_int_groupby0_id1(capacity); 
	}

	SIntArrayList col0;
	SIntArrayList col1;


	public Delta_Path_int_int_groupby0_id1() { this(0); }
	public Delta_Path_int_int_groupby0_id1(int size) {
		size = (int)(size/sizeEstimFactor());
		 col0=new SIntArrayList(size);
		 col1=new SIntArrayList(size);

	}

	public String name() { return "Delta_Path"; }

	public int ordinaryCapacity() { return 131072; }
	public int capacity() { return col0.capacity(); } 	
	public int size() { return col0.size(); }	
	public int vacancy() { return capacity() - size(); }
	public boolean isSmall() { return col0.size() < 131072/10; }

	public boolean isEmpty() { return col0.size()==0; }

	public int totalAllocSize() {
		int capacity = col0.capacity();
		int totalAlloc = 0;
		totalAlloc += 32+capacity*4;
		totalAlloc += 32+capacity*4;

		return totalAlloc;
	}	
	public int totalDataSize() {
		int size = col0.size();
		int totalData = 0;
		totalData += 32+size*4;
		totalData += 32+size*4;

		return (int)(totalData*sizeEstimFactor());
	}
	static float estim = 1.0f;
	public void setSharedSizeEstimFactor(float v) {
		if (v > estim) { estim = v; }
	}
	public float sharedSizeEstimFactor() {
		return estim;
	}

	public int id() { return 2; }	

	public String toString() {
		String str="Table #2:";
		int limit=col0.size();
		str += "size="+limit+" ";
		if (limit > 4) limit=4;
		for (int i=0; i<limit; i++) {
			str += ""+col0.get(i)+", "+col1.get(i)+", ";
			str += "\n";
		}
		return str;
	}

	public void clearQuick() { clear(); }
	public void clear() {
		col0.resetQuick();
		col1.resetQuick();

		assert isEmpty();
	}

	public void addAll(TmpTableInst inst) {
		// should be only used by Sender.java
		if (inst==null) return;
		Delta_Path_int_int_groupby0_id1 other = (Delta_Path_int_int_groupby0_id1)inst;
		col0.addAllFast(other.col0);
		col1.addAllFast(other.col1);
		
	}

	public boolean contains(int a0, int a1) {
		for (int i=0; i< col0.size(); i++) {
		    if (true&&(col0.get(i)==(a0))&&(col1.get(i)==(a1)))
				return true;
		}		
		return false;
	}
	public boolean contains(int a0, int a1, boolean[] dontcare) {
		for (int i=0; i< col0.size(); i++) {
		    if (true&&(dontcare[0] || col0.get(i)==(a0))&&(dontcare[1] || col1.get(i)==(a1)))
				return true;
		}		
		return false;
	}

	public boolean insert(int a0, int a1) {
        col0.add(a0);
        col1.add(a1);

		return true;
	}
	public boolean update(int a0, int a1) {
		return insert(a0, a1);
	}

	public void iterate(VisitorImpl v) {
		for (int i=0; i< col0.size(); i++) {
			boolean cont=v.visit(col0.getQuick(i),col1.getQuick(i));
			if (!cont) return;
		}
	}	
	public void iterate_range(int from, int to, VisitorImpl v) {
		if (to >= size()) to = size()-1;
		for (int i=from; i<= to; i++) {
			boolean cont=v.visit(col0.getQuick(i), col1.getQuick(i));
			if (!cont) return;
		}
	}


	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		col0.writeExternal(out);
		col1.writeExternal(out);

	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		col0.readExternal(in);
		col1.readExternal(in);

	}
}