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
import socialite.tables.Edge_int_int_nest1_indexby0_groupby0_id0;


public final class VisitorEdge_0 extends VisitorImpl implements Runnable {
    private Edge_int_int_nest1_indexby0_groupby0_id0[] $headTable;
    private SRuntime $runtime;
    private final int $epochId;
    private final int $ruleId;
    private TableInstRegistry $registry;
    private TableSliceMap $sliceMap;
    private LockMap $lockMap;
    private final int $const0;
    private final int $const1;
    private int s;
    private int t;
    private int $currentPredicate;
    private int $firstTableIdx;
    private int $userlogCount;
;
    public  VisitorEdge_0(int _$epochId, int _$ruleId, Integer _$$const0, Integer _$$const1, Edge_int_int_nest1_indexby0_groupby0_id0[] $$headTable, SRuntime _$runtime, int _$firstTableIdx) {
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
          {s=(int)$const0;};
          {t=(int)$const1;};
          int $_slice_0=$sliceMap.getHashIndex(0,s);
          try {
              $lockMap.lock(0, $_slice_0);
              boolean $isUpdated=false;
              Edge_int_int_nest1_indexby0_groupby0_id0 _$$headTable=$headTable[$sliceMap.getHashIndex(0,s)];
              $isUpdated=_$$headTable.insert(s, t);
              if ($isUpdated) {
                  {;};
              };
              if ($isUpdated) {
                  {;};
              };
          } finally {
              $lockMap.unlock(0, $_slice_0);
          };
        } while (false);;
    }

    public TableInst[] getDeltaTables() {
        return null;
    }

    public String toString() {
        String str="Edge(s,t) :- s=1,t=2. epoch:"+$epochId;
        return str;
    }

}