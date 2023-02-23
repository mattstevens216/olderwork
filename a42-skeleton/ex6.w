var x = 1 + 1;
var y = 10;
var z = y + x;

while(x < y){
   x = (z / x) + 4; 
}
if( True && x == y ){
    print "result is ";
    print x;
    print "\n";
}
else{
    print "result is ";
    print z;
    print "\n";
}