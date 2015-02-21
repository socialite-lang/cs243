package socialite.query;
/* 
    for query: ?-MaxRank(0,maxRank). 
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
import socialite.tables.MaxRank_int_double_indexby0_range0to0_groupby0_id6;


public final class QueryMaxRank_0 extends VisitorImpl implements QueryRunnable {
    private MaxRank_int_double_indexby0_range0to0_groupby0_id6 _maxRank_;
    private Tuple_int_double tuple = new Tuple_int_double();
    private TableSliceMap $sliceMap;
    private QueryVisitor queryVisitor;
    private boolean $isTerminated=false;
    private int $const1;
    private double maxRank;
;
    public  QueryMaxRank_0(MaxRank_int_double_indexby0_range0to0_groupby0_id6 __maxRank_, QueryVisitor _queryVisitor, TableSliceMap _sliceMap) {
        _maxRank_=__maxRank_;
        queryVisitor=_queryVisitor;
        $sliceMap=_sliceMap;
    }

    public void run() {
        _maxRank_.iterate_by_0($const1, this);
        queryVisitor.finish();
    }

    public int getRuleId() {
        return -1;
    }

    public int getEpochId() {
        return -1;
    }

    public boolean visit(int _0, double _1) {
        do {
          if ($const1!=_0) {
              break;
          };
          maxRank=(double)_1;
          tuple._0=$const1;
          tuple._1=maxRank;
          boolean $cont=queryVisitor.visit(tuple);
          if(!$cont) return false;
          if($isTerminated) throw new SocialiteFinishEval();
        } while (false);;
        return true;
    }

    public void setArgs(List $params) {
        assert $params.size()==1;
        $const1=(Integer)$params.get(0);
    }

    public void setTerminated() {
        $isTerminated=true;
    }

    public void setQueryVisitor(QueryVisitor $qv) {
        queryVisitor=$qv;
    }

}