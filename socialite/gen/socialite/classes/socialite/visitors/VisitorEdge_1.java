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
import socialite.tables.Edge_int_int_nest1_indexby0_range0to1274502_groupby0_id1;


public final class VisitorEdge_1 extends VisitorImpl implements Runnable {
    private Edge_int_int_nest1_indexby0_range0to1274502_groupby0_id1 $headTable;
    private SRuntime $runtime;
    private final int $epochId;
    private final int $ruleId;
    private TableInstRegistry $registry;
    private TableSliceMap $sliceMap;
    private LockMap $lockMap;
    private final java.lang.String $const0;
    private final java.lang.String $const1;
    private java.lang.String l;
    private java.lang.String s2;
    private java.lang.String s1;
    private java.lang.String _$0;
    private int s;
    private int t;
    private int $currentPredicate;
    private int $firstTableIdx;
    private int $userlogCount;
;
    public  VisitorEdge_1(int _$epochId, int _$ruleId, String _$$const0, String _$$const1, Edge_int_int_nest1_indexby0_range0to1274502_groupby0_id1 $$headTable, SRuntime _$runtime, int _$firstTableIdx) {
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
              Iterator $iter4 = Builtin.read($const0) ;
              while ($iter4.hasNext()) {
              	java.lang.String $v5 = (java.lang.String)$iter4.next();
              	l=(java.lang.String)$v5;
              	;
              	try {
              	    {Object[] $array6=(Object[])Builtin.split(l, $const1) ;
              	    s1=(java.lang.String)$array6[0];
              	    s2=(java.lang.String)$array6[1];
              	    _$0=(java.lang.String)$array6[2];};
              	    ;
              	    try {
              	        {s=Builtin.toInt(s1) ;};
              	        ;
              	        try {
              	            {t=Builtin.toInt(s2) ;};
              	            int $_slice_7=$sliceMap.getRangeIndex(1,0,s);
              	            try {
              	                $lockMap.lock(1, $_slice_7);
              	                boolean $isUpdated=false;
              	                Edge_int_int_nest1_indexby0_range0to1274502_groupby0_id1 _$$headTable=$headTable;
              	                $isUpdated=_$$headTable.insert(s, t);
              	                if ($isUpdated) {
              	                    {;};
              	                };
              	                if ($isUpdated) {
              	                    {;};
              	                };
              	            } finally {
              	                $lockMap.unlock(1, $_slice_7);
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
              	        throw new SociaLiteException("Error while invoking $Builtin.toInt("+"\""+s1+"\""+"), "+_$e+""+", "+_$e);
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
        String str="Edge(s,t) :- l=$Builtin.read(\"data/coauthor.txt\"),(s1, s2, _$0)=$Builtin.split(l, \"\t\"),s=$Builtin.toInt(s1),t=$Builtin.toInt(s2). epoch:"+$epochId;
        return str;
    }

}