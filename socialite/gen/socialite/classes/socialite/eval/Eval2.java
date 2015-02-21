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

public class Eval2 extends EvalParallel {
	EdgeCnt_int_int_indexby0_range0to1274502_groupby0_id2[] _edgeCnt= new EdgeCnt_int_int_indexby0_range0to1274502_groupby0_id2[sliceMap.sliceNum(2)];

	public Eval2(SRuntime _runtime, Epoch _epoch, Config _conf) {
		super(_runtime, _epoch, _conf);
		try {
			for(int $i=0; $i<sliceMap.sliceNum(2); $i++) {
			    _edgeCnt[$i]=EdgeCnt_int_int_indexby0_range0to1274502_groupby0_id2.create(sliceMap.localBeginIndex(2), sliceMap.localSize(2));
			};
			tableRegistry.setTableInstArray(2, _edgeCnt);
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
		_edgeCnt = null;

	}
}