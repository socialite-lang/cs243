import sys

N = 1274502

print "reading authorId.txt"
# IdToName table maps author-id to his name.
`IdToName(int id:0..$N, String n) indexby n.
 IdToName(id, n) :- l=$read("data/authorId.txt"), 
                (n,s2)=$split(l,"\t"), id=$toInt(s2).`

Lam = 102025
Knuth = 67123
Dijkstra = 376

Src = Lam

print "reading coauthor.txt"
# Edge table has two columns representing edges of the co-authorship graph.
# The graph is an undirected graph. So if A and B are co-authors, 
# then the Edge table stores (A,B) and (B,A).
`Edge(int n:0..$N, (int t)) multiset.
 Edge(s,t) :- l=$read("data/coauthor.txt"), (s1,s2,_)=$split(l, "\t"),
               s=$toInt(s1), t=$toInt(s2).`

# EdgeCnt table stores the number of edges a node has.
`EdgeCnt(int n:0..$N, int cnt).
 EdgeCnt(s, $inc(1)) :- Edge(s, t).`

#Node table stores all the nodes in the graph.
`Node(int n:0..$N).
 Node(n) :- Edge(n, _).`

print "running PageRank"
# Rank table stores PageRank value of the nodes (authors)
# It has three columns (node-id, iteration number, PageRank value).
`Rank(int n:0..$N, int i:iter, double rank).
 Rank(n, 0, r) :- Node(n), r = 1.0/$N.`
for i in range(20):
    `Rank(n, $i+1, $sum(r)) :- Node(n), r=0.15*1.0/$N ;
                            :- Rank(s, $i, r1), EdgeCnt(s, cnt), r=0.85*r1/cnt, Edge(s, n).` 
    sys.stdout.write("..")
    sys.stdout.flush()

`MaxRank(int n:0..0, double rank).
 MaxRank(0, $max(rank)) :- Rank(n, $i, rank).`

_, maxRank = `MaxRank(0, maxRank)`.next()
`TopRankers(int n, double rank) indexby n.
 TopRankers(n, rank) :- Rank(n, $i, rank), rank>$maxRank*0.3.`

for n, rank in `TopRankers(n, rank)`:
    _, name = `IdToName($n, name)`.next()
    print name,":",rank
