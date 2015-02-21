N = 1274502

print "reading authorId.txt"
`IdToName(int id:0..$N, String n) indexby n.
 IdToName(id, n) :- l=$read("data/authorId.txt"), 
                (n,s2)=$split(l,"\t"), id=$toInt(s2).`

Lam = 102025
Knuth = 67123
Dijkstra = 376

Src = Lam

print "reading coauthor.txt"
# Edge table has two columns representing edges of the co-authorship graph.
# The columns are (src-author, target-author, co-authored paper count).
# The graph is an undirected graph. So if A and B are co-authors with 2 papers, 
# then the Edge table stores (A,B,2) and (B,A,2).
`Edge(int n:0..$N, (int t, int cnt)) multiset.
 Edge(s,t,cnt) :- l=$read("data/coauthor.txt"), (s1,s2,s3)=$split(l, "\t"),
               s=$toInt(s1), t=$toInt(s2), cnt=$toInt(s3).`

print "reading paperCount.txt"
# PaperCnt table has two columns representing
# author and his paper count.
`PaperCnt(int n:0..$N, int cnt).
 PaperCnt(n,cnt) :- l=$read("data/paperCount.txt"), (s1,s2)=$split(l, "\t"),
                    n=$toInt(s1), cnt=$toInt(s2).`

print "running shortest-paths"
`Path(int n:0..$N, int dist, int prev).
 Path(n, $min(d), prev) :- n=$Src, d=0, prev=-1 ;
                        :- Path(s, d1, prev1), Edge(s, n, _), d=d1+1, prev=s.`

def findPathTo(to, src=Src):
    path = []
    while True:
        path.append(to)
        t, dist, prev = `Path($to, dist, prev)`.next()
        if prev==src: 
            path.append(src)
            break
        to = prev
    path.reverse()
    return path

def translatePath(path):
    translated = []
    for i in path:
        _, name = `IdToName($i, name)`.next()
        translated.append(name)
    return translated

path = findPathTo(Knuth)
print translatePath(path)

path = findPathTo(Dijkstra)
print translatePath(path)
