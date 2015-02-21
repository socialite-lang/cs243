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

public class Eval6 extends EvalParallel {
	TopRankers_int_double_indexby0_groupby0_id7[] _topRankers= new TopRankers_int_double_indexby0_groupby0_id7[sliceMap.sliceNum(7)];

	public Eval6(SRuntime _runtime, Epoch _epoch, Config _conf) {
		super(_runtime, _epoch, _conf);
		try {
			for(int $i=0; $i<sliceMap.sliceNum(7); $i++) {
			    _topRankers[$i]=TopRankers_int_double_indexby0_groupby0_id7.create();
			};
			tableRegistry.setTableInstArray(7, _topRankers);
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
		_topRankers = null;

	}
}