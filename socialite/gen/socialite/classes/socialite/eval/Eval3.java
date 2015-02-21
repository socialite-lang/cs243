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

public class Eval3 extends EvalParallel {
	Node_int_indexby0_range0to1274502_groupby0_id3[] _node= new Node_int_indexby0_range0to1274502_groupby0_id3[sliceMap.sliceNum(3)];

	public Eval3(SRuntime _runtime, Epoch _epoch, Config _conf) {
		super(_runtime, _epoch, _conf);
		try {
			for(int $i=0; $i<sliceMap.sliceNum(3); $i++) {
			    _node[$i]=Node_int_indexby0_range0to1274502_groupby0_id3.create(sliceMap.localBeginIndex(3), sliceMap.localSize(3));
			};
			tableRegistry.setTableInstArray(3, _node);
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
		_node = null;

	}
}