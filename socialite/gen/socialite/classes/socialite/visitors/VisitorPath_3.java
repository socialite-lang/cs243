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
import socialite.tables.Path_int_int_int_indexby0_range0to1274502_groupby0_id3;


public final class VisitorPath_3 extends VisitorImpl implements Runnable {
    private Path_int_int_int_indexby0_range0to1274502_groupby0_id3 $headTable;
    private Delta_Path_int_int_int_groupby0_id3 delta$Path;
    private Delta_Path_int_int_int_groupby0_id3 ret$delta$Path;
    private SRuntime $runtime;
    private final int $epochId;
    private final int $ruleId;
    private TableInstRegistry $registry;
    private TableSliceMap $sliceMap;
    private LockMap $lockMap;
    private final int $const0;
    private final int $const1;
    private final int $const2;
    private int n;
    private int d;
    private int prev;
    private int aggr$ret;
    private int $aggrVar;
    private int $currentPredicate;
    private int $firstTableIdx;
    private int $userlogCount;
;
    public  VisitorPath_3(int _$epochId, int _$ruleId, Integer _$$const0, Integer _$$const1, Integer _$$const2, Path_int_int_int_indexby0_range0to1274502_groupby0_id3 $$headTable, SRuntime _$runtime, int _$firstTableIdx) {
        $const0=_$$const0;
        $const1=_$$const1;
        $const2=_$$const2;
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
          {n=(int)$const0;};
          {d=(int)$const1;};
          {prev=(int)$const2;};
          boolean $isUpdated=false;
          Path_int_int_int_indexby0_range0to1274502_groupby0_id3 _$$headTable=$headTable;
          if (_$$headTable.contains(n)) {
              int _$oldAns;
              _$oldAns=_$$headTable.groupby(n);
              aggr$ret=Builtin.min(_$oldAns, d) ;
              if (_$oldAns!=0 && _$oldAns==aggr$ret) continue;
          };
          int $_slice_13=$sliceMap.getRangeIndex(3,0,n);
          try {
              $lockMap.lock(3, $_slice_13);
              if (!_$$headTable.contains(n)) {
                  $aggrVar=d; ;
                  _$$headTable.insert(n, $aggrVar, prev);
                  $isUpdated=true;
              } else {
                  {int _$oldAns;
                  _$oldAns=_$$headTable.groupby(n);
                  $aggrVar=Builtin.min(_$oldAns, d) ;
                  if($aggrVar==(_$oldAns)) continue;
                  $isUpdated=_$$headTable.update(n, $aggrVar, prev);};
              };
          } finally {
              $lockMap.unlock(3, $_slice_13);
          };
          if ($isUpdated) {
              {getDeltaTable().update(n, $aggrVar, prev);};
          };
        } while (false);;
    }

    public TableInst[] getDeltaTables() {
        return new TableInst[]{ret$delta$Path};
    }

    public Delta_Path_int_int_int_groupby0_id3 getDeltaTable() {
        if (delta$Path==null) {
            delta$Path=(Delta_Path_int_int_int_groupby0_id3)TmpTablePool.getSmall(Delta_Path_int_int_int_groupby0_id3.class);
            ret$delta$Path=delta$Path.isEmpty()?delta$Path:null;
        };
        if (delta$Path.vacancy()==0) {
            delta$Path.setReuse(false);
            for(int _$pr:$runtime.getRuleMap(getRuleId()).getDeltaRules(getRuleId()).toArray()) {
                for(IVisitor _$v:$runtime.getVisitorBuilder(_$pr).getNewVisitorInst(_$pr, new TableInst[]{delta$Path})) {
                    _$v.setWorker(getWorker());
                    try { _$v.run(); } catch (SocialiteFinishEval e) {};
                };
            };
            delta$Path.setReuse(true);
            delta$Path.clear();
            TmpTablePool.free(getWorkerId(), delta$Path);
            delta$Path=(Delta_Path_int_int_int_groupby0_id3)TmpTablePool.getSmall(Delta_Path_int_int_int_groupby0_id3.class);
            ret$delta$Path=delta$Path;
        };
        return delta$Path;
    }

    public String toString() {
        String str="Path(n,$Builtin.min(d),prev) :- n=102025,d=0,prev=-1. epoch:"+$epochId;
        return str;
    }

}