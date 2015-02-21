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
import socialite.tables.Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1;
import socialite.tables.Path_int_int_int_indexby0_range0to1274502_groupby0_id3;


public final class VisitorPath_4 extends VisitorImpl implements Runnable {
    private Path_int_int_int_indexby0_range0to1274502_groupby0_id3 $_path0;
    private Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1 $_edge1;
    private Path_int_int_int_indexby0_range0to1274502_groupby0_id3 $headTable;
    private Delta_Path_int_int_int_groupby0_id3 delta$Path;
    private Delta_Path_int_int_int_groupby0_id3 ret$delta$Path;
    private SRuntime $runtime;
    private final int $epochId;
    private final int $ruleId;
    private TableInstRegistry $registry;
    private TableSliceMap $sliceMap;
    private LockMap $lockMap;
    private final int $const3;
    private int s;
    private int d1;
    private int prev1;
    private int n;
    private int _$0;
    private int d;
    private int prev;
    private int aggr$ret;
    private int $aggrVar;
    private int $currentPredicate;
    private int $firstTableIdx;
    private int $userlogCount;
;
    public  VisitorPath_4(int _$epochId, int _$ruleId, Integer _$$const3, Path_int_int_int_indexby0_range0to1274502_groupby0_id3 _$$_path0, Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1 _$$_edge1, Path_int_int_int_indexby0_range0to1274502_groupby0_id3 $$headTable, SRuntime _$runtime, int _$firstTableIdx) {
        $const3=_$$const3;
        $_path0 = _$$_path0;
        $_edge1 = _$$_edge1;
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
          $currentPredicate=0;
          $_path0.iterate_range_0($sliceMap.getRange(3,0,$firstTableIdx)[0],$sliceMap.getRange(3,0,$firstTableIdx)[1],this);
        } while (false);;
    }

    public boolean visit(int _0, int _1, int _2) {
        do {
          switch ($currentPredicate) {
              case 0: 
              {s=(int)_0;
              d1=(int)_1;
              prev1=(int)_2;
              $currentPredicate=1;
              $_edge1.iterate_by_0(s, this);
              $currentPredicate=0;
              ;
              break;
              }

          };
        } while (false);;
        return true;
    }

    public boolean visit_0(int _0) {
        do {
          switch ($currentPredicate) {
              case 1: 
              {if (s!=_0) {
                  break;
              };
              ;
              break;
              }

          };
        } while (false);;
        return true;
    }

    public boolean visit(int _0, int _1) {
        do {
          switch ($currentPredicate) {
              case 1: 
              {n=(int)_0;
              {d=(int)(d1+$const3) ;};
              {prev=(int)s;};
              boolean $isUpdated=false;
              Path_int_int_int_indexby0_range0to1274502_groupby0_id3 _$$headTable=$headTable;
              if (_$$headTable.contains(n)) {
                  int _$oldAns;
                  _$oldAns=_$$headTable.groupby(n);
                  aggr$ret=Builtin.min(_$oldAns, d) ;
                  if (_$oldAns!=0 && _$oldAns==aggr$ret) continue;
              };
              int $_slice_12=$sliceMap.getRangeIndex(3,0,n);
              try {
                  $lockMap.lock(3, $_slice_12);
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
                  $lockMap.unlock(3, $_slice_12);
              };
              if ($isUpdated) {
                  {getDeltaTable().update(n, $aggrVar, prev);};
              };
              ;
              break;
              }

          };
        } while (false);;
        return true;
    }

    public TableInst[] getDeltaTables() {
        return new TableInst[]{ret$delta$Path};
    }

    public Delta_Path_int_int_int_groupby0_id3 getDeltaTable() {
        if (delta$Path==null) {
            delta$Path=(Delta_Path_int_int_int_groupby0_id3)TmpTablePool.get(getWorkerId(),Delta_Path_int_int_int_groupby0_id3.class,0);
            ret$delta$Path=delta$Path.isEmpty()?delta$Path:null;
        };
        if (delta$Path.vacancy()==0) {
            if(ret$delta$Path!=null) getWorker().addTasksForDelta(getRuleId(),delta$Path, 0);
            delta$Path=(Delta_Path_int_int_int_groupby0_id3)TmpTablePool.get(getWorkerId(),Delta_Path_int_int_int_groupby0_id3.class,0);
            ret$delta$Path=delta$Path.isEmpty()?delta$Path:null;
        };
        return delta$Path;
    }

    public String toString() {
        String str="Path(n,$Builtin.min(d),prev) :- Path(s,d1,prev1),Edge(s,n,_$0),d=(d1+1),prev=s. epoch:"+$epochId;
        return str;
    }

}