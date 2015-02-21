package socialite.query;
/* 
    for query: ?-Path(67123,dist,prev). 
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


public final class QueryPath_0 extends VisitorImpl implements QueryRunnable {
    private Path_int_int_int_indexby0_range0to1274502_groupby0_id3 _path_;
    private Tuple_int_int_int tuple = new Tuple_int_int_int();
    private TableSliceMap $sliceMap;
    private QueryVisitor queryVisitor;
    private boolean $isTerminated=false;
    private int $const1;
    private int dist;
    private int prev;
;
    public  QueryPath_0(Path_int_int_int_indexby0_range0to1274502_groupby0_id3 __path_, QueryVisitor _queryVisitor, TableSliceMap _sliceMap) {
        _path_=__path_;
        queryVisitor=_queryVisitor;
        $sliceMap=_sliceMap;
    }

    public void run() {
        _path_.iterate_by_0($const1, this);
        queryVisitor.finish();
    }

    public int getRuleId() {
        return -1;
    }

    public int getEpochId() {
        return -1;
    }

    public boolean visit(int _0, int _1, int _2) {
        do {
          if ($const1!=_0) {
              break;
          };
          dist=(int)_1;
          prev=(int)_2;
          tuple._0=$const1;
          tuple._1=dist;
          tuple._2=prev;
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