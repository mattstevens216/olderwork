var x = 3;
var y = 6;
var z = 9;

if(x < y && z < 10){
   x = y + z;
   y = y + 1;
   z = z + 1;
}
if(x < 15 || x == ((y*z)/7)+ 5) {
   x = x+1;
}
print "result is ";
print x;
print "\n";