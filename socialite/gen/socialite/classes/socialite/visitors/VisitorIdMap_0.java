package socialite.visitors;
/* 
 
*/
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.map.hash.TDoubleObjectHashMap;
import gnu.trove.TIntCollection;
import gnu.trove.TDoubleCollection;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.map.hash.TLongObjectHashMap;
import gnu.trove.iterator.TLongObjectIterator;

import org.apache.commons.lang3.exception.ExceptionUtils;

import socialite.collection.*;

import socialite.resource.*;
import socialite.tables.*;
import socialite.functions.Math;
import socialite.functions.*;
import socialite.visitors.*;
import java.util.Iterator;
import java.util.Collection;
import java.util.List;

import socialite.resource.RuleMap;
import socialite.eval.EvalWithTable;
import socialite.dist.msg.WorkerMessage;

import socialite.eval.TmpTablePool;
import socialite.eval.Worker;
import socialite.eval.DeltaStepWindow;

import socialite.type.*;
import socialite.util.HashCode;
import socialite.util.Assert;
import socialite.util.SociaLiteException;
import socialite.util.SocialiteFinishEval;
import socialite.util.UserLog;

import org.python.core.PyTuple;
import org.python.core.PyList;
import org.python.core.PySequenceList;
import socialite.tables.IdMap_int_String_indexby0_range0to1274502_indexby1_groupby0_id0;


public final class VisitorIdMap_0 extends VisitorImpl implements Runnable {
    private IdMap_int_String_indexby0_range0to1274502_indexby1_groupby0_id0 $headTable;
    private SRuntime $runtime;
    private final int $epochId;
    private final int $ruleId;
    private TableInstRegistry $registry;
    private TableSliceMap $sliceMap;
    private LockMap $lockMap;
    private final java.lang.String $const0;
    private final java.lang.String $const1;
    private java.lang.String l;
    private java.lang.String n;
    private java.lang.String s2;
    private int id;
    private int $currentPredicate;
    private int $firstTableIdx;
    private int $userlogCount;
;
    public  VisitorIdMap_0(int _$epochId, int _$ruleId, String _$$const0, String _$$const1, IdMap_int_String_indexby0_range0to1274502_indexby1_groupby0_id0 $$headTable, SRuntime _$runtime, int _$firstTableIdx) {
        $const0=_$$const0;
        $const1=_$$const1;
        $headTable=$$headTable;
        $epochId=_$epochId;
        $ruleId=_$ruleId;
        $runtime=_$runtime;
        $sliceMap = _$runtime.getSliceMap();
        $lockMap = _$runtime.getLockMap();
        $registry= _$runtime.getTableRegistry();
        $firstTableIdx = _$firstTableIdx;
        $currentPredicate=0;
    }

    public int getRuleId() {
        return $ruleId;
    }

    public int getEpochId() {
        return $epochId;
    }

    public void run() {
        do {
          ;
          try {
              Iterator $iter0 = Builtin.read($const0) ;
              while ($iter0.hasNext()) {
              	java.lang.String $v1 = (java.lang.String)$iter0.next();
              	l=(java.lang.String)$v1;
              	;
              	try {
              	    {Object[] $array2=(Object[])Builtin.split(l, $const1) ;
              	    n=(java.lang.String)$array2[0];
              	    s2=(java.lang.String)$array2[1];};
              	    ;
              	    try {
              	        {id=Builtin.toInt(s2) ;};
              	        int $_slice_3=$sliceMap.getRangeIndex(0,0,id);
              	        try {
              	            $lockMap.lock(0, $_slice_3);
              	            boolean $isUpdated=false;
              	            IdMap_int_String_indexby0_range0to1274502_indexby1_groupby0_id0 _$$headTable=$headTable;
              	            $isUpdated=_$$headTable.insert(id, n);
              	            if ($isUpdated) {
              	                {;};
              	            };
              	            if ($isUpdated) {
              	                {;};
              	            };
              	        } finally {
              	            $lockMap.unlock(0, $_slice_3);
              	        };
              	    } catch(Exception _$e) {
              	        if(_$e instanceof SociaLiteException) throw (SociaLiteException)_$e;
              	        VisitorImpl.L.error(ExceptionUtils.getStackTrace(_$e));
              	        throw new SociaLiteException("Error while invoking $Builtin.toInt("+"\""+s2+"\""+"), "+_$e+""+", "+_$e);
              	    } finally {
              	    ;
              	    };
              	} catch(Exception _$e) {
              	    if(_$e instanceof SociaLiteException) throw (SociaLiteException)_$e;
              	    VisitorImpl.L.error(ExceptionUtils.getStackTrace(_$e));
              	    throw new SociaLiteException("Error while invoking $Builtin.split("+"\""+l+"\""+","+"\""+$const1+"\""+"), "+_$e+""+", "+_$e);
              	} finally {
              	;
              	};
              };
          } catch(Exception _$e) {
              if(_$e instanceof SociaLiteException) throw (SociaLiteException)_$e;
              VisitorImpl.L.error(ExceptionUtils.getStackTrace(_$e));
              throw new SociaLiteException("Error while invoking $Builtin.read("+"\""+$const0+"\""+"), "+_$e+""+", "+_$e);
          } finally {
          ;
          };
        } while (false);;
    }

    public TableInst[] getDeltaTables() {
        return null;
    }

    public String toString() {
        String str="IdMap(id,n) :- l=$Builtin.read(\"data/authorId.txt\"),(n, s2)=$Builtin.split(l, \"\t\"),id=$Builtin.toInt(s2). epoch:"+$epochId;
        return str;
    }

}