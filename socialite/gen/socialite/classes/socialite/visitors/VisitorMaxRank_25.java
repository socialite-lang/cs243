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
import socialite.tables.Rank$1_int_double_indexby0_range0to1274502_groupby0_id5;
import socialite.tables.MaxRank_int_double_indexby0_range0to0_groupby0_id6;


public final class VisitorMaxRank_25 extends VisitorImpl implements Runnable {
    private Rank$1_int_double_indexby0_range0to1274502_groupby0_id5 $_rank$10;
    private MaxRank_int_double_indexby0_range0to0_groupby0_id6 $headTable;
    private SRuntime $runtime;
    private final int $epochId;
    private final int $ruleId;
    private TableInstRegistry $registry;
    private TableSliceMap $sliceMap;
    private LockMap $lockMap;
    private final int $const1;
    private int n;
    private double rank;
    private double aggr$ret;
    private double $aggrVar;
    private int $currentPredicate;
    private int $firstTableIdx;
    private int $userlogCount;
;
    public  VisitorMaxRank_25(int _$epochId, int _$ruleId, Integer _$$const1, Rank$1_int_double_indexby0_range0to1274502_groupby0_id5 _$$_rank$10, MaxRank_int_double_indexby0_range0to0_groupby0_id6 $$headTable, SRuntime _$runtime, int _$firstTableIdx) {
        $const1=_$$const1;
        $_rank$10 = _$$_rank$10;
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
          $_rank$10.iterate_range_0($sliceMap.getRange(5,0,$firstTableIdx)[0],$sliceMap.getRange(5,0,$firstTableIdx)[1],this);
        } while (false);;
    }

    public boolean visit(int _0, double _1) {
        do {
          switch ($currentPredicate) {
              case 0: 
              {n=(int)_0;
              rank=(double)_1;
              boolean $isUpdated=false;
              MaxRank_int_double_indexby0_range0to0_groupby0_id6 _$$headTable=$headTable;
              if (_$$headTable.contains($const1)) {
                  double _$oldAns;
                  _$oldAns=_$$headTable.groupby($const1);
                  aggr$ret=Builtin.max(_$oldAns, rank) ;
                  if (_$oldAns!=0 && _$oldAns==aggr$ret) continue;
              };
              int $_slice_15=$sliceMap.getRangeIndex(6,0,$const1);
              try {
                  $lockMap.lock(6, $_slice_15);
                  if (!_$$headTable.contains($const1)) {
                      $aggrVar=rank; ;
                      _$$headTable.insert($const1, $aggrVar);
                      $isUpdated=true;
                  } else {
                      {double _$oldAns;
                      _$oldAns=_$$headTable.groupby($const1);
                      $aggrVar=Builtin.max(_$oldAns, rank) ;
                      if($aggrVar==(_$oldAns)) continue;
                      $isUpdated=_$$headTable.update($const1, $aggrVar);};
                  };
              } finally {
                  $lockMap.unlock(6, $_slice_15);
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
        String str="MaxRank(0,$Builtin.max(rank)) :- Rank$1(n,rank). epoch:"+$epochId;
        return str;
    }

}