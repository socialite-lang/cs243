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
import socialite.tables.TopRankers_int_double_indexby0_groupby0_id7;


public final class VisitorTopRankers_48 extends VisitorImpl implements Runnable {
    private Rank$1_int_double_indexby0_range0to1274502_groupby0_id5 $_rank$10;
    private TopRankers_int_double_indexby0_groupby0_id7[] $headTable;
    private SRuntime $runtime;
    private final int $epochId;
    private final int $ruleId;
    private TableInstRegistry $registry;
    private TableSliceMap $sliceMap;
    private LockMap $lockMap;
    private final double $const2;
    private final double $const3;
    private int n;
    private double rank;
    private int $currentPredicate;
    private int $firstTableIdx;
    private int $userlogCount;
;
    public  VisitorTopRankers_48(int _$epochId, int _$ruleId, Double _$$const2, Double _$$const3, Rank$1_int_double_indexby0_range0to1274502_groupby0_id5 _$$_rank$10, TopRankers_int_double_indexby0_groupby0_id7[] $$headTable, SRuntime _$runtime, int _$firstTableIdx) {
        $const2=_$$const2;
        $const3=_$$const3;
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
              if (!(rank>(0.0444978593624*0.05)) ) {
                  continue;
              };
              boolean $isUpdated=false;
              TopRankers_int_double_indexby0_groupby0_id7 _$$headTable=$headTable[$sliceMap.getHashIndex(7,n)];
              int $_slice_16=$sliceMap.getHashIndex(7,n);
              try {
                  $lockMap.lock(7, $_slice_16);
                  $isUpdated=_$$headTable.insert(n, rank);
                  if ($isUpdated) {
                      {;};
                  };
              } finally {
                  $lockMap.unlock(7, $_slice_16);
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
        String str="TopRankers(n,rank) :- Rank$1(n,rank),(rank>(0.0444978593624*0.05)). epoch:"+$epochId;
        return str;
    }

}