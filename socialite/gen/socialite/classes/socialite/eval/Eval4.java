package socialite.eval;

import java.lang.reflect.Constructor;
import java.util.List;

import socialite.engine.Config;
import socialite.codegen.RuleComp;
import socialite.codegen.Epoch;

import socialite.parser.Rule;
import socialite.tables.*;
import socialite.resource.*;
import socialite.util.Assert;
import socialite.util.SociaLiteException;

import socialite.eval.Manager;

public class Eval4 extends EvalParallel {
	Rank$0_int_double_indexby0_range0to1274502_groupby0_id4[] _rank$0= new Rank$0_int_double_indexby0_range0to1274502_groupby0_id4[sliceMap.sliceNum(4)];
	Rank$1_int_double_indexby0_range0to1274502_groupby0_id5[] _rank$1= new Rank$1_int_double_indexby0_range0to1274502_groupby0_id5[sliceMap.sliceNum(5)];

	public Eval4(SRuntime _runtime, Epoch _epoch, Config _conf) {
		super(_runtime, _epoch, _conf);
		try {
			for(int $i=0; $i<sliceMap.sliceNum(4); $i++) {
			    _rank$0[$i]=Rank$0_int_double_indexby0_range0to1274502_groupby0_id4.create(sliceMap.localBeginIndex(4), sliceMap.localSize(4));
			};
			for(int $i=0; $i<sliceMap.sliceNum(5); $i++) {
			    _rank$1[$i]=Rank$1_int_double_indexby0_range0to1274502_groupby0_id5.create(sliceMap.localBeginIndex(5), sliceMap.localSize(5));
			};
			tableRegistry.setTableInstArray(4, _rank$0);
			tableRegistry.setTableInstArray(5, _rank$1);
;
		} catch (Throwable t) {
			EvalParallel.L.fatal("Exception while table instantiation:"+t.getMessage());
			throw new SociaLiteException(t.getMessage());
		}
	}

	public void init() {
		super.init();

;		
	}

	//public void run() { super.run(); }	
	public void finish() { 
		super.finish();
		_rank$0 = null;
		_rank$1 = null;

	}
}