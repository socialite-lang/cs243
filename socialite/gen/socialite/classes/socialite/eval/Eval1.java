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

public class Eval1 extends EvalParallel {
	Edge_int_int_nest1_indexby0_range0to1274502_groupby0_id1[] _edge= new Edge_int_int_nest1_indexby0_range0to1274502_groupby0_id1[sliceMap.sliceNum(1)];

	public Eval1(SRuntime _runtime, Epoch _epoch, Config _conf) {
		super(_runtime, _epoch, _conf);
		try {
			for(int $i=0; $i<sliceMap.sliceNum(1); $i++) {
			    _edge[$i]=Edge_int_int_nest1_indexby0_range0to1274502_groupby0_id1.create(sliceMap.localBeginIndex(1), sliceMap.localSize(1));
			};
			tableRegistry.setTableInstArray(1, _edge);
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
		_edge = null;

	}
}