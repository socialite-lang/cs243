package socialite.query;
/* 
    for query: ?-Edge(878869,t,_$0). 
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
import socialite.tables.Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1;


public final class QueryEdge_0 extends VisitorImpl implements QueryRunnable {
    private Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1 _edge_;
    private Tuple_int_int_int tuple = new Tuple_int_int_int();
    private TableSliceMap $sliceMap;
    private QueryVisitor queryVisitor;
    private boolean $isTerminated=false;
    private int $const1;
    private int t;
    private int _$0;
;
    public  QueryEdge_0(Edge_int_int_int_nest1_indexby0_range0to1274502_groupby0_id1 __edge_, QueryVisitor _queryVisitor, TableSliceMap _sliceMap) {
        _edge_=__edge_;
        queryVisitor=_queryVisitor;
        $sliceMap=_sliceMap;
    }

    public void run() {
        _edge_.iterate_by_0($const1, this);
        queryVisitor.finish();
    }

    public int getRuleId() {
        return -1;
    }

    public int getEpochId() {
        return -1;
    }

    public boolean visit_0(int _0) {
        do {
          if ($const1!=_0) {
              break;
          };
        } while (false);;
        return true;
    }

    public boolean visit(int _0, int _1) {
        do {
          t=(int)_0;
          tuple._0=$const1;
          tuple._1=t;
          tuple._2=_$0;
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