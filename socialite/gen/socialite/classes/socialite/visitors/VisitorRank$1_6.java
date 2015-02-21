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
import socialite.tables.Rank$0_int_double_indexby0_range0to1274502_groupby0_id4;
import socialite.tables.EdgeCnt_int_int_indexby0_range0to1274502_groupby0_id2;
import socialite.tables.Edge_int_int_nest1_indexby0_range0to1274502_groupby0_id1;
import socialite.tables.Rank$1_int_double_indexby0_range0to1274502_groupby0_id5;


public final class VisitorRank$1_6 extends VisitorImpl implements Runnable {
    private Rank$0_int_double_indexby0_range0to1274502_groupby0_id4 $_rank$00;
    private EdgeCnt_int_int_indexby0_range0to1274502_groupby0_id2 $_edgeCnt1;
    private Edge_int_int_nest1_indexby0_range0to1274502_groupby0_id1 $_edge3;
    private Rank$1_int_double_indexby0_range0to1274502_groupby0_id5 $headTable;
    private SRuntime $runtime;
    private final int $epochId;
    private final int $ruleId;
    private TableInstRegistry $registry;
    private TableSliceMap $sliceMap;
    private LockMap $lockMap;
    private final double $const8;
    private int s;
    private double r1;
    private int cnt;
    private double r;
    private int n;
    private double aggr$ret;
    private double $aggrVar;
    private int $currentPredicate;
    private int $firstTableIdx;
    private int $userlogCount;
;
    public  VisitorRank$1_6(int _$epochId, int _$ruleId, Double _$$const8, Rank$0_int_double_indexby0_range0to1274502_groupby0_id4 _$$_rank$00, EdgeCnt_int_int_indexby0_range0to1274502_groupby0_id2 _$$_edgeCnt1, Edge_int_int_nest1_indexby0_range0to1274502_groupby0_id1 _$$_edge3, Rank$1_int_double_indexby0_range0to1274502_groupby0_id5 $$headTable, SRuntime _$runtime, int _$firstTableIdx) {
        $const8=_$$const8;
        $_rank$00 = _$$_rank$00;
        $_edgeCnt1 = _$$_edgeCnt1;
        $_edge3 = _$$_edge3;
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
          $_rank$00.iterate_range_0($sliceMap.getRange(4,0,$firstTableIdx)[0],$sliceMap.getRange(4,0,$firstTableIdx)[1],this);
        } while (false);;
    }

    public boolean visit(int _0, double _1) {
        do {
          switch ($currentPredicate) {
              case 0: 
              {s=(int)_0;
              r1=(double)_1;
              $currentPredicate=1;
              $_edgeCnt1.iterate_by_0(s, this);
              $currentPredicate=0;
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
              {if (s!=_0) {
                  break;
              };
              cnt=(int)_1;
              {r=(double)(($const8*r1) /cnt) ;};
              $currentPredicate=3;
              $_edge3.iterate_by_0(s, this);
              $currentPredicate=1;
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
              case 3: 
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

    public boolean visit(int _0) {
        do {
          switch ($currentPredicate) {
              case 3: 
              {n=(int)_0;
              boolean $isUpdated=false;
              Rank$1_int_double_indexby0_range0to1274502_groupby0_id5 _$$headTable=$headTable;
              int $_slice_12=$sliceMap.getRangeIndex(5,0,n);
              try {
                  $lockMap.lock(5, $_slice_12);
                  if (!_$$headTable.contains(n)) {
                      $aggrVar=r; ;
                      _$$headTable.insert(n, $aggrVar);
                      $isUpdated=true;
                  } else {
                      {double _$oldAns;
                      _$oldAns=_$$headTable.groupby(n);
                      $aggrVar=Builtin.sum(_$oldAns, r) ;
                      if($aggrVar==(_$oldAns)) continue;
                      $isUpdated=_$$headTable.update(n, $aggrVar);};
                  };
              } finally {
                  $lockMap.unlock(5, $_slice_12);
              };
              if ($isUpdated) {
                  {;};
              };
              ;
              break;
              }

          };
        } while (false);;
        return true;
    }

    public TableInst[] getDeltaTables() {
        return null;
    }

    public String toString() {
        String str="Rank$1(n,$Builtin.sum(r)) :- Rank$0(s,r1),EdgeCnt(s,cnt),r=((0.85*r1)/cnt),Edge(s,n). epoch:"+$epochId;
        return str;
    }

}