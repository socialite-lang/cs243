package socialite.query;
/* 
    for query: ?-IdMap(i,"Jenny Craven"). 
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
import socialite.tables.IdMap_int_String_indexby0_range0to1274502_indexby1_groupby0_id0;


public final class QueryIdMap_0 extends VisitorImpl implements QueryRunnable {
    private IdMap_int_String_indexby0_range0to1274502_indexby1_groupby0_id0 _idMap_;
    private Tuple_int_Object tuple = new Tuple_int_Object();
    private TableSliceMap $sliceMap;
    private QueryVisitor queryVisitor;
    private boolean $isTerminated=false;
    private int i;
    private java.lang.String $const0;
;
    public  QueryIdMap_0(IdMap_int_String_indexby0_range0to1274502_indexby1_groupby0_id0 __idMap_, QueryVisitor _queryVisitor, TableSliceMap _sliceMap) {
        _idMap_=__idMap_;
        queryVisitor=_queryVisitor;
        $sliceMap=_sliceMap;
    }

    public void run() {
        _idMap_.iterate_by_1($const0, this);
        queryVisitor.finish();
    }

    public int getRuleId() {
        return -1;
    }

    public int getEpochId() {
        return -1;
    }

    public boolean visit(int _0, Object _1) {
        do {
          i=(int)_0;
          if (!$const0.equals(_1)) {
              break;
          };
          tuple._0=i;
          tuple._1=$const0;
          boolean $cont=queryVisitor.visit(tuple);
          if(!$cont) return false;
          if($isTerminated) throw new SocialiteFinishEval();
        } while (false);;
        return true;
    }

    public void setArgs(List $params) {
        assert $params.size()==1;
        $const0=(java.lang.String)$params.get(0);
    }

    public void setTerminated() {
        $isTerminated=true;
    }

    public void setQueryVisitor(QueryVisitor $qv) {
        queryVisitor=$qv;
    }

}