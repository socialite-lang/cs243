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

public class Eval5 extends EvalParallel {
	MaxRank_int_double_indexby0_range0to0_groupby0_id6[] _maxRank= new MaxRank_int_double_indexby0_range0to0_groupby0_id6[sliceMap.sliceNum(6)];

	public Eval5(SRuntime _runtime, Epoch _epoch, Config _conf) {
		super(_runtime, _epoch, _conf);
		try {
			for(int $i=0; $i<sliceMap.sliceNum(6); $i++) {
			    _maxRank[$i]=MaxRank_int_double_indexby0_range0to0_groupby0_id6.create(sliceMap.localBeginIndex(6), sliceMap.localSize(6));
			};
			tableRegistry.setTableInstArray(6, _maxRank);
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
		_maxRank = null;

	}
}