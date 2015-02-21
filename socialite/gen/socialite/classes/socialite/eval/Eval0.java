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

public class Eval0 extends EvalParallel {
	IdToName_int_String_indexby0_range0to1274502_indexby1_groupby0_id0[] _idToName= new IdToName_int_String_indexby0_range0to1274502_indexby1_groupby0_id0[sliceMap.sliceNum(0)];

	public Eval0(SRuntime _runtime, Epoch _epoch, Config _conf) {
		super(_runtime, _epoch, _conf);
		try {
			for(int $i=0; $i<sliceMap.sliceNum(0); $i++) {
			    _idToName[$i]=IdToName_int_String_indexby0_range0to1274502_indexby1_groupby0_id0.create(sliceMap.localBeginIndex(0), sliceMap.localSize(0));
			};
			tableRegistry.setTableInstArray(0, _idToName);
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
		_idToName = null;

	}
}