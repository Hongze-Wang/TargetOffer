#include <iostream>
#include <map>
using namespace std;
int main() {
 int n,K,tmp1,tmp2;
 cin>>n>>K;
// int MM[n+1][n+1]; // 相互计数
 map<pair<int,int>, int> mp; // 相互计数
 map<pair<int,int>, int>::iterator it_find;
 pair<int,int> p;
 
 int C[n+1]; //绝对计数
 
// memset(MM, 0, sizeof(int)*(n+1)*(n+1));
 memset(C, 0, sizeof(int)*(n+1));
 
 for(int i = 1 ; i <= n ; i++){
  cin>>tmp1>>tmp2;
  if(tmp1<tmp2)
   p = make_pair(tmp1,tmp2);
  else {
   p = make_pair(tmp2,tmp1);
  }
//  MM[tmp1][tmp2]++;
//  MM[tmp2][tmp1]++;
  if(mp.count(p)==0){
   mp.insert(make_pair(p,1));
  }
  else{
   it_find = mp.find(p);
   int tmp = it_find->second;
   mp.erase(p);
   mp.insert(make_pair(p,tmp+1));
  }
  C[tmp1]++;
  C[tmp2]++;
 }
 int res = 0;
 
 for(int i = 1 ; i <= n ; i++){
  if(C[i]<=K){
   for(int j = i + 1 ; j <= n ; j++){
    if(C[j]<=K){
//     if(C[i]+C[j]-MM[i][j] == K){
     {
      int vv = 0;
      if(mp.count(make_pair(i, j))>0){
       it_find = mp.find(make_pair(i, j));
       if(C[i]+C[j]-it_find->second==K){
        res++;
       }
      }
      else{
       if(C[i]+C[j]==K){
        res++;
       }
      }
//      cout<<i<<" -- "<<j<<endl;
     }
    }
   }
  }
 }
 cout<<res<<endl;
}